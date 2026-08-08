package br.com.cotiinformatica.api_solicitacoes.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Solicitações")
                        .description("API REST para gerenciamento de solicitações.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("COTI Informática")));
    }
}