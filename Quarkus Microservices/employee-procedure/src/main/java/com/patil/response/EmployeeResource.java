package com.patil.response;

import com.patil.entity.Employee;
import com.patil.repo.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class EmployeeResource{



    @Inject
    EmployeeRepository employeeRepository;

    @Inject
    EntityManager entityManager;

    @GET
    public Response getEmp(){
        List<Employee> emp = employeeRepository.listAll();
        return Response.ok(emp).build();
    }

    //2nd way to call procedure
    @Transactional
    public Employee procedureCall(Employee employee){

        //calls stored procedure
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("insert_employee");

        // Register the input parameters  , Specify the parameter name, data type, and parameter mode (IN, OUT, INOUT):
        storedProcedure.registerStoredProcedureParameter("empName", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("empDept", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("empCast", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("empSalary", Long.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("empContact", Long.class, ParameterMode.IN);

        //Set Parameter Values:
        storedProcedure.setParameter("empName", employee.getEmpName());
        storedProcedure.setParameter("empDept", employee.getEmpDept());
        storedProcedure.setParameter("empCast", employee.getEmpCast());
        storedProcedure.setParameter("empSalary", employee.getEmpSalary());
        storedProcedure.setParameter("empContact", employee.getEmpContact());

        List<Employee> employeeList = storedProcedure.getResultList();

        if (employeeList.isEmpty()) {
            return null;
        } else {
            return employeeList.get(0);
        }
        // Execute the stored procedure
      //  storedProcedure.execute();


       // Retrieve the customer object and the email address
//        Employee emp = emplLIst.get(0);
//        String emailAddress = (String) storedProcedure.getParameter("email");

    }

    @POST
    @Transactional
    public Response saveEmp(Employee employee){
        //empName, empDept,empCast,empSalary,empContact
       // employeeRepository.insertEmployee(employee.getEmpName(),employee.getEmpDept(),employee.getEmpCast(),employee.getEmpSalary(),employee.getEmpContact());
        // Insert employee record using stored procedure
//        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("insert_employee");
//
//        // Register input parameters
//        storedProcedure.registerStoredProcedureParameter("empName", String.class, ParameterMode.IN);
//        storedProcedure.registerStoredProcedureParameter("empDept", String.class, ParameterMode.IN);
//        storedProcedure.registerStoredProcedureParameter("empCast", String.class, ParameterMode.IN);
//        storedProcedure.registerStoredProcedureParameter("empSalary", Long.class, ParameterMode.IN);
//        storedProcedure.registerStoredProcedureParameter("empContact", Long.class, ParameterMode.IN);
//
//        // Set parameter values
//        storedProcedure.setParameter("empName", employee.getEmpName());
//        storedProcedure.setParameter("empDept", employee.getEmpDept());
//        storedProcedure.setParameter("empCast", employee.getEmpCast());
//        storedProcedure.setParameter("empSalary", employee.getEmpSalary());
//        storedProcedure.setParameter("empContact", employee.getEmpContact());
//
//        // Execute stored procedure
//        storedProcedure.execute();

        // Use the named query to call the stored procedure
        employeeRepository.getEntityManager().createNamedStoredProcedureQuery("insert_employee")
                .setParameter("empName", employee.getEmpName())
                .setParameter("empDept", employee.getEmpDept())
                .setParameter("empCast", employee.getEmpCast())
                .setParameter("empSalary", employee.getEmpSalary())
                .setParameter("empContact", employee.getEmpContact())
                .execute();

        return Response.status(Response.Status.CREATED).build();
    }

//    @POST
//    @Transactional
//    public Response saveEmp(Employee employee){
//        //empName, empDept,empCast,empSalary,empContact
//        employeeRepository.insertEmployee(employee.getEmpName(),employee.getEmpDept(),employee.getEmpCast(),employee.getEmpSalary(),employee.getEmpContact());
//        return Response.status(Response.Status.CREATED).build();
//    }

}
