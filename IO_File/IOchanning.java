package IO;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


//อาศัยหลักการต่อท่อจาก io ถึง File
//https://www.tutorialspoint.com/java/java_files_io.htm
//เป็นการอ่านและเขียนแบบ binary
public class IOchanning {
    public static void main(String[] args) throws IOException {
      WRFile.writeFile();
      WRFile.readFile();
        
        
    }
    
}
 class  WRFile{
     public static void writeFile()throws IOException{
          String filename="data.txt";
        //สร้างท่อ 
        FileOutputStream FO=new FileOutputStream(filename);
        BufferedOutputStream BOUT=new BufferedOutputStream(FO);
        DataOutputStream Dout=new DataOutputStream(BOUT);
        
        Dout.writeUTF("hello world");
        Dout.writeInt(2);
        Dout.writeDouble(120);
        
        Dout.close();
        BOUT.close();
        FO.close();
        System.out.println("File Done");
     } 
     public static void readFile() throws IOException{
         String filename="data.txt";
         FileInputStream Fi=new FileInputStream(filename);
         BufferedInputStream BF=new BufferedInputStream(Fi);
         DataInputStream Din=new DataInputStream(BF);
         String d1=Din.readUTF();
         int d2=Din.readInt();
         Double d3=Din.readDouble();
         
         System.out.println(d1+" "+d2+" "+d3);
         Din.close();
         BF.close();
         Fi.close();
     }
}

