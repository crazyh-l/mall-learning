package com.yh.mall.service;

import com.yh.mall.mgb.model.UmsAdmin;
import com.yh.mall.mgb.model.UmsPermission;

import java.util.List;

/**
 * @author YangHao
 * @ClassName: UmsAdminService
 * @Description: 后台管理员 service
 * @date 2020/5/27 14:37
 * @Version V1.0
 */
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUserName(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);
    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);

}
