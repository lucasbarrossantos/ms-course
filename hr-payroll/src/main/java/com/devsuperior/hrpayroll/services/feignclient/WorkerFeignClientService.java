package com.devsuperior.hrpayroll.services.feignclient;

import com.devsuperior.hrpayroll.config.http.DataObject;
import com.devsuperior.hrpayroll.entities.Worker;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class WorkerFeignClientService {

    private final WorkerFeignClient client;

    private final ObjectMapper mapper = new ObjectMapper();

    public Worker getWorkerById(Long id) throws Exception {
        try {
            DataObject data = client.findById(id);
            return mapper.convertValue(data.getData(), Worker.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Entidade não encontrada! " + e.getMessage());
        }
    }

}
