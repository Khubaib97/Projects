/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rational;
import java.util.Scanner;
class Rationall implements Comparable<Rationall>{
    private long numerator;
    private long denominator;
    public Rationall(){}
    public Rationall(long numerator, long denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public long getNumerator(){
        return numerator;
    }
    public long getDenominator(){
        return denominator;
    }
    public Rationall add(Rationall secondrational){
        long resultnum = (this.numerator*secondrational.getDenominator())+(secondrational.getNumerator()*this.denominator);
        long resultden = this.denominator*secondrational.getDenominator();
        long gcd = gcd(resultnum, resultden);
        if(gcd > 1){
            resultnum = resultnum / gcd;
            resultden = resultden / gcd;
        }
        return (new Rationall(resultnum, resultden));
    }
    public Rationall subtract(Rationall secondrational){
        long resultnum = (this.numerator*secondrational.getDenominator())-(secondrational.getNumerator()*this.denominator);
        long resultden = this.denominator*secondrational.getDenominator();
        long gcd = gcd(resultnum, resultden);
        if(gcd > 1){
            resultnum = resultnum / gcd;
            resultden = resultden / gcd;
        }
        return (new Rationall(resultnum, resultden));
    }
    public Rationall multiply(Rationall secondrational){
        long resultnum = this.numerator*secondrational.getNumerator();
        long resultden = this.denominator*secondrational.getDenominator();
        long gcd = gcd(resultnum, resultden);
        if(gcd > 1){
            resultnum = resultnum / gcd;
            resultden = resultden / gcd;
        }
        return (new Rationall(resultnum, resultden));
    }
    public Rationall divide(Rationall secondrational){
        long resultnum = this.numerator*secondrational.getDenominator();
        long resultden = this.denominator*secondrational.getNumerator();
        long gcd = gcd(resultnum, resultden);
        if(gcd > 1){
            resultnum = resultnum / gcd;
            resultden = resultden / gcd;
        }
        return (new Rationall(resultnum, resultden));
    }
    public String toString(){
        if(denominator==1){
            return numerator+"";
        }
        return numerator+"/"+denominator;
    }
    private long gcd(long n, long d){
        if (d==0){
            return n;
        }
        return gcd(d,n%d);
    }
    public int compareTo(Rationall secondrational){
        long num1 = this.numerator/this.denominator;
        long num2 = secondrational.getNumerator()/secondrational.getDenominator();
        if(num1>num2){
            return 1;
        }
        else if(num1==num2){
            return 0;
        }
        else{
            return -1;
        }
    }
}
/**
 *
 * @author Khubaib
 */
public class RATIONAL {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter first numerator: ");
        long num1 = inp.nextLong();
        System.out.println("Enter first denominator: ");
        long den1 = inp.nextLong();
        System.out.println("Enter second numerator: ");
        long num2 = inp.nextLong();
        System.out.println("Enter second denominator: ");
        long den2 = inp.nextLong();
        Rationall rat1 = new Rationall(num1, den1);
        Rationall rat2 = new Rationall(num2, den2);
    }
    
}
