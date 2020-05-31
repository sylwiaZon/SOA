package pl.edu.agh.soa.jpa;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @Column(name="user_id")
    @GeneratedValue
    private int id;

    @Column(name="login", nullable = false)
    private String login;

    @Column(name="password", nullable = false)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
