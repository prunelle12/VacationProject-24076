package Vacation.vacationrental.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="usertable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;

    private String password;
    private String email;

    public User() {
    }

    public User(Integer id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
