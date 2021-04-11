package com.devsuperior.hrworker.servicies;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import com.devsuperior.hrworker.servicies.exception.WorkerNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    public Worker findById(Long id) {
        return workerRepository.findById(id).orElseThrow(() -> new WorkerNotFoundException(id));
    }
}
