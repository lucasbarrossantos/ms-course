package com.devsuperior.hrpayroll.resources;

import com.devsuperior.hrpayroll.config.http.DataObject;
import com.devsuperior.hrpayroll.config.http.Response;
import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/payments")
public class PaymentResource {

    private final PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Response> getPayment(@PathVariable Long workerId, @PathVariable int days) {
        return ResponseEntity.ok(DataObject.build(paymentService.getPayment(workerId, days)));
    }

    public ResponseEntity<Response> getPaymentAlternative(Long workerId, int days) {
        Payment payment = Payment.builder()
                .name("Brann")
                .dailyIncome(400.0)
                .days(days)
                .build();

        return ResponseEntity.ok(DataObject.build(payment));
    }

}
