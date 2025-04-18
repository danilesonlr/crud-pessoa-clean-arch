package br.com.pessoa.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Minha API")
                        .description("Documentação da API com Swagger")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Seu Nome")
                                .email("seu@email.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                );
    }


    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("pessoa")
                .packagesToScan("br.com.pessoa.controller;")
                .build();
    }
}
