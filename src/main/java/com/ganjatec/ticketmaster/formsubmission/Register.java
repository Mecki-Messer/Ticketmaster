package com.ganjatec.ticketmaster.formsubmission;

public class Register {

    private String username;
    private String pass1;
    private String pass2;
    private long matrikel;
    private int department;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public long getMatrikel() {
        return matrikel;
    }

    public void setMatrikel(long matrikel) {
        this.matrikel = matrikel;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}
