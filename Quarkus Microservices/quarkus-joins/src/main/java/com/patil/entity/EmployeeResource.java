package com.patil.entity;


import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    EmployeeRepo employeeRepo;

    @Inject
    DepartmentRepo departmentRepo;

    //Right JOIN
//    @GET
//    @Path("/with-departments")
//    public Response getEmployeesWithDepartments() {
//
//        List<Employee> emp = employeeRepo.find("select e from Employee e right join fetch e.department").list();
//        return Response.ok(emp).build();
//    }

    @GET
    @Path("/departments")
    public List<Employee> getEmployeesWithDepartments() {
        return employeeRepo.find("SELECT e FROM Employee e LEFT JOIN Department d ON e.department.id = d.id").list();
    }

    @POST
    @Path("/emp")
    @Transactional
    public Response setEmployee(Employee employee){
        employeeRepo.persist(employee);
        return Response.ok().build();

    }

    @POST
    @Path("/dept")
    @Transactional
    public Response setDept(Department department){
        departmentRepo.persist(department);
        return Response.ok().build();

    }


}
