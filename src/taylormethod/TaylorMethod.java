package taylormethod;

import java.util.ArrayList;

/**
 *
 * date : 16.08.17 
 * name : syed ashraf ullah
 * email : syedashrafullah15@gmail
 * web: lazycoder.6te.net
 * problem : numerical analysis solve taylor method
 * 
 * y = (x-y)/2;
 * fourth order derivation
 * [0,3] interval
 * y(0) = 1
 */
public class TaylorMethod {
    /*
    here
        yOne = y`
        yTwo = y``
        yThree = y```
        yFour = y^iv
    
    */
    private static float yOne,yTwo,yThree,yFour;
    private static float limit;//maximum iteration limit
    private static float h;
    private static int counter = 0;
    private static ArrayList<Double> derivationOne = new ArrayList<>();
    private static ArrayList<Double> derivationTwo = new ArrayList<>();
    
    private static ArrayList<Double> errorOne = new ArrayList<>();
    private static ArrayList<Double> errorTwo = new ArrayList<>();
    
    
    
    public static void main(String[] args) {
        sop("---------- Taylor method solution --------");
        h = (float)0.25;//step size
        limit = 3;//maximum limit
        funcationOfInterpolation(0,1);//recursive iteration function       
        
        
        sop("\t ************ When Step size h  = 1/2 ************");
        double x = 0.0;//temporary variable
        for(int i =0; i< derivationOne.size(); i++){
             sop("\t Iteration : "+(i+1));
             sop("Value of x = "+(x+=0.5)+"  value of y = "+derivationOne.get(i)+"\nError = "+errorOne.get(i)+"\n");    
        }
        
        sop("\t ************ When Step size h  = 1/4 *********** ");
        x = 0.0;
        for(int i =0; i< derivationTwo.size(); i++){
             sop("\t Iteration : "+(i+1));
             sop("Value of x = "+(x+=0.25)+"  value of y = "+derivationTwo.get(i)+"\nError = "+errorTwo.get(i)+"\n");    
        }
        
        
    }
    
    /*
    recursive function calculate interpolation
    */
    public static int funcationOfInterpolation(float x,float y){
        if(x == limit) return 0;
        float presentX = x+h;
        updateDeriviteYValue(x, y);
        float presentY = derivationOfY(y);
        float error = error(presentY);
        
        if(x%.5==0){
            derivationOne.add((double)y);
            errorOne.add((double)error);
        }else{
            derivationTwo.add((double)y);
            errorTwo.add((double)error);
        }
       
        return funcationOfInterpolation(presentX,presentY);
        
    }
    
    //fourth order taylor method calculation
    public static float derivationOfY(float y){
        return (float)(y+(h*yOne)+((Math.pow(h, 2)*yTwo)/factorial(2))+((Math.pow(h, 3)*yThree)/factorial(3))+((Math.pow(h, 4)*yFour)/factorial(4)));
    }
    
    //derivaiton of y calculation
    public static void updateDeriviteYValue(float x,float y){
        yOne = (float)0.5*(x-y);
        yTwo = (float)0.5*(1-yOne);
        yThree = (float)0.5*(-yTwo);
        yFour = (float)0.5*(-yThree);
    }
    
    
    //calculate factorial by recursive function
    public static int factorial(int n){
        if(n == 1) return 1;
        return n*factorial(n-1);
    }
    
    //calculating error percent
    public static float error(float y){
        float error = (float)(((1-y)/y)*100);
        
        if(error < 0) return error*-1;
        else return error;
    }
    
    //custom print message method
    public static void sop(String message){
        System.out.println(message);
    }
    
}