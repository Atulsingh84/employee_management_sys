package com.CODINGWALLAH.Interfaces;

import com.CODINGWALLAH.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepository  extends JpaRepository<EmployeeEntity,Long>{


}
