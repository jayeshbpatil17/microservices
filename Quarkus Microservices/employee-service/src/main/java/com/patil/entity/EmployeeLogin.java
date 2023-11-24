package com.patil.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="employee_login")
public class EmployeeLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loginId;

    @Column(name="userId",insertable = false, updatable = false)
    private int userId;

    @Column(name="status")
    private String status;

    @Column(name="insertedBy")
    private String insertedBy;

    @Column(name="insertedDate", insertable = false,updatable = false)
    private Timestamp insertedDate;

    @Column(name="lastLogin", insertable = false,updatable = false)
    private Timestamp lastLogin;


    @Column(name="lastActivityTime", insertable = false,updatable = false)
    private Timestamp lastActivityTime;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "userId",unique = true)
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeLogin() {
    }

    public EmployeeLogin(int loginId, int userId, String status, String insertedBy, Timestamp insertedDate, Timestamp lastLogin, Timestamp lastActivityTime,Employee employee) {
        this.loginId = loginId;
        this.userId = employee.getId(); //  employee id getting
        this.status = status;
        this.insertedBy = insertedBy;
        this.insertedDate = insertedDate;
        this.lastLogin = lastLogin;
        this.lastActivityTime = lastActivityTime;
        this.employee=employee;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInsertedBy() {
        return insertedBy;
    }

    public void setInsertedBy(String insertedBy) {
        this.insertedBy = insertedBy;
    }

    public Timestamp getInsertedDate() {
        return insertedDate;
    }

    public void setInsertedDate(Timestamp insertedDate) {
        this.insertedDate = insertedDate;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Timestamp getLastActivityTime() {
        return lastActivityTime;
    }

    public void setLastActivityTime(Timestamp lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }
}
