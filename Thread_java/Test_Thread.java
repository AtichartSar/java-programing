
package Thread_java;

public class Test_Thread {
    public static void main(String[] args) {
        Thread_Java t1=new Thread_Java("you");
        Thread_Java t2=new Thread_Java("za");
        Thread_Java t3=new Thread_Java("Oda");
        
        
        t1.start();
        t2.start();
        t3.start();

/*****Runnable******/
        MyRunnable r=new MyRunnable();
        Thread t4=new Thread(r);
        Thread t5=new Thread(r);
        Thread t7=new Thread(r);
        t4.start();
        t5.start();
        t7.start();
    }
}
