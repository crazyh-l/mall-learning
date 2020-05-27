package com.yh.mall.service;

/**
 * @author YangHao
 * @ClassName: RedisService
 * @Description: redis 操作service
 * 对象和数组都以json形式进行存储
 * @date 2020/5/27 11:09
 * @Version V1.0
 */
public interface RedisService {

    //数据存储
    void set(String key,String value);

    //获取数据
    String get(String key);

    //设置超期时间
    boolean expire(String key,long expire);

    //删除数据
    void remove(String key);

    //自增操作
    Long increment(String key,long delta);
}


