package com.daffodil.varsity.aupf.model;

public class Partner {
    private String partnerName;
    private int partnerLogo;

    public Partner(String partnerName, int partnerLogo) {
        this.partnerName = partnerName;
        this.partnerLogo = partnerLogo;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public int getPartnerLogo() {
        return partnerLogo;
    }

    public void setPartnerLogo(int partnerLogo) {
        this.partnerLogo = partnerLogo;
    }
}
