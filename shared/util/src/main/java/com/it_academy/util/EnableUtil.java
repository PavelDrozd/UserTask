package com.it_academy.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.it_academy.util")
@Configuration
public class EnableUtil {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
