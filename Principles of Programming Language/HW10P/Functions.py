#Author: Matt McCullough

test = int(input("Enter an integer: "));

list = []
list.append(test)

def Doubler(x):
    return x*2;

print(test, "doubled is:" , Doubler(test));


def Tripler(x):
    for i in range(0,len(x)):
        x[i] = x[i]*3

Tripler(list)
print(test, "tripled is:" , list[0]);

def isPrime(x):
    if(x<=0):
        return 0;

    if (x == 1 or x==2):
        return 1;

    for i in range(2,x):
        if (x % i == 0):
            return 0;

    return 1;

if(isPrime(test)==1):
    print(test, "is prime");
else:
    print(test, "is not prime");

