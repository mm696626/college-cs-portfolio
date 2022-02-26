#Author: Matt McCullough

a = int(input("Enter an integer: "));
b = int(input("Enter another integer: "));
c = int(input("Enter another integer: "));

flag = 1;
bool(flag);

if((a+b)<=c):
    flag = 0;
if((b+c)<=a):
    flag = 0;
if((c+a)<=b):
    flag = 0
if(flag == 1):
    print("Valid triangle");
else:
    print("Invalid triangle");

if((a+b)>c):
    if((b+c)>a):
        if((c+a)>b):
            print("Valid triangle");
else:
    print("Invalid triangle");

if((a+b)>c and (b+c)>a and (c+a)>b):
    print("Valid triangle");
else:
    print("Invalid triangle");
