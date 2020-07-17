package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.entity.ConfigurationItem;
import com.example.repository.ConfigurationItemRepository;

@SpringBootApplication
public class ConfigurationItemApplication {
	public static void main(String[] args) {
        SpringApplication.run(ConfigurationItemApplication.class);
    }

    @Bean
    public CommandLineRunner sampleData(ConfigurationItemRepository repository) {
        return (args) -> {
            repository.save(new ConfigurationItem("S12345VM", "Windows VM", "10.0.1.0", "10.0.1.1"));
            repository.save(new ConfigurationItem("S45678VM", "Ubuntu VM",  "10.0.2.0", "10.0.2.1"));
            repository.save(new ConfigurationItem("S67890VM", "RHEL VM", "10.0.3.0", "10.0.3.1"));
            repository.save(new ConfigurationItem("S02468VM", "Centos VM", "10.0.4.0", "10.0.4.1"));
        };
    }
}