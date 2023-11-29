package com.patil.resource;

import com.patil.entity.Employee;
import com.patil.repo.EmployeeRepo;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    EmployeeRepo employeeRepo;

    @Inject
    EntityManager entityManager;

    @POST
    @Transactional
    public Response saveEmp(Employee employee){
//        empName, empDept,empCast,empSalary,empContact
//         employeeRepository.insertEmployee(employee.getEmpName(),employee.getEmpDept(),employee.getEmpCast(),employee.getEmpSalary(),employee.getEmpContact());

//         1st way to Insert employee record using stored procedure
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("insert_employee");

        // Register input parameters
        storedProcedure.registerStoredProcedureParameter("empName", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("empDept", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("empCast", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("empSalary", Long.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("empContact", Long.class, ParameterMode.IN);

        // Set parameter values
        storedProcedure.setParameter("empName", employee.getEmpName());
        storedProcedure.setParameter("empDept", employee.getEmpDept());
        storedProcedure.setParameter("empCast", employee.getEmpCast());
        storedProcedure.setParameter("empSalary", employee.getEmpSalary());
        storedProcedure.setParameter("empContact", employee.getEmpContact());

        // Execute stored procedure
        storedProcedure.execute();

//        // Second Way to Use the named query to call the stored procedure
//        employeeRepository.getEntityManager().createNamedStoredProcedureQuery("insert_employee")
//                .setParameter("empName", employee.getEmpName())
//                .setParameter("empDept", employee.getEmpDept())
//                .setParameter("empCast", employee.getEmpCast())
//                .setParameter("empSalary", employee.getEmpSalary())
//                .setParameter("empContact", employee.getEmpContact())
//                .execute();

        return Response.status(Response.Status.CREATED).build();
    }

}
