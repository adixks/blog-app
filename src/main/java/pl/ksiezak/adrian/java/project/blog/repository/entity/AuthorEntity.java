package pl.ksiezak.adrian.java.project.blog.repository.entity;

import java.math.BigDecimal;

public class AuthorEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String nickName;
    private BigDecimal earned;

    public AuthorEntity() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getEarned() {
        return earned;
    }

    public void setEarned(BigDecimal earned) {
        this.earned = earned;
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", earned=" + earned +
                '}';
    }
}
