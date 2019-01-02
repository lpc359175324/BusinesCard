package com.businesscard.bill.repository;

import com.businesscard.bill.modle.BillingInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BillingRepository extends ElasticsearchRepository<BillingInfo,String> {
}
