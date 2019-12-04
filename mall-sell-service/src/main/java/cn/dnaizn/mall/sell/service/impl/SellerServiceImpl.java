package cn.dnaizn.mall.sell.service.impl;


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
import cn.dnaizn.mall.service.SellerService;
import cn.dnaizn.mall.util.RedisUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import entity.PageResult;
import jodd.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import javax.jms.*;
import javax.jms.Queue;
import java.util.*;


/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SellerServiceImpl implements SellerService {

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
            map.put("status", RedisStatusEnum.UPDATE.getCode());
            Map<String, String> m = new HashMap<>();
            m.put("type", "seller_status");
            m.put("id", sellerExamine.getSellerId());
            m.put("status_cn", RedisStatusEnum.UPDATE.getMessage());
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
            map.put("status", RedisStatusEnum.DELETE.getCode());
            Map<String, String> m = new HashMap<String, String>();
            m.put("type", "seller_status");
            m.put("id", id);
            m.put("status_cn", RedisStatusEnum.DELETE.getMessage());
            map.put("data", m);
            jedis.publish("mall.message", JSONObject.toJSONString(map));
            sellerMapper.deleteByPrimaryKey(id);
            sellerBriefMapper.deleteByPrimaryKey(id);
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
                criteria.andSellerIdLike("%" + seller.getSellerId() + "%");
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
            m.put("status_cn", RedisStatusEnum.CREATE.getMessage());
            map.put("status", RedisStatusEnum.CREATE.getCode());
            jedis.publish("mall.message", JSONObject.toJSONString(map));
            jedis.del(sellerFormKey);
        }else if (seller.getStatus() == 3){
            map.put("status", RedisStatusEnum.UPDATE.getCode());
            m.put("status_cn", RedisStatusEnum.UPDATE.getMessage());
            jedis.publish("mall.message", JSONObject.toJSONString(map));
        }

        jedis.close();
    }

    @Override
    public void updateSellerStatus(String sellerId, Integer status) {
        SellerBrief sellerBrief = sellerBriefMapper.selectByPrimaryKey(sellerId);
        sellerBrief.setStatus(status);
        sellerBriefMapper.updateByPrimaryKeySelective(sellerBrief);
        Map<String, Object> map = new HashMap<>();
        map.put("status", RedisStatusEnum.UPDATE.getCode());
        Jedis jedis = redisUtil.getJedis();
        Map<String, String> m = new HashMap<>();
        m.put("type", "seller_status");
        m.put("id", sellerBrief.getSellerId());
        m.put("status_cn", RedisStatusEnum.UPDATE.getMessage());
        map.put("data", m);
        jedis.publish("mall.message", JSONObject.toJSONString(map));
        jedis.close();
    }

    @Override
    public Seller findMobile(String mobile) {
        return sellerMapper.findMobile(mobile);
    }

    @Override
    public void SellerRegister(SellerFormDTO sellerFormDTO) {

        Jedis jedis = redisUtil.getJedis();
        String sellerFormKey = "sellerFormDTO:" + sellerFormDTO.getSellerId() + ":form";
        String sellerForm = jedis.get(sellerFormKey);
        if (StringUtil.isNotBlank(sellerForm)) {
            jedis.del(sellerFormKey);
        }
        jedis.set("sellerFormDTO:" + sellerFormDTO.getSellerId() + ":form", JSON.toJSONString(sellerFormDTO));
        jedis.close();

    }

    @Override
    public SellerFormDTO getSellerRegisterById(String sellerId) {
        SellerFormDTO sellerFormDTO;
        Jedis jedis = redisUtil.getJedis();
        String sellerFormKey = "sellerFormDTO:" + sellerId + ":form";
        String sellerForm = jedis.get(sellerFormKey);
        sellerFormDTO = JSON.parseObject(sellerForm, SellerFormDTO.class);
        jedis.close();
        return sellerFormDTO;
    }

    /**
     * 注册
     *
     * @param mobile
     */
    @Override
    public void createSmsCode(String mobile, Integer type) {
        //生成随机数
        Jedis jedis = redisUtil.getJedis();
        String sellerMobileKey = "seller:" + mobile + type + ":code";
        String code = jedis.get(sellerMobileKey);
        if (code == null) {
            int i = (int) ((Math.random() * 9 + 1) * 100000);
            if (i <= 99999) {
                code = "0" + i;
            } else {
                code = i + "";
            }
        }
        jedis.setex(sellerMobileKey, 20 * 60, code);
        jedis.close();
        //发送短信内容MQ
        ConnectionFactory connectionFactory = activeMQUtil.getConnectionFactory();
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            //第一个值表示是否使用事务，如果选择true，第二个值相当于选择0
            Session session = connection.createSession(true, Session.SESSION_TRANSACTED);//开启事务
            Queue queue = session.createQueue("sms");
            MessageProducer producer = session.createProducer(queue);
            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("mobile", mobile);//手机号
            mapMessage.setString("template_code", "SMS_176615117");
            if (type == 1) {
                mapMessage.setString("template_code", "SMS_176885415");
            }
            if (type == 2) {
                mapMessage.setString("template_code", "SMS_176943990");
            }
            mapMessage.setString("sign_name", "今抖云");
            Map<String, String> map = new HashMap<>();
            map.put("code", code);
            mapMessage.setString("param", JSON.toJSONString(map));
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.send(mapMessage);
            session.commit();//提交事务
            connection.close();//关闭事务
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    /**
     * 校验验证码
     *
     * @param mobile
     * @param code
     * @return
     */
    @Override
    public boolean checkSmsCode(String mobile, String code, Integer type) {
        Jedis jedis = redisUtil.getJedis();
        String sellerMobileKey = "seller:" + mobile + type + ":code";
        String systemCode = jedis.get(sellerMobileKey);
        if (systemCode == null) {
            return false;
        }
        if (!code.equals(systemCode)) {
            return false;
        }
        jedis.del(sellerMobileKey);
        jedis.close();
        return true;
    }

    /**
     * 增加修改
     *
     * @param sellerExamine
     */
    @Override
    public void addUpdate(SellerExamine sellerExamine) {
        Integer[] arr = new Integer[]{2, 6, 7, 8};
        SellerExamineExample example = new SellerExamineExample();
        SellerExamineExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerExamine.getSellerId());
        criteria.andTypeEqualTo(sellerExamine.getType());
        criteria.andStatusNotEqualTo(3);
        if (sellerExamineMapper.countByExample(example) == 0) {
            getUpdate(sellerExamine, arr);
            sellerExamineMapper.insertSelective(sellerExamine);
        } else {
            getUpdate(sellerExamine, arr);
            sellerExamine.setId(sellerExamineMapper.selectByExample(example).get(0).getId());
            sellerExamineMapper.updateByPrimaryKey(sellerExamine);
        }
    }

    private void getUpdate(SellerExamine sellerExamine, Integer[] arr) {
        sellerExamine.setCreateTime(new Date());
        if (Arrays.asList(arr).contains(sellerExamine.getType())) {
            sellerExamine.setStatus(SellerExamineEnum.PASS_AUDIT.getCode());
            sellerExamine.setAdminId("系统处理");
            sellerExamine.setExamineTime(new Date());
        } else {
            sellerExamine.setStatus(SellerExamineEnum.NOT_AUDIT.getCode());
        }
    }

    @Override
    public void addPrinter(Printer printer) {
        printerMapper.insertSelective(printer);
    }

    @Override
    public void updatePrinter(Printer printer) {
        PrinterExample example = new PrinterExample();
        PrinterExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(printer.getSellerId());
        criteria.andPrinterIdEqualTo(printer.getPrinterId());
        printer.setId(printerMapper.selectByExample(example).get(0).getId());
        printerMapper.updateByPrimaryKeySelective(printer);
    }

    @Override
    public Printer findPrinter(String posId) {
        PrinterExample example = new PrinterExample();
        PrinterExample.Criteria criteria = example.createCriteria();
        criteria.andPrinterIdEqualTo(posId);

        return printerMapper.selectByExample(example).get(0);
    }

    @Override
    public List<Printer> findPrinterList(String sellerId) {
        PrinterExample example = new PrinterExample();
        PrinterExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        return printerMapper.selectByExample(example);
    }


    @Override
    public void deletePos(Integer id) {
        printerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void sellerSet(SellerSetting sellerSetting) {
        if (sellerSettingMapper.selectByPrimaryKey(sellerSetting.getSellerId()) != null) {
            sellerSettingMapper.updateByPrimaryKey(sellerSetting);
        } else {
            sellerSettingMapper.insert(sellerSetting);
        }
    }

    @Override
    public Object sellerFindSet(String sellerId) {
        if (sellerSettingMapper.selectByPrimaryKey(sellerId) == null) {
            return null;
        }
        return sellerSettingMapper.selectByPrimaryKey(sellerId).getSetting();
    }

    @Override
    public SellerWechatAccount isOpenid(String sellerId) {
        SellerWechatAccountExample example = new SellerWechatAccountExample();
        SellerWechatAccountExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(sellerId);
        return sellerWechatAccountMapper.selectByExample(example).get(0);
    }
}
