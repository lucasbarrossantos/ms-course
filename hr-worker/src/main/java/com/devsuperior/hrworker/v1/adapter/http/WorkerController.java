package com.devsuperior.hrworker.v1.adapter.http;

import com.devsuperior.hrworker.v1.adapter.http.confg.DataArray;
import com.devsuperior.hrworker.v1.adapter.http.confg.DataObject;
import com.devsuperior.hrworker.v1.adapter.http.confg.Response;
import com.devsuperior.hrworker.v1.core.servicies.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;
    private final Environment env;

    @GetMapping
    public ResponseEntity<Response> getAllWorkers() {
        return ResponseEntity.ok(DataArray.build(workerService.getAllWorkers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> findById(@PathVariable Long id) {
        log.info("PORT: {}", env.getProperty("local.server.port"));
        return ResponseEntity.ok(DataObject.build(workerService.findById(id)));
    }

}
