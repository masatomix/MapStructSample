package org.example.sample4.model;


import lombok.Data;
import lombok.*;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sample4Dto {
  private  org.example.sample4.model.Order order;
  private  java.lang.String param2;
  private  java.lang.String param3;
}