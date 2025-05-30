package org.example.sample4.mapper;

import org.example.sample4.model.Sample4Domain;
import org.example.sample4.model.Sample4Dto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface Sample4Dto2DomainMapper {

    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "order.value", target = "orderValue")
    @Mapping(source = "param3", target = "domainParam3")
    Sample4Domain toDomain(Sample4Dto source);

}