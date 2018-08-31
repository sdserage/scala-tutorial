import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source

object ScalaTutorial {
  def main(args: Array[String]) {
    

    /* Loops */
    // var i = 0

    // while loop
    // while(i <= 10){
    //   println(i)
    //   i += 1
    // }

    // do loop
    // do {
    //   println(i)
    //   i += 1
    // } while (i <=20)

    // for loop (without brackets)
    // for (i <- 1 to 10)
    //   println(i)

    // until for loop (commonly used for interating through strings)
    // val randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    // for (i <- 0 until randLetters.length)
    //   println(randLetters(i))

    // Loop over a List
    // val aList = List(1,2,3,4,5)
    // for (i <- aList) {
    //   println("List items" + i)
    // }

    // Loop over a List only store even numbers (then print them)
    // var evenList = for {i <- 1 to 20
    //   if (i % 2) == 0
    // } yield i

    // for(i <- evenList)
    //   println(i)

    // Increment multiple variables (i only increments after j reaches 10, j then starts over)
    // for (i <- 1 to 5; j <- 6 to 10){
    //   println("i: " + i)
    //   println("j: " + j)
    // }

    // Loop that 'breaks' and 'continues' (these are not native to scala according to the tutorial)
    // Bonus, demonstrates calling a function
    // def printPrimes() {
    //   val primeList = List(1,2,3,5,7,11)
    //   for(i <- primeList) {
    //     if(i == 11) {
    //       return
    //     }
    //     if(i != 1){
    //       println(i)
    //     }
    //   }
    // }

    // printPrimes

    /* Handle input and output */
    
    // Use terminal input to output different information depending on given input
    // var numberGuess = 0
    // do {
    //   print("Guess a number ")
    //   numberGuess = readLine.toInt
    //   // readInt readDouble readByte readShort readLong
    // } while(numberGuess != 15)
    // printf("You guessed the secret number %d\n", 15)

    // Demonstrates modifying output
    val name = "Derek"
    val age = 39
    val weight = 175.5
    println(s"Hello $name")
    println(f"I am ${age +1} and weigh $weight%.2f")
    // %c // characters
    // %d // different integer types
    // %f // floating point types
    // %s // strings

    // Demonstrates offseting output
    printf("'%5d'\n", 5)
    printf("'%-5d'\n", 5)

    // Demonstrates filling output
    printf("'%.5f'\n", 3.14)

    // filling output for strings
    printf("'%-5s'\n", "hi")
    printf("'%5s'\n", "hi")
    // \b backspace
    // \n newline
    // \a alert // doesn't work, will research
  }
}