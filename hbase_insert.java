package projecthadoop;
import java.io.*;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class hbase_insert
{
public static void main(String[] args) throws Exception
{
int count=0;

HBaseConfiguration hbaseConfig = new HBaseConfiguration();

HTable htable = new HTable(hbaseConfig,"SnippetDB");
System.out.println("ok");
htable.setAutoFlush(false);


htable.setWriteBufferSize(1024 * 1024 * 12);
int j;
String file_array[]={"ATHLETICS","FOOTBALL","CRICKET","TENNIS"};

File f;
FileReader fr=null;
BufferedReader br;
for(j=0;j<file_array.length;j++)
{

f=new File("/home/yahoo/Desktop/target/"+file_array[j]+".txt");
fr=new FileReader(f);
br=new BufferedReader(fr);

int totalRecords=15;
System.out.println("importing " + totalRecords + " records ....");

for (int i=0; i < totalRecords; i++)
{
String snippet=br.readLine();
String url=br.readLine();
String date=br.readLine();

Put put = new Put(Bytes.toBytes(i));
put.add(Bytes.toBytes(file_array[j]), Bytes.toBytes("snippet"), Bytes.toBytes(snippet));
htable.put(put);
put.add(Bytes.toBytes(file_array[j]), Bytes.toBytes("url"), Bytes.toBytes(url));
htable.put(put);
put.add(Bytes.toBytes(file_array[j]), Bytes.toBytes("date"), Bytes.toBytes(date));
htable.put(put);
put.add(Bytes.toBytes(file_array[j]), Bytes.toBytes("linkcount"), Bytes.toBytes(1));
htable.put(put);
}
}
fr.close();
htable.flushCommits();
htable.close();
System.out.println("done");
}
}
