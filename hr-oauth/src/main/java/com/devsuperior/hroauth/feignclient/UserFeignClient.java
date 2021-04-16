package com.devsuperior.hroauth.feignclient;

import com.devsuperior.hroauth.config.AppConfig;
import com.devsuperior.hroauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user", path = "/users", configuration = AppConfig.class)
public interface UserFeignClient {

    @GetMapping("/search")
    User findByEmail(@RequestParam String email);

}
