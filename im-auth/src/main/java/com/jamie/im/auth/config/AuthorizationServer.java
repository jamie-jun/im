package com.jamie.im.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private ClientDetailsService jdbcClientDetails;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtAccessTokenConverter accessTokenConverter;

    @Bean
    public AuthorizationCodeServices authorizationCodeServices(){
        //设置授权码模式
        return new JdbcAuthorizationCodeServices(dataSource); //使用jdbc方式储存授权码
//        return new InMemoryAuthorizationCodeServices();  //使用内存方式储存授权码
    }

    @Bean
    public AuthorizationServerTokenServices tokenServices(){
        DefaultTokenServices services = new DefaultTokenServices();
        services.setClientDetailsService(clientDetailsService); //客服端详情
        services.setSupportRefreshToken(true); //支持刷新令牌
        services.setTokenStore(tokenStore); //令牌储存策略
        //设置令牌增强
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter));
        services.setTokenEnhancer(tokenEnhancerChain);
        services.setAccessTokenValiditySeconds(7200); //令牌默认有效期2小时
        services.setRefreshTokenValiditySeconds(259200); //刷新令牌默认有效期3天
        return services;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 读取客户端配置
        clients.withClientDetails(jdbcClientDetails);
//        clients.inMemory()
//                .withClient("api")
//                .secret(new BCryptPasswordEncoder().encode("secret"))
//                .authorizedGrantTypes("client_credentials","password","refresh_token","authorization_code","implicit")
//                .scopes("all")
//                .redirectUris("http://www.baidu.com");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 设置令牌
        endpoints
                .authenticationManager(authenticationManager)  //认证管理器
                .authorizationCodeServices(authorizationCodeServices) //授权码服务
                .tokenServices(tokenServices()) //令牌管理服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security){
        security
                // 允许访问 /oauth/token_key 获取秘钥
                .tokenKeyAccess("permitAll()")
                // 允许访问 /oauth/check_token 解析校验令牌合法性
                .checkTokenAccess("isAuthenticated()")
                //表单认证（申请令牌）
                .allowFormAuthenticationForClients();
    }
}
