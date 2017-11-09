/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat;

import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import qlbaihat.controller.RequirementController;
import qlbaihat.controller.ScheduleController;
import qlbaihat.model.Song;
import qlbaihat.model.Requirement;
import qlbaihat.model.ScheduleTableModel;

/**
 *
 * @author Huy
 */
public class GUI extends javax.swing.JFrame {

    public static long idSongSelect = 0;
    public ScheduleTableModel scdlTM = new ScheduleTableModel();
    public ScheduleController scdlController;

    public GUI() {
        
        initComponents();
        schedulePanel();
        setIcon();
        select();
        select1();
        
    }

    void select() {
//        String nameSong = null;
//        String nameArtist = null;
//        ListSelectionModel cellSelect = schdlTable.getSelectionModel();
//        cellSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        cellSelect.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                int[] row = schdlTable.getSelectedRows();
//                int[] col = schdlTable.getSelectedColumns();
//                for (int i = 0; i < row.length; i++) {
//                    idSongSelect = (Integer) schdlTable.getValueAt(row[i], 1);
//                }
//                System.out.print(idSongSelect);
//            }
//        });
    }

    void select1() {
        String nameSong = null;
        String nameArtist = null;
        ListSelectionModel cellSelect = mrgTable.getSelectionModel();
        cellSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelect.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int[] row = mrgTable.getSelectedRows();
                int[] col = mrgTable.getSelectedColumns();
                for (int i = 0; i < row.length; i++) {
                    idSongSelect = (Long) mrgTable.getValueAt(row[i], 2);
                }
                System.out.print(idSongSelect);
            }
        });
    }

    public void schedulePanel(){
        ListSelectionModel cellSelect = schdlTable.getSelectionModel();
        cellSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        scdlController = new ScheduleController(schdlTable, scdlTM, schdlViewField);
        schdlViewBtn.setActionCommand("View");
        schdlRequestBtn.setActionCommand("Request");
        schdlPlayedBtn.setActionCommand("Played");
        cellSelect.addListSelectionListener(scdlController);
        schdlViewBtn.addActionListener(scdlController);
        schdlRequestBtn.addActionListener(scdlController);
        schdlPlayedBtn.addActionListener(scdlController);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mode = new javax.swing.ButtonGroup();
        manage = new javax.swing.JTabbedPane();
        playlisttPanel = new javax.swing.JPanel();
        playlistModeLabel = new javax.swing.JLabel();
        playlistRdioAllSongs = new javax.swing.JRadioButton();
        playlistRdioFavoriteSongs = new javax.swing.JRadioButton();
        playlistRdioNotPlayedYet = new javax.swing.JRadioButton();
        playlistRdioAudienceNotAccepted = new javax.swing.JRadioButton();
        playlostSearchBtn = new javax.swing.JRadioButton();
        playlistScrollPane = new javax.swing.JScrollPane();
        playlistTable = new javax.swing.JTable();
        playlistDivLine = new javax.swing.JSeparator();
        playlistAcceptBtn = new javax.swing.JButton();
        playlistSearchField = new javax.swing.JTextField();
        playlistUpdateBtn = new javax.swing.JButton();
        playlistResetBtn = new javax.swing.JButton();
        addRequestpanel = new javax.swing.JPanel();
        resNameLabel = new javax.swing.JLabel();
        resNameField = new javax.swing.JTextField();
        resArtistLabel = new javax.swing.JLabel();
        resArtistField = new javax.swing.JTextField();
        resSenderLabel = new javax.swing.JLabel();
        resSenderField = new javax.swing.JTextField();
        resPhoneLabel = new javax.swing.JLabel();
        resAddrLabel = new javax.swing.JLabel();
        resAdrrField = new javax.swing.JTextField();
        resRecipientLabel = new javax.swing.JLabel();
        resRecipientField = new javax.swing.JTextField();
        resDateLabel = new javax.swing.JLabel();
        resMsgLabel = new javax.swing.JLabel();
        resMsgScrollPane = new javax.swing.JScrollPane();
        resMsgTextArea = new javax.swing.JTextArea();
        resSendBtn = new javax.swing.JButton();
        resSubmitBtn = new javax.swing.JButton();
        resCancelBtn = new javax.swing.JButton();
        resDataField = new javax.swing.JFormattedTextField();
        resPhoneField = new javax.swing.JFormattedTextField();
        schedulingPanel = new javax.swing.JPanel();
        schdlViewLabel = new javax.swing.JLabel();
        schdlViewBtn = new javax.swing.JButton();
        schdlDivLine = new javax.swing.JSeparator();
        schdlScrollPane = new javax.swing.JScrollPane();
        schdlTable = new javax.swing.JTable();
        schdlViewField = new javax.swing.JFormattedTextField();
        schdlRequestBtn = new javax.swing.JButton();
        schdlPlayedBtn = new javax.swing.JButton();
        managerPanel = new javax.swing.JPanel();
        mrgScrollPane = new javax.swing.JScrollPane();
        mrgTable = new javax.swing.JTable();
        mrgDivLine = new javax.swing.JSeparator();
        mgrSearchBtn = new javax.swing.JButton();
        mgrSearchField = new javax.swing.JTextField();
        mgrSearchLabel = new javax.swing.JLabel();
        mrgSearchBtn = new javax.swing.JButton();
        mrgViewBtn = new javax.swing.JButton();
        mrgRequestDateLabel = new javax.swing.JFormattedTextField();
        mrgRequestStat = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý bài hát");

        playlistModeLabel.setText("Chọn chế độ:");

        mode.add(playlistRdioAllSongs);
        playlistRdioAllSongs.setText("Tất cả bài hát.");

        mode.add(playlistRdioFavoriteSongs);
        playlistRdioFavoriteSongs.setText("Bài hát được yêu thích nhất trong tháng");

        mode.add(playlistRdioNotPlayedYet);
        playlistRdioNotPlayedYet.setText("Bài hát chưa được phát sóng");

        mode.add(playlistRdioAudienceNotAccepted);
        playlistRdioAudienceNotAccepted.setText("Các thính giả chưa phát được yêu cầu");

        mode.add(playlostSearchBtn);
        playlostSearchBtn.setText("Tìm kiếm bài hát:");
        playlostSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playlostSearchBtnActionPerformed(evt);
            }
        });

        playlistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên bài hát", "Ca sĩ", "Nhạc sĩ", "Thể loại", "Năm", "Lượt yêu cầu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        playlistScrollPane.setViewportView(playlistTable);
        if (playlistTable.getColumnModel().getColumnCount() > 0) {
            playlistTable.getColumnModel().getColumn(0).setResizable(false);
            playlistTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            playlistTable.getColumnModel().getColumn(6).setResizable(false);
        }

        playlistAcceptBtn.setText("OK");
        playlistAcceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playlistAcceptBtnActionPerformed(evt);
            }
        });

        playlistUpdateBtn.setText("Cập nhật thông tin");

        playlistResetBtn.setText("Reset lượt yêu cầu");

        javax.swing.GroupLayout playlisttPanelLayout = new javax.swing.GroupLayout(playlisttPanel);
        playlisttPanel.setLayout(playlisttPanelLayout);
        playlisttPanelLayout.setHorizontalGroup(
            playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playlisttPanelLayout.createSequentialGroup()
                .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playlisttPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(playlistScrollPane))
                    .addGroup(playlisttPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(playlistDivLine))
                    .addGroup(playlisttPanelLayout.createSequentialGroup()
                        .addContainerGap(243, Short.MAX_VALUE)
                        .addComponent(playlistModeLabel)
                        .addGap(69, 69, 69)
                        .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(playlisttPanelLayout.createSequentialGroup()
                                .addComponent(playlostSearchBtn)
                                .addGap(10, 10, 10)
                                .addComponent(playlistSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE))
                            .addGroup(playlisttPanelLayout.createSequentialGroup()
                                .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(playlistRdioNotPlayedYet)
                                    .addComponent(playlistRdioFavoriteSongs)
                                    .addComponent(playlistRdioAllSongs)
                                    .addComponent(playlistRdioAudienceNotAccepted)
                                    .addGroup(playlisttPanelLayout.createSequentialGroup()
                                        .addComponent(playlistAcceptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(playlistUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(playlistResetBtn)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        playlisttPanelLayout.setVerticalGroup(
            playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playlisttPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playlistRdioAllSongs)
                    .addComponent(playlistModeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playlistRdioFavoriteSongs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playlistRdioNotPlayedYet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playlistRdioAudienceNotAccepted)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playlostSearchBtn)
                    .addGroup(playlisttPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(playlistSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playlistAcceptBtn)
                    .addComponent(playlistUpdateBtn)
                    .addComponent(playlistResetBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playlistDivLine, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playlistScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        manage.addTab("Danh sách bài hát", playlisttPanel);

        resNameLabel.setText("Tên bài hát:");

        resNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resNameFieldActionPerformed(evt);
            }
        });

        resArtistLabel.setText("Tên ca sĩ:");

        resSenderLabel.setText("Tên người gửi:");

        resPhoneLabel.setText("Số điện thoại:");

        resAddrLabel.setText("Địa chỉ:");

        resRecipientLabel.setText("Tên người nhận:");

        resDateLabel.setText("Ngày yêu cầu:");

        resMsgLabel.setText("Lời nhắn:");

        resMsgTextArea.setColumns(20);
        resMsgTextArea.setRows(5);
        resMsgScrollPane.setViewportView(resMsgTextArea);

        resSendBtn.setText("Gửi");
        resSendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resSendBtnActionPerformed(evt);
            }
        });

        resSubmitBtn.setText("Xong");
        resSubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resSubmitBtnActionPerformed(evt);
            }
        });

        resCancelBtn.setText("Hủy");
        resCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resCancelBtnActionPerformed(evt);
            }
        });

        resDataField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        resDataField.setText("dd/MM/yyyy");

        resPhoneField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout addRequestpanelLayout = new javax.swing.GroupLayout(addRequestpanel);
        addRequestpanel.setLayout(addRequestpanelLayout);
        addRequestpanelLayout.setHorizontalGroup(
            addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRequestpanelLayout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addRequestpanelLayout.createSequentialGroup()
                        .addComponent(resSendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(resSubmitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(resCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addRequestpanelLayout.createSequentialGroup()
                        .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(resRecipientLabel)
                            .addComponent(resMsgLabel)
                            .addComponent(resDateLabel)
                            .addComponent(resAddrLabel)
                            .addComponent(resPhoneLabel)
                            .addComponent(resSenderLabel)
                            .addComponent(resArtistLabel)
                            .addComponent(resNameLabel))
                        .addGap(42, 42, 42)
                        .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(resPhoneField, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(resNameField)
                            .addComponent(resArtistField)
                            .addComponent(resSenderField)
                            .addComponent(resAdrrField)
                            .addComponent(resMsgScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(resRecipientField)
                            .addComponent(resDataField))))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        addRequestpanelLayout.setVerticalGroup(
            addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRequestpanelLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resNameLabel)
                    .addComponent(resNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resArtistLabel)
                    .addComponent(resArtistField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resSenderLabel)
                    .addComponent(resSenderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resPhoneLabel)
                    .addComponent(resPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resAddrLabel)
                    .addComponent(resAdrrField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resRecipientLabel)
                    .addComponent(resRecipientField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resDateLabel)
                    .addComponent(resDataField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resMsgLabel)
                    .addComponent(resMsgScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resSendBtn)
                    .addComponent(resSubmitBtn)
                    .addComponent(resCancelBtn))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        manage.addTab("Thêm yêu cầu", addRequestpanel);

        schdlViewLabel.setText("Xem lịch:");

        schdlViewBtn.setText("Xem");
        schdlViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schdlViewBtnActionPerformed(evt);
            }
        });

        schdlTable.setModel(scdlTM);
        schdlScrollPane.setViewportView(schdlTable);

        schdlViewField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        schdlViewField.setText("dd/MM/yyyy");
        schdlViewField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schdlViewFieldActionPerformed(evt);
            }
        });

        schdlRequestBtn.setText("Xem yêu cầu");
        schdlRequestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schdlRequestBtnActionPerformed(evt);
            }
        });

        schdlPlayedBtn.setText("Đã phát");

        javax.swing.GroupLayout schedulingPanelLayout = new javax.swing.GroupLayout(schedulingPanel);
        schedulingPanel.setLayout(schedulingPanelLayout);
        schedulingPanelLayout.setHorizontalGroup(
            schedulingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schedulingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(schdlScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addGap(28, 28, 28))
            .addGroup(schedulingPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(schdlDivLine)
                .addGap(48, 48, 48))
            .addGroup(schedulingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(schedulingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(schedulingPanelLayout.createSequentialGroup()
                        .addComponent(schdlViewLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(schdlViewField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(schedulingPanelLayout.createSequentialGroup()
                        .addComponent(schdlViewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(schdlRequestBtn)
                        .addGap(48, 48, 48)
                        .addComponent(schdlPlayedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 404, Short.MAX_VALUE))
        );
        schedulingPanelLayout.setVerticalGroup(
            schedulingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schedulingPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(schedulingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(schdlViewLabel)
                    .addComponent(schdlViewField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(schedulingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(schdlViewBtn)
                    .addComponent(schdlRequestBtn)
                    .addComponent(schdlPlayedBtn))
                .addGap(18, 18, 18)
                .addComponent(schdlDivLine, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(schdlScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        manage.addTab("Lịch phát sóng", schedulingPanel);

        mrgTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên bài hát", "Thời gian yêu cầu", "Số lượt bình chọn", "Chi tiết", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        mrgScrollPane.setViewportView(mrgTable);

        mgrSearchBtn.setText("Thêm vào lịch");
        mgrSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mgrSearchBtnActionPerformed(evt);
            }
        });

        mgrSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mgrSearchFieldActionPerformed(evt);
            }
        });

        mgrSearchLabel.setText("Tìm kiếm bài hát");

        mrgSearchBtn.setText("Tìm kiếm");

        mrgViewBtn.setText("Xem yêu cầu");
        mrgViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrgViewBtnActionPerformed(evt);
            }
        });

        mrgRequestDateLabel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        mrgRequestDateLabel.setText("Ngày yêu cầu(dd/MM/yyyy)");

        mrgRequestStat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã phát", "Chưa phát" }));

        jButton2.setText("Sửa");

        javax.swing.GroupLayout managerPanelLayout = new javax.swing.GroupLayout(managerPanel);
        managerPanel.setLayout(managerPanelLayout);
        managerPanelLayout.setHorizontalGroup(
            managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mrgScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                    .addGroup(managerPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(managerPanelLayout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(mrgDivLine))
                            .addGroup(managerPanelLayout.createSequentialGroup()
                                .addComponent(mgrSearchLabel)
                                .addGap(3, 3, 3)
                                .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(managerPanelLayout.createSequentialGroup()
                                        .addComponent(mgrSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(mrgSearchBtn))
                                    .addGroup(managerPanelLayout.createSequentialGroup()
                                        .addComponent(mrgRequestDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(71, 71, 71)
                                        .addComponent(mrgRequestStat, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mgrSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(mrgViewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        managerPanelLayout.setVerticalGroup(
            managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managerPanelLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mgrSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mrgSearchBtn)
                    .addComponent(mgrSearchLabel))
                .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(managerPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mrgRequestDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mrgRequestStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(mrgDivLine, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mrgScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managerPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mrgViewBtn)
                            .addComponent(mgrSearchBtn))
                        .addContainerGap())))
        );

        manage.addTab("Quản lí", managerPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manage)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manage)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resNameFieldActionPerformed

    private void resCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resCancelBtnActionPerformed
        resNameField.setText("");
        resArtistField.setText("");
        resSenderField.setText("");
        resPhoneField.setText("");
        resAdrrField.setText("");
        resRecipientField.setText("");
        resDataField.setText("");
        resMsgTextArea.setText("");
    }//GEN-LAST:event_resCancelBtnActionPerformed

    private void playlistAcceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playlistAcceptBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playlistAcceptBtnActionPerformed

    private void playlostSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playlostSearchBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playlostSearchBtnActionPerformed

    private void mgrSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mgrSearchBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mgrSearchBtnActionPerformed

    private void mgrSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mgrSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mgrSearchFieldActionPerformed

    private void resSendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resSendBtnActionPerformed
        String nameSong = resNameField.getText().trim().toUpperCase();
        String nameArtist = resArtistField.getText().trim().toUpperCase();
        String nameSender = resSenderField.getText().trim().toUpperCase();
        String phoneNumber = resPhoneField.getText();
        String address = resAdrrField.getText().trim().toUpperCase();
        String nameReceipt = resRecipientField.getText().trim().toUpperCase();
        String dateSended = resDataField.getText();
        String message = resMsgTextArea.getText().trim();
        System.out.println(nameSong + nameArtist + nameSender + phoneNumber + address + nameReceipt + dateSended + message);
        if ("".equals(nameSong) && "".equals(nameArtist) && "".equals(nameSender) && ("".equals(phoneNumber) || "".equals(address)) && "".equals(nameReceipt) && "".equals(dateSended) && "".equals(message)) {
            JOptionPane.showMessageDialog(null, "Chưa nhập đủ trường.Xin mời nhập lại!");
        } else {
            try {
                RequirementController reqController = new RequirementController();
                Song song = reqController.getSong(nameSong, nameArtist);
                if (song != null) {
                    reqController.updateSong(song);
                    Requirement requirement = new Requirement(nameSender, nameReceipt, phoneNumber, address, null, message, "Chưa phát", dateSended, 0, song.getId());
                    reqController.insertRequirement(requirement);
                } else {
                    long id = new java.util.Date().getTime();
                    song = new Song(id, nameSong, nameArtist, null, null, 0, 1);
                    reqController.insertSong(song);
                    Requirement requirement = new Requirement(nameSender, nameReceipt, phoneNumber, address, null, message, "Chưa phát", dateSended, 0, song.getId());
                    reqController.insertRequirement(requirement);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        resSenderField.setText("");
        resPhoneField.setText("");
        resAdrrField.setText("");
        resRecipientField.setText("");
        resMsgTextArea.setText("");
    }//GEN-LAST:event_resSendBtnActionPerformed

    private void resSubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resSubmitBtnActionPerformed
        this.dispose();
        Management.main();
    }//GEN-LAST:event_resSubmitBtnActionPerformed

    private void schdlRequestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schdlRequestBtnActionPerformed
        if (idSongSelect != 0) {
            Management manager = new Management();
            manager.main();
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn bài hát!!!");
        }
    }//GEN-LAST:event_schdlRequestBtnActionPerformed

    private void mrgViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mrgViewBtnActionPerformed
        if (idSongSelect != 0) {
            Management manager = new Management();
            manager.main();
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn bài hát!!!");
        }
    }//GEN-LAST:event_mrgViewBtnActionPerformed

    private void schdlViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schdlViewBtnActionPerformed
    }//GEN-LAST:event_schdlViewBtnActionPerformed

    private void schdlViewFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schdlViewFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_schdlViewFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addRequestpanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JTabbedPane manage;
    private javax.swing.JPanel managerPanel;
    private javax.swing.JButton mgrSearchBtn;
    private javax.swing.JTextField mgrSearchField;
    private javax.swing.JLabel mgrSearchLabel;
    private javax.swing.ButtonGroup mode;
    private javax.swing.JSeparator mrgDivLine;
    private javax.swing.JFormattedTextField mrgRequestDateLabel;
    private javax.swing.JComboBox<String> mrgRequestStat;
    private javax.swing.JScrollPane mrgScrollPane;
    private javax.swing.JButton mrgSearchBtn;
    private javax.swing.JTable mrgTable;
    private javax.swing.JButton mrgViewBtn;
    private javax.swing.JButton playlistAcceptBtn;
    private javax.swing.JSeparator playlistDivLine;
    private javax.swing.JLabel playlistModeLabel;
    private javax.swing.JRadioButton playlistRdioAllSongs;
    private javax.swing.JRadioButton playlistRdioAudienceNotAccepted;
    private javax.swing.JRadioButton playlistRdioFavoriteSongs;
    private javax.swing.JRadioButton playlistRdioNotPlayedYet;
    private javax.swing.JButton playlistResetBtn;
    private javax.swing.JScrollPane playlistScrollPane;
    private javax.swing.JTextField playlistSearchField;
    private javax.swing.JTable playlistTable;
    private javax.swing.JButton playlistUpdateBtn;
    private javax.swing.JPanel playlisttPanel;
    private javax.swing.JRadioButton playlostSearchBtn;
    private javax.swing.JLabel resAddrLabel;
    private javax.swing.JTextField resAdrrField;
    private javax.swing.JTextField resArtistField;
    private javax.swing.JLabel resArtistLabel;
    private javax.swing.JButton resCancelBtn;
    private javax.swing.JFormattedTextField resDataField;
    private javax.swing.JLabel resDateLabel;
    private javax.swing.JLabel resMsgLabel;
    private javax.swing.JScrollPane resMsgScrollPane;
    private javax.swing.JTextArea resMsgTextArea;
    private javax.swing.JTextField resNameField;
    private javax.swing.JLabel resNameLabel;
    private javax.swing.JFormattedTextField resPhoneField;
    private javax.swing.JLabel resPhoneLabel;
    private javax.swing.JTextField resRecipientField;
    private javax.swing.JLabel resRecipientLabel;
    private javax.swing.JButton resSendBtn;
    private javax.swing.JTextField resSenderField;
    private javax.swing.JLabel resSenderLabel;
    private javax.swing.JButton resSubmitBtn;
    private javax.swing.JSeparator schdlDivLine;
    private javax.swing.JButton schdlPlayedBtn;
    private javax.swing.JButton schdlRequestBtn;
    private javax.swing.JScrollPane schdlScrollPane;
    private javax.swing.JTable schdlTable;
    private javax.swing.JButton schdlViewBtn;
    private javax.swing.JFormattedTextField schdlViewField;
    private javax.swing.JLabel schdlViewLabel;
    private javax.swing.JPanel schedulingPanel;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("favicon.png")));
    }

}
