/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomialexp;

/**
 *
 * @author Khubaib
 */
public class PolynomialExp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Polynomial p = new Polynomial();
        p.Insert(3, 2);
        p.Insert(4, 1);
        p.Insert(10, 0);
        p.display();
        Polynomial q = new Polynomial();
        q.Insert(4, 3);
        q.Insert(2, 2);
        q.Insert(-2, 1);
        q.Insert(4, 0);
        q.display();
        Polynomial r = new Polynomial();
        r.add(p, q);
        r.display();
    }
    
}
