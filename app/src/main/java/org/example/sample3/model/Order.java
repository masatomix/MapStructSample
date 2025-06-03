package org.example.sample3.model;


import lombok.Data;
import lombok.*;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
  private  java.lang.String id;
  private  java.lang.String value;
}