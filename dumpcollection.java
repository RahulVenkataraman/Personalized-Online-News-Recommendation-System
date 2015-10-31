package projecthadoop;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
public class dumpcollection
{
dumpcollection() throws Exception
{
JOptionPane.showMessageDialog(null,"Updation Started...","UPDATE  INFORMATON",JOptionPane.INFORMATION_MESSAGE);
//function();
extraction e=new extraction();
e.main();
System.out.println("success");
//hbase_insert insert = new hbase_insert();
JOptionPane.showMessageDialog(null,"Updation Finished...","UPDATE  INFORMATON",JOptionPane.INFORMATION_MESSAGE);
}
 public static void function() throws Exception
 {
 int i=0;
 System.out.println("IN COLLECTION");
 String sports[]={"ATHLETICS","CRICKET","FOOTBALL","HOCKEY","MOTORSPORT","RACES","TENNIS"};
  int j=sports.length;

  for(i=0;i<j;i++)
  {
  String filename=sports[i];
  String endpointURL = "http://www.thehindu.com/sport/"+filename+"/";
  ArrayList storeWordList = new ArrayList();
  URLConnection uc = new URL(endpointURL).openConnection();
  HttpURLConnection connection = (HttpURLConnection) uc;
  FileWriter ff=new FileWriter("/home/yahoo/Desktop/source/"+filename+".txt");

  connection.setDoOutput(true);
  connection.setRequestMethod("GET");
  connection.connect();

  String line;

  InputStream inputStream = null;
 try
 {
 inputStream = connection.getInputStream();
 }
catch (IOException e)
{
inputStream = connection.getErrorStream();
}

  BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
 while ((line = rd.readLine()) != null)
 {
 ff.write(line);
 storeWordList.add(line);
 }

 ff.close();

 Writer output = null;

 File file = new File("/home/yahoo/Desktop/source/"+filename+".txt");
 output = new BufferedWriter(new FileWriter(file));
 for (Iterator iter = storeWordList.iterator(); iter.hasNext();)
 {
 output.write((String) iter.next());
 }

 output.close();
 
 }

 }
 }

