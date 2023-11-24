    package com.patil.entity;


    import com.fasterxml.jackson.annotation.JsonManagedReference;
    import com.patil.testEnum.CloverEnum;
    import jakarta.persistence.*;
    import org.hibernate.annotations.DynamicUpdate;

    import java.beans.Transient;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    import static com.patil.testEnum.CloverEnum.CI;

    @Entity
    @Table(name="employee")
    public class Employee{

        //private static final AtomicInteger counter = new AtomicInteger(10000);
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  int id;

        private String empId;
        private String empName;
        private String empDept;
        private String empCast;
        private Long empSalary;
        private Long empContact;

        @JsonManagedReference
        @OneToOne(mappedBy = "employee",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
        private  EmployeeLogin employeeLogin;

        public Employee() {
        }


        public EmployeeLogin getEmployeeLogin() {
            return employeeLogin;
        }

        public void setEmployeeLogin(EmployeeLogin employeeLogin) {
            this.employeeLogin = employeeLogin;
        }

        public Employee(int id, String empId, String empName, String empDept, String empCast, Long empSalary, Long empContact, EmployeeLogin employeeLogin) {
            this.id = id;
            this.empId = empId;
            this.empName = empName;
            this.empDept = empDept;
            this.empCast = empCast;
            this.empSalary = empSalary;
            this.empContact = empContact;
            this.employeeLogin = employeeLogin;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmpId() {
            return empId;
        }

        public void setEmpId(String empId) {
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
