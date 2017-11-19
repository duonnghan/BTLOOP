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
    private Statement statement;
    
    /**
     * khởi tạo kết nối tới cơ sở dữ liệu
     */
    public ListInformationSong() throws SQLException{
         con = DataBase.getConnection();
         statement = (Statement)con.createStatement();
    }
    
    
    /**
     * lấy tất cả bài hát trong cơ sở dữ liệu
     * @return mảng hai chiều danh sách InfomationSong nếu không có trả về null
     * @throws SQLException 
     */
    public Object[][] getAllSong()throws SQLException {
        Vector vec = new Vector();
        String sql="SELECT * FROM song";
        ResultSet rs = statement.executeQuery(sql);
        if(rs.next()){
            do{
                InformationSong song = new InformationSong();
                song.setID(rs.getLong("id"));
                song.setNamSX(rs.getInt("year"));
                song.setVote(rs.getInt("vote"));
                song.setNhacsi(rs.getString("composer"));
                song.setName(rs.getString("name"));
                song.setCasi(rs.getString("artist"));
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
     * @return mảng hai chiều thông tin bài hát nếu không có trả về null
     * @throws SQLException 
     */
    public Object[][] getSongNotRequest()throws SQLException {
        Vector vec = new Vector();
        String sql="SELECT * FROM song WHERE vote = 0";
        ResultSet rs=statement.executeQuery(sql);
        if(rs.next()){
            do{
                InformationSong song = new InformationSong();
                song.setID(rs.getLong("id"));
                song.setNamSX(rs.getInt("year"));
                song.setVote(rs.getInt("vote"));
                song.setNhacsi(rs.getString("composer"));
                song.setName(rs.getString("name"));
                song.setCasi(rs.getString("artist"));
                song.setTheloai(rs.getString("genre"));
                vec.add(song);
            } while(rs.next());
            Object [][] object = this.convert(vec);
            return object;
        }
        return null;
    }
    
     
     /**
      * tìm bài hát với tên bài hát
      * @param name
      * @return mảng hai chiều thông tin bài hát nếu không có trả về null
      * @throws SQLException 
      */
    public Object[][] findSong(String name)throws SQLException {
        Vector vec = new Vector();
        String sql="SELECT * FROM song WHERE name like '%"+name+"%'";
        System.out.println("Find song: " + sql);
        ResultSet rs=statement.executeQuery(sql);
         if(rs.next()){
            do{
                InformationSong song = new InformationSong();
                song.setID(rs.getLong("id"));
                song.setNamSX(rs.getInt("year"));
                song.setVote(rs.getInt("vote"));
                song.setNhacsi(rs.getString("composer"));
                song.setName(rs.getString("name"));
                song.setCasi(rs.getString("artist"));
                song.setTheloai(rs.getString("genre"));
                vec.add(song);
            } while(rs.next());
            Object [][] object = this.convert(vec);
            return object;
        }
        return null;
    }
     
    /**
     * lấy thông tin các bài hát đứng đầu bản sếp hạng một tháng
     * @param month int
     * @return mảng hai chiều chứa nội dunng các bài hát nếu không có trả về null
     * @throws SQLException 
     */
    public Object[][] getTopSong(int month)throws SQLException {
        if((month < 1)||(month>12)){//kiểm tra không phải là tháng thì return null
            return null;
        }
        int [] array =new int[12];//khởi tạo mảng lưu id bài hát
        for(int i=0;i<12;i++){
            array[i]=-1;
        }
        String sql="SELECT * FROM topsongs WHERE month = "+ month;
        ResultSet rs=statement.executeQuery(sql);
        if(rs.next()){//đưa danh sách id vào mảng
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
                InformationSong song = this.findSong(array[i]);
                if(song != null){//nếu có bài hát thì đưa vào dánh sách
                    vec.add(song);
                }
            }
            Object [][] object = this.convert(vec);//chuyển đổi vector sang mảng
            return object;
        }
        return null;
    }
    
    /**
     * tìm bài hát theo mã số bài hát
     * @param id
     * @return một đối tượng InformationSong
     * @throws SQLException 
     */
    public InformationSong findSong(int id)throws SQLException{
        String sql="SELECT * FROM song WHERE id='"+ id +"'";
        ResultSet rs=statement.executeQuery(sql);
        InformationSong song = new  InformationSong();
        if(rs.next()){
            song.setID(rs.getLong("id"));
            song.setNamSX(rs.getInt("year"));
            song.setVote(rs.getInt("vote"));
            song.setNhacsi(rs.getString("composer"));
            song.setName(rs.getString("name"));
            song.setCasi(rs.getString("artist"));
            song.setTheloai(rs.getString("genre"));
            return song;
        }
        return null;
    }
    
    /**
     * trèn dữ liệu vào cơ sở dữ liệu
     * @param song là đối tương của InformationSong 
     * @return trả về true nếu thành công, trả về false nếu thất bại 
     * @throws SQLException 
     */
    public boolean insertSong(InformationSong song) throws SQLException{
        String id = new String();
        String ten = new String();
        String caSi = new String();
        String nhacSi = new String();
        String theLoai = new String();
        String namSX = new String();
        String binhChon = new String();
        
        if(song.getID()!=-1){
            id = "'" + song.getID() + "'";
        }else{
            id = "null";
        }
        
        if(song.getName()!= null){
            ten = "'" + song.getName() + "'";
        }else{
            ten = "null";
        }
        
        if(song.getCasi() != null){
            caSi= "'" + song.getCasi() + "'";
        }else{
            caSi = "null";
        }
        
        if(song.getNhacsi() != null){
            nhacSi = "'" + song.getNhacsi() + "'";
        }else{
            nhacSi = "null";
        }
        
        if(song.getTheloai() != null){
            theLoai= "'" + song.getTheloai() + "'";
        }else{
            theLoai = "null";
        }
        
        if(song.getNamSX() != 0){
            namSX = "'" + song.getNamSX() + "'";
        }else{
            namSX = "null";
        }
        
        if(song.getVote()!=-1)
            binhChon = "'" + song.getVote() + "'";
        else
            binhChon = "'" + 0 + "'";
        
        String sql = "insert into `song` values (" + id + ", " + ten +", "+ caSi +", "+nhacSi+", "+theLoai+", "+namSX+", "+binhChon+")";
        if(statement.executeUpdate(sql)==1){
            return true;
        }
        return false;
    }
    /**
     * chỉnh sửa bản ghi bảng song
     * @param song đối tượng của Information
     * @return true thành công, false nếu thất bại
     * @throws SQLException 
     */
    public boolean UpdateSong(InformationSong song) throws SQLException{
        String id = new String();
        String ten = new String();
        String caSi = new String();
        String nhacSi = new String();
        String theLoai = new String();
        String namSX = new String();
        String binhChon = new String();
        String sql = new String("UPDATE `bai_tap_lon_opp`.`song` SET");
        if(song.getID() != -1){
            id = "`id`='";
        }else{
            return false;
        }
        if(song.getName() != null)
            sql = sql + "`name`='" +song.getName()+"', ";
        
        if(song.getCasi()!=null)
            sql = sql + "`artist`='" + song.getCasi() + "', ";
        
        if(song.getNhacsi()!=null)
            sql = sql+"`composer`='" +song.getNhacsi()+ "', ";
        
        if(song.getTheloai()!=null)
            sql = sql +"`genre`='" +song.getTheloai()+ "', ";
        
        if(song.getNamSX()!=0)
            sql = sql +"`year`='" +song.getNamSX()+ "', ";
        
        if(song.getVote()!=-1)
            sql = sql +"`vote`='" +song.getVote()+ "', ";
        
        sql = sql.substring(0, sql.length()-2);
        sql = sql +" WHERE `id`='" +song.getID()+ "'";
        System.out.println(sql);
        
        if(statement.executeUpdate(sql)==1){
            return true;
        }
        return false;
    }
    /**
     * chuyển đổi từ vector lớp InformationSong sang mảng hai chiều
     * @param vec Vector
     * @return một mảng hai chiều các đối tượng
     */
    public Object[][] convert(Vector <InformationSong> vec){
        if(vec == null){//nếu vector null thì return null
            return null;
        }
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
    /**
     * xoa mot bai hat
     * @param id kieu du liwu long
     * @return true thanh cong, false that bai
     * @throws SQLException 
     */
    public boolean deleteSong(long id) throws SQLException{
        String sql = "DELETE FROM `bai_tap_lon_opp`.`song` WHERE `id`='" +id+ "'";
        if(statement.executeUpdate(sql) == 1){
            return true;
        }
        return false;
    }
}
