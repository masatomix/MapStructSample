package org.example.sample8.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import org.mapstruct.ReportingPolicy;
import org.mapstruct.BeanMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;



@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.WARN , uses = { org.example.sample1.mapper.Sample1Dto2DomainMapper.class,  } )
public interface Sample8Dto2DomainMapper {

  
     /**
     * source をjava.util.List<org.example.sample1.model.Sample1Domain> クラスへ変換する。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    java.util.List<org.example.sample1.model.Sample1Domain> toDomain(java.util.List<org.example.sample1.model.Sample1Dto> source);



     /**
     * java.util.List<org.example.sample1.model.Sample1Dto> source の各プロパティをjava.util.List<org.example.sample1.model.Sample1Domain> target へコピーする。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    void toDomainUpdate(java.util.List<org.example.sample1.model.Sample1Dto> source, @MappingTarget java.util.List<org.example.sample1.model.Sample1Domain> target);


}