/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.model;

import qlbaihat.controller.MainController;

/**
 *
 * @author HD
 */
public class DSBaiHat implements MainController{
    private int ID, namSX;
    private String casi, nhacsi, theloai;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public String getCasi() {
        return casi;
    }

    public void setCasi(String casi) {
        this.casi = casi;
    }

    public String getNhacsi() {
        return nhacsi;
    }

    public void setNhacsi(String nhacsi) {
        this.nhacsi = nhacsi;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    @Override
    public Object[] toObject() {
        return new Object[]{this.getID(), this.getNamSX(), this.getCasi(),
            this.getNhacsi(), this.getTheloai()};
        
    }
    
    
}
