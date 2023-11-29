package com.patil.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

;


@Entity
@Table
@NamedStoredProcedureQuery(
        name = "insert_employee",
        procedureName = "insert_employee",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "empName"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "empDept"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "empCast"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "empSalary"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "empContact")
        }
)
public class Employee extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;

    private String empName;

    private String empDept;

    private String empCast;

    private Long empSalary;

    private Long empContact;

    public Employee() {
    }

    public Employee(long empId, String empName, String empDept, String empCast, Long empSalary, Long empContact) {
        this.empId = empId;
        this.empName = empName;
        this.empDept = empDept;
        this.empCast = empCast;
        this.empSalary = empSalary;
        this.empContact = empContact;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
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

    public long getEmpContact() {
        return empContact;
    }

    public void setEmpContact(long empContact) {
        this.empContact = empContact;
    }
}
