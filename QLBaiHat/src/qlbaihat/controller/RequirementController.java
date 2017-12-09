/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import qlbaihat.model.Requirement;
import qlbaihat.model.Song;

/**
 *
 * @author TRAN HAI DANG
 */
public class RequirementController {
    public void insertRequirement(Requirement requirement) throws SQLException{
        java.sql.Connection connection =DataBase.getConnection();
        String sql="INSERT INTO requirement VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps= connection.prepareCall(sql);
        ps.setLong(1, requirement.getId());
        ps.setString(2, requirement.getSender());
        ps.setString(3, requirement.getReceipient());
        ps.setString(4, requirement.getPhone());
        ps.setString(5, requirement.getAddress());
        ps.setString(6, requirement.getSentdate());
        ps.setString(7, requirement.getMessage());
        ps.setLong(8, requirement.getSongid());
        ps.setString(9, requirement.getStatus());
        ps.setString(10, requirement.getPlaydate());     
              
        ps.executeUpdate();
    }
    public void insertSong(Song song) throws SQLException{
        java.sql.Connection connection =DataBase.getConnection();
        String sql="INSERT INTO song VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps= connection.prepareCall(sql);
        ps.setLong(1, song.getId());
        ps.setString(2,song.getName());
        ps.setString(3,song.getArtist());
        ps.setString(4, song.getComposer());
        ps.setString(5,song.getGenre());
        ps.setInt(6, song.getYear());
        ps.setInt(7, song.getVote());
        ps.executeUpdate();
    }
    public void updateSong(Song song) throws SQLException{
        java.sql.Connection connection =DataBase.getConnection();
        String sql="UPDATE song SET vote= ? WHERE id=?";
        PreparedStatement ps= connection.prepareCall(sql);
        ps.setLong(1, song.getVote()+1);
        ps.setLong(2,song.getId());
        ps.executeUpdate();
    }
     public Song getSong(String nameSong,String nameArtist) throws SQLException{
     java.sql.Connection conn= DataBase.getConnection();
     String sql="SELECT * FROM song WHERE name= '"+nameSong+"' && artist= '"+nameArtist+"'";
     PreparedStatement ps=conn.prepareCall(sql);
     ResultSet rs=ps.executeQuery();
     Song song=new Song();
     while(rs.next())
     {
         song.setName(rs.getString("name"));
         song.setArtist(rs.getString("artist"));
         song.setId(rs.getLong("id"));
         song.setVote(rs.getInt("vote"));
         return song;
      }
     return null;
     }
}
