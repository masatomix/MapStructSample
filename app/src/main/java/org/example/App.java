package org.example;

import org.example.sample1.mapper.Sample1Dto2DomainMapper;
import org.example.sample1.model.Sample1Dto;
import org.example.sample2.mapper.Sample2Dto2DomainMapper;
import org.example.sample2.model.Sample2Dto;
import org.example.sample3.mapper.Sample3Dto2DomainMapper;
import org.example.sample3.model.Sample3Dto;
import org.example.sample4.mapper.Sample4Dto2DomainMapper;
import org.example.sample4.model.Order;
import org.example.sample4.model.Sample4Dto;
import org.example.sample5.mapper.Sample5Dto2DomainMapper;
import org.example.sample5.model.Sample5Domain;
import org.example.sample5.model.Sample5Dto1;
import org.example.sample5.model.Sample5Dto2;
import org.example.sample5.model.Sample5Dto3;
import org.example.sample6.mapper.Sample6Dto2DomainMapper;
import org.example.sample6.model.Sample6Dto;
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

        {
            var from = new Sample2Dto("value1", "100", "49歳");
            var mapper = context.getBean(Sample2Dto2DomainMapper.class);
            var to = mapper.toDomain(from);
            System.out.println(from);
            System.out.println(to);
        }

        {
            var from = new Sample3Dto("0001", "オーダー001", "100", "49歳");
            var mapper = context.getBean(Sample3Dto2DomainMapper.class);
            var to = mapper.toDomain(from);

            System.out.println(from);
            System.out.println(to);

            // var inv = new Sample3Dto();
            // System.out.println(mapper.toDomainInverse(to));
            // mapper.toDomainUpdateInverse(to, inv);
            // mapper.toOrderUpdateInverse(to.getOrder(), inv);
            // System.out.println(inv);
        }

        {
            var from = new Sample4Dto(new Order("0001", "オーダー001"), "100", "49歳");
            var mapper = context.getBean(Sample4Dto2DomainMapper.class);
            var to = mapper.toDomain(from);

            System.out.println(from);
            System.out.println(to);

        }
        {
            var from1 = new Sample5Dto1("id1", "value1");
            var from2 = new Sample5Dto2("id2", "value2");
            var from3 = new Sample5Dto3("id3", "value3");

            var mapper = context.getBean(Sample5Dto2DomainMapper.class);
            Sample5Domain to = null;

            to = new Sample5Domain();
            mapper.toDomainUpdate(from1, to);
            System.out.println(to + ": v1だけ、コピーされた");
            mapper.toDomainUpdate(from2, to);
            System.out.println(to + ": id,v2だけ、コピーされた");
            mapper.toDomainUpdate(from3, to);
            System.out.println(to + ": v3だけ、コピーされた");

            // to = new Sample5Domain();
            // mapper.toDomainUpdate(from1, from2, from3, to);
            // System.out.println(to);
        }
        {

            var from = new Sample6Dto("id", "value1", "value2", "value3");
            var mapper = context.getBean(Sample6Dto2DomainMapper.class);
            System.out.println(from);
            System.out.println(mapper.toDomain1(from));
            System.out.println(mapper.toDomain2(from));
            System.out.println(mapper.toDomain3(from)+ ": idコピーはちゃんと除外できた");
        }

    }

}