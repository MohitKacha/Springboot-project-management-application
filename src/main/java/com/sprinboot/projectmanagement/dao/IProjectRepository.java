package com.sprinboot.projectmanagement.dao;

import com.sprinboot.projectmanagement.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends CrudRepository<Project, Long> {
}
