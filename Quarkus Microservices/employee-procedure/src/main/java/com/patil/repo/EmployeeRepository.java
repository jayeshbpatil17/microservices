package com.patil.repo;

import com.patil.entity.Employee;
import io.quarkus.arc.DefaultBean;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BeanParam;
import jdk.jfr.Registered;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.jboss.logging.annotations.Producer;



@ApplicationScoped
public interface EmployeeRepository extends PanacheRepositoryBase<Employee, Long> {

    //public void insertEmployee(String empName,String empDept ,String empCast , Long empSalary , Long empContact);

}
