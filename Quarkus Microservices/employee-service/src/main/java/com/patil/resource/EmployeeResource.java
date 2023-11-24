package com.patil.resource;

import com.patil.entity.Employee;
import com.patil.entity.EmployeeLogin;
import com.patil.entity.EmployeeLoginRepo;
import com.patil.entity.EmployeeRepo;
import com.patil.testEnum.CloverEnum;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Path("/employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {


    @Inject
    EmployeeRepo employeeRepo;

    @Inject
    EmployeeLoginRepo employeeLoginRepo;

    @Inject
    EntityManager entityManager;


    @GET
    public Response getAllEmployees() {
        List<Employee> empList=employeeRepo.listAll();
        return Response.ok(empList).build();
    }

    @GET
    @Path("/{empId}")
    public Response getEmployee(@PathParam("empId") String empId){
        Employee employee = employeeRepo.findByEmpId(empId);
       //Employee employee = employeeRepo.findById(empId);
        return Response.ok(employee).build();
    }


    @POST
    @Transactional
    public Response createEmployee(Employee employee) {
        //Long lastInsertId = ((Long) entityManager.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult())+1;
        //int lastInsertId = 1;
        int lastInsertId = ((int) entityManager.createNativeQuery("SELECT e.id FROM quarkus.employee e order by e.id desc limit 1").getSingleResult())+1;
        System.out.println("inside create employee"+lastInsertId);
        employee.setEmpId(CloverEnum.CI.name()+String.format("%05d", lastInsertId));

//        EmployeeLogin el = new EmployeeLogin();
//        el.setEmployee(employee);
//        //el.setUserId(employee.getId()); // not using
//        employee.setEmployeeLogin(el);
//        employeeRepo.persist(employee);
//        //employeeLoginRepo.persist(el); //not using

        EmployeeLogin el =employee.getEmployeeLogin();
        el.setEmployee(employee);
        //el.setUserId(employee.getId()); // not using
        employee.setEmployeeLogin(el);
        employeeRepo.persist(employee);
        //employeeLoginRepo.persist(el); //not using


//        employee.setEmployeeLogin(el);
//        employeeRepo.persist(employee);
//        el.setUserId(employee.getId()); // Set the userId based on the corresponding employee id
//        el.setEmployee(employee);
//
//// Persist the entities
//        employeeLoginRepo.persist(el);


        if(employeeRepo.isPersistent(employee)){
            return Response.status(Response.Status.CREATED).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

//
//    @PUT
//    @Path("/{empId}")
//    @Transactional
//    public Response updateEmployee(@PathParam("empId") String empId, Employee employee){
//
//
//        Employee emp = employeeRepo.findByEmpId(empId);
//
//        if (emp == null) {
//            return Response.status(Response.Status.NOT_FOUND).entity("Employee not found").build();
//        }
//
//        emp.setEmpName(employee.getEmpName());
//        emp.setEmpCast(employee.getEmpCast());
//        emp.setEmpDept(employee.getEmpDept());
//        emp.setEmpSalary(employee.getEmpSalary());
//        emp.setEmpContact(employee.getEmpContact());
//
//        return Response.ok(emp).build();
//    }


//This methods only update fields which we want using : empId : CI00001 ,CI00015
    @PUT
    @Path("/{empId}")
    @Transactional
    public Response updateEmployeeEmpId(@PathParam("empId") String empId, Employee employee) {

        Optional<Employee> opnEmp = Optional.ofNullable(employeeRepo.findByEmpId(empId));
        //Employee empDetails=employeeRepo.findById(emId);

        Employee dbEmp = opnEmp.get();
        if (opnEmp.isPresent()) {

            if (Objects.nonNull(employee.getEmpName())) {
                dbEmp.setEmpName(employee.getEmpName());
            }
            if (Objects.nonNull(employee.getEmpCast())) {
                dbEmp.setEmpCast(employee.getEmpCast());
            }
            if (Objects.nonNull(employee.getEmpContact())) {
                dbEmp.setEmpContact(employee.getEmpContact());
            }
            if (Objects.nonNull(employee.getEmpDept())) {
                dbEmp.setEmpDept(employee.getEmpDept());
            }
            if (Objects.nonNull(employee.getEmpSalary())) {
                dbEmp.setEmpSalary(employee.getEmpSalary());
            }
            if (Objects.nonNull(employee.getEmployeeLogin())) {
                dbEmp.setEmployeeLogin(employee.getEmployeeLogin());
            }
        }
            employeeRepo.persist(dbEmp);

            if (employeeRepo.isPersistent(dbEmp)) {
                return Response.ok().build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        }

    //This methods only update fields which we want using : id : 1 ,2 , 14 , 15
    @PUT
    @Path("/{empId}")
    @Transactional
    public Response updateEmployeeId(@PathParam("empId") Long empId, Employee employee) {

        Optional<Employee> opnEmp = Optional.ofNullable(employeeRepo.findById(empId));
        //Employee empDetails=employeeRepo.findById(emId);

        Employee dbEmp = opnEmp.get();
        if (opnEmp.isPresent()) {

            if (Objects.nonNull(employee.getEmpName())) {
                dbEmp.setEmpName(employee.getEmpName());
            }
            if (Objects.nonNull(employee.getEmpCast())) {
                dbEmp.setEmpCast(employee.getEmpCast());
            }
            if (Objects.nonNull(employee.getEmpContact())) {
                dbEmp.setEmpContact(employee.getEmpContact());
            }
            if (Objects.nonNull(employee.getEmpDept())) {
                dbEmp.setEmpDept(employee.getEmpDept());
            }
            if (Objects.nonNull(employee.getEmpSalary())) {
                dbEmp.setEmpSalary(employee.getEmpSalary());
            }
            if (Objects.nonNull(employee.getEmployeeLogin())) {
                dbEmp.setEmployeeLogin(employee.getEmployeeLogin());
            }

        }
        employeeRepo.persist(dbEmp);

        if (employeeRepo.isPersistent(dbEmp)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }


}
