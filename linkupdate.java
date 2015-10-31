package projecthadoop;
import java.nio.ByteBuffer;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;



public class linkupdate
{

linkupdate(String snippet,String sport) throws Exception
{
function(snippet,sport);
}
public static void function(String arg1,String arg2) throws Exception
{
System.out.println("IN LINK UPDATE");
String snippet=null;
String link=null;

String h_snippet=arg1;
String sport_name=arg2;

HTable hhtable = new HTable(HBaseConfiguration.create(), "SnippetDB");
hhtable.setAutoFlush(false);
hhtable.setWriteBufferSize(1024 * 1024 * 12);
Scan ss = new Scan();
ResultScanner sscanner=hhtable.getScanner(ss);
ss.addFamily(Bytes.toBytes(sport_name));
Result result=null;
Put put=null;



System.out.println("SPORT NAME   :"+sport_name);

int b;

for(result=sscanner.next();(result!=null);result=sscanner.next())
{
snippet=new String(result.getValue(Bytes.toBytes(sport_name),Bytes.toBytes("snippet")));
byte[] linkcount=(result.getValue(Bytes.toBytes(sport_name),Bytes.toBytes("linkcount")));

if(snippet.equals(h_snippet))
{

put = new Put((result.getRow()));
ByteBuffer buffer1=ByteBuffer.wrap(linkcount);

b=buffer1.getInt();
System.out.println("BEFORE VALUE   :"+b);
put.add(Bytes.toBytes(sport_name), Bytes.toBytes("linkcount"), Bytes.toBytes(b+1));
hhtable.put(put);

}
}

System.out.println("done");

sscanner.close();
hhtable.flushCommits();
hhtable.close();

System.out.println("OUT FROM LINK UPDATE");
}
}
