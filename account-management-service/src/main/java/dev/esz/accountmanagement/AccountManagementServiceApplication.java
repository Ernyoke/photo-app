package dev.esz.accountmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountManagementServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountManagementServiceApplication.class, args);
    }
}
