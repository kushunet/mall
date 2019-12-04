package cn.dnaizn.mall.manager.service.impl;

import cn.dnaizn.mall.DTO.AddressDTO;
import cn.dnaizn.mall.DTO.DeliverDTO;
import cn.dnaizn.mall.DTO.SellerFormDTO;
import cn.dnaizn.mall.DTO.SellerRegisterDTO;
import cn.dnaizn.mall.enums.RedisStatusEnum;
import cn.dnaizn.mall.enums.SellerExamineEnum;
import cn.dnaizn.mall.enums.SellerStatusEnum;
import cn.dnaizn.mall.exception.MallException;
import cn.dnaizn.mall.mapper.*;
import cn.dnaizn.mall.mq.ActiveMQUtil;
import cn.dnaizn.mall.pojo.*;
import cn.dnaizn.mall.service.AdminSellerService;
import cn.dnaizn.mall.util.RedisUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.*;
@Service
@Transactional
public class AdminSellerServiceImpl implements AdminSellerService {
    @Autowired
    SellerMapper sellerMapper;

    @Autowired
    SellerBriefMapper sellerBriefMapper;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    ActiveMQUtil activeMQUtil;

    @Autowired
    SellerExamineMapper sellerExamineMapper;

    @Autowired
    SellerSettingMapper sellerSettingMapper;

    @Autowired
    PrinterMapper printerMapper;

    @Autowired
    SellerWechatAccountMapper sellerWechatAccountMapper;

    /**
     * 查询全部
     */
    @Override
    public List<Seller> findAll() {
        return sellerMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Seller> page = (Page<Seller>) sellerMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(SellerRegisterDTO sellerRegisterDTO) {
        Seller seller = new Seller();
        SellerBrief sellerBrief = new SellerBrief();
        seller.setSellerId(sellerRegisterDTO.getSellerId());
        seller.setPassword(sellerRegisterDTO.getPassword());
        seller.setMobile(sellerRegisterDTO.getMobile());
        seller.setCreateTime(new Date());
        seller.setStatus(SellerStatusEnum.NOT_APPLY.getCode());
        sellerBrief.setSellerId(seller.getSellerId());
        Jedis jedis = redisUtil.getJedis();
        String sellerMobileKey = "sellerFormDTO:" + sellerRegisterDTO.getMobile() + ":form";
        jedis.del(sellerMobileKey);
        sellerMapper.insertSelective(seller);
        sellerBriefMapper.insertSelective(sellerBrief);
        jedis.close();
    }

    @Override
    public void update(Seller seller) {
        sellerMapper.updateByPrimaryKey(seller);
    }

    /**
     * 修改
     */
    @Override
    public void tUpdate(String sellerId, Integer id) {
        SellerExamine sellerExamine = sellerExamineMapper.selectByPrimaryKey(id);
        if (sellerExamine.getStatus().equals(2)) {
            if (!sellerExamine.getSellerId().equals(sellerId)) {
                throw new MallException(1, "修改ID不属于该商家");
            }

            if (sellerExamine.getType().equals(0)) {
                //头像
                SellerBrief sellerBrief = new SellerBrief();
                sellerBrief.setSellerId(sellerId);
                sellerBrief.setAvatar(sellerExamine.getData());
                sellerBriefMapper.updateByPrimaryKeySelective(sellerBrief);
            } else if (sellerExamine.getType().equals(1)) {
                //店铺名
                SellerBrief sellerBrief = new SellerBrief();
                sellerBrief.setSellerId(sellerId);
                Seller seller = new Seller();
                seller.setSellerId(sellerId);
                seller.setNickName(sellerExamine.getData());
                sellerBrief.setNickName(sellerExamine.getData());
                sellerMapper.updateByPrimaryKeySelective(seller);
                sellerBriefMapper.updateByPrimaryKeySelective(sellerBrief);
            } else if (sellerExamine.getType().equals(2)) {
                //联系人电话
                SellerBrief sellerBrief = new SellerBrief();
                sellerBrief.setSellerId(sellerId);
                Seller seller = new Seller();
                seller.setSellerId(sellerId);
                seller.setLinkmanMobile(sellerExamine.getData());
                sellerBrief.setLinkmanMobile(sellerExamine.getData());
                sellerMapper.updateByPrimaryKeySelective(seller);
                sellerBriefMapper.updateByPrimaryKeySelective(sellerBrief);
            } else if (sellerExamine.getType().equals(3)) {
                //详细地址
                AddressDTO addressDTO = JSONObject.parseObject(sellerExamine.getData(), AddressDTO.class);
                updateAddress(addressDTO, sellerExamine.getSellerId());
            } else if (sellerExamine.getType().equals(4)) {
                SellerBrief sellerBrief = new SellerBrief();
                sellerBrief.setSellerId(sellerId);
                //分类
                sellerBrief.setCategory1Id(Integer.parseInt(JSON.parseArray(sellerExamine.getData()).getString(0)));
                sellerBrief.setCategory2Id(Integer.parseInt(JSON.parseArray(sellerExamine.getData()).getString(1)));
                sellerBriefMapper.updateByPrimaryKeySelective(sellerBrief);
            } else if (sellerExamine.getType().equals(5)) {
                //相册
                SellerBrief sellerBrief = new SellerBrief();
                sellerBrief.setSellerId(sellerId);
                sellerBrief.setAlbum(sellerExamine.getData());
                sellerBriefMapper.updateByPrimaryKeySelective(sellerBrief);
            } else if (sellerExamine.getType().equals(6)) {
                //营业时间
                SellerBrief sellerBrief = new SellerBrief();
                sellerBrief.setSellerId(sellerId);
                sellerBrief.setBusinessHours(sellerExamine.getData());
                sellerBriefMapper.updateByPrimaryKeySelective(sellerBrief);
            } else if (sellerExamine.getType().equals(7)) {
                //公告
                SellerBrief sellerBrief = new SellerBrief();
                sellerBrief.setSellerId(sellerId);
                sellerBrief.setNotice(sellerExamine.getData());
                sellerBriefMapper.updateByPrimaryKeySelective(sellerBrief);
            } else if (sellerExamine.getType().equals(8)) {
                //简介
                SellerBrief sellerBrief = new SellerBrief();
                sellerBrief.setSellerId(sellerId);
                sellerBrief.setBrief(sellerExamine.getData());
                sellerBriefMapper.updateByPrimaryKeySelective(sellerBrief);
            } else if (sellerExamine.getType().equals(9)) {
                //营业执照
                Seller seller = new Seller();
                seller.setSellerId(sellerId);
                seller.setLicense(sellerExamine.getData());
                sellerMapper.updateByPrimaryKeySelective(seller);
            } else if (sellerExamine.getType().equals(10)) {
                //其他执照
                Seller seller = new Seller();
                seller.setSellerId(sellerId);
                seller.setPapers(sellerExamine.getData());
                sellerMapper.updateByPrimaryKeySelective(seller);
            } else if (sellerExamine.getType().equals(11)) {
                //法人身份证
                Seller seller = new Seller();
                seller.setSellerId(sellerId);
                seller.setLegalPerson(JSON.parseObject(sellerExamine.getData()).getString("legalPerson"));
                seller.setLegalPersonCardId(JSON.parseObject(sellerExamine.getData()).getString("legalPersonCardId"));
                seller.setLegalPersonPic(JSON.parseObject(sellerExamine.getData()).getString("legalPersonPic"));
                sellerMapper.updateByPrimaryKeySelective(seller);
            } else {
                return;
            }
            Jedis jedis = redisUtil.getJedis();
            Map<String, Object> map = new HashMap<>();
            map.put("status", RedisStatusEnum.SELLER_UPDATA.getCode());
            Map<String, String> m = new HashMap<>();
            m.put("type", "seller_status");
            m.put("id", sellerExamine.getSellerId());
            m.put("status_cn", RedisStatusEnum.SELLER_UPDATA.getMessage());
            map.put("data", m);
            jedis.publish("mall.message", JSONObject.toJSONString(map));
            jedis.close();
            sellerExamine.setStatus(SellerExamineEnum.SHUT_DOWN.getCode());
            sellerExamineMapper.updateByPrimaryKeySelective(sellerExamine);
        } else {
            throw new MallException(1, "审核状态不正确");
        }
    }

    private void updateAddress(AddressDTO addressDTO, String sellerId) {
        SellerBrief sellerBrief = sellerBriefMapper.selectByPrimaryKey(sellerId);
        Seller seller = sellerMapper.selectByPrimaryKey(sellerId);
        seller.setAddress(addressDTO.getAdcode());
        seller.setAddressDetail(addressDTO.getAddress() + addressDTO.getAddressDetail());
        sellerBrief.setAdcode(addressDTO.getAdcode());
        sellerBrief.setAddress(addressDTO.getAddress());
        sellerBrief.setAddressDetail(addressDTO.getAddressDetail());
        sellerBrief.setLocation(addressDTO.getLocation());
        sellerBriefMapper.updateByPrimaryKeySelective(sellerBrief);
        sellerMapper.updateByPrimaryKeySelective(seller);
    }

    @Override
    public void updateSellerBrief(SellerBrief sellerBrief) {
        sellerBriefMapper.updateByPrimaryKeySelective(sellerBrief);
    }

    @Override
    public List<SellerExamine> findOneUpdate(String sellerId, Integer type) {
        SellerExamineExample example = new SellerExamineExample();
        SellerExamineExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        criteria.andStatusNotEqualTo(3);
        criteria.andTypeEqualTo(type);
        return sellerExamineMapper.selectByExample(example);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public Seller findOne(String id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    @Override
    public DeliverDTO findOneDeliver(String sellerId) {
        DeliverDTO deliverDTO = new DeliverDTO();
        BeanUtils.copyProperties(sellerBriefMapper.selectByPrimaryKey(sellerId), deliverDTO);
        return deliverDTO;
    }

    @Override
    public AddressDTO findAddress(String sellerId) {
        SellerBrief sellerBrief = sellerBriefMapper.selectByPrimaryKey(sellerId);
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAdcode(sellerBrief.getAdcode());
        addressDTO.setAddress(sellerBrief.getAddress());
        addressDTO.setAddressDetail(sellerBrief.getAddressDetail());
        addressDTO.setLocation(sellerBrief.getLocation());
        return addressDTO;
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(String[] ids) {
        Jedis jedis = redisUtil.getJedis();
        for (String id : ids) {
            Map<String, Object> map = new HashMap<>();
            map.put("status", RedisStatusEnum.SELLER_DELETE.getCode());
            Map<String, String> m = new HashMap<String, String>();
            m.put("type", "seller_status");
            m.put("id", id);
            m.put("status_cn", RedisStatusEnum.SELLER_DELETE.getMessage());
            map.put("data", m);
            jedis.publish("mall.message", JSONObject.toJSONString(map));
            sellerMapper.deleteByPrimaryKey(id);
        }
        jedis.close();
    }


    @Override
    public PageResult findPage(Seller seller, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        SellerExample example = new SellerExample();
        SellerExample.Criteria criteria = example.createCriteria();

        if (seller != null) {
            if (seller.getSellerId() != null && seller.getSellerId().length() > 0) {
                criteria.andSellerIdEqualTo(seller.getSellerId());
            }
            if (seller.getName() != null && seller.getName().length() > 0) {
                criteria.andNameLike("%" + seller.getName() + "%");
            }
            if (seller.getNickName() != null && seller.getNickName().length() > 0) {
                criteria.andNickNameLike("%" + seller.getNickName() + "%");
            }
            if (seller.getPassword() != null && seller.getPassword().length() > 0) {
                criteria.andPasswordLike("%" + seller.getPassword() + "%");
            }
            if (seller.getEmail() != null && seller.getEmail().length() > 0) {
                criteria.andEmailLike("%" + seller.getEmail() + "%");
            }
            if (seller.getMobile() != null && seller.getMobile().length() > 0) {
                criteria.andMobileLike("%" + seller.getMobile() + "%");
            }
            if (seller.getTelephone() != null && seller.getTelephone().length() > 0) {
                criteria.andTelephoneLike("%" + seller.getTelephone() + "%");
            }
            if (seller.getAddressDetail() != null && seller.getAddressDetail().length() > 0) {
                criteria.andAddressDetailLike("%" + seller.getAddressDetail() + "%");
            }
            if (seller.getLinkmanName() != null && seller.getLinkmanName().length() > 0) {
                criteria.andLinkmanNameLike("%" + seller.getLinkmanName() + "%");
            }
            if (seller.getLinkmanQq() != null && seller.getLinkmanQq().length() > 0) {
                criteria.andLinkmanQqLike("%" + seller.getLinkmanQq() + "%");
            }
            if (seller.getLinkmanMobile() != null && seller.getLinkmanMobile().length() > 0) {
                criteria.andLinkmanMobileLike("%" + seller.getLinkmanMobile() + "%");
            }
            if (seller.getLinkmanEmail() != null && seller.getLinkmanEmail().length() > 0) {
                criteria.andLinkmanEmailLike("%" + seller.getLinkmanEmail() + "%");
            }
            if (seller.getLicense() != null && seller.getLicense().length() > 0) {
                criteria.andLicenseLike("%" + seller.getLicense() + "%");
            }
            if (seller.getPapers() != null && seller.getPapers().length() > 0) {
                criteria.andPapersLike("%" + seller.getPapers() + "%");
            }
            if (seller.getLogoPic() != null && seller.getLogoPic().length() > 0) {
                criteria.andLogoPicLike("%" + seller.getLogoPic() + "%");
            }
            if (seller.getBrief() != null && seller.getBrief().length() > 0) {
                criteria.andBriefLike("%" + seller.getBrief() + "%");
            }
            if (seller.getLegalPerson() != null && seller.getLegalPerson().length() > 0) {
                criteria.andLegalPersonLike("%" + seller.getLegalPerson() + "%");
            }
            if (seller.getLegalPersonCardId() != null && seller.getLegalPersonCardId().length() > 0) {
                criteria.andLegalPersonCardIdLike("%" + seller.getLegalPersonCardId() + "%");
            }
            if (seller.getLegalPersonPic() != null && seller.getLegalPersonPic().length() > 0) {
                criteria.andLegalPersonPicLike("%" + seller.getLegalPersonPic() + "%");
            }
            if (seller.getBankName() != null && seller.getBankName().length() > 0) {
                criteria.andBankNameLike("%" + seller.getBankName() + "%");
            }
            if (seller.getBankUser() != null && seller.getBankUser().length() > 0) {
                criteria.andBankUserLike("%" + seller.getBankUser() + "%");
            }
            if (seller.getStatus()!=null){
                criteria.andStatusEqualTo(seller.getStatus());
            }

        }

        Page<Seller> page = (Page<Seller>) sellerMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void updateStatus(String sellerId, Integer status) {
        Jedis jedis = redisUtil.getJedis();
        Seller seller = sellerMapper.selectByPrimaryKey(sellerId);
        SellerBrief sellerBrief = sellerBriefMapper.selectByPrimaryKey(sellerId);
        seller.setStatus(status);
        String sellerFormKey = "sellerFormDTO:" + sellerId + ":form";
        String sellerForm = jedis.get(sellerFormKey);
        if (sellerForm != null) {
            SellerFormDTO sellerFormDTO = JSON.parseObject(sellerForm, SellerFormDTO.class);
            seller.setSellerId(seller.getSellerId());
            seller.setNickName(sellerFormDTO.getNickName());
            seller.setLinkmanName(sellerFormDTO.getLinkmanName());
            seller.setLinkmanMobile(sellerFormDTO.getLinkmanMobile());
            seller.setAddress(sellerFormDTO.getAdcode());
            if (sellerFormDTO.getCity().isEmpty()) {
                sellerFormDTO.setCity("");
            }
            if (sellerFormDTO.getAreas().isEmpty()) {
                sellerFormDTO.setAreas("");
            }
            seller.setAddressDetail(sellerFormDTO.getProvince() + sellerFormDTO.getCity() +
                    sellerFormDTO.getAreas() + sellerFormDTO.getAddressDetail());
            seller.setLicense(sellerFormDTO.getLicense());
            seller.setPapers(sellerFormDTO.getPapers());
            seller.setLegalPerson(sellerFormDTO.getLegalPerson());
            seller.setLegalPersonCardId(sellerFormDTO.getLegalPersonCardId());
            seller.setLegalPersonPic(sellerFormDTO.getLegalPersonPic());
            sellerBrief.setSellerId(seller.getSellerId());
            sellerBrief.setNickName(sellerFormDTO.getNickName());
            sellerBrief.setLinkmanName(sellerFormDTO.getLinkmanName());
            sellerBrief.setLinkmanMobile(sellerFormDTO.getLinkmanMobile());
            sellerBrief.setCategory1Id(sellerFormDTO.getCategory1Id());
            sellerBrief.setCategory2Id(sellerFormDTO.getCategory2Id());
            sellerBrief.setCategory3Id(sellerFormDTO.getCategory3Id());
            sellerBrief.setAdcode(sellerFormDTO.getAdcode());
            sellerBrief.setAvatar(sellerFormDTO.getAvatar());
            sellerBrief.setAddress(sellerFormDTO.getProvince() + sellerFormDTO.getCity() + sellerFormDTO.getAreas());
            sellerBrief.setAddressDetail(sellerFormDTO.getAddressDetail());
            sellerBrief.setAlbum(sellerFormDTO.getAlbum());
            sellerBrief.setLocation(sellerFormDTO.getLocation());
        }
        sellerMapper.updateByPrimaryKey(seller);
        sellerBriefMapper.updateByPrimaryKey(sellerBrief);
        Map<String, Object> map = new HashMap<>();
        Map<String, String> m = new HashMap<>();
        m.put("type", "seller_status");
        m.put("id", seller.getSellerId());
        map.put("data", m);
        if (seller.getStatus()==1){
            m.put("status_cn", RedisStatusEnum.SELLER_CREATE.getMessage());
            map.put("status", RedisStatusEnum.SELLER_CREATE.getCode());
            jedis.publish("mall.message", JSONObject.toJSONString(map));
            jedis.del(sellerFormKey);
        }else if (seller.getStatus()==3){
            map.put("status", RedisStatusEnum.SELLER_DELETE.getCode());
            m.put("status_cn", RedisStatusEnum.SELLER_DELETE.getMessage());
            jedis.publish("mall.message", JSONObject.toJSONString(map));
        }

        jedis.close();
    }

}
