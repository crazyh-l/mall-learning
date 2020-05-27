package com.yh.mall.dao;

import com.yh.mall.mgb.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YangHao
 * @ClassName: UmsAdminRoleRelationDao
 * @Description: 后台用户与角色管理自定义Dao
 * @date 2020/5/27 14:49
 * @Version V1.0
 */
public interface UmsAdminRoleRelationDao{

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);

}
