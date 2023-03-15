package com.ganjatec.ticketmaster.utils;

import com.ganjatec.ticketmaster.utils.Utilities;

public class testmain {

    public static void main(String[] args){
        String testpass = "testDope1234";
        Utilities ut = new Utilities();
        System.out.println("Password: " + testpass);
        System.out.println(ut.hashPassword(testpass));
    }
}
