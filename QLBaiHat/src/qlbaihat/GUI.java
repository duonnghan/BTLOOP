/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbaihat;

import java.awt.Toolkit;

/**
 *
 * @author HD
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mode = new javax.swing.ButtonGroup();
        manage = new javax.swing.JTabbedPane();
        songListPanel = new javax.swing.JPanel();
        modeLabel = new javax.swing.JLabel();
        rdioAllSongs = new javax.swing.JRadioButton();
        rdioFavoriteSongs = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        mothChooser = new com.toedter.calendar.JMonthChooser();
        divideLine = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        songsTable = new javax.swing.JTable();
        newSongPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        artistLabel = new javax.swing.JLabel();
        artistField = new javax.swing.JTextField();
        composerLabel = new javax.swing.JLabel();
        composerField = new javax.swing.JTextField();
        yearLabel = new javax.swing.JLabel();
        yearComBox = new javax.swing.JComboBox<>();
        genreLabel = new javax.swing.JLabel();
        genreComBox = new javax.swing.JComboBox<>();
        addBtn = new javax.swing.JButton();
        cancel1Btn = new javax.swing.JButton();
        submit1Btn = new javax.swing.JButton();
        addRequestpanel = new javax.swing.JPanel();
        resNameLabel = new javax.swing.JLabel();
        resNameField = new javax.swing.JTextField();
        resArtistLabel = new javax.swing.JLabel();
        resArtistField = new javax.swing.JTextField();
        senderLabel = new javax.swing.JLabel();
        senderField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        addrLabel = new javax.swing.JLabel();
        adrrField = new javax.swing.JTextField();
        recipientLabel = new javax.swing.JLabel();
        recipientField = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        msgLabel = new javax.swing.JLabel();
        msgScrollPane = new javax.swing.JScrollPane();
        msgTextArea = new javax.swing.JTextArea();
        sendBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        schedulingPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý bài hát");

        modeLabel.setText("Chọn chế độ:");

        mode.add(rdioAllSongs);
        rdioAllSongs.setText("Tất cả bài hát.");

        mode.add(rdioFavoriteSongs);
        rdioFavoriteSongs.setText("Bài hát được yêu thích nhất trong tháng");

        mode.add(jRadioButton3);
        jRadioButton3.setText("Bài hát chưa được phát sóng");

        mode.add(jRadioButton4);
        jRadioButton4.setText("Các thính giả chưa phát được yêu cầu");

        mothChooser.setToolTipText("");

        songsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(songsTable);
        if (songsTable.getColumnModel().getColumnCount() > 0) {
            songsTable.getColumnModel().getColumn(0).setResizable(false);
            songsTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            songsTable.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout songListPanelLayout = new javax.swing.GroupLayout(songListPanel);
        songListPanel.setLayout(songListPanelLayout);
        songListPanelLayout.setHorizontalGroup(
            songListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(songListPanelLayout.createSequentialGroup()
                .addGroup(songListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, songListPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(divideLine))
                    .addGroup(songListPanelLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(modeLabel)
                        .addGap(64, 64, 64)
                        .addGroup(songListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton3)
                            .addGroup(songListPanelLayout.createSequentialGroup()
                                .addGroup(songListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdioFavoriteSongs)
                                    .addComponent(rdioAllSongs))
                                .addGap(18, 18, 18)
                                .addComponent(mothChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addGroup(songListPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        songListPanelLayout.setVerticalGroup(
            songListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(songListPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(songListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(songListPanelLayout.createSequentialGroup()
                        .addGroup(songListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdioAllSongs)
                            .addComponent(modeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdioFavoriteSongs))
                    .addComponent(mothChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addGap(18, 18, 18)
                .addComponent(divideLine, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        manage.addTab("Danh sách bài hát", songListPanel);

        nameLabel.setText("Tên bài hát:");

        artistLabel.setText("Ca sĩ:");

        artistField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                artistFieldActionPerformed(evt);
            }
        });

        composerLabel.setText("Nhạc sĩ:");

        composerField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                composerFieldActionPerformed(evt);
            }
        });

        yearLabel.setText("Năm:");

        yearComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" }));
        yearComBox.setSelectedIndex(26);

        genreLabel.setText("Thể loại:");

        genreComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhạc trẻ", "Nhạc trữ tình", "Nhạc vàng", "Nhạc đỏ", "Rap", "Hip hop", "Nhạc thiếu nhi", "Nhạc không lời", "EDM" }));

        addBtn.setText("Thêm");

        cancel1Btn.setText("Hủy");
        cancel1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel1BtnActionPerformed(evt);
            }
        });

        submit1Btn.setText("Xong");
        submit1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit1BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newSongPanelLayout = new javax.swing.GroupLayout(newSongPanel);
        newSongPanel.setLayout(newSongPanelLayout);
        newSongPanelLayout.setHorizontalGroup(
            newSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newSongPanelLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(newSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(genreLabel)
                        .addComponent(yearLabel)
                        .addComponent(composerLabel)
                        .addComponent(artistLabel)
                        .addComponent(nameLabel))
                    .addGroup(newSongPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nameField)
                        .addComponent(artistField)
                        .addComponent(composerField, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                    .addComponent(yearComBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genreComBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newSongPanelLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(cancel1Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(submit1Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        newSongPanelLayout.setVerticalGroup(
            newSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newSongPanelLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(newSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistLabel)
                    .addComponent(artistField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(composerLabel)
                    .addComponent(composerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearLabel)
                    .addComponent(yearComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genreLabel)
                    .addComponent(genreComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(newSongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(cancel1Btn)
                    .addComponent(submit1Btn))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        manage.addTab("Thêm bài hát", newSongPanel);

        resNameLabel.setText("Tên bài hát:");

        resNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resNameFieldActionPerformed(evt);
            }
        });

        resArtistLabel.setText("Tên ca sĩ:");

        senderLabel.setText("Tên người gửi:");

        phoneLabel.setText("Số điện thoại:");

        addrLabel.setText("Địa chỉ:");

        recipientLabel.setText("Tên người nhận:");

        dateLabel.setText("Ngày yêu cầu:");

        msgLabel.setText("Lời nhắn:");

        msgTextArea.setColumns(20);
        msgTextArea.setRows(5);
        msgScrollPane.setViewportView(msgTextArea);

        sendBtn.setText("Gửi");

        submitBtn.setText("Xong");

        cancelBtn.setText("Hủy");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addRequestpanelLayout = new javax.swing.GroupLayout(addRequestpanel);
        addRequestpanel.setLayout(addRequestpanelLayout);
        addRequestpanelLayout.setHorizontalGroup(
            addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRequestpanelLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(addRequestpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(recipientLabel)
                    .addComponent(msgLabel)
                    .addComponent(dateLabel)
                    .addComponent(addrLabel)
                    .addComponent(phoneLabel)
                    .addComponent(senderLabel)
                    .addComponent(resArtistLabel)
                    .addComponent(resNameLabel))
                .addGap(42, 42, 42)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resNameField)
                    .addComponent(resArtistField)
                    .addComponent(senderField)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adrrField)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(msgScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(recipientField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addRequestpanelLayout.setVerticalGroup(
            addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRequestpanelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resNameLabel)
                    .addComponent(resNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resArtistLabel)
                    .addComponent(resArtistField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senderLabel)
                    .addComponent(senderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addrLabel)
                    .addComponent(adrrField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recipientLabel)
                    .addComponent(recipientField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateLabel)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msgLabel)
                    .addComponent(msgScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(addRequestpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendBtn)
                    .addComponent(submitBtn)
                    .addComponent(cancelBtn))
                .addGap(32, 32, 32))
        );

        manage.addTab("Thêm yêu cầu", addRequestpanel);

        jLabel1.setText("Xem lịch:");

        jButton1.setText("Xem");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Tên bài hát", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout schedulingPanelLayout = new javax.swing.GroupLayout(schedulingPanel);
        schedulingPanel.setLayout(schedulingPanelLayout);
        schedulingPanelLayout.setHorizontalGroup(
            schedulingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schedulingPanelLayout.createSequentialGroup()
                .addGroup(schedulingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(schedulingPanelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(schedulingPanelLayout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(schedulingPanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, schedulingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addGap(28, 28, 28))
        );
        schedulingPanelLayout.setVerticalGroup(
            schedulingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schedulingPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(schedulingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        manage.addTab("Lịch phát sóng", schedulingPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(manage)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manage, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void artistFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_artistFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_artistFieldActionPerformed

    private void composerFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_composerFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_composerFieldActionPerformed

    private void cancel1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel1BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel1BtnActionPerformed

    private void submit1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit1BtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submit1BtnActionPerformed

    private void resNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resNameFieldActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed

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
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel addRequestpanel;
    private javax.swing.JLabel addrLabel;
    private javax.swing.JTextField adrrField;
    private javax.swing.JTextField artistField;
    private javax.swing.JLabel artistLabel;
    private javax.swing.JButton cancel1Btn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField composerField;
    private javax.swing.JLabel composerLabel;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JSeparator divideLine;
    private javax.swing.JComboBox<String> genreComBox;
    private javax.swing.JLabel genreLabel;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTabbedPane manage;
    private javax.swing.ButtonGroup mode;
    private javax.swing.JLabel modeLabel;
    private com.toedter.calendar.JMonthChooser mothChooser;
    private javax.swing.JLabel msgLabel;
    private javax.swing.JScrollPane msgScrollPane;
    private javax.swing.JTextArea msgTextArea;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel newSongPanel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JRadioButton rdioAllSongs;
    private javax.swing.JRadioButton rdioFavoriteSongs;
    private javax.swing.JTextField recipientField;
    private javax.swing.JLabel recipientLabel;
    private javax.swing.JTextField resArtistField;
    private javax.swing.JLabel resArtistLabel;
    private javax.swing.JTextField resNameField;
    private javax.swing.JLabel resNameLabel;
    private javax.swing.JPanel schedulingPanel;
    private javax.swing.JButton sendBtn;
    private javax.swing.JTextField senderField;
    private javax.swing.JLabel senderLabel;
    private javax.swing.JPanel songListPanel;
    private javax.swing.JTable songsTable;
    private javax.swing.JButton submit1Btn;
    private javax.swing.JButton submitBtn;
    private javax.swing.JComboBox<String> yearComBox;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("favicon.png")));
    }
}
