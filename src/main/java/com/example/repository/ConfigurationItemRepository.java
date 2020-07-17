package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ConfigurationItem;

@Repository
public interface ConfigurationItemRepository extends CrudRepository<ConfigurationItem, Long> {

    List<ConfigurationItem> findByName(String name);
}