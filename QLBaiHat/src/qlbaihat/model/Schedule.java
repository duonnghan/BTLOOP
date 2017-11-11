/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.model;

/**
 *
 * @author TRAN HAI DANG
 */
public class Schedule {
    int id;
    String nameSong,nameArtist,note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Schedule() {
    }

    public Schedule(int id, String nameSong, String nameArtist, String note) {
        this.id = id;
        this.nameSong = nameSong;
        this.nameArtist = nameArtist;
        this.note = note;
    }
}
