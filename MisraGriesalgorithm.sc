import scala.io.Source
import scala.util.control._
object MisraGries {
  def main(args: Array[String]): Unit = {
    if (args.length>0) { // I check if the filename was given.
      val file = args(0) // I save the input filename.
      val fileSource = Source.fromFile(file) // I save words from input file.
      val words = fileSource.mkString.split("\\W+").map(_.toLowerCase).toList // I save words in the type String and change all letters to lower case.
      fileSource.close() // I close the input file.
      val m = words.length
      val k = 21
      val n = m/k
      val Keys = Array.fill(m)("")
      val Values = Array.fill(m)(0)
      val loop = new Breaks
      //I use break loops and con to stop the loop after updating Values and Keys.
      for(word <- words) //We take word from list of words from the book.
      {
        var con = false //When false, it means that there is no space in Keys and Values for new word and word is not already in there.
        loop.breakable(
          for(l<-0 until k) { //Loop of the Values and Keys.
            if (Keys(l) == word) { //When word is in the Keys than we add Values for this word and we change con to true.
              Values(l) = Values(l) + 1
              con = true
              loop.break //We stop the second for loop.
            }
            else {
              if (Values(l) == 0) { //If there is empty place in the Keys than we put the word in and change con into true.
                Keys(l) = word
                Values(l) = 1
                con = true
                loop.break //We stop the second for loop.
              }
            }
          })
        if(!con) //If Values and Keys was full and the word wasn't in it than we subtract one from every value in Values
          for (j <- 0 until k) {
            if(Values(j)==0)
            {

            }
            else{
              Values(j) = Values(j) - 1
            }
            if (Values(j) == 0) {
              //We delete the redundant word
              Keys(j) = ""
            }
          }
      }

      //sort keys and values and print the table
      val kv = Keys.zip(Values).sortBy(-_._2)
      val pairs = words.groupBy(identity).view.mapValues(_.length).toList.sortBy(-_._2)
      val (w, f) = pairs.unzip
      def yorn (A: Double, B: Double): Boolean ={
        if(A>B){return true}
        else {return false}
      }
      def theoretical(A: Double, B: Double, C:Double): Boolean ={
        //I define the method, which check if the generalized mean inequalities are fulfilled.
        if(A <= B & B <= C){
          return true
        }
        else{
          return false
        }
      }
      println("word ", "fl ", "fl - m/k ", "fl* ", "fl>m/k?", "fl-m/k <= fl* <= fl?")
      for(i<-0 until k)
      {
        println(f"${kv(i)._1} | ${f(i)} | ${f(i)-n} | ${kv(i)._2} | ${yorn(f(i),n)} | ${theoretical(f(i)-n,kv(i)._2, f(i))}")
      }
    }
  }
}