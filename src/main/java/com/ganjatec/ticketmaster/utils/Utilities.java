package com.ganjatec.ticketmaster.utils;

import com.ganjatec.ticketmaster.dataclasses.*;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.codec.digest.*;

public class Utilities {

    public String createSalt() {
        Random random = new Random();
        int[] intArray = new int[32];
        for(int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(9);
        }
        String salt = Arrays.toString(intArray).replaceAll("\\D+","");
        return salt;
    }

    public Hash hashPassword(String pass) {
        String salt = createSalt();
        String toHash = pass + salt;

        String sha256hex = DigestUtils.sha256Hex(toHash);

        Hash hash = new Hash();
        hash.setHash(sha256hex);
        hash.setSalt(salt);
        return hash;
    }

    public boolean validatePassword(String pass, Hash hash) {
        String toHash = pass + hash.getSalt();
        String sha256hex = DigestUtils.sha256Hex(toHash);

        if((sha256hex.equals(hash.getHash()))) {
            return true;
        }

        return false;
    }
}
