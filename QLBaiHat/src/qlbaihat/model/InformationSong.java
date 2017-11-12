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
    private int namSX, vote;
    private String casi, nhacsi, theloai, name;
    
    /**
     * khởi tạo constructor mặc định
     */
    public InformationSong() {
        this.ID = -1;
        this.namSX = 0;
        this.vote = 0;
        this.casi = new String();
        this.name = new String();
        this.nhacsi = new String();
        this.theloai = new String();
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
        this.name = name;
        this.vote = vote;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setVote(int vote) {
        this.vote = vote;
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
        return name;
    }

    public int getVote() {
        return vote;
    }
    /**
     * trả lại một vecter chứa thông tin bài hát
     * @return Vector
     */
    public Vector getSong(){
        Vector vec = new Vector();
        vec.add(this.ID);
        vec.add(this.name);
        vec.add(this.casi);
        vec.add(this.nhacsi);
        vec.add(this.theloai);
        vec.add(this.namSX);
        vec.add(this.vote);
        return vec;
    }
    
    public static int getcountcomponent(){
        return 7;
    }
}
