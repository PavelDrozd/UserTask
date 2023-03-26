package com.it_academy.store;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.it_academy.store")
@EnableJpaRepositories("com.it_academy.store.repository")
@EntityScan("com.it_academy.store.entity")
public class EnableStore {
}
