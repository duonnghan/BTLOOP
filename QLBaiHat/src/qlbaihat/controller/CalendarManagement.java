/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import qlbaihat.GUI;

/**
 *
 * @author Tuan
 */
public class CalendarManagement {
    private java.sql.Connection conn = null;
    Statement stmt = null;
    
    public void hienThi(JTable table,String subSql) throws SQLException, ClassNotFoundException
           //khởi tạo dữ liệu cho bảng
      {
       conn = qlbaihat.controller.DataBase.getConnection();
       stmt = conn.createStatement();
       String sql = "SELECT song.name AS `NameSong`, song.artist AS 'Artist', COUNT(requirement.songid) AS 'Số lượt yêu cầu',   "
               + "GROUP_CONCAT(requirement.sender ORDER BY requirement.sender SEPARATOR ', ' ) AS 'Các thính giả yêu cầu' "
               + "FROM song, requirement "
               + "WHERE song.id = requirement.songid "
               +subSql
               + "AND requirement.status != 'Đã thêm'"               
               + "GROUP BY song.name ORDER BY COUNT(requirement.songid) DESC LIMIT 15";
       Vector col;
       Vector data;
        try (ResultSet rs = stmt.executeQuery(sql)) {
            
            ResultSetMetaData rsmd=rs.getMetaData();
            int c =rsmd.getColumnCount();
            col = new Vector(c);
            for(int i =1;i<= c;i++)
            {
                col.add(rsmd.getColumnName(i));
            }     

            Vector row = new Vector();
            data = new Vector();
            while(rs.next())
            {
                row=new Vector(c);
                for(int i=1;i<= c;i++){                   
                    row.add(rs.getString(i));
                }
                
                data.add(row);
            } 
        rs.close();
        }    
      TableModel dataModel = new DefaultTableModel(data, col);
      table.setModel(dataModel);
        
      } 
    
    public void ThemLichPhat(JTextField text, JTable table)throws SQLException ,ClassNotFoundException
    {
        int r = table.getSelectedRow();
            if(r > -1){
                java.sql.Connection connection =DataBase.getConnection();
                               
                try {                   
                    Statement st = connection.createStatement();
                    String sql = "UPDATE requirement SET requirement.playdate = '" +text.getText()+ "' "
                            + "WHERE requirement.songid IN "
                            + "(SELECT id FROM song WHERE song.name = '"+ table.getValueAt(r, 0)+"' "
                            + "AND song.artist = '"+table.getValueAt(r, 1)+"')";
//                    if( st.executeUpdate(sql) == 1){  
                        st.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                        int modelIndex = table.convertRowIndexToModel(r); 
                        DefaultTableModel model = (DefaultTableModel)table.getModel();
                        model.removeRow(modelIndex);
//                    }
//                    else
//                        JOptionPane.showMessageDialog(null, "Ko thành công");                   
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            else{
                JOptionPane.showMessageDialog(null, "Chọn bài hát để thêm lịch phát");
            }
    }
    
    public static boolean isValidDate(String inDate) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
    dateFormat.setLenient(false);
    try {
      dateFormat.parse(inDate.trim());
    } catch (ParseException pe) {
      return false;
    }
    return true;
  }
    
    public static boolean compareDates(String psDate) throws ParseException{
        Date todaysDate = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String todayString = df.format(todaysDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
        Date date1 = dateFormat.parse(psDate);
        Date date2 = dateFormat.parse(todayString);
        if(date2.after(date1)) {           
            return true;
        } else {
            return false;
        }
    }
}

