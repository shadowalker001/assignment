import java.util.Scanner;
public class Bisection1{
    public static void main(String arg[]){
        double a,b,x,fx,e;
        int n=1;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter initial value a: ");
        a=input.nextDouble();

        System.out.print("Enter initial value b: ");
        b=input.nextDouble();

        System.out.print("Enter prescribed error limit e: ");
        e=input.nextDouble();

        do{
            x=(a+b)/2;
            fx=(x*x*x)+x-3;
            if(fx<0)
                a=x;
            if(fx>0)
                b=x;
            n=n+1;
        }while((Math.abs(b-a)>=e)&&(fx!=0));
        System.out.println("The root with desired error = "+x);

        System.out.println("The number of approximations is = "+n);
    }
}