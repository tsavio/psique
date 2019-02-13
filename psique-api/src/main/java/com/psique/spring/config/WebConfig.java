package com.psique.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author <a href="mailto:thyago@usto.re">Thyago Sávio</a>
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.psique.spring.controller"})
public class WebConfig extends WebMvcConfigurerAdapter{

}
