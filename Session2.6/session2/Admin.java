/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Admin.java
 *
 * Created on 2014-11-27, 22:42:27
 */

package session2;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
//import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Mark
 */
public class Admin extends javax.swing.JFrame {
    private String nm, pass;
    private ImageIcon icon;

    /** Creates new form Admin */
    public Admin(String nm, String pass){
        initComponents();
        this.nm = nm;    this.pass = pass;
        this.icon = new ImageIcon(getClass().getResource("/session2/head/initial.jpg"));
    }//构造器

    public String getnm(){
      return this.nm;
    }
    public String getpass(){
      return this.pass;
    }
    public ImageIcon geticon(){
      return this.icon;
    }

    private boolean setPass(String str){
        if (str.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,12}")) {
            this.pass = str; return true;}
        else return false;
    }//修改密码

    private boolean stackup(int type, int num){
        if (num < 0) {
            JOptionPane.showMessageDialog(rootPane, "WRONG NUMBER!", "WARNING", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            double tmp = Main.mn - num * Storage.price[type];
            if ( tmp >= 0){
              Storage.piece[type] += num;   Storage.num[type]++;
              Main.mn = tmp;
              Storage.price[type] *= 0.95;
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Money not ENOUGH!", "WARNING", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }//进货,改变进价

    private void stock(String nm, double price){
        int tmp = ++Main.goods;
        if (tmp<=50){
            Storage.arr[tmp] = nm;
            Storage.price[tmp] = price;
            Storage.proto[tmp] = price;// 保存原价记录
        }
    }//增加商品
    private void under(byte type){
        int tmp = --Main.goods;
        for (int i = type; i<tmp ; i++){
            Storage.arr[i] = Storage.arr[i+1];
            Storage.price[i] = Storage.price[i+1];
        }
    }//下架商品

    private boolean addMember(String str){
        int tmp = Main.clerk;
        if ((Main.clerk < 10)&&(checkName(str))){
            Main.sl[Main.clerk] = new Saler(str,str);
            Main.clerk ++;
            return true;
        }
       return false;
    }//增加员工

     public boolean checkName(String str){
        for (int i = 0; i<Main.clerk; i++){
            if (Main.sl[i].getnm().equals(str)) return false;
        }
        return true;
    }

    private void fireMember(int type){
        jComboBox2.removeItemAt(type);
        Main.sl[type] = null; Main.clerk -= 1;
        while(Main.sl[type + 1] != null){
            Main.sl[type] = Main.sl[type + 1];
            type ++;
        }
    }//开除员工

    private String showType(int type){
        double tmp;
        if (Storage.num[type] == 0) tmp = Storage.price[type];
        else tmp = (( 20 * Storage.proto[type] - 19 * Storage.price[type])/(Storage.num[type] + 1));
        return String.format("%.2f", tmp);
    }//set to show average进价

    private void query(){
        double sell = 0, prof = 0;
        //set to show cap.mn;//流动资金总额
            sell = Saler.Tsale;    prof = Saler.Tprofit;
            //set to show query tab
            jLabel7.setText("流动资金 " + Main.mn); jLabel8.setText("总销售额 " + sell);  jLabel9.setText("总利润 " + prof);
            jLabel17.setText(String.format("%s %.2f %%", "利润率", (Main.lim * 100)));
    }//show 流动资金余额，总销售额，总利润

    private void fillTable(javax.swing.JTable tb){
        //DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();
        for (int i = 0; i < Main.goods; i++){
            tb.getModel().setValueAt(Storage.arr[i], i, 0);
            tb.getModel().setValueAt(String.format("%d", Storage.piece[i]), i, 1);
            tb.getModel().setValueAt(String.format("%.2f", Storage.price[i]), i, 2);
            tb.getModel().setValueAt(showType(i), i, 3);
        }
        tb.invalidate();    query();
    }

    private void fillBox(){
        jComboBox2.removeAllItems();
        for (int i = 0; i< Main.clerk; i++){
            if (Main.sl[i] != null)
                jComboBox2.addItem(Main.sl[i].getnm());
        }
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING)
            if (JOptionPane.showConfirmDialog(rootPane, "Are you sure to exit?", "EXIT", JOptionPane.YES_NO_OPTION) == 1) return;
            else  super.processWindowEvent(e);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jFrame2 = new javax.swing.JFrame();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton6 = new javax.swing.JButton();
        jFrame3 = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField4 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();

        jFrame1.setTitle("Set Password");
        jFrame1.setBounds(new java.awt.Rectangle(0, 0, 300, 360));
        jFrame1.setLocationByPlatform(true);
        jFrame1.setMinimumSize(new java.awt.Dimension(300, 360));
        jFrame1.getContentPane().setLayout(null);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("原密码");
        jFrame1.getContentPane().add(jLabel3);
        jLabel3.setBounds(16, 80, 60, 15);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("新密码");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jFrame1.getContentPane().add(jLabel4);
        jLabel4.setBounds(16, 140, 60, 15);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("确认新密码");
        jFrame1.getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 200, 70, 15);

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(80, 80, 180, 21);

        jPasswordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField2FocusLost(evt);
            }
        });
        jFrame1.getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(80, 140, 180, 21);

        jPasswordField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField3FocusLost(evt);
            }
        });
        jFrame1.getContentPane().add(jPasswordField3);
        jPasswordField3.setBounds(80, 200, 180, 21);

        jButton3.setText("Confirm");
        jButton3.setFocusPainted(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jFrame1.getContentPane().add(jButton3);
        jButton3.setBounds(120, 260, 100, 40);

        jTextField1.setEditable(false);
        jTextField1.setForeground(new java.awt.Color(255, 0, 0));
        jTextField1.setText("新密码必须包含大小写字母和数字，6-12位");
        jTextField1.setAutoscrolls(false);
        jTextField1.setBorder(null);
        jTextField1.setFocusable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(jTextField1);
        jTextField1.setBounds(22, 30, 240, 15);

        jTextField2.setEditable(false);
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setAutoscrolls(false);
        jTextField2.setBorder(null);
        jTextField2.setFocusable(false);
        jFrame1.getContentPane().add(jTextField2);
        jTextField2.setBounds(102, 170, 130, 15);

        jTextField3.setEditable(false);
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(null);
        jFrame1.getContentPane().add(jTextField3);
        jTextField3.setBounds(100, 230, 130, 15);

        jFrame1.getAccessibleContext().setAccessibleParent(jPanel2);

        jFrame2.setTitle("进库");
        jFrame2.setBounds(new java.awt.Rectangle(0, 0, 400, 300));
        jFrame2.setLocationByPlatform(true);
        jFrame2.setMinimumSize(new java.awt.Dimension(400, 300));
        jFrame2.setResizable(false);
        jFrame2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jFrame2ComponentShown(evt);
            }
        });
        jFrame2.getContentPane().setLayout(null);

        jLabel10.setFont(new java.awt.Font("宋体", 0, 18));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("数量");
        jFrame2.getContentPane().add(jLabel10);
        jLabel10.setBounds(50, 120, 100, 60);

        jComboBox1.setFont(new java.awt.Font("宋体", 0, 16));
        jFrame2.getContentPane().add(jComboBox1);
        jComboBox1.setBounds(170, 50, 150, 40);

        jLabel11.setFont(new java.awt.Font("宋体", 0, 18));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("商品类型");
        jFrame2.getContentPane().add(jLabel11);
        jLabel11.setBounds(50, 40, 100, 60);

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFrame2.getContentPane().add(jFormattedTextField1);
        jFormattedTextField1.setBounds(170, 130, 150, 40);

        jButton6.setText("提交");
        jButton6.setFocusPainted(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jFrame2.getContentPane().add(jButton6);
        jButton6.setBounds(100, 220, 190, 30);

        jFrame3.setBounds(new java.awt.Rectangle(0, 0, 373, 180));
        jFrame3.setLocationByPlatform(true);
        jFrame3.setResizable(false);

        jPanel7.setBackground(new java.awt.Color(50, 50, 50));
        jPanel7.setToolTipText("");
        jPanel7.setMinimumSize(new java.awt.Dimension(373, 180));
        jPanel7.setPreferredSize(new java.awt.Dimension(373, 180));
        jPanel7.setLayout(null);

        jLabel16.setFont(new java.awt.Font("微软雅黑 Light", 0, 18));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("类型：");
        jPanel7.add(jLabel16);
        jLabel16.setBounds(20, 20, 54, 25);

        jRadioButton3.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("新宋体", 0, 14));
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("plain");
        jRadioButton3.setBorder(null);
        jRadioButton3.setFocusPainted(false);
        jPanel7.add(jRadioButton3);
        jRadioButton3.setBounds(90, 10, 70, 40);

        jRadioButton1.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("新宋体", 0, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("警告");
        jRadioButton1.setBorder(null);
        jRadioButton1.setFocusPainted(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButton1);
        jRadioButton1.setBounds(160, 10, 70, 40);

        jRadioButton2.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("新宋体", 0, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("勉励");
        jRadioButton2.setBorder(null);
        jRadioButton2.setFocusPainted(false);
        jPanel7.add(jRadioButton2);
        jRadioButton2.setBounds(230, 10, 70, 40);

        jTextField4.setFont(new java.awt.Font("微软雅黑 Light", 0, 18)); // NOI18N
        jTextField4.setText("写点什么···");
        jTextField4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField4FocusGained(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        jPanel7.add(jTextField4);
        jTextField4.setBounds(20, 60, 320, 50);

        jButton9.setBackground(new java.awt.Color(50, 50, 50));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("确定");
        jButton9.setFocusPainted(false);
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jPanel7.add(jButton9);
        jButton9.setBounds(130, 120, 100, 30);

        jFrame3.getContentPane().add(jPanel7, java.awt.BorderLayout.CENTER);

        jFrame3.getAccessibleContext().setAccessibleParent(jPanel6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("管理员界面");
        setBounds(new java.awt.Rectangle(0, 0, 778, 466));
        setFocusCycleRoot(false);
        setMinimumSize(new java.awt.Dimension(778, 466));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(770, 190));
        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(50, 50, 50));
        jButton1.setFont(new java.awt.Font("微软雅黑 Light", 0, 24));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("库存管理");
        jButton1.setFocusPainted(false);
        jButton1.setOpaque(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(120, 60, 200, 80);

        jButton2.setBackground(new java.awt.Color(50, 50, 50));
        jButton2.setFont(new java.awt.Font("微软雅黑 Light", 0, 24));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("员工管理");
        jButton2.setFocusPainted(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(420, 60, 200, 80);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><u>修改密码</u></html>");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(688, 40, 70, 40);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/session2/home.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton4.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton4.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(0, 0, 70, 70);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("<html><u>注销</u></html>");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(690, 10, 60, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 770, 170);

        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(50, 50, 50));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        jLabel15.setFont(new java.awt.Font("微软雅黑", 1, 24));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("使用须知");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(280, 20, 170, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 770, 270);

        jPanel4.setBackground(new java.awt.Color(50, 50, 50));
        jPanel4.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(50, 50, 50));
        jLabel2.setForeground(new java.awt.Color(250, 250, 250));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html><u>Set Balance Rate</u></html>");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });
        jPanel4.add(jLabel2);
        jLabel2.setBounds(560, 0, 150, 30);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(250, 250, 250));
        jTable1.setFont(new java.awt.Font("宋体", 0, 14));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "商品名", "库存", "进价", "平均进价"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setEnabled(false);
        jTable1.setSelectionBackground(new java.awt.Color(50, 50, 50));
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 520, 270);

        jButton5.setBackground(new java.awt.Color(50, 50, 50));
        jButton5.setFont(new java.awt.Font("微软雅黑 Light", 0, 20)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("进货");
        jButton5.setFocusPainted(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel4.add(jButton5);
        jButton5.setBounds(570, 200, 150, 40);

        jLabel7.setBackground(new java.awt.Color(50, 50, 50));
        jLabel7.setFont(new java.awt.Font("微软雅黑 Light", 0, 14));
        jLabel7.setForeground(new java.awt.Color(250, 250, 250));
        jLabel7.setText("流动资金");
        jLabel7.setText(String.format("%s\t%.2f", "流动资金", Main.mn));
        jPanel4.add(jLabel7);
        jLabel7.setBounds(550, 50, 160, 20);

        jLabel8.setBackground(new java.awt.Color(50, 50, 50));
        jLabel8.setFont(new java.awt.Font("微软雅黑 Light", 0, 14));
        jLabel8.setForeground(new java.awt.Color(250, 250, 250));
        jLabel8.setText("总利润");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(550, 130, 160, 20);

        jLabel9.setBackground(new java.awt.Color(50, 50, 50));
        jLabel9.setFont(new java.awt.Font("微软雅黑 Light", 0, 14));
        jLabel9.setForeground(new java.awt.Color(250, 250, 250));
        jLabel9.setText("总销售额");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(550, 90, 160, 20);

        jLabel17.setBackground(new java.awt.Color(50, 50, 50));
        jLabel17.setFont(new java.awt.Font("微软雅黑 Light", 0, 14));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("利润率");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(550, 170, 170, 20);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 0, 770, 270);

        jPanel5.setBackground(new java.awt.Color(50, 50, 50));
        jPanel5.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel5ComponentShown(evt);
            }
        });
        jPanel5.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(50, 50, 50));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(null);

        jLabel13.setBackground(new java.awt.Color(50, 50, 50));
        jLabel13.setFont(new java.awt.Font("微软雅黑 Light", 0, 16));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("利润额");
        jPanel6.add(jLabel13);
        jLabel13.setBounds(60, 40, 280, 30);

        jLabel14.setBackground(new java.awt.Color(50, 50, 50));
        jLabel14.setFont(new java.awt.Font("微软雅黑 Light", 0, 16));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("销售额");
        jPanel6.add(jLabel14);
        jLabel14.setBounds(60, 130, 280, 30);

        jButton7.setBackground(new java.awt.Color(50, 50, 50));
        jButton7.setFont(new java.awt.Font("微软雅黑 Light", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("开除");
        jButton7.setFocusPainted(false);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jPanel6.add(jButton7);
        jButton7.setBounds(290, 210, 90, 24);

        jButton8.setBackground(new java.awt.Color(50, 50, 50));
        jButton8.setFont(new java.awt.Font("微软雅黑 Light", 0, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("留言");
        jButton8.setFocusPainted(false);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jPanel6.add(jButton8);
        jButton8.setBounds(160, 210, 90, 24);
        jButton8.getAccessibleContext().setAccessibleName("jButton8");
        jButton8.getAccessibleContext().setAccessibleDescription("");

        jPanel5.add(jPanel6);
        jPanel6.setBounds(260, 0, 510, 270);

        jComboBox2.setBackground(new java.awt.Color(50, 50, 50));
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                jComboBox2ComponentRemoved(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox2);
        jComboBox2.setBounds(40, 60, 160, 21);

        jLabel12.setBackground(new java.awt.Color(50, 50, 50));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabel12);
        jLabel12.setBounds(50, 110, 150, 130);

        jButton10.setBackground(new java.awt.Color(50, 50, 50));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("增加员工");
        jButton10.setFocusPainted(false);
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jPanel5.add(jButton10);
        jButton10.setBounds(37, 10, 160, 23);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(0, 0, 770, 270);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 170, 770, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        jPasswordField3.setText(null); jPasswordField2.setText(null); jPasswordField1.setText(null);
        this.jFrame1.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        jLabel2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        double tmp;
        do{
          String str = JOptionPane.showInputDialog(rootPane, "Please input the new balance limit below.(0-100]", "Set Balance", JOptionPane.INFORMATION_MESSAGE);
          tmp = Double.parseDouble(str) / 100;
        }while(tmp <= 0 || tmp > 1);
          Main.lim = tmp; query();  
          JOptionPane.showMessageDialog(rootPane,String.format("%s%.2f","The balance limit now is ", tmp));

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPasswordField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusLost
        // TODO add your handling code here:
        String tmp = String.valueOf(jPasswordField2.getPassword());
        if (! tmp.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,12}")){
            jTextField2.setText("新密码不符合规范！");
        }
        else jTextField2.setText("");
    }//GEN-LAST:event_jPasswordField2FocusLost

    private void jPasswordField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField3FocusLost
        // TODO add your handling code here:
        String t1 = String.valueOf(jPasswordField2.getPassword());
        String t2 = String.valueOf(jPasswordField3.getPassword());
        if (! t1.equals(t2)){
            jTextField3.setText("与前一次输入不符！");
        }
        else jTextField3.setText("");
    }//GEN-LAST:event_jPasswordField3FocusLost

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        String t1 = String.valueOf(jPasswordField2.getPassword());
        String t2 = String.valueOf(jPasswordField3.getPassword());
        String t3 = String.valueOf(jPasswordField1.getPassword());
        boolean b = t1.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,12}");
        if ((! b) || (! t1.equals(t2)) || (! t3.equals(this.pass))){
            JOptionPane.showMessageDialog(rootPane, "INCORRECT!", "WARNING", JOptionPane.WARNING_MESSAGE);
            jPasswordField1.setText(""); jPasswordField2.setText(""); jPasswordField3.setText("");
        }
        else {this.pass = t1; jFrame1.setVisible(false); JOptionPane.showMessageDialog(rootPane, "Successful!\nPlease keep the new password in your mind!");}
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        jPanel3.setVisible(true); jPanel4.setVisible(false); jPanel5.setVisible(false);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        fillTable(jTable1);
        jPanel4.setVisible(true); jPanel3.setVisible(false); jPanel5.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        jPanel5.setVisible(true); jPanel4.setVisible(false); jPanel3.setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Main.pad.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
        jLabel6.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }//GEN-LAST:event_jLabel6MouseEntered

    private void jTable1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentShown
        // TODO add your handling code here:
        fillTable(jTable1);
    }//GEN-LAST:event_jTable1ComponentShown

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        try{
            int tmp =Integer.parseInt(jFormattedTextField1.getText());
            System.out.println(tmp);
            if (stackup(jComboBox1.getSelectedIndex(),tmp)){
               jFrame2.setVisible(false);
               JOptionPane.showMessageDialog(rootPane, "Successful!");
               jFormattedTextField1.setText(null);
               fillTable(jTable1);
            }
        }catch(java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Wrong Input", "ERROR", JOptionPane.ERROR_MESSAGE);
            jFormattedTextField1.setText(null);
        }
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        jFormattedTextField1.setText(null);
        jFrame2.setVisible(true);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jFrame2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jFrame2ComponentShown
        // TODO add your handling code here:
        //jComboBox1.removeAllItems();
         for (int i = 0; i < Main.goods; i++){
             jComboBox1.addItem(Storage.arr[i]);
         }
    }//GEN-LAST:event_jFrame2ComponentShown

    private void jPanel5ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel5ComponentShown
        // TODO add your handling code here:
        fillBox();
    }//GEN-LAST:event_jPanel5ComponentShown

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
        int i = jComboBox2.getSelectedIndex();
        System.out.println(i);
        System.out.println((String)jComboBox2.getItemAt(i));
        if (JOptionPane.showConfirmDialog(rootPane, "Are you sure to lose this one?", "QUERY", JOptionPane.OK_CANCEL_OPTION) == 0){
            jComboBox2.setSelectedIndex((i + 1) % Main.clerk);
            fireMember(i);
        }
    }//GEN-LAST:event_jButton7MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        int i = jComboBox2.getSelectedIndex();
        //System.out.println(Main.sl[i]);
     if (i >= 0){
        jLabel12.setIcon(Main.sl[i].icon);
        jLabel13.setText("利润额 " + Main.sl[i].profit);
        jLabel14.setText("销售额 " + Main.sl[i].sale);
     }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2ComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jComboBox2ComponentRemoved
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox2ComponentRemoved

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
        jTextField4.setText("写点什么···");
        jFrame3.setVisible(true);
    }//GEN-LAST:event_jButton8MouseClicked

    private void jTextField4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusGained
        // TODO add your handling code here:
        jTextField4.setText(null);
    }//GEN-LAST:event_jTextField4FocusGained

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int i = jComboBox2.getSelectedIndex();
        Main.sl[i].setLabel14("<html><u>!You got new Message!</u><html>");
        Main.sl[i].addMessage(jTextField4.getText(), 0);
        jFrame3.setVisible(false);
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
        int i = jComboBox2.getSelectedIndex();
        Main.sl[i].setLabel14("!You got new Message!");

        if (jRadioButton3.isSelected()) Main.sl[i].addMessage(jTextField4.getText(), 0);
        else if (jRadioButton1.isSelected()) Main.sl[i].addMessage(jTextField4.getText(), 1);
        else if (jRadioButton2.isSelected()) Main.sl[i].addMessage(jTextField4.getText(), 2);
        jFrame3.setVisible(false);
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(rootPane, "Are you sure to hire one more member?", "QUERY", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
            String str = JOptionPane.showInputDialog(rootPane, "The account for new member:");
            if (addMember(str)){
                JOptionPane.showMessageDialog(rootPane, "Success!", "HireMember", JOptionPane.INFORMATION_MESSAGE);
                jComboBox2.addItem(str);
            }
        }
        else JOptionPane.showMessageDialog(rootPane, "满员", "WARNING", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButton10MouseClicked

    /**
    * @param args the command line arguments
    */
    public void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Saler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Saler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Saler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Saler.class.getName()).log(Level.SEVERE, null, ex);
                }
                int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 770) / 2;
                int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 448) / 2;
                setLocation(w, h);
                jPanel3.setVisible(true); jPanel4.setVisible(false); jPanel5.setVisible(false);
                setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

}
