package projecthadoop;
import java.io.*;

class extraction
{
public void main() throws Exception
    {

    int index=0,sports_array=0;
    int i1=0,j1=0,i2=0,j2=0,i3=0,j3=0;
    int count=0,c=0;

    String input=null,result=null;

    String search1[]={"ATHLETICS\">","CRICKET\">","FOOTBALL\">","HOCKEY\">","MOTORSPORT\">","RACES\">","TENNIS\">"};

    String search2="</a>"
            + "",search3="<a href",search4="e\"",search5="title=\"Updated: ",search6=" at";

    String sports[]={"ATHLETICS","CRICKET","FOOTBALL","HOCKEY","MOTORSPORT","RACES","TENNIS"};

    sports_array=sports.length;

    for(index=0;index<sports_array;index++)
        {

      File source_file=new File("/home/yahoo/Desktop/source/"+sports[index]+".txt");
      File target_file=new File("/home/yahoo/Desktop/target/"+sports[index]+".txt");
      FileReader file_reader=new FileReader(source_file);
      FileWriter file_writer=new FileWriter(target_file);
     BufferedReader buffer_reader=new BufferedReader(file_reader);

       while((input=buffer_reader.readLine())!=null)
       {

        i1=0;j1=0;

        while(c<15)
        {
        i1=input.indexOf(search1[index],j1);
        j1=input.indexOf(search2,i1);
        result=input.substring((i1+(search1[index].length())),j1);
        file_writer.write(result+"\n");


        i2=input.indexOf(search3,j1);
        j2=input.indexOf(search4,i2);
        result=input.substring((i2+9),j2) ;
         file_writer.write(result+"e"+"\n");

        i3=input.indexOf(search5,j2);
        j3=input.indexOf(search6,i3);
        result=input.substring((i3+16),j3) ;
        file_writer.write(result+"\n");


         c++;
        }
        c=0;
}
        file_reader.close();
        file_writer.close();

}
      System.out.println("*****Extraction Completed*****");
}
}