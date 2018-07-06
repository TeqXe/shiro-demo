package top.yuyg.shirorole.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Author: YU YUGANG
 * @DESCRIPTION:
 * @DATE: CREATED IN  2018/7/6 16:22
 */
public class MyRolePermissionResolver implements RolePermissionResolver{
    @Override
    public Collection<Permission> resolvePermissionsInRole(String s) {
        if("role1".equals(s)) {
            //如果用户拥有role1，那么就返回一个“menu:*”的权限。
            return Arrays.asList((Permission)new WildcardPermission("menu:*"));
        }
        return null;
    }
}
