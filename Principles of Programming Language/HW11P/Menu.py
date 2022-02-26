running = 1;
bool(running);
choice1=0;
choice2=0;

while(bool(running)==True):
    print("Welcome to the PPL Menu System");
    print("Author: Matt McCullough");
    print("1. Echo a number");
    print("2. Double a number");
    print("3. Eat something");
    print("4. Quit");
    selection = int(input("Enter your selection: "));
    if(selection==1):
        choice1 = int(input("Enter a number: "));
        print("The number is: " , choice1);
    elif(selection==2):
        choice2 = int(input("Enter a number: "));
        choice2 = choice2*2;
        print("The number doubled is: " , choice2);
    elif(selection==3):
        food = input("Enter a food: ");
        print("If you eat", choice2, " ", food, "it will cost you $", choice1);
    elif(selection==4):
        print("Thanks for using the Menu System");
        print("Goodbye!");
        running=0;
    else:
        print("Invalid choice");







