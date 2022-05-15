package com.java.sprint2;

import java.util.Scanner;

public class bankABC {
    public static void main(String[] args) {
        newCustomerLogin();

    }

    public static boolean newCustomerLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create a login id (min length 5, max length 10. Alphabets only):");
        String loginCheck = sc.next();
        if (loginCheck.length() >= 5 && loginCheck.length() <= 10 && loginCheck.chars().allMatch(Character::isLetter)) {
            System.out.println("Create a password (min length 5, max length 10. Has to contain upper- and lowercase letters, special characters and numbers):");
            String passwordCheck = sc.next();
            if(passwordCheck.length() >= 5 && passwordCheck.length() <= 10 && checkString(passwordCheck)){
                System.out.println("You have created your login credentials");
                return true;
            }else{
                errorMessage();
            }
        }else{
            errorMessage();
        }
        return false;
    }

    private static boolean checkString(String input) {
        String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
        char ch;
        boolean numberPresent = false;
        boolean upperCasePresent = false;
        boolean lowerCasePresent = false;
        boolean specialCharacterPresent = false;

        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                numberPresent = true;
            } else if (Character.isUpperCase(ch)) {
                upperCasePresent = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCasePresent = true;
            } else if (specialChars.contains(String.valueOf(ch))) {
                specialCharacterPresent = true;
            }
        }

        return
                numberPresent && upperCasePresent && lowerCasePresent && specialCharacterPresent;
    }

    private static void errorMessage (){
        System.out.println("Invalid input. Please follow requirements and try again.");
    }
}
