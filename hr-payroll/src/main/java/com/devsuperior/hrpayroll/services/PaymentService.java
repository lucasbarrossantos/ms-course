package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    private final RestTemplate restTemplate;

    public Payment getPayment(long workerId, int days) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("id", workerId);

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
        assert worker != null;

        return Payment.builder()
                .name(worker.getName())
                .dailyIncome(worker.getDailyIncome())
                .days(days)
                .build();
    }

}
