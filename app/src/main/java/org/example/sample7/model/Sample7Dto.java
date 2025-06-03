package org.example.sample7.model;


import lombok.Data;
import lombok.*;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sample7Dto {
  private  java.util.List<org.example.sample3.model.Sample3Dto> sample3dtos;
}