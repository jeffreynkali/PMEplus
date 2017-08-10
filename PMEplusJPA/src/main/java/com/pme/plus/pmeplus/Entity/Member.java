package com.pme.plus.pmeplus.Entity;

import javax.persistence.*;

/**
 * Created by gnkali on 6/15/17.
 */
@Entity(name = "Member")
@Table(name = "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMember;

    @Version
    private int version;

    private String firstname;
    private String lastname;
    private String email;

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
