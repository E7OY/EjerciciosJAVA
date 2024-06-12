package com.liceolapaz.des.egm;

import java.net.URL;
import java.util.Date;

public class Piloto {

    private String driverId;
    private int permanentNumber;
    private String code;
    private URL url;
    private String givenName;
    private String familyName;
    private Date dateOfBirth;
    private String nationality;


    public Piloto(String driverId, int permanentNumber, String code, URL url, String givenName, String familyName, Date dateOfBirth, String nationality) {
        this.driverId = driverId;
        this.permanentNumber = permanentNumber;
        this.code = code;
        this.url = url;
        this.givenName = givenName;
        this.familyName = familyName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public int getPermanentNumber() {
        return permanentNumber;
    }

    public void setPermanentNumber(int permanentNumber) {
        this.permanentNumber = permanentNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "driverId='" + driverId + '\'' +
                ", permanentNumber=" + permanentNumber +
                ", code='" + code + '\'' +
                ", url=" + url +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
