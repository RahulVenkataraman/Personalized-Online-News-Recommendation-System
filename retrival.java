package projecthadoop;
import java.nio.ByteBuffer;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
public final class retrival
{

retrival(String user, String password) throws Exception
{
         function(user,password);
}

public void function(String temp1,String temp2) throws Exception
{

String username=temp1;
String password=temp2;
float max=0;
int maxindex=0;
int flag=0;
float priority[]=new float[4];
String sports[]={"ATHLETICS","CRICKET","FOOTBALL","TENNIS"};

float athletics = 0,cricket=0,football=0,tennis=0;

byte[] temp=new byte[8];
int dindex=0;

HTable htable = new HTable(HBaseConfiguration.create(), "UserDB");
htable.setAutoFlush(false);
htable.setWriteBufferSize(1024 * 1024 * 12);
Scan s = new Scan();
s.addFamily(Bytes.toBytes("details"));

String display[]=new String[4];
display[0]=null;
display[1]=null;
display[2]=null;
display[3]=null;

ResultScanner scanner=htable.getScanner(s);

for(Result result=scanner.next();(result!=null);result=scanner.next())
{

String h_username=new String(result.getValue(Bytes.toBytes("details"),Bytes.toBytes("username")));
String h_password=new String(result.getValue(Bytes.toBytes("details"),Bytes.toBytes("password")));


if(username.equals(h_username) && password.equals(h_password))
{
//System.out.println("username:"+h_username);
//System.out.println("password:"+h_password);
flag=1;

temp=(result.getValue(Bytes.toBytes("details"), Bytes.toBytes("athletics")));
ByteBuffer buffer1=ByteBuffer.wrap(temp);
athletics=buffer1.getFloat();
System.out.println("athletics   :"+athletics);
priority[0]=athletics;

temp=(result.getValue(Bytes.toBytes("details"), Bytes.toBytes("cricket")));
ByteBuffer buffer2=ByteBuffer.wrap(temp);
cricket=buffer2.getFloat();
priority[1]=cricket;
System.out.println("cricket   :"+cricket);

temp=(result.getValue(Bytes.toBytes("details"), Bytes.toBytes("football")));
ByteBuffer buffer3=ByteBuffer.wrap(temp);
football=buffer3.getFloat();
priority[2]=football;
System.out.println("football   :"+football);

temp=(result.getValue(Bytes.toBytes("details"), Bytes.toBytes("tennis")));
ByteBuffer buffer4=ByteBuffer.wrap(temp);
tennis=buffer4.getFloat();
priority[3]=tennis;
System.out.println("tennis     :"+tennis);


//System.out.println("athletics is :" + athletics+" cricket is :"+cricket+" football is :"+football+" tennis is :"+tennis);
break;
}
}
scanner.close();
htable.flushCommits();
htable.close();


for(int j=0;j<4;j++)
{
    max=0;
    maxindex=0;

    for(int i=0;i<4;i++)
    {
     if(priority[i]>=max)
       {
         max = priority[i];
         maxindex=i;
       }
    }
       {
      priority[maxindex]=-1;
      display[dindex]=sports[maxindex];
      dindex++;
      }
    
    }


//System.out.println("program  done");
//System.out.println("DISPLAY"+display[0]+"    "+display[1]+"      "+display[2]+"           "+display[3]+"  ");
if(flag==1)
{
    System.out.println("login");
search_1 s_1=new search_1(display,username,password);
System.out.println("out");
    }
}

}
