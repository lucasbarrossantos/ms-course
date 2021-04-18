package com.devsuperior.hrworker.v1.adapter.repository;

import com.devsuperior.hrworker.v1.adapter.entity.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {

}
