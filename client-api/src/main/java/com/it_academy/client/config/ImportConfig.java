package com.it_academy.client.config;

import com.it_academy.service.EnableService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
    EnableService.class
})
@Configuration
public class ImportConfig {
}
