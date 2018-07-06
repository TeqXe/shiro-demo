package top.yuyg.shiroauth.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @Author: YU YUGANG
 * @DESCRIPTION:
 * @DATE: CREATED IN  2018/7/6 09:55
 */
public class MyRealm2 implements Realm{
    @Override
    public String getName() {
        return "myRealm2";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        //仅支持UsernamePasswordToken类型的Token
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
        if (!"cheng".equals(username)){
            throw new UnknownAccountException();
        }
        if (!"123".equals(password)){
            throw new IncorrectCredentialsException();
        }
        //如果身份验证成功，返回一个authenticationInfo 实现
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
