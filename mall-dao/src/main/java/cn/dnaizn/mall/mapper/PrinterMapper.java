package cn.dnaizn.mall.mapper;

import cn.dnaizn.mall.pojo.Printer;
import cn.dnaizn.mall.pojo.PrinterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrinterMapper {
    int countByExample(PrinterExample example);

    int deleteByExample(PrinterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Printer record);

    int insertSelective(Printer record);

    List<Printer> selectByExample(PrinterExample example);

    Printer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Printer record, @Param("example") PrinterExample example);

    int updateByExample(@Param("record") Printer record, @Param("example") PrinterExample example);

    int updateByPrimaryKeySelective(Printer record);

    int updateByPrimaryKey(Printer record);
}