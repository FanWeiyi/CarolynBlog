package com.carolyn.shrio;

import cn.hutool.core.bean.BeanUtil;
import com.carolyn.entity.User;
import com.carolyn.service.UserService;
import com.carolyn.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @projectName: blog
 * @package: com.carolyn.shrio
 * @className: AccountRealm
 * @author: Carolyn
 * @description: 用户realm，用于在SecurityUtils.login()时进行登录验证信息
 * @date: 2023/3/1 18:18
 */

@Slf4j
@Component
public class AccountRealm extends AuthorizingRealm {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserService userService;
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwt = (JwtToken) token;
        log.info("jwt----------------->{}", jwt);
        String userId = jwtUtils.getClaimByToken((String) jwt.getPrincipal()).getSubject();
        User user = userService.getById(Long.parseLong(userId));
        if(user == null) {
            throw new UnknownAccountException("账户不存在！");
        }
        if(user.getStatus() == -1) {
            throw new LockedAccountException("账户已被锁定！");
        }
        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);
        log.info("profile----------------->{}", profile.toString());
        return new SimpleAuthenticationInfo(profile, jwt.getCredentials(), getName());
    }
}
