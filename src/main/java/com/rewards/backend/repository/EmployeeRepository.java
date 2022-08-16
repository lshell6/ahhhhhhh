package com.rewards.backend.repository;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rewards.backend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

@Query("select e from Employee e where e.username=?1")

Employee getByUsername(String username);


@Transactional

@Modifying

@Query("update Employee e SET e.name=?2,e.securityQuestion=?3,e.securityAnswer=?4 "

+ " where e.username=?1")

void updateProfile(String username, String name, String securityQuestion, 

String securityAnswer);


@Transactional

@Modifying

@Query("update Employee e SET e.password=?2 where e.username=?1")

void resetPassword(String username, String password, LocalDate date);

}


