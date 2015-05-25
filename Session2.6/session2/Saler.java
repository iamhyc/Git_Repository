/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Saler.java
 *
 * Created on 2014-11-27, 22:42:34
 */

package session2;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.io.File;
import java.util.Formatter;
//import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author Mark
 */
public class Saler extends javax.swing.JFrame {

    private  String nm, pass;
    public ImageIcon icon = new ImageIcon();//初始化员工图标
    
    public double sale = 0, profit = 0;
    public static double Tsale = 0, Tprofit = 0;

    Vector listData = new Vector();
    boolean jlabel14 = false;
    /** Creates new form Saler */
     Saler(String nm, String pass){
        this.nm = nm;    this.pass = pass;
        try{
        this.icon = new ImageIcon(getClass().getResource("/session2/head/"+ nm +".png"));}
        catch(NullPointerException e){
            this.icon = new ImageIcon(getClass().getResource("/session2/head/initial.jpg"));
        }
        initComponents();
    }//构造器

    public String getnm(){
      return this.nm;
    }
    public String getpass(){
      return this.pass;
    }
    public ImageIcon getIcon(){
        return this.icon;
    }
    //各种get method

    private boolean setPass(String str){
        if (str.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,12}")) {
            this.pass = str; return true;}
        else return false;
    }
    //各种set method

    public void setLabel14(String tmp){
        jlabel14 = true;
        jLabel14.setText(tmp);
    }
    public void addMessage(String tmp, int type){
        String t1;
        if (type == 1) tmp = "[WARNING]" + tmp;
        else tmp = "[GOOD!]" + tmp;
        listData.add(tmp);
        jList1.setListData(listData);
    }

    private void order (int type, int num, double unit){
        double t1, t2;
        String wname, contact, address;

        t1 = unit - Storage.price[type];//利润
        t2 = unit * num;//总售价

        if ((((t1 / Storage.price[type]) < Main.lim)&&(JOptionPane.showConfirmDialog(null, "Low Profit! Sure to make this order?", "WARNING!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == 0)) || ((t1 / Storage.price[type]) >= Main.lim)) //利润过低
            {
                Main.mn += t2;
                this.sale += t2; Tsale += this.sale;
                Storage.piece[type] -= num; 
                this.profit += t1 * num; Tprofit += this.profit;
                fillTable(jTable1);
                jFrame2.setVisible(false);
                JOptionPane.showMessageDialog(rootPane, "Successful!");
            }//set to show (订单信息)
    }//下单

    private void fillTable(javax.swing.JTable tb){
        //DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();
        for (int i = 0; i < Main.goods; i++){
            tb.getModel().setValueAt(Storage.arr[i], i, 0);
            tb.getModel().setValueAt(String.format("%d", Storage.piece[i]), i, 1);
            tb.getModel().setValueAt(String.format("%.2f",Storage.price[i]), i, 2);
            //tb.getModel().setValueAt(showType(i), i, 3);
        }
        tb.invalidate();    query();
    }

    private void query(){
        //set to show cap.mn;//流动资金总额
            //set to show query tab
            jLabel7.setText("流动资金 " + Main.mn);
            jLabel8.setText("销售额 " + this.sale);
            jLabel9.setText("利润额 " + this.profit);
    }//show 流动资金余额，总销售额，总利润
    
    private void setLabel13(){
        int i = jComboBox1.getSelectedIndex();
        try{
            int j = Integer.parseInt(jFormattedTextField1.getText());
            double k = Double.parseDouble(jFormattedTextField2.getText());
            double t = k-Storage.price[i];

            jLabel13.setText(String.format("总售价%.2f\t  利润%.2f  ", j*k, t * j));

            if (k != 0)
              jLabel20.setText(String.format("(利润率 %.2f%%)", (t/Storage.price[i])*100));
            String tmp ="";
            if ((k - Storage.price[i] < Main.lim)) tmp = "Low Profit !";
            jTextArea1.setText(String.format("\n\n\t商品类型\t%s \n\n\n\t数量\t%d \n\n\n\t售价\t%.2f\n\t\t%s", Storage.arr[i], j, j*k, tmp));
        }
        catch(java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "Wrong Input!", "ERROR", JOptionPane.ERROR_MESSAGE);
            jFormattedTextField1.setText("0");    jFormattedTextField2.setText("0");
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
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jFrame2 = new javax.swing.JFrame();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jFrame3 = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jFrame4 = new javax.swing.JFrame();
        jLabel19 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jFrame1.setTitle("Set Password");
        jFrame1.setBounds(new java.awt.Rectangle(0, 0, 300, 360));
        jFrame1.setLocationByPlatform(true);
        jFrame1.setMinimumSize(new java.awt.Dimension(300, 360));
        jFrame1.setResizable(false);
        jFrame1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jFrame1WindowClosed(evt);
            }
        });
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

        jTextField2.setEditable(false);
        jTextField2.setForeground(new java.awt.Color(255, 0, 0));
        jTextField2.setText("新密码必须包含大小写字母和数字，6-12位");
        jTextField2.setAutoscrolls(false);
        jTextField2.setBorder(null);
        jTextField2.setFocusable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(jTextField2);
        jTextField2.setBounds(22, 30, 240, 15);

        jTextField3.setEditable(false);
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setAutoscrolls(false);
        jTextField3.setBorder(null);
        jTextField3.setFocusable(false);
        jFrame1.getContentPane().add(jTextField3);
        jTextField3.setBounds(102, 170, 130, 15);

        jTextField4.setEditable(false);
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(null);
        jFrame1.getContentPane().add(jTextField4);
        jTextField4.setBounds(100, 230, 130, 15);

        jFrame2.setTitle("下单");
        jFrame2.setBounds(new java.awt.Rectangle(0, 0, 370, 480));
        jFrame2.setLocationByPlatform(true);
        jFrame2.setMinimumSize(new java.awt.Dimension(370, 480));
        jFrame2.setResizable(false);
        jFrame2.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jFrame2WindowClosed(evt);
            }
        });
        jFrame2.getContentPane().setLayout(null);

        jButton2.setText("Submit");
        jButton2.setAutoscrolls(true);
        jButton2.setFocusPainted(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jFrame2.getContentPane().add(jButton2);
        jButton2.setBounds(110, 410, 130, 30);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("客户姓名");
        jFrame2.getContentPane().add(jLabel15);
        jLabel15.setBounds(50, 210, 70, 30);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("客户电话");
        jFrame2.getContentPane().add(jLabel16);
        jLabel16.setBounds(50, 270, 70, 30);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("客户地址");
        jFrame2.getContentPane().add(jLabel17);
        jLabel17.setBounds(50, 340, 70, 30);

        jTextField5.setAutoscrolls(false);
        jFrame2.getContentPane().add(jTextField5);
        jTextField5.setBounds(150, 210, 110, 30);

        jTextField6.setAutoscrolls(false);
        jFrame2.getContentPane().add(jTextField6);
        jTextField6.setBounds(150, 270, 130, 30);
        jFrame2.getContentPane().add(jTextField7);
        jTextField7.setBounds(150, 340, 200, 30);

        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("微软雅黑", 1, 14));
        jTextArea1.setRows(3);
        jTextArea1.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextArea1);

        jFrame2.getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(-4, -4, 380, 200);

        jFrame2.getAccessibleContext().setAccessibleDescription("");

        jFrame3.setTitle("Message Box");
        jFrame3.setBounds(new java.awt.Rectangle(0, 0, 258, 130));
        jFrame3.setLocationByPlatform(true);
        jFrame3.setMinimumSize(new java.awt.Dimension(258, 130));
        jFrame3.setResizable(false);

        jList1.setFont(new java.awt.Font("新宋体", 0, 16));
        jScrollPane3.setViewportView(jList1);

        jFrame3.getContentPane().add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jFrame3.getAccessibleContext().setAccessibleParent(jPanel4);

        jFrame4.setAlwaysOnTop(true);
        jFrame4.setLocationByPlatform(true);
        jFrame4.setMinimumSize(new java.awt.Dimension(139, 235));
        jFrame4.setResizable(false);
        jFrame4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jFrame4ComponentShown(evt);
            }
        });

        jLabel19.setPreferredSize(new java.awt.Dimension(100, 100));

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton4.setText("更改");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jFrame4Layout = new javax.swing.GroupLayout(jFrame4.getContentPane());
        jFrame4.getContentPane().setLayout(jFrame4Layout);
        jFrame4Layout.setHorizontalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame4Layout.createSequentialGroup()
                .addGroup(jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFrame4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFrame4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jFrame4Layout.setVerticalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jFrame4.getAccessibleContext().setAccessibleParent(jPanel4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("销售人员界面");
        setBounds(new java.awt.Rectangle(0, 0, 786, 478));
        setMinimumSize(new java.awt.Dimension(786, 478));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel4ComponentShown(evt);
            }
        });
        jPanel4.setLayout(null);

        jTable1.setAutoCreateRowSorter(true);
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
                {null, null, null},
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
                "商品名", "库存", "进价"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setEnabled(false);
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 490, 270);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Calculator"));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(null);

        jButton1.setText("下单");
        jButton1.setFocusPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(80, 240, 140, 23);

        jLabel10.setFont(new java.awt.Font("宋体", 0, 18));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("数量");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 90, 100, 40);

        jComboBox1.setFont(new java.awt.Font("宋体", 0, 16));
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox1FocusGained(evt);
            }
        });
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(130, 20, 120, 40);

        jLabel11.setFont(new java.awt.Font("宋体", 0, 18));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("商品类型");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 20, 100, 40);

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField1.setText("0");
        jFormattedTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField1FocusLost(evt);
            }
        });
        jPanel2.add(jFormattedTextField1);
        jFormattedTextField1.setBounds(130, 90, 120, 30);

        jLabel12.setFont(new java.awt.Font("宋体", 0, 18));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("售价");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(10, 150, 100, 40);

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField2.setText("0.00");
        jFormattedTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField2FocusLost(evt);
            }
        });
        jPanel2.add(jFormattedTextField2);
        jFormattedTextField2.setBounds(130, 150, 120, 30);

        jLabel13.setText("总售价  利润");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(20, 190, 230, 30);

        jLabel20.setText("利润率");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(20, 220, 230, 15);

        jPanel4.add(jPanel2);
        jPanel2.setBounds(490, 0, 280, 270);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 170, 770, 270);

        jPanel1.setLayout(null);

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
        jLabel1.setBounds(642, 20, 90, 20);

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
        jLabel6.setBounds(650, 80, 80, 20);

        jLabel7.setText("流动资金");
        jLabel7.setText(String.format("%s\t%.2f", "流动资金", Main.mn));
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 120, 160, 20);

        jLabel9.setText("总销售额");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(200, 120, 160, 20);

        jLabel8.setText("总利润");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(410, 120, 160, 20);

        jLabel2.setIcon(this.icon);
        jLabel2.setMaximumSize(new java.awt.Dimension(100, 100));
        jLabel2.setMinimumSize(new java.awt.Dimension(100, 100));
        jLabel2.setName(""); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(530, 20, 80, 80);

        jTextField1.setBackground(new java.awt.Color(240, 240, 240));
        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("微软雅黑", 0, 22));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("生命不息，售货不止");
        jTextField1.setAutoscrolls(false);
        jTextField1.setFocusable(false);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(22, 20, 440, 80);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("<html><u>Message Box</u></html>");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14);
        jLabel14.setBounds(600, 130, 160, 30);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("<html><u>更改头像</u></html>");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
        });
        jPanel1.add(jLabel18);
        jLabel18.setBounds(650, 50, 80, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 770, 170);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        jPasswordField3.setText(null); jPasswordField2.setText(null); jPasswordField1.setText(null);
        this.jFrame1.setVisible(true);
}//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setCursor(new Cursor(Cursor.HAND_CURSOR));
}//GEN-LAST:event_jLabel1MouseEntered

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

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jPasswordField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusLost
        // TODO add your handling code here:
        String tmp = String.valueOf(jPasswordField2.getPassword());
        if (! tmp.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,12}")){
            jTextField3.setText("新密码不符合规范！");
        } else jTextField3.setText("");
}//GEN-LAST:event_jPasswordField2FocusLost

    private void jPasswordField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField3FocusLost
        // TODO add your handling code here:
        String t1 = String.valueOf(jPasswordField2.getPassword());
        String t2 = String.valueOf(jPasswordField3.getPassword());
        if (! t1.equals(t2)){
            jTextField4.setText("与前一次输入不符！");
        } else jTextField4.setText("");
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
        } else {this.pass = t1; jFrame1.setVisible(false); JOptionPane.showMessageDialog(rootPane, "Successful!\nPlease keep the new password in your mind!");}
}//GEN-LAST:event_jButton3MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField2ActionPerformed

    private void jPanel4ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel4ComponentShown
        // TODO add your handling code here:
        //jComboBox1.removeAllItems();
        for (int i = 0; i < Main.goods; i++){
             jComboBox1.addItem(Storage.arr[i]);
         }
    }//GEN-LAST:event_jPanel4ComponentShown

    private void jComboBox1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusGained
        // TODO add your handling code here:
        jComboBox1.removeAllItems();
        for (int i = 0; i < Main.goods; i++){
             jComboBox1.addItem(Storage.arr[i]);
        }
        setLabel13();
    }//GEN-LAST:event_jComboBox1FocusGained

    private void jFormattedTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField1FocusGained
        // TODO add your handling code here:
        setLabel13();
    }//GEN-LAST:event_jFormattedTextField1FocusGained

    private void jFormattedTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField1FocusLost
        // TODO add your handling code here:
        setLabel13();
    }//GEN-LAST:event_jFormattedTextField1FocusLost

    private void jFormattedTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField2FocusGained
        // TODO add your handling code here:
        setLabel13();
    }//GEN-LAST:event_jFormattedTextField2FocusGained

    private void jFormattedTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField2FocusLost
        // TODO add your handling code here:
        setLabel13();
    }//GEN-LAST:event_jFormattedTextField2FocusLost

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        setLabel13();
        jTextField7.setText(null); jTextField6.setText(null); jTextField5.setText(null);
        jFrame2.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
        setLabel13();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        int i = jComboBox1.getSelectedIndex();
        try{
            int j = Integer.parseInt(jFormattedTextField1.getText());
            double k = Double.parseDouble(jFormattedTextField2.getText());
        if ((j <= 0) || (k <= 0) || (Storage.piece[i] < j)) JOptionPane.showMessageDialog(rootPane, "Not Allowed.", "KIDDING ME", JOptionPane.ERROR_MESSAGE);
            else order(i,j,k);
        }
        catch(java.lang.NumberFormatException e){}
    }//GEN-LAST:event_jButton2MouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        fillTable(jTable1);
    }//GEN-LAST:event_formComponentShown

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        jFrame3.setVisible(true);
        if (jlabel14) {
            jlabel14 = false; jLabel14.setText("<html><u>Message Box</u></html>");
        }
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        // TODO add your handling code here:
        jLabel18.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        jFrame4.setVisible(true);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        int i = jComboBox2.getSelectedIndex();
        jLabel19.setIcon(new ImageIcon(getClass().getResource("/session2/head/"+ String.format("%s%02d", "10", i + 1) +".png")));
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jFrame4ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jFrame4ComponentShown
        // TODO add your handling code here:
        if (jComboBox2.getItemAt(0) == null)
        for (int i = 0; i < 18; i++){
        String tmp = String.format("%s%02d", "10", i + 1);
        jComboBox2.addItem(tmp);
        }
    }//GEN-LAST:event_jFrame4ComponentShown

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        this.icon = (ImageIcon) jLabel19.getIcon();
        jLabel2.setIcon(this.icon);
        jFrame4.setVisible(false);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jFrame2WindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jFrame2WindowClosed
        // TODO add your handling code here:
        jTextField5.setText(null); jTextField6.setText(null); jTextField7.setText(null);
    }//GEN-LAST:event_jFrame2WindowClosed

    private void jFrame1WindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jFrame1WindowClosed
        // TODO add your handling code here:
        jFrame1.dispose();
    }//GEN-LAST:event_jFrame1WindowClosed

    @Override
    public String toString(){
        return this.nm;
    }
    /**
    * @param args the command line arguments
    */
    public void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 786) / 2;
                int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 478) / 2;
                setLocation(w, h);
                setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JFrame jFrame4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    protected javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    protected javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

}
