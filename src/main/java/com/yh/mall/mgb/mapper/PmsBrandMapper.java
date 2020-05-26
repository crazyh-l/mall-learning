package com.yh.mall.mgb.mapper;

import com.yh.mall.mgb.model.PmsBrand;
import com.yh.mall.mgb.model.PmsBrandExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YangHao
 * @ClassName: PmsBrandMapper
 * @Description: TODO
 * @date 2020/5/26 17:33
 * @Version V1.0
 */
public interface PmsBrandMapper {

    int countByExample(PmsBrandExample example);

    int deleteByExample(PmsBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsBrand record);

    int insertSelective(PmsBrand record);

    List<PmsBrand> selectByExampleWithBLOBs(PmsBrandExample example);

    List<PmsBrand> selectByExample(PmsBrandExample example);

    PmsBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updateByExample(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updateByPrimaryKeySelective(PmsBrand record);

    int updateByPrimaryKeyWithBLOBs(PmsBrand record);

    int updateByPrimaryKey(PmsBrand record);
}
