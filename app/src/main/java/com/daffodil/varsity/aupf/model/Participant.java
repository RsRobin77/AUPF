package com.daffodil.varsity.aupf.model;

public class Participant {
    private String Name, Designation, Institute, Country, Email;

    public Participant(String name, String designation, String institute, String country, String email) {
        Name = name;
        Designation = designation;
        Institute = institute;
        Country = country;
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public String getDesignation() {
        return Designation;
    }

    public String getInstitute() {
        return Institute;
    }

    public String getCountry() {
        return Country;
    }

    public String getEmail() {
        return Email;
    }
}
