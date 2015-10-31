package projecthadoop;
import java.nio.ByteBuffer;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class logout
{
    logout(String user,String pass) throws Exception
    {
        function(user,pass);
    }
public static void function(String temp1,String temp2) throws Exception
{

String username=temp1;//should pass from login
String password=temp2;


String snippet=null;
String link=null;


String display[]={"FOOTBALL","TENNIS","ATHLETICS","CRICKET"};
String display1[]={"football","tennis","athletics","cricket"};



HTable hhtable = new HTable(HBaseConfiguration.create(), "SnippetDB");
hhtable.setAutoFlush(false);
hhtable.setWriteBufferSize(1024 * 1024 * 12);
Scan ss = new Scan();
ResultScanner sscanner = null;
Result rresult=null;
byte []rowkey=null;
Put put=null;

for(int k=0;k<4;k++)
{
rresult=null;
ss.addFamily(Bytes.toBytes(display[k]));
sscanner=hhtable.getScanner(ss);
System.out.println("The Array:"+display[k]);
int b=0;
float count=0,snippetcount=0;
byte[] linkcount;

for(rresult=sscanner.next();(rresult!=null);rresult=sscanner.next())
{
linkcount=(rresult.getValue(Bytes.toBytes(display[k]),Bytes.toBytes("linkcount")));
ByteBuffer buffer1=ByteBuffer.wrap(linkcount);
b=buffer1.getInt();
count=count+b;
snippetcount++;
}


System.out.println("link count "+count);
System.out.println("snippet count "+snippetcount);

float newlinkcount=count/snippetcount;
System.out.println("new link count "+newlinkcount);


HTable htable = new HTable(HBaseConfiguration.create(), "UserDB");
htable.setAutoFlush(false);
htable.setWriteBufferSize(1024 * 1024 * 12);
Scan s = new Scan();
s.addFamily(Bytes.toBytes("details"));

ResultScanner scanner=htable.getScanner(s);


byte[] athletics;
byte[] cricket;
byte[] football;
byte[] tennis;
float originalvalue,uathletics,ucricket,ufootball,utennis,uratio;
ByteBuffer buffer1;
float array[]=new float[4];
for(Result result=scanner.next();(result!=null);result=scanner.next())
{
String str=new String(result.getValue(Bytes.toBytes("details"),Bytes.toBytes("username")));
String str1=new String(result.getValue(Bytes.toBytes("details"),Bytes.toBytes("password")));
if(username.equals(str) && password.equals(str1))
{
football=result.getValue(Bytes.toBytes("details"),Bytes.toBytes("football"));
buffer1=ByteBuffer.wrap(football);
array[0]=buffer1.getFloat();

tennis=result.getValue(Bytes.toBytes("details"),Bytes.toBytes("tennis"));
buffer1=ByteBuffer.wrap(tennis);
array[1]=buffer1.getFloat();

athletics=result.getValue(Bytes.toBytes("details"),Bytes.toBytes("athletics"));
buffer1=ByteBuffer.wrap(athletics);
array[2]=buffer1.getFloat();

cricket=result.getValue(Bytes.toBytes("details"),Bytes.toBytes("cricket"));
buffer1=ByteBuffer.wrap(cricket);
array[3]=buffer1.getFloat();

System.out.println("befroe  "+display[k]+" "+array[0]);
uratio=0;
for(int indx=0;indx<4;indx++)
{
if(indx==k)
{
array[indx]*=newlinkcount;
uratio+=array[indx];
}
else
{
uratio+=array[indx];
}
}
for(int indx=0;indx<4;indx++)
array[indx]=array[indx]/uratio;
System.out.println("after  "+display[k]+" "+array[0]);
put = new Put((result.getRow()));
put.add(Bytes.toBytes("details"), Bytes.toBytes("football"), Bytes.toBytes(array[0]));
htable.put(put);
put.add(Bytes.toBytes("details"), Bytes.toBytes("tennis"), Bytes.toBytes(array[1]));
htable.put(put);
put.add(Bytes.toBytes("details"), Bytes.toBytes("athletics"), Bytes.toBytes(array[2]));
htable.put(put);

put.add(Bytes.toBytes("details"), Bytes.toBytes("cricket"), Bytes.toBytes(array[3]));
htable.put(put);
break;
}
}
htable.flushCommits();
htable.close();
scanner.close();
}
sscanner.close();
hhtable.flushCommits();
hhtable.close();

    //code for reset link count
    {
    {





HBaseConfiguration hbaseConfig = new HBaseConfiguration();
HTable hhhtable = new HTable(hbaseConfig, "SnippetDB");
hhhtable.setAutoFlush(false);
hhhtable.setWriteBufferSize(1024 * 1024 * 12);
String file_array[]={"ATHLETICS","FOOTBALL","CRICKET","TENNIS"};


for(int j=0;j<file_array.length;j++)
{

int totalRecords=15;
System.out.println("importing " + totalRecords + " records ....");
for (int i=0; i <totalRecords ; i++)
{
Put put1 = new Put(Bytes.toBytes(i));
put1.add(Bytes.toBytes(file_array[j]), Bytes.toBytes("linkcount"), Bytes.toBytes(1));
hhhtable.put(put1);
}
}
hhhtable.flushCommits();
hhhtable.close();

    }

    }

System.out.println("done");
}
}
