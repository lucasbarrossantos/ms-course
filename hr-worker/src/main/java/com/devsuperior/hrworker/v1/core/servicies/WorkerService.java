package com.devsuperior.hrworker.v1.core.servicies;

import com.devsuperior.hrworker.v1.adapter.mapper.WorkerMapper;
import com.devsuperior.hrworker.v1.adapter.repository.WorkerRepository;
import com.devsuperior.hrworker.v1.core.servicies.exception.WorkerNotFoundException;
import com.devsuperior.hrworker.v1.core.model.Worker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public List<Worker> getAllWorkers() {
        return new ArrayList<>(WorkerMapper.toCollectionModels(workerRepository.findAll()));
    }

    public Worker findById(Long id) {
        return WorkerMapper.toModel(workerRepository.findById(id).orElseThrow(() -> new WorkerNotFoundException(id)));
    }
}
