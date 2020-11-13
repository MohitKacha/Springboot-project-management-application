package com.sprinboot.projectmanagement.dao;

import com.sprinboot.projectmanagement.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee,Long> {
}
