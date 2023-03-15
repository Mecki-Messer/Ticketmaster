package com.ganjatec.ticketmaster.dataclasses;

import jakarta.persistence.*;

@Entity
@Table(name = "Sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String uuid;
    private boolean validated;
    private int timeout;
    private Long linkedUser;


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Long getLinkedUser() {
        return linkedUser;
    }

    public void setLinkedUser(Long linkedUser) {
        this.linkedUser = linkedUser;
    }
}
