package top.yuyg.shirorole;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: YU YUGANG
 * @DESCRIPTION:
 * @DATE: CREATED IN  2018/7/6 14:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionTest extends BaseTest{

    @Test(expected = UnauthorizedException.class)
    public void testCheckPermission(){
        login("classpath:shiro-permission.ini","yu","123");
        //断言拥有权限：user:create
        subject().checkPermission("user:create");
        //断言拥有权限：user:delete and user:update
        subject().checkPermissions("user:delete", "user:update");
        //断言拥有权限：user:view 失败抛出异常
        subject().checkPermissions("user:view");
    }

}
