package com.kafka.producer.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TransactionDetails {
    String id;
    String status;
    String amount;
}
