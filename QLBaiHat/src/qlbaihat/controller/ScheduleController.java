/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.controller;

import com.mysql.jdbc.Connection;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import qlbaihat.GUI;
import static qlbaihat.GUI.idSongSelect;
import qlbaihat.Management;
import qlbaihat.model.ScheduleTableModel;

/**
 *
 * @author hungenr
 */
public class ScheduleController implements ActionListener, ListSelectionListener {

    ScheduleTableModel model;
    JTable schdlTable;
    String date;
    JDateChooser input;
    public static long idSongSelect = 0;

    public ScheduleController(JTable schdlTable, ScheduleTableModel model, JDateChooser input) {
        this.schdlTable = schdlTable;
        this.model = model;
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Date calendar = input.getDate();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        date = format.format(calendar);
        switch (command) {
            case "View":
                viewCommandAction();
                break;
            case "Requuest":
        {
            try {
                requuestCommandAction();
            } catch (SQLException ex) {
                Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "Played":
                playedCommandAction();
                viewCommandAction();
                break;
        }
    }

//Xử lí sự kiện nhấn nút Xem
    public void viewCommandAction() {
        String sql = "";
        sql = "SELECT DISTINCT s.id, namesong, nameatirst, s.note "
                + "FROM schedule as s, requirement as r "
                + "WHERE s.songid=r.songid and playdate='" + date + "';";
        model.setSQL(sql);
        model.loaData();
    }

//Xử lí sự kiện nhấn nút Xem yêu cầu    
    public void requuestCommandAction() throws SQLException {
        if (idSongSelect != 0) {
            Management manager = new Management();
            manager.main();
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn bài hát!!!");
        }
    }

//Xử lí sự kiện nhấn nút Đã phát    
    public void playedCommandAction() {
        long songid = 0;
        String sql1="SELECT songid FROM schedule WHERE id='"+idSongSelect+"';";
        java.sql.Connection conn=DataBase.getConnection();
         PreparedStatement ps;
                try {
                    ps = conn.prepareCall(sql1);
                     ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        songid=rs.getLong("songid");
                    }
                    rs.close();
                    ps.close();
                    conn.close();
                    String sql = "";
        sql = "UPDATE schedule "
                + "SET note='ĐÃ PHÁT' "
                + "WHERE songid='" + songid + "';";
        model.setSQL(sql);
        model.updateData();
        JOptionPane.showMessageDialog(null, "Thành công!!!");
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } 
        
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int[] row = schdlTable.getSelectedRows();
        int[] col = schdlTable.getSelectedColumns();
        for (int i = 0; i < row.length; i++) {
            idSongSelect = (Long) schdlTable.getValueAt(row[i], 1);
        }
        System.out.println(idSongSelect);
    }

}