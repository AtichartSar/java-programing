package Thread_java;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_Java extends Thread{

    public Thread_Java(String name) {
        if(name==null||name.trim().equals("")){
           name="unset"; 
        }
        super.setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            
                System.out.println("Hello "+(i+1)+getName());
                //sleep ทำให้ thread แบ่งการทำงานเป็นช่วงๆชัดเจน
            try {    
                sleep(1500);
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
}
