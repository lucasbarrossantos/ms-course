package com.devsuperior.hrpayroll.services.feignclient;

import com.devsuperior.hrpayroll.config.AppConfig;
import com.devsuperior.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers", configuration = AppConfig.class)
public interface WorkerFeignClient {

    @GetMapping("/{id}")
    Worker findById(@PathVariable Long id);

}
