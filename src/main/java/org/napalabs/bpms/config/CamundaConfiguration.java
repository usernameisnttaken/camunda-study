package org.napalabs.bpms.config;


import jakarta.servlet.Filter;
import org.camunda.bpm.engine.rest.security.auth.ProcessEngineAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CamundaConfiguration {

    @Bean
    public FilterRegistrationBean<CorsFilter> processCorsFilter() {
        var source = new UrlBasedCorsConfigurationSource();
        var config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);

        var bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }

//    @Bean
//    public FilterRegistrationBean processEngineAuthenticationFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setName("camunda-auth");
//        registration.setFilter(getProcessEngineAuthenticationFilter());
//        registration.addInitParameter("authentication-provider",
//                "org.camunda.bpm.engine.rest.security.auth.impl.HttpBasicAuthenticationProvider");
//        registration.addUrlPatterns("/*");
//        return registration;
//    }

//    @Bean
//    public Filter getProcessEngineAuthenticationFilter() {
//        return new ProcessEngineAuthenticationFilter();
//    }

}
