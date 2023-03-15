package com.ganjatec.ticketmaster.dataclasses;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    private String username;

    //TODO set Foreign Key
    private long hashID;

    private long matrikelnr;

    private int department;

    private int privLevel;

    //Getters and Setters
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getHashID() {
        return hashID;
    }

    public void setHashID(long hashID) {
        this.hashID = hashID;
    }

    public long getMatrikelnr() {
        return matrikelnr;
    }

    public void setMatrikelnr(long matrikelnr) {
        this.matrikelnr = matrikelnr;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getPrivLevel() {
        return privLevel;
    }

    public void setPrivLevel(int privLevel) {
        this.privLevel = privLevel;
    }
}
