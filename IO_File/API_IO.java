package IO;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class API_IO {
    public static void main(String[] args) throws IOException {
        String filepath="D:/Mydata/Customer.txt";
        FileReader fr=new FileReader(filepath);
        BufferedReader br=new BufferedReader(fr);
        List<Customer> custs=new ArrayList<>();
        
        String Read=null;
        //วนลูปอ่านค่าจากไฟล
        while ((Read=br.readLine())!=null) {            
            String[]data=Read.split(",");
            Customer cust=new Customer(Integer.parseInt(data[0]), data[1], data[2]);
            custs.add(cust);
        }
        br.close();
        fr.close();
        for (Customer cust : custs) {
            System.out.print(cust.getId()+" ");
            System.out.print(cust.getName()+" ");
            System.out.println(cust.getAddress());
        }
        
    }
}




class Customer implements Serializable{
    int id;
    String name;
    String address;

    public Customer() {
    }
    
    public Customer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
