package org.example.sample2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import org.mapstruct.ReportingPolicy;
import org.mapstruct.BeanMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;



@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.WARN , uses = { org.example.Sample2Dto2DomainConverter.class,  } )
public interface Sample2Dto2DomainMapper {

  
     /**
     * source をorg.example.sample2.model.Sample2Domain クラスへ変換する。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(source = "param3", target = "domainParam3" ,qualifiedByName = "toInt")
    org.example.sample2.model.Sample2Domain toDomain(org.example.sample2.model.Sample2Dto source);



     /**
     * org.example.sample2.model.Sample2Dto source の各プロパティをorg.example.sample2.model.Sample2Domain target へコピーする。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(source = "param3", target = "domainParam3" ,qualifiedByName = "toInt")
    void toDomainUpdate(org.example.sample2.model.Sample2Dto source, @MappingTarget org.example.sample2.model.Sample2Domain target);


}