package br.com.cotiinformatica.api_solicitacoes;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class ApiSolicitacoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSolicitacoesApplication.class, args);
	}

}
