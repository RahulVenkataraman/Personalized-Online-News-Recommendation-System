package projecthadoop;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
public class signupform extends javax.swing.JFrame
{
public signupform()
{
        initComponents();
}
private void initComponents()
{

jRadioButton1 = new javax.swing.JRadioButton();
welcome_label = new javax.swing.JLabel();
username = new javax.swing.JTextField();
password = new javax.swing.JPasswordField();
repeatpassword = new javax.swing.JPasswordField();
jLabel1 = new javax.swing.JLabel();
jLabel2 = new javax.swing.JLabel();
jLabel3 = new javax.swing.JLabel();
sumbit = new javax.swing.JButton();
football = new javax.swing.JCheckBox();
cricket = new javax.swing.JCheckBox();
hockey = new javax.swing.JCheckBox();
tennis = new javax.swing.JCheckBox();
jLabel4 = new javax.swing.JLabel();

jRadioButton1.setText("jRadioButton1");
setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 welcome_label.setText("      SIGNUP");
jLabel1.setText("User Name  :");
jLabel2.setText("Pass Word  :");
jLabel3.setText("Repeat Pass Word  :");
sumbit.setText("SUBMIT");
sumbit.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
try {
sumbitActionPerformed(evt);
}
catch (IOException ex)
{
Logger.getLogger(signupform.class.getName()).log(Level.SEVERE, null, ex);
}
}
});
football.setText("FootBall");
cricket.setText("Cricket");
hockey.setText("Athletics");
 tennis.setText("Tennis");
jLabel4.setText("Favourite");
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(82, 82, 82)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jLabel3)
.addGroup(layout.createSequentialGroup()
.addGap(34, 34, 34)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jLabel2)
.addComponent(jLabel1))))
.addComponent(jLabel4))
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
.addGap(18, 18, 18)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
.addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(repeatpassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
.addComponent(football, javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(cricket, javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(hockey, javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(tennis, javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(sumbit, javax.swing.GroupLayout.Alignment.LEADING)))
.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
.addGap(20, 20, 20)
.addComponent(username))))
.addGroup(layout.createSequentialGroup()
.addGap(179, 179, 179)
.addComponent(welcome_label, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
.addContainerGap(121, Short.MAX_VALUE))
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(19, 19, 19)
.addComponent(welcome_label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(30, 30, 30)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel1)
.addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel2))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel3)
.addComponent(repeatpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(football)
.addComponent(jLabel4))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(cricket)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(hockey)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(tennis)
.addGap(18, 18, 18)
.addComponent(sumbit)
.addGap(13, 13, 13))
);
pack();
}
private void sumbitActionPerformed(java.awt.event.ActionEvent evt) throws IOException
{
boolean isfootballselected = false,iscricketselected=false,isathleticsselected=false,istennisselected=false;

String sinupusername=username.getText();
String sinuppassword=password.getText();

//System.out.println(sinuppassword);
isfootballselected=football.isSelected();
istennisselected=tennis.isSelected();
iscricketselected=cricket.isSelected();
isathleticsselected=hockey.isSelected();
float count=0;
if(isfootballselected)
count++;
if(istennisselected)
count++;
if(iscricketselected)
count++;
if(isathleticsselected)
count++;
float priority=(1/count);
priority=priority+1;
float z=1;

HBaseConfiguration hbaseConfig = new HBaseConfiguration();
HTable htable = new HTable(hbaseConfig, "UserDB");
htable.setAutoFlush(false);
htable.setWriteBufferSize(1024 * 1024 * 12);
byte [] rowkey =Bytes.toBytes(sinupusername);
Put put = new Put(rowkey);

put.add(Bytes.toBytes("details"), Bytes.toBytes("username"), Bytes.toBytes(sinupusername)); htable.put(put);
put.add(Bytes.toBytes("details"), Bytes.toBytes("password"), Bytes.toBytes(sinuppassword)); htable.put(put);

if(isathleticsselected)
        {
           put.add(Bytes.toBytes("details"), Bytes.toBytes("athletics"), Bytes.toBytes(priority)); htable.put(put);
        }
else
        {
            put.add(Bytes.toBytes("details"), Bytes.toBytes("athletics"), Bytes.toBytes(z)); htable.put(put);
        }
if(iscricketselected)
         {
        put.add(Bytes.toBytes("details"), Bytes.toBytes("cricket"), Bytes.toBytes(priority)); htable.put(put);
         }
else
         {
            put.add(Bytes.toBytes("details"), Bytes.toBytes("cricket"), Bytes.toBytes(z)); htable.put(put);
        }

if(isfootballselected)
        {
        put.add(Bytes.toBytes("details"), Bytes.toBytes("football"), Bytes.toBytes(priority)); htable.put(put);
        }
else
        {
            put.add(Bytes.toBytes("details"), Bytes.toBytes("football"), Bytes.toBytes(z)); htable.put(put);
        }
if(istennisselected)
        {
        put.add(Bytes.toBytes("details"), Bytes.toBytes("tennis"), Bytes.toBytes(priority)); htable.put(put);
        }
else
        {
            put.add(Bytes.toBytes("details"), Bytes.toBytes("tennis"), Bytes.toBytes(z)); htable.put(put);
        }


htable.flushCommits();
htable.close();


//System.out.println("done");

welcome we=new welcome();

we.setVisible(true);

this.setVisible(false);
    }

public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signupform().setVisible(true);
            }
        });
    }
    private javax.swing.JCheckBox cricket;
    private javax.swing.JCheckBox football;
    private javax.swing.JCheckBox hockey;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField repeatpassword;
    private javax.swing.JButton sumbit;
    private javax.swing.JCheckBox tennis;
    private javax.swing.JTextField username;
    private javax.swing.JLabel welcome_label;

}
