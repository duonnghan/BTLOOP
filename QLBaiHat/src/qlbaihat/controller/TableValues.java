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
    public String [] TITLE = {"ID", "Tên bài hát", "Ca sĩ", "Nhạc sĩ", "Thể loại", "Năm", "Lượt yêu cầu"};
    public Object[][] object;

    /**
     * contruct mặc định
     */
    public TableValues() {
    }
    
    /**
     * khởi tạo với mảng tên tiêu đề
     * @param array 
     */
    public TableValues(String[]array) {
        this.TITLE = array;
    }

    /**
     * khởi tạo với mảng hai chiều các đối tượng
     * @param object 
     */
    public TableValues(Object[][] object) {
        this.object = object;
    }
     
    /**
     * khởi tạo TableValue với hai mảng
     * @param array là mảng một chiều chứa thiêu đề
     * @param object là mảng hai chiều chứa nội dung
     */
    public TableValues(String[]array, Object[][] object){
        this.object = object;
        this.TITLE = array;
    }
    
    public String[] getTITLE() {
        return TITLE;
    }

    public Object[][] getObject() {
        return object;
    }

    public void setTITLE(String[] TITLE) {
        this.TITLE = TITLE;
    }

    public void setObject(Object[][] object) {
        this.object = object;
    }
    
    public String getColumnName(int col) {
        return TITLE[col];
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
