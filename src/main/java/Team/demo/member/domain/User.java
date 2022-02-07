package Team.demo.member.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter


public class User {
  private String member;
  private String password;
  private String email;
  private String address;
  private int phone;
  private String name;



  public  User(){};


    public User(String member, String password, String email, String address, int phone, String name) {
        this.member = member;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.name = name;
    }
}
