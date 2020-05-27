package com.yh.mall.dao;

import com.yh.mall.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YangHao
 * @ClassName: EsProductDao
 * @Description: TODO
 * @date 2020/5/27 16:42
 * @Version V1.0
 */
public interface EsProductDao {

    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
