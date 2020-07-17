package com.example.rest;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.entity.ConfigurationItem;
import com.example.repository.ConfigurationItemRepository;

@RestController
public class ConfigurationItemApi {
	private final ConfigurationItemRepository configurationItemRepo;

    public ConfigurationItemApi(ConfigurationItemRepository configurationItemRepo) {
        this.configurationItemRepo = configurationItemRepo;
    }

    @GetMapping(value = "/ci", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ConfigurationItem> getConfigurationItems() {
        return configurationItemRepo.findAll();
    }

    @GetMapping(value = "/ci/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ConfigurationItem getConfigurationItem(@PathVariable long id){
        return configurationItemRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ci id %s", id)));
    }

    @PostMapping(value = "/ci", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ConfigurationItem createConfigurationItem(@Valid @RequestBody ConfigurationItem configurationItem) {
        return configurationItemRepo.save(configurationItem);
    }
}
