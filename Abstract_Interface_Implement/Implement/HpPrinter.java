
package Implement;

import Abstract_class.MyPrinter;
import Interface.Fax_Interface;
import Interface.Scanner_Interface;

public class HpPrinter extends MyPrinter implements Fax_Interface,Scanner_Interface {

    @Override
    public void print() {
        System.out.println("Hp Printing");
    }

    @Override
    public void fax() {
        System.out.println("Hp Faxing");
    }

    @Override
    public void scan() {
        System.out.println("Hp Scanning");
    }
    
    
}
