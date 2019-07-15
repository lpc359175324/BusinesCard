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
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {
        @Autowired
        private BillingRepository billingRepository;

        /**
         * 对索引操作的API(创建索引，删除)
         */
        @Autowired
        private ElasticsearchTemplate esTemplate;

        public static void main(String[] args) {
                System.out.println("乱码");
        }
        @Test
        public void createIndex() {
                // 创建索引，会根据Item类的@Document注解信息来创建
                boolean index = esTemplate.createIndex(BillingInfo.class);
                // 配置映射，会根据Item类中的@Id、@Field等字段来自动完成映射
                boolean mapping = esTemplate.putMapping(BillingInfo.class);
                System.out.println("索引创建返回:"+index+"，mapping创建成功:"+mapping);

        }


        @Test
        public void listPageCustomers() {
                Sort sort = new Sort(Sort.Direction.DESC, "orderNumber.keyword");
                Pageable pageable = PageRequest.of(0, 5, sort);
                Page<BillingInfo> billingInfoList = billingRepository.getBillingInfoByOrderNumber("Alice", pageable);
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
                BillingInfo bill = new BillingInfo();
                billingRepository.save(new BillingInfo("2", "Bob"));
                for (int i = 20; i < 40; i++) {
                        billingRepository.save(new BillingInfo(i + "", "Alice"));
                }
        }

        @Test
        public void listByOrderNumber() {
                List<BillingInfo> list = billingRepository.getBillingInfoByOrderNumber("summer");
                list.forEach(x -> System.out.println(x.toString()));
        }

}
