
package edu.cornellcollege.matrix;
/**
 * 
 * @author Erlang
 * @version 1 April 2020
 */
public class matrix {

    private double [][] elements = new double[2][2];
    
    public matrix() {
        this.elements[0][0] = 1.0;
        this.elements[0][1] = 0.0; 
        this.elements[1][0] = 0.0;
        this.elements[1][1] = 1.0;
        
    }
    
    public matrix(double m00,double m01,double m10,double m11){
        this.elements[0][0] = m00;
        this.elements[0][1] = m01; 
        this.elements[1][0] = m10;
        this.elements[1][1] = m11;
    }
    public matrix multiply( matrix otherMatrix){
        double left00 = this.elements[0][0];
        double left01 = this.elements[0][1];
        double left10 = this.elements[1][0];
        double left11 = this.elements[1][1];
        
        double right00 = otherMatrix.elements[0][0];
        double right01 = otherMatrix.elements[0][1];
        double right10 = otherMatrix.elements[1][0];
        double right11 = otherMatrix.elements[1][1];
        
        double product00 = left00 * right00 + left01 * right10;
        double product01 = left00 * right01 + left01 * right11;
        double product10 = left10 * right00 + left11 * right10;
        double product11 = left10 * right01 + left11 * right11;
        
        return new matrix (product00,product01,product10,product11);
        
        
    }
    
    public String toString(){
        double m00 = this.elements[0][0];
        double m01 = this.elements[0][1];
        double m10 = this.elements[1][0];
        double m11 = this.elements[1][1];
        
        String row0 = "(" + m00 + "," + m01 +")";
        String row1 = "(" + m10 + "," + m11 +")";
        
        return "(" + row0 + "," + row1 + ")";
    }
    public void rotation (double angle){
        this.elements[0][0] = Math.cos(angle);
        this.elements[0][1] = -Math.sin(angle); 
        this.elements[1][0] = Math.sin(angle);
        this.elements[1][1] = Math.cos(angle);
    }
    
    public double get (int row, int column){
        return this.elements[row][column];
    }//get (int,int)
    public static void main(String[] args) {
       matrix identity = new matrix();
       System.out.println("identity =" + identity);
       matrix product = identity.multiply(identity);
       System.out.println("identity =" + identity);
       
       matrix ccw = new matrix ();
       ccw.rotation(Math.PI/4);
       
       matrix cw = new matrix ();
       cw.rotation(-Math.PI/4);
       
       matrix netrotation = ccw.multiply(cw);
       System.out.println ("net rotation =" +netrotation );
       
    }
    
}
