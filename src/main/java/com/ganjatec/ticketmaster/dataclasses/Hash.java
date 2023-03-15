package com.ganjatec.ticketmaster.dataclasses;

import jakarta.persistence.*;

@Entity
@Table(name = "Hashes")
public class Hash {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    private String hash;

    private String salt;


    //Getter and Setter
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
