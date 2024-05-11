package com.back_api.backend_api.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfi {
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
