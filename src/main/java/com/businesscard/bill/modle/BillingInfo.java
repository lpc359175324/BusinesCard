package com.businesscard.bill.modle;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Document(indexName = "billing_info", type = "bill", shards = 1, replicas = 0, refreshInterval = "-1")
public class BillingInfo {
        /**
         * ID
         */
        @Id
        @NonNull
        private String id;
        /**
         * 订单号
         */
        @NonNull
        private String orderNumber;
        /**
         *交易号商家订单号
         */
        private String MerchantOrderNumber;
        /**
         *交易创建时间
         */
        private String TransactionCreationTime;
        /**
         *付款时间
         */
        private String TimeOfPayment;
        /**
         *最近修改时间
         */
        private String LastModifiedTime;
        /**
         *交易来源地
         */
        private String SourceOfTransaction;
        /**
         *类型
         */
        private String Type;
        /**
         *交易对方
         */
        private String TheDealingParty;
        /**
         *商品名称
         */
        private String NameOfCommodity;
        /**
         *金额
         */
        private String Amount;
        /**
         *收支
         */
        private String BalanceOfPayments;
        /**
         *交易状态
         */
        private String TransactionStatus;
        /**
         *服务费
         */
        private String TheServiceFee;
        /**
         *成功退款
         */
        private String SuccessfulOfRefund;
        /**
         *备注资金状态
         */
        private String RemarksFundStatus;
}
