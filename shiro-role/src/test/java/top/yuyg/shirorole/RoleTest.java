package top.yuyg.shirorole;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @Author: YU YUGANG
 * @DESCRIPTION:
 * @DATE: CREATED IN  2018/7/6 13:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTest extends BaseTest{

    /**
     * 测试主体是否有角色
     */
    @Test
    public void testHasRole(){
        login("classpath:shiro-role.ini","yu","123");
        //判断拥有角色 role1
        Assert.assertEquals(true,subject().hasRole("role1"));
        //判断拥有角色 role1 和 role2
        Assert.assertEquals(true,subject().hasAllRoles(Arrays.asList("role1","role2")));
    }

    @Test(expected = UnauthorizedException.class)
    public void testCheckRole() {
        login("classpath:shiro-role.ini", "yu", "123");
        //断言拥有角色：role1
        subject().checkRole("role1");
        //断言拥有角色：role1 and role3 失败抛出异常
        subject().checkRoles("role1", "role3");
    }

}
