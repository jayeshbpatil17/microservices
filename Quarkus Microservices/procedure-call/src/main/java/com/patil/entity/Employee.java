package com.patil.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_procedure")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String empName;

    private String empDept;

    private String empCast;

    private Long empSalary;

    private Long empContact;

    public Employee() {
    }

    public Employee(Long empId, String empName, String empDept, String empCast, Long empSalary, Long empContact) {
        this.empId = empId;
        this.empName = empName;
        this.empDept = empDept;
        this.empCast = empCast;
        this.empSalary = empSalary;
        this.empContact = empContact;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public String getEmpCast() {
        return empCast;
    }

    public void setEmpCast(String empCast) {
        this.empCast = empCast;
    }

    public Long getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Long empSalary) {
        this.empSalary = empSalary;
    }

    public Long getEmpContact() {
        return empContact;
    }

    public void setEmpContact(Long empContact) {
        this.empContact = empContact;
    }
}
