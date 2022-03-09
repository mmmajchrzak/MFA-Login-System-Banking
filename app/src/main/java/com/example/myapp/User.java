package com.example.myapp;

public class User {
    public String FullName, Pesel, emailRegi, PasswordRegi;

    public User(String fullName, String pesel, String emailRegi) {

    }

    public User(String FullName, String Pesel, String emailRegi, String PasswordRegi) {
        this.emailRegi = emailRegi;
        this.Pesel = Pesel;
        this.FullName = FullName;

    }
}



