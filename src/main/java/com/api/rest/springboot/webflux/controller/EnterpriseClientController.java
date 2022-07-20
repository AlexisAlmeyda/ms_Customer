package com.api.rest.springboot.webflux.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.springboot.webflux.dto.EnterpriseClientDto;
import com.api.rest.springboot.webflux.resource.EnterpriseClientResource;
import com.api.rest.springboot.webflux.webclient.dto.ActiveProduct;
import com.api.rest.springboot.webflux.webclient.dto.PassiveProduct;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/client/enterprise")
public class EnterpriseClientController {
  
  private static final Logger logger = LoggerFactory.getLogger(EnterpriseClientController.class);
  
  @Autowired
  private EnterpriseClientResource enterpriseClientResource;
  
  @GetMapping
  public Flux<EnterpriseClientDto> findAll(){
    logger.debug("Getting EnterpriseClient");
      return enterpriseClientResource.findAll();
  }
  
  @PostMapping
  public Mono<EnterpriseClientDto> register(@Valid @RequestBody EnterpriseClientDto enterpriseClientDto){
      logger.debug("Register EnterpriseClient");
      return enterpriseClientResource.create(enterpriseClientDto);
  }
  
  @GetMapping("/{id}")
  public Mono<EnterpriseClientDto> listById(@PathVariable String id){
    logger.debug("Getting EnterpriseClientbyid");
    return enterpriseClientResource.findById(id);
  }
  
  @PutMapping("/{id}")
  public Mono<EnterpriseClientDto> update(@RequestBody EnterpriseClientDto enterpriseClientDto, @PathVariable String id){
    logger.debug("Putting EnterpriseClientbyid");
      return enterpriseClientResource.update(enterpriseClientDto, id);
  }
  
  @DeleteMapping("/{id}")
  public Mono<Void> remove(@PathVariable String id){
    return enterpriseClientResource.delete(id);
  }
  
  //Se agrego para WebConfig
  @GetMapping("/enterpriseActives/{idClient}")
  public Flux<ActiveProduct> getCreditCards(@PathVariable("idClient") String idClient){
    return enterpriseClientResource.getCreditCards(idClient);
  }
  
  @GetMapping("/enterprisePassives/{idClient}")
  public Flux<PassiveProduct> getNumberAccounts(@PathVariable("idClient") String idClient){
    return enterpriseClientResource.getNumberAccounts(idClient);
  }

}
