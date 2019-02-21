
import Abstract_class.MyPrinter;
import Implement.CannonPrinter;
import Implement.EpsonPrinter;
import Implement.HpPrinter;
import Interface.Fax_Interface;
import Interface.Scanner_Interface;


public class testPrinter {
    public static void main(String[] args) {
        //ใช้ได้แค่เมทอดของ MyPrinter
        MyPrinter hp=new HpPrinter();
        hp.print();
        //ใช้ได้แค่ทุกเมทอดของ HpPrinter
        HpPrinter hpm=(HpPrinter)hp;
        hpm.print();
        hpm.scan();
        hpm.fax();
        
        
        
        
        MyPrinter epson =new EpsonPrinter();
        epson.print();
        
        Scanner_Interface sc=new HpPrinter();
        sc.scan();
        
        Fax_Interface ca=new CannonPrinter();
        ca.fax();
        
        
    }
}
