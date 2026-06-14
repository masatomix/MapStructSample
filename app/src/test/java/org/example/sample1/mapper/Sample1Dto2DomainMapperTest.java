package org.example.sample1.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.sample1.model.Sample1Domain;
import org.example.sample1.model.Sample1Dto;
import org.junit.jupiter.api.Test;

/**
 * Sample1 の MapStruct マッピング検証（task#1071）。
 *
 * <p>componentModel="spring" のマッパーでも、生成される実装クラス
 * {@code Sample1Dto2DomainMapperImpl} は素の no-arg クラスのため、Spring コンテキスト
 * 無しで直接インスタンス化して単体テストできる。旧 AppTest（gradle init 生成の
 * 存在しない getGreeting() を参照する JUnit4 テンプレート）を置き換える。
 */
class Sample1Dto2DomainMapperTest {

    private final Sample1Dto2DomainMapper mapper = new Sample1Dto2DomainMapperImpl();

    @Test
    void toDomainMapsNamesAndConvertsType() {
        Sample1Dto dto = new Sample1Dto("val1", "100", "val3");

        Sample1Domain domain = mapper.toDomain(dto);

        // 同名プロパティはそのままコピー
        assertEquals("val1", domain.getParam1());
        // String "100" → Integer 100（MapStruct の型変換）
        assertEquals(Integer.valueOf(100), domain.getParam2());
        // @Mapping(source="param3", target="domainParam3")
        assertEquals("val3", domain.getDomainParam3());
    }

    @Test
    void toDomainUpdateCopiesIntoExistingTarget() {
        Sample1Dto dto = new Sample1Dto("a", "200", "c");
        Sample1Domain target = new Sample1Domain();

        mapper.toDomainUpdate(dto, target);

        assertEquals("a", target.getParam1());
        assertEquals(Integer.valueOf(200), target.getParam2());
        assertEquals("c", target.getDomainParam3());
    }
}
