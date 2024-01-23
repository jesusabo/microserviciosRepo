package com.usuario.service.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usuario.service.modelos.Carro;

@FeignClient(name = "carro-service")
@RequestMapping("/carro")
public interface CarroFeignClient {
	
	@PostMapping("/guardar")
	public Carro save(@RequestBody Carro carro);

}
