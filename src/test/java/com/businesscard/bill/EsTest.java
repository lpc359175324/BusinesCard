package com.businesscard.bill;

import com.businesscard.bill.modle.BillingInfo;
import com.businesscard.bill.repository.BillingRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {
        @Autowired
        private BillingRepository billingRepository;

        @Test
        public void listPageCustomers() {
                Sort sort = new Sort(Sort.Direction.DESC, "orderNumber.keyword");
                Pageable pageable = PageRequest.of(0, 5, sort);
                Page<BillingInfo> billingInfoList= billingRepository.getBillingInfoByOrderNumber( "Alice",pageable);
                billingInfoList.forEach(billingInfo -> System.out.println(billingInfo.toString()));
         }

         @Test
        public void listPageQuery() {
                 QueryBuilder customerQuery = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("orderNumber", "Alice"));
                 Page<BillingInfo> billingInfoList = billingRepository.search(customerQuery, PageRequest.of(0, 10));
                 billingInfoList.forEach(billingInfo -> System.out.println(billingInfo.toString()));
         }

        @Test
        public void saveBillingInfo() {
                billingRepository.save(new BillingInfo("1", "Alice"));
                billingRepository.save(new BillingInfo("2", "Bob"));
                billingRepository.save(new BillingInfo("3", "neo"));
                billingRepository.save(new BillingInfo("4", "summer"));
                for (int i = 20; i < 40; i++) {
                        billingRepository.save(new BillingInfo(i+"", "Alice"));
                }
        }

        @Test
        public void listByOrderNumber() {
                List<BillingInfo> list = billingRepository.getBillingInfoByOrderNumber("summer");
                list.forEach(x -> System.out.println(x.toString()));
        }

}
