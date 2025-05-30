package org.example.sample3.model;


import lombok.Data;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sample3Dto {
    private java.lang.String orderId;
    private java.lang.String orderValue;
    private java.lang.String param2;
    private java.lang.String param3;
}
