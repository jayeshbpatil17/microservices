package com.patil.repo;

import com.patil.entity.Employee;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeRepo implements PanacheRepository<Employee> {
}
