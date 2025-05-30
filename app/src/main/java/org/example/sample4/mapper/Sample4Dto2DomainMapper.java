package org.example.sample4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import org.mapstruct.ReportingPolicy;
import org.mapstruct.BeanMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;



@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.WARN  )
public interface Sample4Dto2DomainMapper {

  
     /**
     * source をorg.example.sample4.model.Sample4Domain クラスへ変換する。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "order.value", target = "orderValue")
    @Mapping(source = "param3", target = "domainParam3")
    org.example.sample4.model.Sample4Domain toDomain(org.example.sample4.model.Sample4Dto source);



     /**
     * org.example.sample4.model.Sample4Dto source の各プロパティをorg.example.sample4.model.Sample4Domain target へコピーする。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "order.value", target = "orderValue")
    @Mapping(source = "param3", target = "domainParam3")
    void toDomainUpdate(org.example.sample4.model.Sample4Dto source, @MappingTarget org.example.sample4.model.Sample4Domain target);


}