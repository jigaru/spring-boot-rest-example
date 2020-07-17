package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class ConfigurationItem {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @NotEmpty
  private String name;
  @NotEmpty
  private String description;
  private String ipAddress;
  private String macAddress;
  
  public ConfigurationItem(String name, String description, String ipAddress, String macAddress) {
    this.name = name;
    this.description = description;
    this.ipAddress = ipAddress;
    this.macAddress = macAddress;
  }

}