#HW3 Matt McCullough

#load library
library(ggplot2);

#Question 1

#part a
g <- ggplot(data = diamonds, mapping = aes(x = carat));
g + geom_histogram(binwidth = .35, color = "blue", fill = "cyan");
mean(diamonds$carat);
sd(diamonds$carat);

#part b
mean(diamonds$carat);
sd(diamonds$carat)/sqrt(500);

#part c

samplesize = 500;
numsamples = 50000;
SampleMeans <- numeric(numsamples)

# calculate sample means
for (i in 1:numsamples) {
  indices <- sample(1:nrow(diamonds), samplesize)
  SampleMeans[i] <- mean(diamonds$carat[indices])
}

# convert vector of sample means into a data frame
CaratSampleMeansDF <- data.frame(SampleMeans)


# histogram of sample means
g <- ggplot(data = CaratSampleMeansDF,aes(x = SampleMeans))
g + geom_histogram(color = "white", fill = "black")

mean(SampleMeans)
sd(SampleMeans)

#Question 2

#part a
Mileage = read.csv("Fuel_Economy.csv");
set.seed(1);
SampleMileages = Mileage[sample(nrow(Mileage), 35), ]
SampleMileages

#part b
xbar = mean(SampleMileages);
standardDev = sd(SampleMileages);
n = length(SampleMileages);

xbar
standardDev

alpha = 0.05;

t = qt(1-alpha/2, df = n-1);
t

confInt = c(xbar-t*standardDev/sqrt(n), xbar+t*standardDev/sqrt(n));
confInt

#part c
result = t.test(SampleMileages);
conf = result$conf.int
conf

#part d
mean(Mileage$MILEAGE)