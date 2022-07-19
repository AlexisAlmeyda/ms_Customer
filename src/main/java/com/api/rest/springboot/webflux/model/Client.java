package com.api.rest.springboot.webflux.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import com.api.rest.springboot.webflux.util.ValidationConstants;

import lombok.Data;

@Data
public class Client {
  
  @Id
  private String id;
  
  private String name;
  
  private String documentType;
  
  private String email;
  
  private String address;
  
  private String phone;

  @CreatedDate
  private LocalDateTime createdDate;
  
  @LastModifiedDate
  private LocalDateTime updatedDate;

}
