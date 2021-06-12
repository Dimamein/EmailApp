package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternateEmail;
    private String email;
    private final String company = "companyname.com";
    private int mailboxCapacity;
    private int defaultPasswordLength = 10;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created for: " + firstName + " " + lastName);
        this.department = setDepatment();
        this.password = randomPassword(defaultPasswordLength);
        this.email = emailValue();

        System.out.println(email);
    }

    private String setDepatment(){
        String departmentName = null;
        int depNum;
        System.out.println("Enter department number \nfor Sale 1 " + "\nfor Development 2 \nfor Accounting 3 \nfor None 4");
        Scanner scanner = new Scanner(System.in);

        do {
            depNum = scanner.nextInt();
            switch (depNum) {
                case 1:
                    departmentName = "Sales";
                    System.out.println("Sales");
                    break;
                case 2:
                    departmentName = "Development";
                    System.out.println("Development");
                    break;
                case 3:
                    departmentName = "Accounting";
                    System.out.println("Accounting");
                    break;
                case 4:
                    departmentName = "";
                    System.out.println("None");
                    break;
                default:
                    System.out.println("enter proper value");
            }
        } while (depNum != 1 && depNum != 2 && depNum != 3 && depNum != 4);
        return departmentName;
    }

    private String randomPassword(int passLenght) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#$*()";
        char[] password = new char[passLenght];
        for (int i = 0; i < passLenght; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    private String emailValue() {
        if(department != ""){
            return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + company;
        } else {
            return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + company;
        }
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName + " COMPANY EMAIL: " + email + " MAILBOX CAPACITY " + mailboxCapacity;
    }
}
