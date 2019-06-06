import java.util.Scanner;
public class Langrange{
    public static void main(String[] args){
        //varialbles initializations
        int points=0;                           
        int inter_value;
        double pnx=0.0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Interpolation Number of Points:: ");
        points = scan.nextInt();
        
        System.out.print("Enter Default Interpolation Value:: ");
        inter_value = scan.nextInt();

        //{array variables}
        double x_value[] = new double[points];
        double f_x_value[] = new double[points];

        for(int val=0; val<points; val++)
        {
            System.out.print("Enter Value x"+val+":: ");
            x_value[val] = scan.nextDouble();       
            System.out.print("Enter Value f(x"+val+"):: ");
            f_x_value[val]=scan.nextDouble();                  
        }
        
        //solves for the value of pnx
        for(int counter=0; counter<x_value.length; counter++)
        {
            double l_value=1.0;
            double value = 1.0;

            for(int explore=0; explore<x_value.length; explore++)
            {
                if(counter==explore)
                {
                    explore =explore+1; 
                    if(explore!=x_value.length)
                    {
                        l_value =l_value*(inter_value-x_value[explore])/(x_value[counter]-x_value[explore]);
                    }
                }
                else
                {
                    l_value =l_value*(inter_value-x_value[explore])/(x_value[counter]-x_value[explore]);
                }
            }

        value =value*l_value*f_x_value[counter];
        //shows each Ln(x)f(xn)
        System.out.println("The L"+counter+"(x)f(x"+counter+") = "+value);      
        pnx=pnx+value;
        }
        //shows pn(x)
        System.out.println("The Value Of Pn("+inter_value+") = "+pnx);     
    }
}
