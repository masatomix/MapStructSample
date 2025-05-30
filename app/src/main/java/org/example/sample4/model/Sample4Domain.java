package org.example.sample4.model;


import lombok.Data;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sample4Domain {
    private java.lang.String orderId;
    private java.lang.String orderValue;
    private java.lang.Integer param2;
    private java.lang.String domainParam3;
}
