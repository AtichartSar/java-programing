
package Test;

public class Static_Class {
    public static void main(String [] src)
    {
        MyStudent []s=new MyStudent[3];
        s[0]=new MyStudent("1", "bo1", "bo1@gmail.com");
        s[1]=new MyStudent("2", "bo2", "bo2@gmail.com");
        s[2]=new MyStudent("3", "bo3", "bo3@gmail.com");
        
        for (MyStudent myStudent : s) {
            System.out.print(myStudent.getId()+" ");
            System.out.print(myStudent.getName()+" ");
            System.out.print(myStudent.getEmail()+" ");
            System.out.println("");
        }
        
        //สามารถเรียกเมทอดโดยไม่ต้องสร้าง อินสแตนก่อน
        MyStudent.getStudentDetail();
    
    }
    
}
class MyStudent{
    private String id;
    private String name;
    private String email;
    //static int counter เป็นของคราส Mystudent ถ้ามีการสร้างคราส ตัว static จะเป็นตัวเดียวกันทั้งหมด
    // เป็นการแชที่งคราส
    static int counter=0;
    
    public static void getStudentDetail(){
        System.out.println("Counter Student "+counter);
    }
    public MyStudent(){
        counter++;
    }
    public MyStudent(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        counter++;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }   
}

