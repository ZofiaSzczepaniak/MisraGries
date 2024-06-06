# MisraGries
The Misra-Gries summary is an algorithm for finding the most frequent elements in a data stream using limited memory by maintaining a set of counters for a fixed number of elements and updating these counters as new elements are encountered. If an element not currently being tracked is observed and there is no available counter, all counters are decremented; otherwise, the element's counter is incremented or initialized if space permits. 

#The files in the project:
- alice29.txt - the exemplary book: “Alice’s Adventures in Wonderland”.
- MisraGriesalgorithm.sc - contain implementation of Misra-Gries algorithm.

# Instructions:
First to use the program, one must install the Scala compiler. To do so, enter the site and follow the given steps: https://docs.scala-lang.org/getting-started/index.html

Then to start the program one must type the following commands in a terminal:
```
scalac MisraGriesalgorithm.sc
scala MisraGries <text filename> 
```
