/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import product.services.AddProductValidator;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;
import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class App {
    public String getGreeting() {
        return "Hello world.";
    }
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println(new App().getGreeting());
    }

    @Bean("dataSource")
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/nokia_inventory?useSSL=false")
                .username("root")
                .password("root")
                .build();
    }

    @Bean("validator")

    public AddProductValidator validator() {
        return  new AddProductValidator();
    }

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Product",
                "This Service Takes Products ",
                "1.0",
                "No Conditions",
                new Contact("ashvin","none","none"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}
