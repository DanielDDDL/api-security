package com.daniel.example.restful_api_security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private TokenStore tokenStore;
    private UserApprovalHandler userApprovalHandler;

    @Autowired
    public AuthorizationServerConfiguration(AuthenticationManager authenticationManager,
                                            PasswordEncoder passwordEncoder,
                                            TokenStore tokenStore,
                                            UserApprovalHandler userApprovalHandler) {

        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.tokenStore = tokenStore;
        this.userApprovalHandler = userApprovalHandler;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()

        .withClient("my-trusted-client")
                    .secret(passwordEncoder.encode("secret"))
                    .authorizedGrantTypes("client_credentials")
                    .authorities("ROLE_CLIENT")
                    .scopes("read")
                    .accessTokenValiditySeconds(60);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .authenticationManager(authenticationManager)
                .tokenStore(tokenStore)
                .userApprovalHandler(userApprovalHandler);
    }

}
