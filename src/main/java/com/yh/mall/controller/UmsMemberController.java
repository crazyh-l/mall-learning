package com.yh.mall.controller;

import com.yh.mall.common.api.CommonResult;
import com.yh.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author YangHao
 * @ClassName: UmsMemberController
 * @Description: 会员登录注册管理Controller
 * @date 2020/5/27 11:21
 * @Version V1.0
 */
@Controller
@Api(tags = "UmsMemberController")
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;


    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {

        return memberService.generateAuthCode(telephone);
    }


    @ApiOperation("校验验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upatePassword(@RequestParam String telephone,@RequestParam String authCode) {

        return memberService.verifyAuthCode(telephone,authCode);
    }
}
