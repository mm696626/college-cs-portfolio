library(neuralnet)

nor <- function(x) { 
  return( (x -min(x))/(max(x)-min(x)) )   
}

accuracy <- function(T){
  return (sum(diag(T))/sum(rowSums(T)) * 100)
}

# read data set
ReadEchocardiogramDataSet <- function() {
  Echocardiogram=read.csv("echocardiogram.data",header=F, na.strings = c("?"
  ))
  
  names(Echocardiogram)[2]<-"alive"
  names(Echocardiogram)[3]<-"ageattack"
  names(Echocardiogram)[5]<-"fracshort"
  names(Echocardiogram)[6]<-"epss"
  names(Echocardiogram)[7]<-"lvdd"
  names(Echocardiogram)[9]<-"wallmotion"
  
  Echocardiogram = Echocardiogram[,c(2,3,5,6,7,9)]
  
  
  return(Echocardiogram) 
  
}



Echocardiogram = ReadEchocardiogramDataSet()
Echocardiogram = na.omit(Echocardiogram)


card_norm <- as.data.frame(lapply(Echocardiogram, nor))

set.seed(1);

 
ran <- sample(1:nrow(Echocardiogram), floor(0.8*nrow(Echocardiogram))) 

# extract training set
card_train <- card_norm[ran,] 

# extract testing set
card_test <- card_norm[-ran,]

card_test_category <- Echocardiogram[-ran,1]

hiddenlayerstruc <- 7

# train the neural net
NN <- neuralnet(alive ~ ageattack+fracshort+epss+lvdd+wallmotion, card_train,
                hidden = hiddenlayerstruc, linear.output = F)

# type NN on prompt to see info on NN
NN

# plot the neural net
plot(NN)

card_pred <- predict(NN, card_test[,2:6])
card_predclass <- sapply(card_pred, round, digits = 0)

# create confusion matrix
card_testclass<-card_test[,1]
tab <- table(card_predclass,card_testclass)

cat('accuracy of neural net with (',hiddenlayerstruc,
    ') hidden nodes on the test set: ',accuracy(tab),'\n')
