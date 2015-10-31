
package projecthadoop;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;
import java.net.URI.*;
import javax.swing.*;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public final class search_3 extends JFrame
 {


public search_3(final String[] display,final String username_3,final String password_3) throws Exception
{
     this.setVisible(false);

     String sport_name=display[2];

    URI[] uri=new URI[20];
    JButton[] buttons=new JButton[20];
    JPanel p1=new JPanel();

 
    final JFrame frame = new JFrame("Links");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700, 700);
    frame.setVisible(true);

    p1.setLayout(new GridLayout(5,20,10,5));

     Container container = frame.getContentPane();
     container.setLayout(new GridBagLayout());



    String snippet=null;
    String link=null;
    String date=null;

    int i=0;

    HTable htable = new HTable(HBaseConfiguration.create(), "SnippetDB");
    htable.setAutoFlush(false);
    htable.setWriteBufferSize(1024 * 1024 * 12);
    Scan s = new Scan();
    s.addFamily(Bytes.toBytes(sport_name));
    ResultScanner scanner=htable.getScanner(s);




    for(    org.apache.hadoop.hbase.client.Result  result=scanner.next();(result!=null) && i<buttons.length;result=scanner.next())
{

        link=new String(result.getValue(Bytes.toBytes(sport_name),Bytes.toBytes("url")));
        snippet=new String(result.getValue(Bytes.toBytes(sport_name),Bytes.toBytes("snippet")));

        uri[i]=new URI(link);
        buttons[i]= new JButton();
        buttons[i].setText("<HTML>"+snippet  +"<FONT color=\"#000099\"><U>Click</U></FONT></HTML>");
        buttons[i].addActionListener((ActionListener) new OpenUrlAction(snippet,i,uri[i],sport_name));
        p1.add(buttons[i]);
        i++;
}

JButton back_3=new JButton("<<BACK");
      p1.add(back_3);
    container.add(p1);
    back_3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
    {
            frame.setVisible(false);
            try
            {
            search_2 s2 = new search_2(display,username_3,password_3);
            }
            catch (Exception ex)
            {
            }
    }});
    JButton next_3=new JButton("NEXT>>");
    next_3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
    {
            frame.setVisible(false);
            try
            {
            search_4 s4 = new search_4(display,username_3,password_3);
            }
            catch (Exception ex)
            {
            }
    }});
    p1.add(next_3);
    container.add(p1);


}


private static class OpenUrlAction extends JFrame implements ActionListener
{

 private  String snippet;
 int i;
 private URI uri;
 String s_name;


 public OpenUrlAction(String temp1,int temp2,URI temp3,String temp4) throws FileNotFoundException, IOException
 {
 snippet=temp1;
 i=temp2;
 uri=temp3;
 s_name=temp4;
 }

 public void actionPerformed(ActionEvent e)
{
try
{
    open(uri);
    linkupdate obj=new linkupdate(snippet,s_name);
   

}
catch (Exception ex)
{
}
}
        public void open(URI ur) throws Exception
        {
            Desktop desktop=Desktop.getDesktop();
            desktop.browse(ur);
        }

    }


}

