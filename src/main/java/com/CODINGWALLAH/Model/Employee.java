package com.CODINGWALLAH.Model;


import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data

public class Employee {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public Employee(){

    }

    public Employee(String name,String email,String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

      public String getName(){ return name;}
      public void setName(String name){this.name = name;}

      public String getEmail() {return email;}
      public void setEmail(String email) {this.email = email;}

      public String getPhone() {return phone;}
      public void setPhone(String phone) {this.phone = phone;}

      public Long getId(){return id;}
      public void setId(Long id) {this.id = id;}
}

//    //getter no need to use this get and setter if we use lambok
//    public String getName() {
//        return Name;
//    }
//    //setter
//    public void setName(String name) {
//        Name = name;
//    }


