package com.example.MVCLab3.Model;

import java.util.Objects;

public class User {
    private int Id;
    private String Name;
    private String Surname;
    private String Date;
    private String Email;
    private String Socials;

    public User(int id, String name, String surname, String date, String email, String socials) {
        Id = id;
        Name = name;
        Surname = surname;
        Date = date;
        Email = email;
        Socials = socials;
    }



    public User() {

    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    @Override
    public String toString() {
        return Name + " " + Surname + " "+ Date + " "+ Email + " "+ Socials +"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getName().equals(user.getName()) && getSurname().equals(user.getSurname()) && getDate().equals(user.getDate())
                && getEmail().equals(user.getEmail()) && getSocials().equals(user.getSocials());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getDate(), getEmail(), getSocials());
    }
}
