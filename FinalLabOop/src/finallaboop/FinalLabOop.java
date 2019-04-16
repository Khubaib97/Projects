/*c
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finallaboop;
class Ticket{
    private double price;
    private int daysEarly;
    private String promotionCode = "";
    public Ticket(double price, int daysEarly){
        this.price = price;
        this.daysEarly = daysEarly;
    }
    public int getDaysEarly(){
        return daysEarly;
    }
    public double getPrice(){
        return price;
    }
    public String getPromotionCode(){
        return promotionCode;
    }
    public void setPromotionCode(String code)throws NullPromoCodeException{
        if(code==null){
            throw new NullPromoCodeException();
        }
        this.promotionCode = code;
    }
    public String toString(){
        if(getPromotionCode().equals("")){
            return ("Price: "+getPrice()+"$\nTicket was booked "+getDaysEarly()+" days before the event.\nNo Promo Code used.");
        }
        return ("Price: "+getPrice()+"$\nTicket was booked "+getDaysEarly()+" days before the event.\nPromo Code used: "+getPromotionCode());
    }
}
class StudentTicket extends Ticket implements Comparable<StudentTicket>{
    private boolean honors;
    public StudentTicket(double price, boolean honors){
        super(price, 14);
        this.honors = honors;
    }
    public boolean isHonorStudent(){
        return honors;
    }
    @Override
    public void setPromotionCode(String code) throws NullPromoCodeException{
        if(code==null){
            throw new NullPromoCodeException();
        }
        super.setPromotionCode(code+" (student)");
    }
    @Override
    public double getPrice(){
        double discounted = super.getPrice();
        discounted = discounted/2;
        if(honors==true){
            discounted = discounted - 5;
            if(discounted<0){
                discounted = 0;
            }
        }
        return discounted;
    }
    @Override
    public int compareTo(StudentTicket ticket) {
        if(getPrice() == ticket.getPrice()){
            if(getPromotionCode().equals("") || ticket.getPromotionCode().equals("")){
                System.out.println("Cannot compare since one or more of the codes are empty");
                return 420;
            }
            if(getPromotionCode().charAt(0) < ticket.getPromotionCode().charAt(0)){
                return -1;
            }
            else if(getPromotionCode().charAt(0) == ticket.getPromotionCode().charAt(0)){
                return 0;
            }
            else{
                return 1;
            }
        }
        if(getPrice() < ticket.getPrice()){
            return -1;
        }
        if(getPrice() > ticket.getPrice()){
            return 1;
        }
        return 420;
    }
}
class NullPromoCodeException extends Exception{
    NullPromoCodeException(){
        System.out.println("No promo code entered.");
    }
}
/**
 *
 * @author Khubaib
 */
public class FinalLabOop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws NullPromoCodeException {
        try{
            Ticket t1 = new Ticket(8.5, 2);
            Ticket t2 = new Ticket(6.5, 1);
            t2.setPromotionCode("ghareeb needs a discount bro");
            StudentTicket st1 = new StudentTicket(5, false);
            StudentTicket st2 = new StudentTicket(7, false);
            st2.setPromotionCode("KEXP call-in winner");
            StudentTicket st3 = new StudentTicket(4, true);
            StudentTicket st4 = new StudentTicket(3, false);
            StudentTicket st5 = new StudentTicket(12, true);
            System.out.println(t1.toString());
            System.out.println(t2.toString());
            System.out.print(st1.isHonorStudent()+" ");
            System.out.println(st1.toString());
            System.out.println(st2.toString());
            System.out.print(st3.getPrice()+" ");
            System.out.println(st3.toString());
            System.out.println(st4.getPrice());
            System.out.println(st5.getPrice());
            System.out.println(st4.compareTo(st5));
            System.out.println(st4.compareTo(st4));
            System.out.println(st2.compareTo(st2));
            st5.setPromotionCode(null);
        }
        catch(NullPromoCodeException ex){
            System.out.println(ex);
        }
    }
    
}
