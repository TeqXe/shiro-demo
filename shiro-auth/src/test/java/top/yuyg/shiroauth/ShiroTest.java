package top.yuyg.shiroauth;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: YU YUGANG
 * @DESCRIPTION:
 * @DATE: CREATED IN  2018/7/5 16:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroTest {

    @Test
    public void testIni(){
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("yu","123");
        try {
            //4、登录验证
            subject.login(token);
        }catch (AuthenticationException e ){
            //4、身份验证失败
            e.printStackTrace();
        }
        //5、断言用户已经登录
        Assert.assertEquals(true,subject.isAuthenticated());

        //6、退出登录
        subject.logout();
    }

    @Test
    public void testSimgleRealm(){
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("yu","123");
        try {
            //4、登录验证
            subject.login(token);
        }catch (AuthenticationException e ){
            //4、身份验证失败
            e.printStackTrace();
        }
        //5、断言用户已经登录
        Assert.assertEquals(true,subject.isAuthenticated());

        //6、退出登录
        subject.logout();
    }

    @Test
    public void testCustomeMultiRealm(){
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("cheng","123");
        try {
            //4、登录验证
            subject.login(token);
        }catch (AuthenticationException e ){
            //4、身份验证失败
            e.printStackTrace();
        }
        //5、断言用户已经登录
        Assert.assertEquals(true,subject.isAuthenticated());

        //6、退出登录
        subject.logout();

    }

    @Test
    public void testJdbcRealm(){
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("yu","123");
        try {
            //4、登录验证
            subject.login(token);
        }catch (AuthenticationException e){
            //4、身份验证失败
            e.printStackTrace();
        }

        //5、断言用户已经登录
        Assert.assertEquals(true,subject.isAuthenticated());

        //6、退出登陆
        subject.logout();
    }
}
