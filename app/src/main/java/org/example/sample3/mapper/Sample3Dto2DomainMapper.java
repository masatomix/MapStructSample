package org.example.sample3.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import org.mapstruct.ReportingPolicy;
import org.mapstruct.BeanMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.WARN 
)
public interface Sample3Dto2DomainMapper {

  
     /**
     * source をorg.example.sample3.model.Order クラスへ変換する。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(source = "orderId", target = "id")
    @Mapping(source = "orderValue", target = "value")
    org.example.sample3.model.Order toOrder(org.example.sample3.model.Sample3Dto source);





     /**
     * org.example.sample3.model.Sample3Dto source の各プロパティをorg.example.sample3.model.Order target へコピーする。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(source = "orderId", target = "id")
    @Mapping(source = "orderValue", target = "value")
    void toOrderUpdate(org.example.sample3.model.Sample3Dto source, @MappingTarget org.example.sample3.model.Order target);

    

  
     /**
     * source をorg.example.sample3.model.Sample3Domain クラスへ変換する。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(source = "param3", target = "domainParam3")
    @Mapping(source = ".", target = "order")
    org.example.sample3.model.Sample3Domain toDomain(org.example.sample3.model.Sample3Dto source);





     /**
     * org.example.sample3.model.Sample3Dto source の各プロパティをorg.example.sample3.model.Sample3Domain target へコピーする。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(source = "param3", target = "domainParam3")
    @Mapping(source = ".", target = "order")
    void toDomainUpdate(org.example.sample3.model.Sample3Dto source, @MappingTarget org.example.sample3.model.Sample3Domain target);

    

}