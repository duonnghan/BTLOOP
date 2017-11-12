/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.controller;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tuyen
 */
public class TableValues extends AbstractTableModel {
    public Object[][] object;

    public TableValues(Object[][] object) {
        this.object = object;
    }
   
    public int getRowCount() {
        return object.length;
    }

    public int getColumnCount() {
        return object[0].length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return object[rowIndex][columnIndex];
    } 
}
