package com.patil.entity;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeRepo implements PanacheRepository<Employee>{

    public Employee findByEmpId(String empId) {
        return find("empId", empId).firstResult();
    }

}
