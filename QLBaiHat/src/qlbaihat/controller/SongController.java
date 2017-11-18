/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.controller;

import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTable;
import qlbaihat.InfoMusic;
import qlbaihat.model.InformationSong;
import qlbaihat.model.ListInformationSong;

/**
 *
 * @author tuyen
 */
public class SongController {
    private int chosen, month;
    private long id;
    private JTable song;
    private String name;
    private JLabel label;

    /**
     * khởi tạo
     * @param chosen int
     * @param song JTable
     */
    public SongController(int chosen, int month, JTable song, String name, long id, JLabel label) {
        this.chosen = chosen;
        this.month=month;
        this.song = song;
        this.name = name;
        this.id = id;
        this.label = label;
    }
    
    public void deleteSong(){
        System.out.println("xoa bai hat");
        ListInformationSong listSong;
        try{
            listSong = new ListInformationSong();
            if(listSong.deleteSong(id)){
                label.setText("xóa thành công");
            }else{
                label.setText("xóa thất bại");
            }
        }catch(SQLException e){
            label.setText("xóa thất bại");
        }
    }
    
    /**
     * them mot bai hat vao co so du lieu
     * @param label the JLabel de hien thi ket qua tra ve
     * @param song doi tuong cua InformationSong
     */
    public static void addSong(JLabel label, InformationSong song){
        try{
            ListInformationSong listSong = new ListInformationSong();
            if(listSong.insertSong(song)){
                label.setText("thành công");
            }else{
                label.setText("thông tin sai, vui lòng nhập lại");
            }
        }catch(SQLException e){
            label.setText("thông tin sai, vui lòng nhập lại");
            e.getStackTrace();
        }
    }
    /**
     * xảy ra khi nhấn vào ok
     */
    public void eventOK(){
        switch(chosen){
            case 0:this.displayAllSong(); break;
            case 1:this.displayFavouriteSongs(); break;
            case 2:this.displayFindSong(); break;
            case 3:this.inforMusic(); break;
            case 4:this.deleteSong();break;
            default:  break;
        }
    }
    /**
     * thêm bài hát
     */
    public boolean inforMusic(){
        InfoMusic addMusic = new InfoMusic();
        addMusic.setVisible(true);
        return true;
    }
    /**
     * hiển thị tất cả các bài hát
     */
    public void displayAllSong(){
        ListInformationSong listSong;
        Object [][] object = null;
        try{
            listSong = new ListInformationSong();
            object = listSong.getAllSong();
        }catch(SQLException e){
            label.setText("không có bài hát nào thỏa mãn");
        }
        if(object == null){
            this.setfree();
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
         ListInformationSong listSong;
        Object [][] object = null;
        try{
            listSong = new ListInformationSong();
            System.out.println(month);
            object = listSong.getTopSong(month);
        }catch(SQLException e){
            label.setText("không có bài hát nào thỏa mãn");
        }
        if(object == null){
            this.setfree();
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
         ListInformationSong listSong;
        Object [][] object = null;
        try{
            listSong = new ListInformationSong();
            object = listSong.findSong(name);
        }catch(SQLException e){
            label.setText("không có bài hát nào thỏa mãn");
        }
        if(object == null){
            this.setfree();
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
                {null, null, null, null, null, null, null}
            };
        TableValues values = new TableValues(object);
        song.setModel(values);
    }
    
    public void updateSong(){
        TableValues data= (TableValues) song.getModel();
        Object [][] object = data.getObject();
    }
}
