package com.rewards.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "manager")
public class Manager {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long Id;


@Column(nullable = false)
private String name;


@Column(nullable = false)
private String username;


@Column(nullable = false)
private String password;


@Column(nullable = false)
private String securityQuestion; 


@Column(nullable = false)
private String securityAnswer;


public Manager() {

super();

// TODO Auto-generated constructor stub

}


public Manager(Long id, String name, String username, String password, String securityQuestion,

String securityAnswer) {

super();

Id = id;

this.name = name;

this.username = username;

this.password = password;

this.securityQuestion = securityQuestion;

this.securityAnswer = securityAnswer;

}




public Long getId() {

return Id;

}


public void setId(Long id) {

Id = id;

}


public String getName() {

return name;

}


public void setName(String name) {

this.name = name;

}


public String getUsername() {

return username;

}


public void setUsername(String username) {

this.username = username;

}


public String getPassword() {

return password;

}


public void setPassword(String password) {

this.password = password;

}


public String getSecurityQuestion() {

return securityQuestion;

}


public void setSecurityQuestion(String securityQuestion) {

this.securityQuestion = securityQuestion;

}


public String getSecurityAnswer() {

return securityAnswer;

}


public void setSecurityAnswer(String securityAnswer) {

this.securityAnswer = securityAnswer;

}



}