package com.rgr.spring.datajpa.sec;



import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class UserMy extends AbstractEntity {
    @Column(name = "Login", unique = false, nullable = true)
    private String username;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "Mail", nullable = true)
    private String mail;
    @Column(name = "Authority", nullable = true)
    private String authority;

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "User :" +
                " username = " + username;
    }
}
