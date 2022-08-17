package com.rewards.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rewards.backend.model.Employee;
import com.rewards.backend.model.Manager;
import com.rewards.backend.repository.EmployeeRepository;
import com.rewards.backend.repository.ManagerRepository;

@Service
public abstract class MyUserDetailsService implements UserDetailsService{

@Autowired
private EmployeeRepository employeeRepository;

@Autowired
private ManagerRepository managerRepository;


public UserDetails loadEmployeeByUsername(String username) throws UsernameNotFoundException {
Employee e = employeeRepository.getByUsername(username);
//convert UserInfo(User from DB) in UserDetails

if(e == null)
throw new UsernameNotFoundException("Username invalid!!!");
/*

* user role into List<GrantedAuthority>

*/
List<GrantedAuthority> list = new ArrayList<>();

SimpleGrantedAuthority sga = new SimpleGrantedAuthority(e.getCurrent_points().toString() + " " + e.getTotal_points().toString()); 

list.add(sga);


User user =new User(e.getUsername(), e.getPassword(),list );

return user;

}


public UserDetails loadManagerByUsername(String username) throws UsernameNotFoundException {

Manager m = managerRepository.getByUsername(username);

//convert UserInfo(User from DB) in UserDetails

if(m == null)

throw new UsernameNotFoundException("Username invalid!!!");

/*

* user role into List<GrantedAuthority>

*/

List<GrantedAuthority> list = new ArrayList<>();

SimpleGrantedAuthority sga = new SimpleGrantedAuthority(m.getName()); 

list.add(sga);


User user =new User(m.getUsername(), m.getPassword(),list );

return user;

}

}