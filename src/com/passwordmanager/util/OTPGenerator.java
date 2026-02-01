package com.passwordmanager.util;

import java.util.Random;

public class OTPGenerator {

    private static String currentOTP;

    public static String generateOTP() {
        currentOTP = String.valueOf(100000 + new Random().nextInt(900000));
        return currentOTP;
    }

    public static boolean validateOTP(String input) {
        boolean isValid = input.equals(currentOTP);
        currentOTP = null; // OTP expires after use
        return isValid;
    }
}
