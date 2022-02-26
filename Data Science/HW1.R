#Matt McCullough HW1 Part 2

#load in csv file
WineRed=read.csv("winequality-red.csv",header=T,sep=";")

#create histogram of alcohol data
Alcohol = WineRed[["alcohol"]]
hist(Alcohol,col = "red")

#five number summary
summary(Alcohol)

#pull in quality data
Quality = WineRed[["quality"]]

#box plot
boxplot(Alcohol~Quality, pch = 19, col = "blue")

#histogram of PH data
PH = WineRed[["pH"]]
hist(PH, col = "purple")

#interval of 95% of the data (2 standard deviations away)
interval = c(mean(PH)-2*sd(PH),mean(PH)+2*sd(PH))
interval


#get real fraction of 95% of data
totalInInterval = sum(interval[1] <= PH & PH <= interval[2])
fraction = totalInInterval/length(PH)
fraction * 100

