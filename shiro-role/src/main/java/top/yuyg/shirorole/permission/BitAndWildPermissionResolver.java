package top.yuyg.shirorole.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.Arrays;
import java.util.Collection;

/**
 * BitAndWildPermissionResolver实现了PermissionResolver接口，
 * 并根据权限字符串是否以“+”开头来解析权限字符串为BitPermission或WildcardPermission。
 * @Author: YU YUGANG
 * @DESCRIPTION:
 * @DATE: CREATED IN  2018/7/6 15:57
 */
public class BitAndWildPermissionResolver implements PermissionResolver {

    @Override
    public Permission resolvePermission(String s) {
        if (s.startsWith("+")){
            return new BitPermission(s);
        }
        return new WildcardPermission(s);
    }
}
