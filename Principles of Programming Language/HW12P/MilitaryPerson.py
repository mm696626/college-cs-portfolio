class MilitaryPerson:
    def __init__(self, firstName,lastName,rank,serialNumber,branch,active):
        self.firstName = firstName;
        self.lastName = lastName;
        self.rank = rank;
        self.serialNumber = serialNumber;
        self.branch = branch;
        self.active = active;


#This is the default constructor, but you cannot have mulitple constructors in Python. Sorry :(
    #def __init__(self):
    #    self.firstName = "Matt";
    #    self.lastName = "McCullough";
    #    self.rank = "Corporate";
    #    self.serialNumber = "1234";
    #    self.branch = "The Greatest";
    #    self.active = False;

    def get_branch(self):
        return self.branch;

    def set_branch(self, b):
        self.branch = b;

    def __del__(self):
        print("Military Person deleted");



p1 = MilitaryPerson("Gomer", "Pyle", "Private", "GMP-345", "Marines", True);
p2 = MilitaryPerson("Grace", "Hopper", "Rear Admiral", "GAH-712", "Navy", False);
print(p1.get_branch());
print(p2.get_branch());

