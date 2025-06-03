package org.example.sample2.model;


import lombok.Data;
import lombok.*;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sample2Domain {
  private  java.lang.String param1;
  private  java.lang.Integer param2;
  private  java.lang.String domainParam3;
}