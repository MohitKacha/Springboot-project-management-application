package com.sprinboot.projectmanagement.dao;

import com.sprinboot.projectmanagement.dto.ChartData;
import com.sprinboot.projectmanagement.dto.EmployeeProject;
import com.sprinboot.projectmanagement.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectRepository extends CrudRepository<Project, Long> {

    @Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as value " +
            "FROM project " +
            "GROUP BY stage")
    public List<ChartData> getProjectStatus();
}
