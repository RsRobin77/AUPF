package com.daffodil.varsity.aupf.model;

public class ContactAdmin {
    private int adminAvatar;
    private String name, designation, mail, cell;

    public ContactAdmin(int adminAvatar, String name, String designation, String mail, String cell) {
        this.adminAvatar = adminAvatar;
        this.name = name;
        this.designation = designation;
        this.mail = mail;
        this.cell = cell;
    }

    public int getAdminAvatar() {
        return adminAvatar;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getMail() {
        return mail;
    }

    public String getCell() {
        return cell;
    }
}
