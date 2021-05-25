package com.example.MVCLab3.Model;

public class UserToUpdateModel {

    private String NameToUpdate;
    private String SurnameToUpdate;
    private String Name;
    private String Surname;
    private String Date;
    private String Email;
    private String Socials;

    public UserToUpdateModel(String nameForUpdate, String surnameToUpdate, String name, String surname, String date, String email, String socials) {
        NameToUpdate = nameForUpdate;
        SurnameToUpdate = surnameToUpdate;
        Name = name;
        Surname = surname;
        Date = date;
        Email = email;
        Socials = socials;
    }

    public String getNameToUpdate() {
        return NameToUpdate;
    }

    public void setNameToUpdate(String nameToUpdate) {
        NameToUpdate = nameToUpdate;
    }

    public String getSurnameToUpdate() {
        return SurnameToUpdate;
    }

    public void setSurnameToUpdate(String surnameToUpdate) {
        SurnameToUpdate = surnameToUpdate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSocials() {
        return Socials;
    }

    public void setSocials(String socials) {
        Socials = socials;
    }
}
