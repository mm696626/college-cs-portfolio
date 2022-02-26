#Matt McCullough
#Homework 4 Part 2
library(ggplot2)
tampalms = load("TAMPALMS.Rdata")

#part a
g<-ggplot(data=TAMPALMS, aes(x=Market_Val,y=Sale_Price))
g+geom_point(color= "green")

#x is market value y is sale price
#explanatory is market value and the response is the sale price
#sale price vs. market value (y vs x)

#part b
reg <- lm(Sale_Price~Market_Val, data = TAMPALMS)
summary(reg)
anova(reg)


#part c
reg$coef
#y = 1.408271x + 1.358681

g<-ggplot(data=TAMPALMS, aes(x=Market_Val,y=Sale_Price))
g+geom_point(color= "green")+
  geom_smooth(method= "lm",se=FALSE)

#part d
#It would be appropriate as for every increase of market value (which is 1.408271 thousand dollars) to the market value of a property, there is
#an increase of 1.35881 thousand dollars of to the predicted sale price on average.


#part e
summary(reg)

#t value 38.132  p value 1.056065e-50
#you can also use summary to find this


#part f
confint(reg) #95 conf interval

#part g
g<-ggplot(data=TAMPALMS,aes(x=Sale_Price,y=reg$residuals))
g+geom_point(color = "green")+geom_abline(intercept=0,slope=0)+
  ylab("Residuals")+
  ggtitle("Residual Plot for the Tampa Data Set")+
  theme(plot.title = element_text(hjust = 0.5))

#part h
g<-ggplot(data=TAMPALMS,aes(x=reg$residuals))
g+geom_histogram(bins=20,fill="green", color = "black")+
  ggtitle("Histogram of Residuals")+
  xlab("Residuals")+
  theme(plot.title = element_text(hjust = 0.5))
#this resembles a normal distribution with mean of 0

#part i
#Residual standard error: 68.76 on 74 degrees of freedom
#Approximately 95% lie within 2s or 137.5132 thousand dollars

#part j
#95.16% of the variability can be explained by the regression
#also in summary

#part k
Market_Val <- c(300)
df <- data.frame(Market_Val)
# estimate y and display prediction interval
predict(reg, df, interval="prediction")
