package com.daffodil.varsity.aupf.model;

public class JuryMember {
    private int avatar;
    private String name;
    private String info;
    private String designation;

    public JuryMember(int avatar, String name, String designation, String info) {
        this.avatar = avatar;
        this.name = name;
        this.info = info;
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}
