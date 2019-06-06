/*
*Newton Raphson  method
*/
/* @author Omeken */
import java.util.Scanner;

public class Raphson{
    /*
    *@param args the command line arguments
    */

    public static void main(String[] args){
        double x, xnew, fx, e, tol, fprime, diff;
        int n=1;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter initial value x: ");
        x = input.nextDouble();

        System.out.print("Enter initial value epslon: ");
        e = input.nextDouble();

        System.out.print("Enter initial value of tol: ");
        tol = input.nextDouble();

        do{
            fx = (x*x)-(2*x)-3;
            fprime=2*x-2;
            xnew = x-fx/fprime;
            diff = x-xnew;
            x=xnew;
            n=n+1;
        }while((Math.abs(fprime)>e)&&(Math.abs(diff)>(tol*Math.abs(xnew))));
        System.out.println("The root with desired error = "+x);

        System.out.println("The number of approximation is "+n);

    } 

}