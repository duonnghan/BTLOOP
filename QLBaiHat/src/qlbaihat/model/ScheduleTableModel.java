/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import qlbaihat.controller.DataBase;

public class ScheduleTableModel extends AbstractTableModel {

    public ArrayList<Schedule> values = new ArrayList<>();
    public final static String[] columnNames = {
        "STT", "ID", "Tên bài hát", "Ca sĩ", "Ghi chú", ""
    };

    String sql;
    int count = 0;

    public void setSQL(String sql) {
        this.sql = sql;
    }

    public void loaData() {
        Connection conn = DataBase.getConnection();
        System.out.println("Opened database connection");
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            System.out.println(" - Excuted: " + sql);
            int i = 0;
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getLong(1));
                schedule.setNameSong(rs.getString(2));
                schedule.setNameArtist(rs.getString(3));
                schedule.setNote(rs.getString(4));
                values.add(schedule);
                i++;
            }
            count = i;
            System.out.println(" - Got " + count + " rows");
            state.close();
            conn.close();
            System.out.println("Closed database connection");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.fireTableDataChanged();
    }

    public void updateData() {
        Connection conn = DataBase.getConnection();
        System.out.println("Opened database connection");
        try {
            Statement state = conn.createStatement();
            int count = state.executeUpdate(sql);
            System.out.println(" - Excuted: " + sql);
            System.out.println(" - Updated " + count + " rows");
            state.close();
            conn.close();
            System.out.println("Closed database connection");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return count;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return values.get(rowIndex).getId();
            case 2:
                return values.get(rowIndex).getNameSong();
            case 3:
                return values.get(rowIndex).getNameArtist();
            case 4:
                return values.get(rowIndex).getNote();
        }
        return 0;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

}