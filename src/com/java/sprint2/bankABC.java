package com.java.sprint2;

import java.util.Scanner;

public class bankABC {
    public static void main(String[] args) {
        System.out.println("Welcome to BankABC. Do you have your login credentials(Y/N)?");
        Scanner sc = new Scanner(System.in);
        char a = sc.next().charAt(0);
        if (a == 'y' || a == 'Y') {
            existingCustomerLogin();
            openCD();
        } else if (a == 'n' || a == 'N') {
            newCustomerLogin();
            openCD();
        } else {
            bye();
        }
    }

    public static boolean newCustomerLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create a login id (min length 5, max length 10. Alphabets only):");
        String loginCheck = sc.next();
        if (loginCheck.length() >= 5 && loginCheck.length() <= 10 && loginCheck.chars().allMatch(Character::isLetter)) {
            System.out.println("Create a password (min length 5, max length 10. Has to contain upper- and lowercase letters, special characters and numbers):");
            String passwordCheck = sc.next();
            if (passwordCheck.length() >= 5 && passwordCheck.length() <= 10 && checkString(passwordCheck)) {
                System.out.println("You have created your login credentials");
                return true;
            } else {
                errorMessage();
            }
        } else {
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

    private static void errorMessage() {
        System.out.println("Invalid input. Please follow requirements and try again.");
    }

    public static boolean existingCustomerLogin() {
        for (int i = 1; i <= 3; i++) {
            if (loginPassword()) {
                return true;
            }
        }
        System.out.println("Number of unsuccessful attempts exceeded limit. Try again after 24 hours.");
        return false;
    }

    private static boolean loginPassword() {
        String[][] userCreds = {
                {"user", "password"},
                {"Oleh", "Oleksiienko"},
                {"Swati", "Panda"},
                {"Sagyn", "Sagyn"},
                {"Hosna", "Aunjun"},
                {"Ayazhan", "Nokerova"},
                {"Begimai", "Aibekova"},
                {"Mykhailo", "Andybur"},
                {"Inna", "Merlin"},
                {"JeanD'Amour", "Bisanukuri"}
        };
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter login id:");
        String login = sc.next();
        System.out.println("Please enter password:");
        String password = sc.next();
        for (int i = 0; i < userCreds.length; i++) {
            if (login.equals(userCreds[i][0]) && password.equals(userCreds[i][1])) {
                return true;
            }
        }
        System.out.println("Invalid login id or/and password. Try again");
        return false;
    }

    public static void computeCDAmount() {
        Scanner sc = new Scanner(System.in);
        String cdErr = "Please follow our CD amount and term requirements";
        System.out.println("Enter CD amount (min 5,000 - max 50,000) you wish to invest:");
        int amountCD = sc.nextInt();
        double totalAmount = amountCD;
        double interest;
        if (amountCD >= 5000 && amountCD <= 50000) {
            System.out.println("Enter CD period (min 1 - max 5) in years:");
            int periodCD = sc.nextInt();
            if (periodCD >= 1 && periodCD <= 5) {
                if (amountCD <= 20000) {
                    interest = 0.02;
                } else {
                    interest = 0.04;
                }
                for (int i = 1; i <= periodCD; i++) {
                    totalAmount += totalAmount * interest;
                    interest = interest + 0.0025;
                }
                totalAmount = (double) (Math.round(totalAmount * 100.0) / 100.0);
                System.out.println("Congratulations!");
                System.out.println("Your initial amount is " + amountCD);
                System.out.println("At the end of your " + periodCD + "-year CD, you'll get " + totalAmount + "!");
                System.out.println("Thank you for choosing BankABC's CD service.");
            }else{
                System.out.println(cdErr);
            }
        } else {
            System.out.println(cdErr);
        }
    }

    public static void openCD() {
        System.out.println("Do you want to open a CD account today(Y/N)?");
        Scanner scan = new Scanner(System.in);
        char b = scan.next().charAt(0);
        if (b == 'y' || b == 'Y') {
            computeCDAmount();
        } else {
            bye();
        }
    }

    private static void bye() {
        System.out.println("Goodbye!");
    }
}
