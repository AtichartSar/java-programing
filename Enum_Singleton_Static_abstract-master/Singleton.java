package Test;



/*
ทำให้ออบเจคมีตัวเดียวเพื่อควบคุมให้ง่าย
ทุกคนใช้ออบเจคที่เดียวกัน
*/

public class Singleton {
    public static void main(String[] args) {
       HouseSingleton hc=HouseSingleton.getHouseSingleton();
        House h1= hc.createHourse("aa", "red");
        House h2= hc.createHourse("as", "rea");
        House h3= hc.createHourse("ad", "res");
        System.out.println(h1.getAddress());
    }
    
}
class HouseSingleton{
    private static HouseSingleton instance = new HouseSingleton();
    private HouseSingleton(){}//ปิดช่องทางการสร้าง ออบเจค จากนอกคราส
    public static HouseSingleton getHouseSingleton(){
        return instance;
    }
    public House createHourse(String address,String color){
        return new House(address, color);
    }
}

class House{
    private String address;
    private String color;
    House(){
        
    }

    public House(String address, String color) {
        this.address = address;
        this.color = color;
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
