package com.yh.mall.service;

import com.yh.mall.common.api.CommonResult;

/**
 * @author YangHao
 * @ClassName: UmsMemberService
 * @Description: 会员管理 Service
 * @date 2020/5/27 11:28
 * @Version V1.0
 */
public interface UmsMemberService {
    //生成验证码
    CommonResult generateAuthCode(String telephone);
    //判断验证码与手机号是否匹配
    CommonResult verifyAuthCode(String telephone,String authCode);
}
