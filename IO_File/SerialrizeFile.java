package IO;
//writeFile แบบ object

import IO.Customer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class SerialrizeFile {
    public static void main(String[] args) throws IOException, ClassNotFoundException  {
        read();
        
        
    }
    public static void read() throws IOException, ClassNotFoundException {
        FileInputStream fin=new FileInputStream("D:/cu.txt");
        ObjectInputStream oin=new ObjectInputStream(fin);
        List<Customer> custs=new ArrayList<>();
        custs=(List<Customer>) oin.readObject();
        oin.close();
        fin.close();
        for (Customer cust : custs) {
            System.out.print(cust.getId()+" ");
            System.out.print(cust.getName()+" ");
            System.out.println(cust.getAddress());
        }
    }
    public static void write() throws IOException {
        List<Customer> cust=new ArrayList();
        cust.add(new Customer(1, "k1", "k1@gmail.com"));
        cust.add(new Customer(2, "k2", "k2@gmail.com"));
        cust.add(new Customer(3, "k2", "k3@gmail.com"));
        FileOutputStream fout=new FileOutputStream("D:/cu.txt");
        ObjectOutputStream oout=new ObjectOutputStream(fout);
        oout.writeObject(cust);
        
        oout.close();
        fout.close();  
    }
}
