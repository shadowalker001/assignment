import java.util.Scanner;   //IMPORTS JAVA PACKAGE (SCANNER) THAT WILL TAKE CHARGE OF OUR INPUTS
public class Index{
    public static void main(String[] args){
        //INITIALIZING OUR VARIABLES HERE
        boolean go=false;
        int num=0; 
        int default_value;
        int index=0;
        int count=0; 
        double pn_x=0.0;
        Scanner input = new Scanner(System.in);

        while(go==false){
            System.out.print("Enter Number Of Interpolations:  ");
            num = input.nextInt();
            if(num>=1){     //VALIDATING FOR POSITIVE INTEGERS
                go=true;
            }
        }
        
        System.out.print("Enter Default Interpolation Value: ");
        default_value = input.nextInt();

        //SETTING OUR ARRAY VARIABLES HERE
        double x[] = new double[num];
        double f_x[] = new double[num];

        //USING WHILE CONDITIONAL LOOP TO ACCEPT ALL OUR INPUTS DEPENDIONG ON THE NO OF INTERPOLATIONS SET
        while(index<num){
            System.out.print("Enter x"+index+": ");
            x[index] = input.nextDouble();                  //USING ARRAY X TO COLLECT ALL X VALUES
            System.out.print("Enter f(x"+index+"): ");
            f_x[index]=input.nextDouble();                  //USING ARRAY F_X TO COLLECT ALL F(X) VALUES
        index++;
        }
        
        //LOOPING FROM L0... TO n NUMBER OF TERMS, SOLVING THEIR VALUES, AND COMPUTING THIER SUM AS WELL
        while(count<x.length){
            int inner_count1=0;
            double l=1.0;
            double value = 1.0;

            //LOOPING THROUGH EACH Ln(x)f(xn) AND COMPUTING THIER VALUES
            while(inner_count1<x.length){
                if(count==inner_count1){
                    inner_count1 +=1; 
                    if(inner_count1!=x.length){
                        l *= (default_value-x[inner_count1])/(x[count]-x[inner_count1]);
                    }
                }else{
                    l *= (default_value-x[inner_count1])/(x[count]-x[inner_count1]);
                }
            inner_count1++;
            }

        value *= l*f_x[count];
        System.out.println("L"+count+"(x)f(x"+count+") = "+value);      //DISPLAYING EACH VALUE OF Ln(x)f(xn)
        pn_x += value;
        count++;
        }
        System.out.println("The Final Value Of Pn("+default_value+") = "+pn_x);     //DISPLAYS THE FINAL VALUE OF pn(x)
    }
}
