/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.model;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;

public class DataTableModel extends AbstractTableModel {
    
    public Object[][] values;
    
    public DataTableModel(Statement state, String sql){
        try{
            ResultSet rs = state.executeQuery(sql); 
            int i = 0;
            while(rs.next()){
                values[i][0] = rs.getInt(1);
                values[i][1] = rs.getString(2);
                values[i][2] = rs.getString(3);
                values[i][3] = rs.getString(4);
                values[i][4] = rs.getString(5);
                values[i][5] = rs.getInt(6);
                values[i][6] = rs.getInt(7);
                i++;
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public int getRowCount() {
        return values.length;
    }

    @Override
    public int getColumnCount() {
        return values[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return values[rowIndex][columnIndex];
    }

}
