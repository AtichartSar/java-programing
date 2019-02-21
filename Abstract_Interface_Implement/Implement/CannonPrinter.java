
package Implement;
import Interface.Fax_Interface;
import Abstract_class.MyPrinter;

public class CannonPrinter extends MyPrinter implements Fax_Interface {

    @Override
    public void print() {
        System.out.println("Cannon printing");
    }

    @Override
    public void fax() {
        System.out.println("Cannon faxing");
    }
    
}
