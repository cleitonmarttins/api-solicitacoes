package br.com.cotiinformatica.api_solicitacoes.infrastructure.configurations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Bean
    ModelMapper modelMapper() {

        var modelMapper = new ModelMapper();

        Converter<LocalDateTime, String> localDateTimeToString =
                context -> context.getSource() == null
                        ? null
                        : context.getSource().format(DATE_TIME_FORMATTER);

        Converter<String, LocalDateTime> stringToLocalDateTime =
                context -> context.getSource() == null
                        ? null
                        : LocalDateTime.parse(
                        context.getSource(),
                        DATE_TIME_FORMATTER
                );

        modelMapper.addConverter(localDateTimeToString);
        modelMapper.addConverter(stringToLocalDateTime);

        return modelMapper;
    }
}