package com.ihrm.system;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.common.utils.PermissionConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;



/**
 * @author lish
 * @date 2020/10/6 14:39
 */
@SpringBootApplication(scanBasePackages = "com.ihrm")
@EntityScan(value = "com.ihrm.domain.system")
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }


}
