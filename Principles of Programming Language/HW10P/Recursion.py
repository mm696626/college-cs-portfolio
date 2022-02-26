#Author: Matt McCullough

n = int(input("Enter an integer: "));
r = int(input("Enter another integer: "));

def choose(n,r):
    if(r==0):
        return 1;
    if(r==n):
        return 1;
    if(r>n):
        return 0;
    else:
        return choose(n-1,r-1) + choose(n-1,r);

print(choose(n,r));

def josephus(n,k):
    if(n==1):
        return 1;
    else:
        return ((josephus(n-1,k) + k-1) % n) + 1;

print(josephus(n,r));






