package com.itheima.config;

import com.aliyuncs.exceptions.ClientException;
import com.itheima.utils.AliOSSUtils;
import com.itheima.utils.AliOssProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AliOssProperties.class)
public class AliOSSAutoConfiguration {
    @Bean
    public AliOSSUtils aliOSSUtils(AliOssProperties aliOssProperties) throws ClientException {
        AliOSSUtils aliOSSUtils = new AliOSSUtils();
        aliOSSUtils.setAliOssProperties(aliOssProperties);
        return aliOSSUtils;
    }
}
