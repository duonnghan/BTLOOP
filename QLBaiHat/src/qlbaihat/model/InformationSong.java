/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.model;

import java.util.Vector;

/**
 *lớp chứa thông tin bài hát
 * @author tuyen
 */
public class InformationSong {
    private long ID;
    private int namSX, binhchon;
    private String casi, nhacsi, theloai, ten;
    
    /**
     * khởi tạo constructor mặc định
     */
    public InformationSong() {
        this.ID = -1;
        this.namSX = 0;
        this.binhchon = 0;
        this.casi = null;
        this.ten = null;
        this.nhacsi = null;
        this.theloai = null;
    }
     
    /**
     * khởi tạo constructor chứa thông tin khởi tạo
     * @param ID
     * @param namSX
     * @param vote
     * @param casi
     * @param nhacsi
     * @param theloai
     * @param name 
     */
    public InformationSong(long ID, int namSX, int vote,  String casi, String nhacsi, String theloai, String name) {
        this.ID = ID;
        this.namSX = namSX;
        this.casi = casi;
        this.nhacsi = nhacsi;
        this.theloai = theloai;
        this.ten = name;
        this.binhchon = vote;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public void setCasi(String casi) {
        this.casi = casi;
    }

    public void setNhacsi(String nhacsi) {
        this.nhacsi = nhacsi;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public void setName(String ten) {
        this.ten = ten;
    }

    public void setVote(int binhchon) {
        this.binhchon = binhchon;
    }

    public int getNamSX() {
        return namSX;
    }

    public String getCasi() {
        return casi;
    }

    public String getNhacsi() {
        return nhacsi;
    }

    public String getTheloai() {
        return theloai;
    }

    public String getName() {
        return ten;
    }

    public int getVote() {
        return binhchon;
    }
    /**
     * trả lại một vecter chứa thông tin bài hát
     * @return Vector
     */
    public Vector getSong(){
        Vector vec = new Vector();
        vec.add(this.ID);
        vec.add(this.ten);
        vec.add(this.casi);
        vec.add(this.nhacsi);
        vec.add(this.theloai);
        vec.add(this.namSX);
        vec.add(this.binhchon);
        return vec;
    }
    
    public static int getcountcomponent(){
        return 7;
    }
    
}
