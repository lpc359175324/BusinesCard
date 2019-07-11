package com.businesscard.bill.repository;

import com.businesscard.bill.modle.BillingInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BillingRepository extends ElasticsearchRepository<BillingInfo, String> {
        /**
         *获取订单信息
         * @param orderNumber
         * @return
         */
        public List<BillingInfo> getBillingInfoByOrderNumber(String orderNumber);



}
