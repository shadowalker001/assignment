#INITIALIZING OUR VARIABLES HERE
go=False    #BOOLEAN INITIALIZATION TO HANDLE +INTEGERS INPUTS
x=[]        #ARRAY VARIABLE
f_x=[]      #ARRAY VARIABLE
index=0     
count=0     
pn_x=0.0    #FLOAT VARIABLE

while go==False:
    num = int(input("Enter Number Of Interpolations: "))
    if num>=1:
        go=True

default_value = float(input("Enter Default Interpolation Value: "))
    
#USING WHILE CONDITIONAL LOOP TO ACCEPT ALL OUR INPUTS DEPENDIONG ON THE NO OF INTERPOLATIONS SET
while index < num:
    x.append(float(input("Enter x"+str(index)+" : ")))          #USING ARRAY X TO COLLECT ALL X VALUES
    f_x.append(float(input("Enter f(x"+str(index)+") : ")))     #USING ARRAY F_X TO COLLECT ALL F(X) VALUES
    index +=1

while count < len(x):   #LOOPING FROM L0... TO n NUMBER OF TERMS, SOLVING THEIR VALUES, AND COMPUTING THIER SUM AS WELL
    i_count=0
    l=1
    value=1
    while i_count < len(x):     #LOOPING THROUGH EACH Ln(x)f(xn) AND COMPUTING THIER VALUES
        if count==i_count:
            i_count+=1
            if i_count != len(x):
                l *= (default_value-x[i_count])/(x[count]-x[i_count])
        else:
            l *= (default_value-x[i_count])/(x[count]-x[i_count])
        i_count+=1

    value *= l*f_x[count]
    print("L"+str(count)+"(x)f(x"+str(count)+") : "+str(value))     #DISPLAYING EACH VALUE OF Ln(x)f(xn)
    pn_x +=value
    count +=1

print("The Final Value Of Pn("+str(default_value)+") : "+str(pn_x))       #DISPLAYS THE FINAL VALUE OF pn(x)