package org.example;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class Sample2Dto2DomainConverter {

    @Named("toInt")
    public Integer convert1(String value) {
        System.out.println("Converter#convert1がうごいた");
        // カスタム変換ロジック
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        String target = value.trim();
        String trim = target.endsWith("歳") ? target.substring(0, target.length() - 1) : target;

        return Integer.parseInt(trim);
    }

}
