/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.controller;

import java.sql.SQLException;
import javax.swing.JTable;
import qlbaihat.model.ListInformationSong;

/**
 *
 * @author tuyen
 */
public class SongController {
    private int chosen;
    private JTable song;
    private String name;

    /**
     * khởi tạo
     * @param chosen int
     * @param song JTable
     */
    public SongController(int chosen, JTable song, String name) {
        this.chosen = chosen;
        this.song = song;
        this.name = name;
    }
    
    /**
     * xảy ra khi nhấn vào ok
     */
    public void eventOK(){
        switch(chosen){
            case 0:this.displayAllSong(); break;
            case 1:this.displayFavouriteSongs(); break;
            case 2:this.displayFindSong(); break;
            case 3:this.setfree(); break;
            default:  break;
        }
    }
    
    /**
     * hiển thị tất cả các bài hát
     */
    public void displayAllSong(){
        ListInformationSong listSong = new ListInformationSong();
        Object [][] object = null;
        try{
            object = listSong.getAllSong();
        }catch(SQLException e){
            System.out.println("don't get data");
        }
        if(object == null){
            return;
        }else{
            TableValues values = new TableValues(object);
            song.setModel(values);
        }
    }
    
    /**
     * lấy 12 bài hát được yêu thích nhất trong tháng chosen
     * @param chosen 
     */
    public void displayFavouriteSongs(){
         ListInformationSong listSong = new ListInformationSong();
        Object [][] object = null;
        try{
            object = listSong.getTopSong(chosen);
        }catch(SQLException e){
            System.out.println("don't get data");
        }
        if(object == null){
            return;
        }else{
            TableValues values = new TableValues(object);
            song.setModel(values);
        }
    }
    
    
    /**
     * hiển thị bài hát tìm kiếm
     */
    public void displayFindSong(){
         ListInformationSong listSong = new ListInformationSong();
        Object [][] object = null;
        try{
            object = listSong.findSong(name);
        }catch(SQLException e){
            System.out.println("don't get");
        }
        if(object == null){
            return;
        }else{
            TableValues values = new TableValues(object);
            song.setModel(values);
        }
    }
     
    public void setfree(){
        Object [][] object = new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            };
        TableValues values = new TableValues(object);
        song.setModel(values);
    }
}
