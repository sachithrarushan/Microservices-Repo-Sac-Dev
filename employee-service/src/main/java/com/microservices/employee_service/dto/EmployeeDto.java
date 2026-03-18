package com.microservices.employee_service.dto;

public class EmployeeDto {

    private String firstname;
    private String lastname;
    private String email;
    private String departmentCode;
    public EmployeeDto() {
    }

    public EmployeeDto(String firstname, String lastname, String email, String departmentCode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.departmentCode = departmentCode;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
