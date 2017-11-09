/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;
import qlbaihat.controller.DataBase;

public class ScheduleTableModel extends AbstractTableModel {

    public Object[][] values = new Object[100][5];
    public final static String[] columnNames = {
        "STT", "ID", "Tên bài hát", "Ca sĩ", "Ghi chú",""
    };

    String sql;
    int count = 0;
    
    public void setSQL(String sql){
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
                values[i][0] = i + 1;
                values[i][1] = rs.getLong(1);
                values[i][2] = rs.getString(2);
                values[i][3] = rs.getString(3);
                values[i][4] = rs.getString(4);
                i++;
            }
            count = i;
            System.out.println(" - Got " + count + " rows");
            state.close();
            conn.close();
            System.out.println("Closed database connection");
        } catch (Exception e) {
            System.out.println(e);
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
            System.out.println(e);
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
        return values[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

}
