package com.businesscard.bill;

import com.businesscard.bill.modle.BillingInfo;
import com.businesscard.bill.repository.BillingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {
        @Autowired
        private BillingRepository billingRepository;

        @Test
        public void saveBillingInfo() {
                 billingRepository.save(new BillingInfo("Alice"));
                billingRepository.save(new BillingInfo("Bob"));
                billingRepository.save(new BillingInfo("neo"));
                billingRepository.save(new BillingInfo("summer"));
        }

}
