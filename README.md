# MapStructSample

MapStruct Sample Project

## Sample1: 通常パタン

- プロパティ名が同じ場合は、自動でマッピングされる。
- 型もいいあんばいに自動で変換してくれる
  - 手動でやるのは後述。qualifiedByName で指定する
- プロパティ名のマッピングを指定することも可能
  - ``unmappedTargetPolicy = ReportingPolicy.WARN` で、マッピングしていないプロパティがあったらコンパイル時に警告がでる

![alt text](sample1.png)

```java
package org.example.sample1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.example.sample1.model.Sample1Domain;
import org.example.sample1.model.Sample1Dto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface Sample1Dto2DomainMapper {
    @Mapping(source = "param3", target = "domainParam3")
    Sample1Domain toDomain(Sample1Dto source);
}
```

```java
package org.example;

import org.example.sample1.mapper.Sample1Dto2DomainMapper;
import org.example.sample1.model.Sample1Dto;
import org.example.sample2.mapper.Sample2Dto2DomainMapper;
import org.example.sample2.model.Sample2Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        {
            var from = new Sample1Dto("value1", "100", "value3");
            var mapper = context.getBean(Sample1Dto2DomainMapper.class);
            var to = mapper.toDomain(from);
            System.out.println(from);
            System.out.println(to);
        }

    }

}
```

実行結果

```console
Sample1Dto(param1=value1, param2=100, param3=value3)
Sample1Domain(param1=value1, param2=100, domainParam3=value3)
```

## Sample2: 個別の変換ロジックを挟みたい

プロパティごとに、個別の変換ロジックを適用したい場合。

- プロパティの単位で、個別の変換ロジックを適用できる
  - Mapper側で、``uses``と``qualifiedByName``を用いて``param3 → domainParam3``の変換には ``Sample2Dto2DomainConverter``クラスの``toInt`` というメソッドを使うと宣言
  - ``Sample2Dto2DomainConverter``クラス側では ``Named``で先の名前(``toInt``)を指定しておく


![alt text](sample2.png)


Mapper
```java
package org.example.sample2.mapper;

import org.example.Sample2Dto2DomainConverter;
import org.example.sample2.model.Sample2Domain;
import org.example.sample2.model.Sample2Dto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN, uses = Sample2Dto2DomainConverter.class)
public interface Sample2Dto2DomainMapper {

    @Mapping(source = "param3", target = "domainParam3", qualifiedByName = "toInt")
    Sample2Domain toDomain(Sample2Dto source);

}
```


個別の変換クラスを定義しておく
```java
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

```



Main
```java
package org.example;

import org.example.sample1.mapper.Sample1Dto2DomainMapper;
import org.example.sample1.model.Sample1Dto;
import org.example.sample2.mapper.Sample2Dto2DomainMapper;
import org.example.sample2.model.Sample2Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        {
            var from = new Sample2Dto("value1", "100", "49歳");
            var mapper = context.getBean(Sample2Dto2DomainMapper.class);
            var to = mapper.toDomain(from);
            System.out.println(from);
            System.out.println(to);
        }
    }

}
```
実行結果

```console
Converter#convert1がうごいた
Sample2Dto(param1=value1, param2=100, param3=49歳)
Sample2Domain(param1=value1, param2=100, domainParam3=49)
```



## Sample3: ネストされたオブジェクトにコピーする1

フラットなオブジェクトを、ネストされた構造にコピーしたい

- フラットなオブジェクト ``Sample3Dto``自体 → ``Order``クラスであるorderプロパティに渡すと考える
  - ``Sample3Dto``自体は ``.`` で表現する
  - 具体的には ``@Mapping(source = ".", target = "order")`` って書けばOK
  - ``Sample3Dto → Order`` のMapperは個別に作成しておくと(``Order toOrder(Sample3Dto source)``) と、自動で呼び出されるので、あとはなにもしなくてよい


![alt text](sample3.png)

Mapper
```java
package org.example.sample3.mapper;

import org.example.sample3.model.Order;
import org.example.sample3.model.Sample3Domain;
import org.example.sample3.model.Sample3Dto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface Sample3Dto2DomainMapper {

    @Mapping(source = "param3", target = "domainParam3")
    @Mapping(source = ".", target = "order")
    Sample3Domain toDomain(Sample3Dto source);

    @Mapping(source = "orderId", target = "id")
    @Mapping(source = "orderValue", target = "value")
    Order toOrder(Sample3Dto source);

}

```

Main

```java
package org.example;

import org.example.sample3.mapper.Sample3Dto2DomainMapper;
import org.example.sample3.model.Sample3Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        {
            var from = new Sample3Dto("0001", "オーダー001", "100", "49歳");
            var mapper = context.getBean(Sample3Dto2DomainMapper.class);
            var to = mapper.toDomain(from);

            System.out.println(from);
            System.out.println(to);
        }
    }

}

```

実行結果

```console
Sample3Dto(orderId=0001, orderValue=オーダー001, param2=100, param3=49歳)
Sample3Domain(order=Order(id=0001, value=オーダー001), param2=100, domainParam3=49歳)
```

## Sample3': ネストされたオブジェクトにコピーする2

ネストしたオブジェクトが、単一のプロパティからのマッピングで生成できるのであれば、既出のカスタマイズメソッド``qualifiedByName``方式でもOK。

![alt text](sample3dash.png)

```java
変更前
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface Sample3Dto2DomainMapper {

    @Mapping(source = "param3", target = "domainParam3")
    @Mapping(source = ".", target = "order")
    Sample3Domain toDomain(Sample3Dto source);

    @Mapping(source = "orderId", target = "id")
    @Mapping(source = "orderValue", target = "value")
    Order toOrder(Sample3Dto source);

}

変更後
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN, uses = Sample3Dto2DomainConverter.class)
public interface Sample3Dto2DomainMapper {

    @Mapping(source = "param3", target = "domainParam3")
    @Mapping(source = "orderId", target = "order", qualifiedByName = "toOrder")
    Sample3Domain toDomain(Sample3Dto source);

}
```

```java
@Mapper(componentModel = "spring")
public class Sample3Dto2DomainConverter {
    @Named("toOrder")
    public Order toOrder(String orderId) {
        return new Order(orderId);
    }
}
```

などとして、qualifiedByName でカスタマイズメソッドを挟むでもOK！




## Sample4: ネストされたオブジェクトのフラット化

先と逆で、ネストされたオブジェクトをフラットなオブジェクトにコピーしたい

- ネストされたプロパティへは ``@Mapping(source = "order.id", target = "orderId")`` と指定ができる

![alt text](sample4.png)


Mapper
```java
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

```





Main
```java
package org.example;


import org.example.sample4.model.Order;
import org.example.sample4.model.Sample4Dto;
import org.example.sample4.mapper.Sample4Dto2DomainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        {
            var from = new Sample4Dto(new Order("0001", "オーダー001"), "100", "49歳");
            var mapper = context.getBean(Sample4Dto2DomainMapper.class);
            var to = mapper.toDomain(from);

            System.out.println(from);
            System.out.println(to);

        }
    }

}

```
実行結果

```console
Sample4Dto(order=Order(id=0001, value=オーダー001), param2=100, param3=49歳)
Sample4Domain(orderId=0001, orderValue=オーダー001, param2=100, domainParam3=49歳)
```


