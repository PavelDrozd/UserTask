package com.it_academy.service;

import com.it_academy.store.EnableStore;
import com.it_academy.util.EnableUtil;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Import({
        EnableStore.class,
        EnableUtil.class
})
@ComponentScan("com.it_academy.service")
@EnableTransactionManagement
public class EnableService {
}
