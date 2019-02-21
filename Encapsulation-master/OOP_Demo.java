
public class OOP_Demo {

    public static void main(String[] args) {
        // TODO code application logic here
        Account ac=new Account();
        ac.setBalance(300.0);
        ac.setAcctId("123");
        
        Customer cus=new Customer();
        cus.setId("44");
        cus.setName("Tomy");
        cus.setAddress("bangkok");
        
        cus.setAccount(ac);
        
        System.out.println("Your acc id : "+cus.getAccount().getaAcctId());
        System.out.println("Your Balance : "+cus.getAccount().getBalance());
        System.out.println("Customer name : "+cus.getName());
        System.out.println("Customer Id : "+cus.getId());
        System.out.println("Customer address : "+cus.getAddress());
        
    }
    
}
class Customer{
    private String Id;
    private String name;
    private String address;
    private Account account;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
}

class Account{
    private String acctId;
    private double balance;
    
    public String getaAcctId(){
        return acctId;
    }
    public double getBalance(){
        return balance;
    }
    public void setAcctId(String acctId){
        this.acctId=acctId;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
   
}
