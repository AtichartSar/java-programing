
package demo;

public class Demo {
    public static void main(String[] args) {
        
        Employee[]emps=new Employee[3];
         emps[0]=new Manager( "Manager","123", "Tony", 100000, "13-04-62");
         emps[1] =new Engineer("Engineer", "124", "jim", 100000, "13-02-63");
        emps[2] =new Engineer("Engineer", "125", "Cary", 150000, "11-03-63");
         for (Employee emp : emps) {
             System.out.println(emp.getDetail());
        }
       
    }
}



//************************************class Engineer(Sub_class)********************
class Engineer extends Employee{
     private String  faculty;

    public Engineer() {
    }
    public Engineer(String faculty, String id, String name, double salary, String birthday) {
        super(id, name, salary, birthday);
        this.faculty = faculty;
    }

    @Override
    public String getDetail() {
        return super.getDetail()+" - "+getFaculty(); //To change body of generated methods, choose Tools | Templates.
    }
    public String getFaculty() {
        return faculty;
    }
    
     
}
//************************************class Manage(Sub_class)********************
class Manager extends Employee{
    private String departMent;
    public Manager() {
    }
    public Manager(String departMent,String id, String name, double salary, String birthday) {
        super(id, name, salary, birthday);
        this.departMent = departMent;
    }   
    @Override 
    public String getDetail() {
        return super.getDetail()+" - "+getDepartMent(); //To change body of generated methods, choose Tools | Templates.
    }
    public String getDepartMent() {
        return departMent;
    }
}
//****************************************class super********************
class Employee{
    private String id;
    private String name;
    private double salary;
    private String birthday;

    public Employee() {
    }
    

    public Employee(String id, String name, double salary, String birthday) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }
    
    public String getDetail(){
        return id+" : "+name+" ("+birthday+") ";
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
}


