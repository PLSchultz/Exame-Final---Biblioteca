package com.example.biblioteca.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Radical")
                        .description("Você foi contratado por uma biblioteca renomada para desenvolver uma API que permita o gerenciamento de livros, autores e empréstimos. A biblioteca deseja modernizar seu sistema de gerenciamento e precisa de uma API robusta para realizar operações de cadastro, consulta, atualização e remoção de livros e empréstimos.")
                        .version("1.0")

                ).externalDocs(
                        new ExternalDocumentation()
                                .description("Pedro Sarmento, baseada na API feita em grupo para o PI"));
    }
}
