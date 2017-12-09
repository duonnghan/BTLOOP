/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.controller;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
        sql = "SELECT DISTINCT s.id, namesong, nameatirst, status "
                + "FROM schedule as s, requirement as r "
                + "WHERE s.songid=r.songid and playdate='" + date + "';";
        model.setSQL(sql);
        model.loaData();
    }

//Xử lí sự kiện nhấn nút Đã phát    
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
        String sql = "";
        sql = "UPDATE requirement "
                + "SET status='Đã phát' "
                + "WHERE songid='" + idSongSelect + "';";
        model.setSQL(sql);
        model.updateData();
        JOptionPane.showMessageDialog(null, "Thành công!!!");
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