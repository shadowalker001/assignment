import java.util.Scanner;
public class Langrange{
    public static void main(String[] args){
        int myxvalue;                           
        int myivalue;
        int val=0;
        int loc=0;
        double pn_handler=0.0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Insert Number of values = ");
        myxvalue = scan.nextInt();
        
        //ARRAY VARIABLE
        double my_array_x[] = new double[myxvalue];
        double my_array_fx[] = new double[myxvalue];

        do
        {
            System.out.print("Input  x"+val+" = ");
            my_array_x[val] = scan.nextDouble();       
            System.out.print("Input  f(x"+val+") = ");
            my_array_fx[val]=scan.nextDouble();
            
            val++;
        }
        while(val<myxvalue);

        System.out.print("Input Default Interpolation Value = ");
        myivalue = scan.nextInt();
        
        //SOLVES PN(X) VALUE
        do
        {                         //FIRST DO WHILE LOOP
            double compute_l=1.0;
            double value = 1.0;
            int finder=0;

            do
            {                      //SECOND DO WHILE LOOP
                if(loc==finder)
                {
                    finder =finder+1; 
                    if(finder!=my_array_x.length)
                    {
                        compute_l *= (myivalue-my_array_x[finder])/(my_array_x[loc]-my_array_x[finder]);
                    }
                }
                else
                {
                    compute_l *= (myivalue-my_array_x[finder])/(my_array_x[loc]-my_array_x[finder]);
                }

            finder +=1;
            }
            while(finder<my_array_x.length);

        value *= compute_l*my_array_fx[loc];     
        pn_handler +=value;

        loc += 1; 
        }
        while(loc<my_array_x.length);

        //SHOWS PN(X)
        System.out.println("The Pn("+myivalue+") = "+pn_handler);   
    }
}
