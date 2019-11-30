package com.swapnil.HibernateCriteria.config;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpHeaders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



@Configuration
@EnableJpaAuditing
class AuditConfig {

  private final Logger log = LoggerFactory.getLogger(AuditConfig.class);

  @Bean
  public AuditorAware<Long> createAuditorProvider() {

    return new SecurityAuditor();
  }

  @Bean
  public AuditingEntityListener createAuditingListener() {

    return new AuditingEntityListener();
  }

  public class SecurityAuditor implements AuditorAware<Long> {

    @Override
    public Long getCurrentAuditor() {
    	
    	//TO-DO set auditor Id...
    	return 1L;
    }
  }

}