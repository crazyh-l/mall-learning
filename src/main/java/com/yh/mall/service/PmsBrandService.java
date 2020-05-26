package com.yh.mall.service;

import com.yh.mall.mgb.model.PmsBrand;

import java.util.List;

/**
 * @author YangHao
 * @ClassName: PmsBrandService
 * @Description: TODO
 * @date 2020/5/26 16:51
 * @Version V1.0
 */
public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
