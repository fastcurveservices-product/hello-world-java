package com.fastcurveservices.helloworld.repository;

import com.fastcurveservices.helloworld.entity.DemoEntity;
import org.springframework.data.repository.CrudRepository;

public interface DemoEntityRepository extends CrudRepository<DemoEntity, Long> {
}
