package com.yh.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author YangHao
 * @ClassName: MybatisConfig
 * @Description: TODO
 * @date 2020/5/26 15:56
 * @Version V1.0
 */
@Configuration
@MapperScan({"com.yh.mall.mgb.mapper","com.yh.mall.dao"})
public class MybatisConfig {


}
