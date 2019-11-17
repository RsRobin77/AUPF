package com.daffodil.varsity.aupf.model;

public class ContactAdmin {
    private int adminAvatar;
    private String name, designation, mail, cell,whatsapp;

    public ContactAdmin(int adminAvatar, String name, String designation, String mail, String cell, String whatsapp) {
        this.adminAvatar = adminAvatar;
        this.name = name;
        this.designation = designation;
        this.mail = mail;
        this.cell = cell;
        this.whatsapp = whatsapp;
    }

    public int getAdminAvatar() {
        return adminAvatar;
    }

    public void setAdminAvatar(int adminAvatar) {
        this.adminAvatar = adminAvatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }
}
