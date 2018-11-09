package com.businesscard.bill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class LoggerTest {
        Logger logger = LoggerFactory.getLogger(getClass());
}
