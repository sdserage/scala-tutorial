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
    // val name = "Derek"
    // val age = 39
    // val weight = 175.5
    // println(s"Hello $name")
    // println(f"I am ${age +1} and weigh $weight%.2f")
    // %c // characters
    // %d // different integer types
    // %f // floating point types
    // %s // strings

    // Demonstrates offseting output
    // printf("'%5d'\n", 5)
    // printf("'%-5d'\n", 5)

    // Demonstrates filling output
    // printf("'%.5f'\n", 3.14)

    // filling output for strings
    // printf("'%-5s'\n", "hi")
    // printf("'%5s'\n", "hi")
    // \b backspace
    // \n newline
    // \a alert // doesn't work, will research

    /* Strings */

    // var randSent = "I saw a dragon fly by"
    
    // // Display index of string
    // println("3rd index :" + randSent(3))

    // // Display length of string
    // println("String length: " + randSent.length)

    // // Concatonate string
    // println(randSent.concat(" and explode"))

    // // Compare strings
    // println("Are strings equal " + "I saw a dragon".equals(randSent))
    
    // // Get index of first letter of substring
    // println("dragon starts at index " + randSent.indexOf("dragon"))
    
    // // Convert string to an array
    // val randSentArray = randSent.toArray
    // for(v <- randSentArray)
    //   println(v)

    /* Functions */

    /*
      Function basic layout:

      def funcName (param1: dataType, param2: dataType) : returnType = {
        function body
        return value toReturn
      }
    */

    // Simple number sum function * Note: 'return' can be used but isn't needed, Scala will return value of last line
    // def getSum(num1: Int = 1, num2: Int = 1): Int = {
    //   num1 + num2
    // }
    // println("5 + 4 = " + getSum(5, 4))

    // Has no return value
    // def sayHi() : Unit = {
    //   println("Hi, how are you?")
    // }
    // sayHi

    // Function takes any number of arguments of the same type
    // def getSum(args: Int*) : Int = {
    //   var sum : Int = 0
    //   for(num <- args){
    //     sum += num
    //   }
    //   sum
    // }
    // println("Get Sum " + getSum(1,2,3,4,5,6))

    // Recursion Example
    def factorial(num: BigInt) : BigInt = {
      if(num <= 1)
        1
      else
        num * factorial(num - 1)
    }
    println("Factorial of 4 = " + factorial(4))
  }
}