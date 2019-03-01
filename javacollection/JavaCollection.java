
package javacollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaCollection {

    public static void main(String[] args) {
        //แบบ list ข้อมูลจะเรียงลำดับ 
        List<Customer> cu=new ArrayList();
        cu.add(new Customer("1", "n1"));
        cu.add(new Customer("2", "n2"));
        cu.add(new Customer("3", "n3"));
        System.out.println("*****List************");
        for (Customer customer : cu) {
            System.out.print(customer.getId()+" " );
            System.out.println(customer.getName());
            
        }
        //แบบ Set ข้อมูลจะไม่เรียงลำดับและถูกเก็บแบบเป็นกลุ่มก้อน เวลาเรียก ข้อมูลจะเรียงไม่ถูกลำดับ
        
        System.out.println("");
        System.out.println("*****Set************");
        Set<Customer> cus=new HashSet<>();
        cus.add(new Customer("1", "n1"));
        cus.add(new Customer("2", "n2"));
        cus.add(new Customer("3", "n3"));
        for (Customer cu1 : cus) {
            System.out.print(cu1.getId()+" ");
            System.out.println(cu1.getName());
            
        }
        //แบบ Map ข้อมูลจะมีพารามิเตอคีย และเรียงลำดับกันเหมือน List และอ้างอิงจาก คีย
        System.out.println("");
        System.out.println("*****Map************");
        Map<String,Customer> cum=new HashMap();
        cum.put("1",new Customer("1", "n1"));
        cum.put("2",new Customer("2", "n2"));
        cum.put("3",new Customer("3", "n3"));
        cum.put("4",new Customer("4", "n4"));
        cum.put("5",new Customer("4", "n4"));
        cum.put("6",new Customer("4", "n4"));
        for (String key : cum.keySet()) {
            System.out.print(key+" Key  ");
            //อินสแตนอ้างอิงคีย
            Customer c= cum.get(key);
            System.out.print(c.getId());
            System.out.println(c.getName());
        }
        System.out.println("*****Map************");
        Collection<Customer> CusList=(Collection<Customer>)cum.values();
        for (Customer c : CusList) {
            System.out.print(c.getId()+" ");
            System.out.println(c.getName());
        }
        
    }
    
}

class Customer{
    private String id;
    private String name;

    public Customer() {
    }

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
