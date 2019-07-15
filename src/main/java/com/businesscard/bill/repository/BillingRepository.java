package com.businesscard.bill.repository;

import com.businesscard.bill.modle.BillingInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author lpc
 */
public interface BillingRepository extends ElasticsearchRepository<BillingInfo, String> {
        /**
         *获取订单信息
         * @param orderNumber
         * @param
         * @return
         */
         List<BillingInfo> getBillingInfoByOrderNumber(String orderNumber);
        /**
         *分页
         * @param orderNumber
         * @param pageable
         * @return
         */
         Page<BillingInfo> getBillingInfoByOrderNumber(String orderNumber,Pageable pageable);

}
