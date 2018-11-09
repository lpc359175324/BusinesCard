package com.businesscard.bill;

import com.businesscard.bill.web.HelloController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
public class WebRequestTest {
        
        private MockMvc mockMvc;
        
        @Before
        public void setMockMvcByHelloController() throws Exception {
                mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
        }
        
        @Test
        public void getHello() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders
                        .post("/hello?name=m")
                        .accept(MediaType.APPLICATION_JSON_UTF8))
//                        .andDo(print());  //输出全部信息
                        .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("x"))); //获取返回结果比较是否含有 "x”
        }
        
}










