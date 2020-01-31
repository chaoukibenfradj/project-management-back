package com.jihene.parc.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jihene.parc.model.entity.Task;

public interface taskRepository extends JpaRepository<Task, Long>{
    List<Task> findAll();

}
