package org.example.sample5.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import org.mapstruct.ReportingPolicy;
import org.mapstruct.BeanMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;



@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.WARN  )
public interface Sample5Dto2DomainMapper {

  
     /**
     * source をorg.example.sample5.model.Sample5Domain クラスへ変換する。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(target = "id" , ignore = true)
    @Mapping(source = "v1", target = "v1")
    @Mapping(target = "v2" , ignore = true)
    @Mapping(target = "v3" , ignore = true)
    org.example.sample5.model.Sample5Domain toDomain(org.example.sample5.model.Sample5Dto1 source);



     /**
     * org.example.sample5.model.Sample5Dto1 source の各プロパティをorg.example.sample5.model.Sample5Domain target へコピーする。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(target = "id" , ignore = true)
    @Mapping(source = "v1", target = "v1")
    @Mapping(target = "v2" , ignore = true)
    @Mapping(target = "v3" , ignore = true)
    void toDomainUpdate(org.example.sample5.model.Sample5Dto1 source, @MappingTarget org.example.sample5.model.Sample5Domain target);


  
     /**
     * source をorg.example.sample5.model.Sample5Domain クラスへ変換する。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(source = "id", target = "id")
    @Mapping(target = "v1" , ignore = true)
    @Mapping(source = "v2", target = "v2")
    @Mapping(target = "v3" , ignore = true)
    org.example.sample5.model.Sample5Domain toDomain(org.example.sample5.model.Sample5Dto2 source);



     /**
     * org.example.sample5.model.Sample5Dto2 source の各プロパティをorg.example.sample5.model.Sample5Domain target へコピーする。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(source = "id", target = "id")
    @Mapping(target = "v1" , ignore = true)
    @Mapping(source = "v2", target = "v2")
    @Mapping(target = "v3" , ignore = true)
    void toDomainUpdate(org.example.sample5.model.Sample5Dto2 source, @MappingTarget org.example.sample5.model.Sample5Domain target);


  
     /**
     * source をorg.example.sample5.model.Sample5Domain クラスへ変換する。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "v1" , ignore = true)
    @Mapping(target = "v2" , ignore = true)
    @Mapping(source = "v3", target = "v3")
    org.example.sample5.model.Sample5Domain toDomain(org.example.sample5.model.Sample5Dto3 source);



     /**
     * org.example.sample5.model.Sample5Dto3 source の各プロパティをorg.example.sample5.model.Sample5Domain target へコピーする。
     * @Mapping(source = "param1", target = "param2") などで、プロパティ名の関連付けも可能
     * @BeanMapping(ignoreByDefault = true)とした場合は、プロパティ名一致による自動変換はおこなわない。
     * @param source
     * @return
     */
    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "v1" , ignore = true)
    @Mapping(target = "v2" , ignore = true)
    @Mapping(source = "v3", target = "v3")
    void toDomainUpdate(org.example.sample5.model.Sample5Dto3 source, @MappingTarget org.example.sample5.model.Sample5Domain target);


}