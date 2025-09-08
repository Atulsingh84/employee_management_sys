package com.CODINGWALLAH.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CDEmp_DB")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String name;
 private String phone;
 private String email;


    public EmployeeEntity() {

    }

    public EmployeeEntity(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public void setId(Long id){this.id = id;}
    public Long getId() { return id;}


}
