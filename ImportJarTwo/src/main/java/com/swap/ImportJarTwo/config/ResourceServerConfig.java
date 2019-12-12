package com.swap.ImportJarTwo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

  @Autowired
  DataSource dataSource;
  
  //paths that are protected by OAuth2 security
  @Override
  public void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
	.antMatchers("/v2/api-docs", "/swagger-resources/**", "/webjars/**", "/swagger-ui.html", "/**")
	.permitAll().and().authorizeRequests().anyRequest().authenticated();
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore());
  }

  @Bean
  public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
  }

}
