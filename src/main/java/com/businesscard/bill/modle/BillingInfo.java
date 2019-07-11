package com.businesscard.bill.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(indexName = "billing_info", type = "bill", shards = 1, replicas = 0, refreshInterval = "-1")
public class BillingInfo {
        /**
         * ID
         */
        @Id
        private String id;

        /**
         * 订单号
         */
        @NonNull
        private String orderNumber;
        //交易号商家订单号
        //交易创建时间
        //付款时间
        //最近修改时间
        //交易来源地
        //类型
        //交易对方
        //商品名称
        //金额
        //收/支
        //交易状态
        //服务费
        //成功退款
        //备注资金状态


}
