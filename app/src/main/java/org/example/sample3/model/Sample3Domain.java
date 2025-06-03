package org.example.sample3.model;


import lombok.Data;
import lombok.*;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sample3Domain {
  private  org.example.sample3.model.Order order;
  private  java.lang.Integer param2;
  private  java.lang.String domainParam3;
}