library(ggplot2)

# load "caret" library (this contains the knnreg function)
library(caret)

# This library contains rmse function
library(ModelMetrics)  

# load honda data

HONDA=read.csv("Honda_Civic_price.csv");

## perform k-NN regression on the Honda data set

# Normalization function
# Input: vector x
# Output: normalized vector
nor <- function(x) { 
  return( (x -min(x))/(max(x)-min(x)) )   
}

# normalize age and mileage columns of dataset (these 
# correspond to the predictors)
honda_norm <- as.data.frame(lapply(HONDA[,2:3], nor))

# display summary
summary(honda_norm)

# set random seed
set.seed(1) 

# Randomly select 90% of the indices (rows) of the 
# dataset. This will be the indices of the training set
inTrain <- sample(1:nrow(HONDA), floor(0.9 * nrow(HONDA))) 

# extract training set
honda_trainX <- honda_norm[inTrain,]
honda_trainY <- HONDA[inTrain,4]

# extract testing set
honda_testX <- honda_norm[-inTrain,]
honda_testY <- HONDA[-inTrain,4]

# run knnreg function
kval <- 7
fit <- knnreg(honda_trainX, honda_trainY, k = kval)

# predict target values (response values) on the test set
honda_pred <- predict(fit, honda_testX)

# plot predicted value vs y value on the test set
# using ggplot
HondaPred <- data.frame(honda_testY, honda_pred)
g <- ggplot(data=HondaPred,aes(x=honda_testY,y=honda_pred))
g + geom_point() + geom_abline(slope=1,intercept=0)+
  xlab("Scaled price on test set") +
  ylab("Predicted price on test set")

# calculate the RMSE (Root Mean Square Error)
honda_rmse <- rmse(honda_testY,honda_pred)

print(paste('RMSE of kNNreg with k = ',kval,
            ' on test set: ',honda_rmse))