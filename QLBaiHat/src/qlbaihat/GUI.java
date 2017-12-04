/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import qlbaihat.controller.CalendarManagement;
import qlbaihat.controller.DataBase;
import qlbaihat.controller.RequirementController;
import qlbaihat.controller.ScheduleController;
import qlbaihat.controller.SongController;
import qlbaihat.model.Song;
import qlbaihat.model.Requirement;
import qlbaihat.model.ScheduleTableModel;
/**
 *
 * @author HD
 */
public class GUI extends javax.swing.JFrame {

    public static long idSongSelect=0;
    String nameSong,nameArtisrt,nameComposer,type,date;
    int vote;
    public ScheduleTableModel scdlTM = new ScheduleTableModel();
    public ScheduleController scdlController;

    
    public GUI() throws SQLException, ClassNotFoundException {
        initComponents();
        schedulePanel();
        setIcon();
        select();
        select1();
        select2();
        CalendarManagement cl = new CalendarManagement();
            cl.hienThi(mrgTable,"");
    }
    public void schedulePanel(){
        ListSelectionModel cellSelect = schdlTable.getSelectionModel();
        cellSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        scdlController = new ScheduleController(schdlTable, scdlTM, jDateChooser1);
        schdlViewBtn.setActionCommand("View");
        schdlRequestBtn.setActionCommand("Request");
        schdlPlayedBtn.setActionCommand("Played");
        cellSelect.addListSelectionListener(scdlController);
        schdlViewBtn.addActionListener(scdlController);
        schdlRequestBtn.addActionListener(scdlController);
        schdlPlayedBtn.addActionListener(scdlController);
    }
    void select2()
    {        
        ListSelectionModel cellSelect=listSong.getSelectionModel();
        cellSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelect.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) 
            {
                int[] row=listSong.getSelectedRows();
                int[] col=listSong.getSelectedColumns();
            for(int i=0;i<row.length;i++)
            {
                idSongSelect=(long) listSong.getValueAt(row[i], 0);
                System.out.println(idSongSelect);
            }            
            }
        });
    }
 void select()
    {        
        ListSelectionModel cellSelect=schdlTable.getSelectionModel();
        cellSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelect.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) 
            {
                int[] row=schdlTable.getSelectedRows();
                int[] col=schdlTable.getSelectedColumns();
            for(int i=0;i<row.length;i++)
            {
                idSongSelect=(Long) schdlTable.getValueAt(row[i], 1);            
            }            
            System.out.print(idSongSelect);
            }
        });
    }
  void select1()
    {        
        
        ListSelectionModel cellSelect=mrgTable.getSelectionModel();
        cellSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelect.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) 
            {
                String nameSong=null;
                String nameArtist=null;
                int[] row=mrgTable.getSelectedRows();
                int[] col=mrgTable.getSelectedColumns();
            for(int i=0;i<row.length;i++)
            {   
                nameSong=(String) mrgTable.getValueAt(row[i], 0);
                nameArtist=(String) mrgTable.getValueAt(row[i], 1);            
            }
            if(nameSong==null||nameArtist==null){
                JOptionPane.showMessageDialog(null, "Không có dữ liệu!!");
            }
            String sql="SELECT id FROM song WHERE name='"+nameSong+"' && artist='"+nameArtist+"'";
            Connection connection = qlbaihat.controller.DataBase.getConnection();
            PreparedStatement ps;
                try {
                    ps = connection.prepareCall(sql);
                     ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        idSongSelect=rs.getLong("id");
                    }
                    rs.close();
                    ps.close();
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }       
            System.out.print(idSongSelect);
            }
        });
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
        addSong = new javax.swing.JRadioButton();
        playlostSearchBtn = new javax.swing.JRadioButton();
        playlistScrollPane = new javax.swing.JScrollPane();
        listSong = new javax.swing.JTable();
        playlistDivLine = new javax.swing.JSeparator();
        ok = new javax.swing.JButton();
        playlistSearchField = new javax.swing.JTextField();
        playlistResetBtn = new javax.swing.JButton();
        Month = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
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
        resPhoneField = new javax.swing.JFormattedTextField();
        resDataField = new com.toedter.calendar.JDateChooser();
        schedulingPanel = new javax.swing.JPanel();
        schdlViewLabel = new javax.swing.JLabel();
        schdlViewBtn = new javax.swing.JButton();
        schdlDivLine = new javax.swing.JSeparator();
        schdlScrollPane = new javax.swing.JScrollPane();
        schdlTable = new javax.swing.JTable();
        schdlRequestBtn = new javax.swing.JButton();
        schdlPlayedBtn = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        managerPanel = new javax.swing.JPanel();
        mrgScrollPane = new javax.swing.JScrollPane();
        mrgTable = new javax.swing.JTable();
        mrgDivLine = new javax.swing.JSeparator();
        mgrSearchBtn = new javax.swing.JButton();
        mgrSearchLabel = new javax.swing.JLabel();
        showDanhSach = new javax.swing.JButton();
        mrgViewBtn = new javax.swing.JButton();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý bài hát");

        playlistModeLabel.setText("Chọn chế độ:");

        mode.add(playlistRdioAllSongs);
        playlistRdioAllSongs.setText("Tất cả bài hát.");
        playlistRdioAllSongs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playlistRdioAllSongsActionPerformed(evt);
            }
        });

        mode.add(playlistRdioFavoriteSongs);
        playlistRdioFavoriteSongs.setText("Bài hát được yêu thích nhất trong tháng");
        playlistRdioFavoriteSongs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playlistRdioFavoriteSongsActionPerformed(evt);
            }
        });

        mode.add(addSong);
        addSong.setText("Thêm bài hát");
        addSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSongActionPerformed(evt);
            }
        });

        mode.add(playlostSearchBtn);
        playlostSearchBtn.setText("Tìm kiếm bài hát:");
        playlostSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playlostSearchBtnActionPerformed(evt);
            }
        });

        listSong.setModel(new javax.swing.table.DefaultTableModel(
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
        playlistScrollPane.setViewportView(listSong);
        if (listSong.getColumnModel().getColumnCount() > 0) {
            listSong.getColumnModel().getColumn(0).setResizable(false);
            listSong.getColumnModel().getColumn(0).setPreferredWidth(5);
            listSong.getColumnModel().getColumn(6).setResizable(false);
        }

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                putOk(evt);
            }
        });

        playlistResetBtn.setText("Reset lượt yêu cầu");
        playlistResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playlistResetBtnActionPerformed(evt);
            }
        });

        Month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        Month.setEnabled(false);
        Month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout playlisttPanelLayout = new javax.swing.GroupLayout(playlisttPanel);
        playlisttPanel.setLayout(playlisttPanelLayout);
        playlisttPanelLayout.setHorizontalGroup(
            playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playlisttPanelLayout.createSequentialGroup()
                .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playlisttPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playlistScrollPane)
                            .addComponent(playlistDivLine)))
                    .addGroup(playlisttPanelLayout.createSequentialGroup()
                        .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(playlisttPanelLayout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(playlistModeLabel)
                                .addGap(69, 69, 69)
                                .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(playlisttPanelLayout.createSequentialGroup()
                                        .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(addSong)
                                            .addComponent(playlistRdioFavoriteSongs)
                                            .addComponent(playlistRdioAllSongs))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(playlisttPanelLayout.createSequentialGroup()
                                        .addComponent(playlostSearchBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(playlistSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(playlisttPanelLayout.createSequentialGroup()
                                .addGap(408, 408, 408)
                                .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(playlistResetBtn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
            .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(playlisttPanelLayout.createSequentialGroup()
                    .addGap(338, 338, 338)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(339, Short.MAX_VALUE)))
        );
        playlisttPanelLayout.setVerticalGroup(
            playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playlisttPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playlistRdioAllSongs)
                    .addComponent(playlistModeLabel))
                .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playlisttPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(playlistRdioFavoriteSongs))
                    .addComponent(Month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(addSong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playlostSearchBtn)
                    .addComponent(playlistSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ok)
                    .addComponent(playlistResetBtn))
                .addGap(46, 46, 46)
                .addComponent(playlistDivLine, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(playlistScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(playlisttPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(playlisttPanelLayout.createSequentialGroup()
                    .addGap(287, 287, 287)
                    .addComponent(jLabel1)
                    .addContainerGap(267, Short.MAX_VALUE)))
        );

        playlisttPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addSong, playlistRdioAllSongs, playlistRdioFavoriteSongs, playlostSearchBtn});

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

        resPhoneField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        resDataField.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout addRequestpanelLayout = new javax.swing.GroupLayout(addRequestpanel);
        addRequestpanel.setLayout(addRequestpanelLayout);
        addRequestpanelLayout.setHorizontalGroup(
            addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRequestpanelLayout.createSequentialGroup()
                .addContainerGap(223, Short.MAX_VALUE)
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
                            .addComponent(resDataField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(223, Short.MAX_VALUE))
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
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(resDateLabel)
                    .addComponent(resDataField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resMsgLabel)
                    .addComponent(resMsgScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resSendBtn)
                    .addComponent(resSubmitBtn)
                    .addComponent(resCancelBtn))
                .addContainerGap(93, Short.MAX_VALUE))
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
                .addComponent(schdlScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                .addGap(28, 28, 28))
            .addGroup(schedulingPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(schdlDivLine)
                .addGap(48, 48, 48))
            .addGroup(schedulingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(schedulingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(schedulingPanelLayout.createSequentialGroup()
                        .addComponent(schdlViewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(schdlRequestBtn)
                        .addGap(48, 48, 48)
                        .addComponent(schdlPlayedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(schedulingPanelLayout.createSequentialGroup()
                        .addComponent(schdlViewLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        schedulingPanelLayout.setVerticalGroup(
            schedulingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schedulingPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(schedulingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(schdlViewLabel)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(schedulingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(schdlViewBtn)
                    .addComponent(schdlRequestBtn)
                    .addComponent(schdlPlayedBtn))
                .addGap(18, 18, 18)
                .addComponent(schdlDivLine, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(schdlScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        manage.addTab("Lịch phát sóng", schedulingPanel);

        mrgTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên bài hát", "Ca sĩ", "Số lượt yêu cầu", "Các thính giả yêu cầui"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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

        mgrSearchLabel.setText("Ngày phát");

        showDanhSach.setText("Tìm kiếm");
        showDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDanhSachActionPerformed(evt);
            }
        });

        mrgViewBtn.setText("Xem yêu cầu");
        mrgViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrgViewBtnActionPerformed(evt);
            }
        });

        refresh.setText("Refresh");
        refresh.setToolTipText("");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout managerPanelLayout = new javax.swing.GroupLayout(managerPanel);
        managerPanel.setLayout(managerPanelLayout);
        managerPanelLayout.setHorizontalGroup(
            managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mrgScrollPane)
                    .addGroup(managerPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(managerPanelLayout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(mrgDivLine))
                            .addGroup(managerPanelLayout.createSequentialGroup()
                                .addComponent(mgrSearchLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(showDanhSach)
                                .addGap(36, 36, 36)
                                .addComponent(refresh)
                                .addGap(0, 110, Short.MAX_VALUE)))))
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
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(showDanhSach)
                        .addComponent(mgrSearchLabel)
                        .addComponent(refresh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(managerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managerPanelLayout.createSequentialGroup()
                        .addComponent(mrgDivLine, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mrgScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managerPanelLayout.createSequentialGroup()
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
        resMsgTextArea.setText("");
    }//GEN-LAST:event_resCancelBtnActionPerformed

    private void playlostSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playlostSearchBtnActionPerformed
        playlistSearchField.setEnabled(true);
        Month.setEnabled(false);
    }//GEN-LAST:event_playlostSearchBtnActionPerformed

    private void mgrSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mgrSearchBtnActionPerformed
        
        java.sql.Connection conn= DataBase.getConnection();
        String sql="INSERT INTO schedule(id,idsong,namesong,nameatirst,note) SELECT null,id,name,artist,'CHƯA PHÁT' FROM song WHERE song.id='"+idSongSelect+"'";
        String sqlUpdate="UPDATE requirement SET status='Đã thêm' WHERE songid='"+idSongSelect+"'";
        java.sql.Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql); 
            stmt.executeUpdate(sqlUpdate);
            stmt.close();
            conn.close();
        JOptionPane.showMessageDialog(null, "Thêm vào lịch thành công!");
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_mgrSearchBtnActionPerformed

    private void resSendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resSendBtnActionPerformed
        String nameSong = resNameField.getText().trim().toUpperCase();
        String nameArtist =resArtistField.getText().trim().toUpperCase();
        String nameSender=resSenderField.getText().trim().toUpperCase();
        String phoneNumber =resPhoneField.getText();
        String address=resAdrrField.getText().trim().toUpperCase();
        String nameReceipt=resRecipientField.getText().trim().toUpperCase();
        SimpleDateFormat dateFomat = new SimpleDateFormat("dd/MM/yyyy");
        String dateSended =dateFomat.format(resDataField.getDate());
        String message=resMsgTextArea.getText().trim();
        System.out.println(nameSong+ nameArtist + nameSender + phoneNumber+address+ nameReceipt+ dateSended+ message);
        if("".equals(nameSong)&&"".equals(nameArtist)&&"".equals(nameSender)&&("".equals(phoneNumber)||"".equals(address))&&"".equals(nameReceipt)&&"".equals(dateSended)&&"".equals(message))
        {
            JOptionPane.showMessageDialog(null, "Chưa nhập đủ trường.Xin mời nhập lại!");          
        }
        else{
            try{
                RequirementController reqController =new RequirementController();
                Song song= reqController.getSong(nameSong, nameArtist);
                if(song!=null)
                {
                 reqController.updateSong(song);
                 Requirement requirement=new Requirement(nameSender, nameReceipt, phoneNumber, address, null, message, "Chưa phát", dateSended, 0, song.getId());
                 reqController.insertRequirement(requirement);
                }
                else
                {
                    long id= new java.util.Date().getTime();
                    song = new Song(id, nameSong, nameArtist, null, null, 0, 1);
                    reqController.insertSong(song);
                    Requirement requirement=new Requirement(nameSender, nameReceipt, phoneNumber, address, null, message, "Chưa phát", dateSended, 0, song.getId());
                    reqController.insertRequirement(requirement);   
                }
                    }catch(SQLException e){
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
        if(idSongSelect!=0)
        {
            Management manager;
            try {
                manager = new Management();
                manager.main();
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn bài hát!!!");
    }//GEN-LAST:event_schdlRequestBtnActionPerformed

    private void mrgViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mrgViewBtnActionPerformed
         if(idSongSelect!=0)
        {
            Management manager;
             try {
                 manager = new Management();
                 manager.main();
             } catch (SQLException ex) {
                 Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
        else
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn bài hát!!!");               
    }//GEN-LAST:event_mrgViewBtnActionPerformed

    private void showDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDanhSachActionPerformed
       try {
           SimpleDateFormat dateFomat = new SimpleDateFormat("dd/MM/yyyy");
        String dateSended =dateFomat.format(jDateChooser4.getDate());
            CalendarManagement cl = new CalendarManagement();
            cl.hienThi(mrgTable,"AND playdate='"+dateSended+"'");
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showDanhSachActionPerformed

    private void addSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSongActionPerformed
        /**
         * @author tuyên
         * diễn ra khi chọn thêm bài hát
         */
        playlistSearchField.setEnabled(false);
        Month.setEnabled(false);
    }//GEN-LAST:event_addSongActionPerformed

    private void putOk(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_putOk
       int chosen =5;
        if(playlistRdioAllSongs.isSelected()){//chọn tât cả bài hát
            chosen = 0;
        }
        
        if(playlistRdioFavoriteSongs.isSelected()){//chọn bài hát yêu thích nhất tháng
            chosen = 1;
        }
        
        if(playlostSearchBtn.isSelected()){//tìm kiếm bài hát
            chosen = 2;
        }
        
        if(addSong.isSelected()){//thêm bài hát
            chosen = 3;
        }
        int month =  Month.getSelectedIndex() + 1;
        String name = playlistSearchField.getText().trim().toUpperCase();
        SongController control = new SongController(chosen, month, listSong, name, jLabel1);
        control.eventOK();
        TableModel data = listSong.getModel();
    }//GEN-LAST:event_putOk

    private void playlistRdioFavoriteSongsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playlistRdioFavoriteSongsActionPerformed
      /**
         * @author tuyên
         * diễn ra khi chọn bài hát được yêu thích nhất tháng
         */
        playlistSearchField.setEnabled(false);
        Month.setEnabled(true);
    }//GEN-LAST:event_playlistRdioFavoriteSongsActionPerformed

    private void playlistRdioAllSongsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playlistRdioAllSongsActionPerformed
         /**
         * @author tuyên
         * diễn ra khi chọn tất cả bài hát
         */
        playlistSearchField.setEnabled(false);
        Month.setEnabled(false);
    }//GEN-LAST:event_playlistRdioAllSongsActionPerformed

    private void schdlViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schdlViewBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_schdlViewBtnActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
       
        try {
             CalendarManagement cl = new CalendarManagement();
            cl.hienThi(mrgTable,"");
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshActionPerformed

    private void playlistResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playlistResetBtnActionPerformed
       String sql="UPDATE song SET vote='0' WHERE vote!='0'";
        Connection con = DataBase.getConnection();
        try {
            Statement statement = (Statement)con.createStatement();
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Reset thành công!");
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_playlistResetBtnActionPerformed

    private void MonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonthActionPerformed
//     private void mgrSearchBtnMouseClicked(java.awt.event.MouseEvent evt) {                                          
//        String ngayThang = mgrSearchField.getText();
//        if(!(ngayThang.equals("")||ngayThang.equals("dd/mm/yyyy"))){           
//            CalendarManagement cl = new CalendarManagement();
//            if(cl.isValidDate(ngayThang)){
//                try {
//                    if(cl.compareDates(ngayThang)){
//                        JOptionPane.showMessageDialog(null, "Ngày bạn nhập đã trôi qua");
//                    }
//                    else{
//                        try {
//                            cl.ThemLichPhat(mgrSearchField, mrgTable);
//                        } catch (SQLException ex) {
//                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (ClassNotFoundException ex) {
//                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                } catch (ParseException ex) {
//                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            else
//                JOptionPane.showMessageDialog(rootPane, "Hãy nhập lại ngày dự kiến phát theo mẫu dd/mm/yyyy");
//        }
//        else 
//            JOptionPane.showMessageDialog(rootPane, "Hãy nhập ngày dự kiến phát");
//        
//    }                        
     
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
                if ("Nimbus".equals(info.getName())) {
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
                try {
                    new GUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Month;
    private javax.swing.JPanel addRequestpanel;
    private javax.swing.JRadioButton addSong;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable listSong;
    private javax.swing.JTabbedPane manage;
    private javax.swing.JPanel managerPanel;
    private javax.swing.JButton mgrSearchBtn;
    private javax.swing.JLabel mgrSearchLabel;
    private javax.swing.ButtonGroup mode;
    private javax.swing.JSeparator mrgDivLine;
    private javax.swing.JScrollPane mrgScrollPane;
    private javax.swing.JTable mrgTable;
    private javax.swing.JButton mrgViewBtn;
    private javax.swing.JButton ok;
    private javax.swing.JSeparator playlistDivLine;
    private javax.swing.JLabel playlistModeLabel;
    private javax.swing.JRadioButton playlistRdioAllSongs;
    private javax.swing.JRadioButton playlistRdioFavoriteSongs;
    private javax.swing.JButton playlistResetBtn;
    private javax.swing.JScrollPane playlistScrollPane;
    private javax.swing.JTextField playlistSearchField;
    private javax.swing.JPanel playlisttPanel;
    private javax.swing.JRadioButton playlostSearchBtn;
    private javax.swing.JButton refresh;
    private javax.swing.JLabel resAddrLabel;
    private javax.swing.JTextField resAdrrField;
    private javax.swing.JTextField resArtistField;
    private javax.swing.JLabel resArtistLabel;
    private javax.swing.JButton resCancelBtn;
    private com.toedter.calendar.JDateChooser resDataField;
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
    private javax.swing.JLabel schdlViewLabel;
    private javax.swing.JPanel schedulingPanel;
    private javax.swing.JButton showDanhSach;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("favicon.png")));
    }

}

