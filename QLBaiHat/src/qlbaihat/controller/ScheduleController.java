/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import qlbaihat.model.ScheduleTableModel;

/**
 *
 * @author hungenr
 */
public class ScheduleController implements ActionListener, ListSelectionListener {

    ScheduleTableModel model;
    JTable schdlTable;
    String date;
    JTextField input;
    public static long idSongSelect = 0;

    public ScheduleController(JTable schdlTable, ScheduleTableModel model, JTextField input) {
        this.schdlTable = schdlTable;
        this.model = model;
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        date = input.getText();
        switch (command) {
            case "View":
                viewCommandAction();
                break;
            case "Requuest":

                break;
            case "Played":
                playedCommandAction();
                viewCommandAction();
                break;
        }

    }

    public void viewCommandAction() {
        String sql = "";
        sql = "SELECT DISTINCT s.id, namesong, nameatirst, status "
                + "FROM schedule as s, requirement as r "
                + "WHERE s.id=r.songid and playdate='" + date + "';";
        model.setSQL(sql);
        model.loaData();
    }

    public void playedCommandAction() {
        String sql = "";
        sql = "UPDATE requirement "
                + "SET status='Đã phát' "
                + "WHERE songid='" + idSongSelect + "';";
        model.setSQL(sql);
        model.updateData();
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
