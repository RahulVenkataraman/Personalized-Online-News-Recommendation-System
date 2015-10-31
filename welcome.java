package projecthadoop;
import java.awt.event.ActionEvent;


public class welcome extends javax.swing.JFrame
{
    public welcome() {
       initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("successfully Registered..........");

        jButton1.setText("LOGIN PAGE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);

            }

        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(123, 123, 123))
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jButton1)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(jButton1)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        loginform_withupdate object=new loginform_withupdate();
        this.setVisible(false);
        object.setVisible(true);
    }

    public static void main(String args[])
    {

        java.awt.EventQueue.invokeLater(new Runnable()
        {

            public void run()
            {
              welcome we=new welcome();
              we.setVisible(true);
            }

        });
    }
   private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;

}
