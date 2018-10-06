package com.wys.read.shiro;

import com.wys.read.domain.User;
import com.wys.read.repository.UserRepository;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 9:45 2018/10/6
 * @Modified By:
 */
public class AuthRealm extends AuthorizingRealm {

    private final Logger log = LoggerFactory.getLogger(AuthRealm.class);

    @Autowired
    UserRepository userRepository;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {



        return null;
    }

    /**
     * 认证登录
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User user = userRepository.findUserByUsername(username);
        String realName = getName();
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());

        log.info("realName: {}", realName);

        // 封装用户信息，构建AuthenticationInfo对象并返回
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user, user.getPassword()
                , credentialsSalt, realName);

        return authcInfo;
    }

}
