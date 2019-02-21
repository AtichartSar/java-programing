/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author Ozero
 */
public class Enum {
    public static void main(String[] args) {
        Month m=Month.APRIL;
        System.out.println(m.getIndex()+" "+m.getThai()+" "+m.name());
        System.out.println(m.toString());
        
        switch(m){
            case JANUARY: System.out.println("case มกราคม");break;
            case FEBUARY: System.out.println("case กุมภาพันธ์");break;
            case APRIL: System.out.println("case เมษายน");break;
            default:break;
        }
        
    }
    
}
enum Month{
    JANUARY("JANUARY","มกราคม",0),
    FEBUARY("FEBUARY","กุมภาพันธ์",1),
    MARCH("MARCH","มีนาคม",2),
    APRIL("APRIL","เมษายน",3),
    MAY("MAY","พฤษภาคม",4),
    JUNE("JUNE","มิถุนายน",5),
    JULY("JULY","กรกฎาคม",6),
    AUGUST("AUGUST","สิงหาคม",7),
    SEPTEMBER("SEPTEMBER","กันยายน",8),
    OCTOBER("OCTOBER","ตุลาคม",9),
    NOVEMBER("NOVEMBER","พฤษจิกายน",10),
    DECEMBER("DECEMBER","ธันวาคม",11);
    private String eng;
    private String thai;
    private int index;
    private Month(String eng,String thai,int index){
        this.eng=eng;
        this.thai=thai;
        this.index=index;
    }

    public String getEng() {
        return eng;
    }

    public String getThai() {
        return thai;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Month{" + "eng=" + eng + ", thai=" + thai + ", index=" + index + '}';
    }
    
    
}
