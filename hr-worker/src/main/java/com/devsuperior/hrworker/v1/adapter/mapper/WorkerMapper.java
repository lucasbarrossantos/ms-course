package com.devsuperior.hrworker.v1.adapter.mapper;

import com.devsuperior.hrworker.v1.adapter.entity.WorkerEntity;
import com.devsuperior.hrworker.v1.core.model.Worker;

import java.util.Collection;
import java.util.stream.Collectors;

public class WorkerMapper {

    public static Collection<WorkerEntity> toCollectionEntities(Collection<Worker> models) {
        return models.stream().map(WorkerMapper::toEntity).collect(Collectors.toList());
    }

    public static Collection<Worker> toCollectionModels(Collection<WorkerEntity> entities) {
        return entities.stream().map(WorkerMapper::toModel).collect(Collectors.toList());
    }

    private WorkerMapper(){
        super();
    }

    public static Worker toModel(WorkerEntity entity) {
        return Worker.builder()
                .id(entity.getId())
                .name(entity.getName())
                .dailyIncome(entity.getDailyIncome())
                .build();
    }

    public static WorkerEntity toEntity(Worker model) {
        return WorkerEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .dailyIncome(model.getDailyIncome())
                .build();
    }

}
