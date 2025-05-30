package org.example.sample6.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import org.mapstruct.ReportingPolicy;
import org.mapstruct.BeanMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;



@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.WARN  )
public interface Sample6Dto2DomainMapper {

  
     /**
     * source をorg.example.sample6.model.Sample6Domain1 クラスへ変換する。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    org.example.sample6.model.Sample6Domain1 toDomain1(org.example.sample6.model.Sample6Dto source);



     /**
     * org.example.sample6.model.Sample6Dto source の各プロパティをorg.example.sample6.model.Sample6Domain1 target へコピーする。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    void toDomain1Update(org.example.sample6.model.Sample6Dto source, @MappingTarget org.example.sample6.model.Sample6Domain1 target);


  
     /**
     * source をorg.example.sample6.model.Sample6Domain2 クラスへ変換する。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    org.example.sample6.model.Sample6Domain2 toDomain2(org.example.sample6.model.Sample6Dto source);



     /**
     * org.example.sample6.model.Sample6Dto source の各プロパティをorg.example.sample6.model.Sample6Domain2 target へコピーする。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    void toDomain2Update(org.example.sample6.model.Sample6Dto source, @MappingTarget org.example.sample6.model.Sample6Domain2 target);


  
     /**
     * source をorg.example.sample6.model.Sample6Domain3 クラスへ変換する。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(target = "id" , ignore = true)
    org.example.sample6.model.Sample6Domain3 toDomain3(org.example.sample6.model.Sample6Dto source);



     /**
     * org.example.sample6.model.Sample6Dto source の各プロパティをorg.example.sample6.model.Sample6Domain3 target へコピーする。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(target = "id" , ignore = true)
    void toDomain3Update(org.example.sample6.model.Sample6Dto source, @MappingTarget org.example.sample6.model.Sample6Domain3 target);


}