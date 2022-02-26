#R Homework 2 by Matt McCullough

#load ggplot library
library(ggplot2)

#load data set
load("WineQualityRedMore.RData")

#Question 1

#scatter plot of fixed acidity vs pH (1a)
g <- ggplot(data = WineRedMore, mapping = aes(x = fixed.acidity, y = pH))
g+geom_point() + geom_smooth(method = "lm", color = "red")

#scatter plot of fixed acidity vs pH (with color) (1b)
g <- ggplot(data = WineRedMore, mapping = aes(x = fixed.acidity, y = pH, color = citric.acid.cat))
g+geom_point()

#scatter plot of fixed acidity vs pH (with color and size) (1c)
g <- ggplot(data = WineRedMore, mapping = aes(x = fixed.acidity, y = pH, color = citric.acid.cat, size = alcohol))
g+geom_point()


#scatter plot of fixed acidity vs pH (facets) (1d)
g <- ggplot(data = WineRedMore, mapping = aes(x = fixed.acidity, y = pH, color = alcohol.cat))
g+geom_point()+facet_wrap(~quality.cat) + geom_smooth(method = "lm", color = "black")

#scatter plot of fixed acidity vs pH (facets) (1e)
g <- ggplot(data = WineRedMore, mapping = aes(x = fixed.acidity, y = pH, color = quality.cat))
g+geom_point()+facet_grid(alcohol.cat~citric.acid.cat)+ geom_smooth(method = "lm", color = "black")


#Question 2


# create bar plot (2a)
bar <- ggplot(data = WineRedMore)
bar + geom_bar(mapping = aes(x = quality.cat))

# create bar plot with fill (2b)
bar <- ggplot(data = WineRedMore)
bar + geom_bar(mapping = aes(x = quality.cat, fill = alcohol.cat))

# create bar plot with fill and proportion (2c)
bar <- ggplot(data = WineRedMore)
bar + geom_bar(mapping = aes(x = quality.cat, fill = alcohol.cat), position = "fill")

# create bar plot with relation to each other (2d)
bar <- ggplot(data = WineRedMore)
bar + geom_bar(mapping = aes(x = quality.cat, fill = alcohol.cat), position = "dodge")


#Question 3

#histogram of PH (3a)

pH <- ggplot(data = WineRedMore, aes(x = pH))
pH + geom_histogram(binwidth = .1, color = "red", fill = "green")

#histogram of PH with normal curve (3b)

pH <- ggplot(data = WineRedMore, aes(x = pH))
pH + geom_histogram(aes(y=..density..), binwidth = .1, color = "red", fill = "green") + stat_function(fun = dnorm, args = list(mean = mean(WineRedMore$pH,na.rm=T), sd = sd(WineRedMore$pH,na.rm=T)))

#histogram of PH with facets (3c)
pH <- ggplot(data = WineRedMore, aes(x = pH))
pH + geom_histogram(binwidth = .1, color = "red", fill = "green") + facet_wrap(~alcohol.cat)

#Question 4

#alcohol vs quality box plot (4a)
alcohol <- ggplot(data = WineRedMore, aes(x = alcohol, y = quality.cat))
alcohol + geom_boxplot(color="black", fill="white")

#citric.acid.cat fill mapping (4b)
alcohol <- ggplot(data = WineRedMore, aes(x = alcohol, y = quality.cat, fill = citric.acid.cat))
alcohol + geom_boxplot(color="black")

