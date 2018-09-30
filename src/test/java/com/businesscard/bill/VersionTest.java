package com.businesscard.bill;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VersionTest {
        
        //获取spring-boot版本
        @Test
        public void getVersionTest() {
                String version = SpringBootVersion.getVersion();
                System.out.println(version);
                String implementationVersion = SpringApplication.class.getPackage().getImplementationVersion();
                System.out.println(implementationVersion);
        }
}
