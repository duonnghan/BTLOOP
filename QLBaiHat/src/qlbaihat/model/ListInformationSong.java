/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import qlbaihat.controller.DataBase;

/**
 *
 * @author tuyen
 */
public class ListInformationSong {
    private Connection con;
    
    /**
     * khởi tạo kết nối tới cơ sở dữ liệu
     */
    public ListInformationSong(){
         con = DataBase.getConnection();
    }

    public ListInformationSong(int i, int i0, int i1, String tuyen, String tuyen0, String tuyen1, String tuyen2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * lấy tất cả bài hát trong cơ sở dữ liệu
     * @return Vector danh sách InfomationSong
     * @throws SQLException 
     */
    public Object[][] getAllSong()throws SQLException {
        Vector vec = new Vector();
        
        String sql="SELECT * FROM song";
        Statement statement = (Statement) con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        if(rs.next()){
            {
                InformationSong song = new InformationSong();
                song.setID(rs.getLong("id"));
                song.setNamSX(rs.getInt("year"));
                song.setVote(rs.getInt("vote"));
                song.setCasi(rs.getString("composer"));
                song.setName(rs.getString("name"));
                song.setTheloai(rs.getString("artist"));
                song.setTheloai(rs.getString("genre"));
                vec.add(song);
            } while(rs.next());
            Object [][] object = this.convert(vec);
            return object;
        }
        return null;
    }
    
    
    /**
     * lấy thông tin các bài hát có lượt bình chọn là 0
     * @return Vector chứa Vector thông tin bài hát
     * @throws SQLException 
     */
    public Object[][] getSongNotRequest()throws SQLException {
        Vector vec = new Vector();
        String sql="SELECT * FROM song WHERE vote = 0";
        PreparedStatement ps=con.prepareCall(sql);
        ResultSet rs=ps.executeQuery();
         if(rs.next()){
            {
                InformationSong song = new InformationSong();
                song.setID(rs.getInt("id"));
                song.setNamSX(rs.getInt("year"));
                song.setVote(rs.getInt("vote"));
                song.setCasi(rs.getString("composer"));
                song.setName(rs.getString("name"));
                song.setTheloai(rs.getString("artist"));
                song.setTheloai(rs.getString("genre"));
                vec.add(song);
            } while(rs.next());
            Object [][] object = this.convert(vec);
            return object;
        }
        return null;
    }
    
    
    /**
     * lấy thông tin bài hát được bình
     * @return
     * @throws SQLException 
     */
     public static Vector getSongNotPlay()throws SQLException {
         Vector vec = new Vector();
        return vec;
    }
    
     
     /**
      * tìm bài hát với tên bài hát
      * @param name
      * @return Vector thông tin bài hát
      * @throws SQLException 
      */
    public Object[][] findSong(String name)throws SQLException {
        Vector vec = new Vector();
        String sql="SELECT * FROM song WHERE name like '%/name/%'";
        PreparedStatement ps=con.prepareCall(sql);
        ResultSet rs=ps.executeQuery();
         if(rs.next()){
            {
                InformationSong song = new InformationSong();
                song.setID(rs.getInt("id"));
                song.setNamSX(rs.getInt("year"));
                song.setVote(rs.getInt("vote"));
                song.setCasi(rs.getString("composer"));
                song.setName(rs.getString("name"));
                song.setTheloai(rs.getString("artist"));
                song.setTheloai(rs.getString("genre"));
                vec.add(song);
            } while(rs.next());
            Object [][] object = this.convert(vec);
            return object;
        }
        return null;
    }
     
    /**
     * lấy thông tin các bài hát đứng đầu bản sếp hạng mooth tháng
     * @param month int
     * @return Object[][]
     * @throws SQLException 
     */
    public Object[][] getTopSong(int month)throws SQLException {
        int [] array =new int[12];
        String sql="SELECT * FROM topsongs WHERE month = '"+ month + "'";
        PreparedStatement ps=con.prepareCall(sql);
        ResultSet rs=ps.executeQuery();
        array[0] = rs.getInt("idsong1");
        array[1] = rs.getInt("idsong2");
        array[2] = rs.getInt("idsong3");
        array[3] = rs.getInt("idsong4");
        array[4] = rs.getInt("idsong5");
        array[5] = rs.getInt("idsong6");
        array[6] = rs.getInt("idsong7");
        array[7] = rs.getInt("idsong8");
        array[8] = rs.getInt("idsong9");
        array[9] = rs.getInt("idsong10");
        array[10] = rs.getInt("idsong11");
        array[11] = rs.getInt("idsong12");
        Vector vec = new Vector();
        for(int i = 0; i<12 ; i++){
            vec.add(findSong(array[0]));
        }
        Object [][] object = this.convert(vec);
        return object;
    }
    
    /**
     * tìm bài hát theo mã số bài hát
     * @param id
     * @return Object[][]
     * @throws SQLException 
     */
    public Vector findSong(int id)throws SQLException{
        String sql="SELECT * FROM song WHERE id='"+ id +"'";
        PreparedStatement ps=con.prepareCall(sql);
        ResultSet rs=ps.executeQuery();
        InformationSong song = new  InformationSong();
        if(rs.next()){
            song.setID(rs.getInt("id"));
            song.setNamSX(rs.getInt("year"));
            song.setVote(rs.getInt("vote"));
            song.setCasi(rs.getString("composer"));
            song.setName(rs.getString("name"));
            song.setTheloai(rs.getString("artist"));
            song.setTheloai(rs.getString("genre"));
            return song.getSong();
        }
        return null;
    }
    
    public Object[][] convert(Vector <InformationSong> vec){
        int countvec = vec.size();
        int countSong = InformationSong.getcountcomponent();
        Object[][] object =new Object[countvec][countSong];
        for(int i=0; i< countvec ; i++){
            for(int j = 0; j < countSong; j++){
                object[i][j]=vec.get(i).getSong().get(j);
            }
        }
        return object;
    }
    public static void main(String[]args){
        ListInformationSong listSong = new ListInformationSong();
        try{
            Object[][] object = listSong.getAllSong();
            if(object.length > 1){
                System.out.println(object[0][1].toString());
            }
        }catch(SQLException e){
            System.out.println("don't accept database");
        }
    }
}
