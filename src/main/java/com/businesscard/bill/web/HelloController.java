package com.businesscard.bill.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

        @RequestMapping("/hello")
        public String HelloController(String name) {
                return "string";
        }
}
