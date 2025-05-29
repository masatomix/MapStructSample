package org.example;

// import org.example.sample1.mapper.Sample1Dto2DomainMapper;
// import org.example.sample1.model.Sample1Dto;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App implements CommandLineRunner {
    // @Autowired
    // private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(new App().getGreeting());

        // {
        //     {
        //         var mapper = context.getBean(Sample1Dto2DomainMapper.class);
        //         var result = mapper.toDomain(new Sample1Dto("value1", "100", "value3"));
        //         System.out.println(result);
        //     }
        // }
    }

    public String getGreeting() {
        return "Hello World!";
    }
}