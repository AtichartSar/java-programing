
package Implement;

import Abstract_class.MyPrinter;
import Interface.Scanner_Interface;
public class EpsonPrinter extends MyPrinter implements Scanner_Interface{

    @Override
    public void print() {
        System.out.println("Epson printing");
    }

    @Override
    public void scan() {
        System.out.println("Epson scanning");
    }
    
}
