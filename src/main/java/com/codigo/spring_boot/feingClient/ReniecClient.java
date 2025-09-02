package com.codigo.spring_boot.feingClient;

import com.codigo.spring_boot.dto.ReniecResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "reniec-client", url = "https://api.decolecta.com/v1/reniec/dni")
public interface ReniecClient {

    @GetMapping()
    ReniecResponse getPersona(@RequestParam String numero, @RequestHeader("Authorization") String token);
}
