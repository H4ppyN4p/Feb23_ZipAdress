package com.company;

public class AdressZip
{
    private String adress;
    private int zip;

    public AdressZip(String adress, int zip){
        this.adress = adress;
        this.zip = zip;
    }

    public String getAdress() {
        return adress;
    }

    public int getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "City: " + adress + " with zip nr: " + zip;
    }
}
