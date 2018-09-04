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
    // def factorial(num: BigInt) : BigInt = {
    //   if(num <= 1)
    //     1
    //   else
    //     num * factorial(num - 1)
    // }
    // println("Factorial of 4 = " + factorial(4))

    /* Arrays */

    // // Create an Array of 20 indexes (all values defaulted to 0)
    // val favNums = new Array[Int](20)
    
    // // Create an array of 2 strings
    // val friends = Array("Bob", "Tom")

    // // Reassign index
    // friends(0) = "Sue"

    // // Print specific index
    // println("Best friends " + friends(0))
    
    // // ArrayBuffer for arrays of indeterminate length
    // val friends2 = ArrayBuffer[String]()

    // // Insert
    // friends2.insert(0, "Phil")

    // // 
    // friends2 += "Mark"

    // friends2 ++= Array("Susy", "Paul")

    // // Insert mulitiple
    // friends2.insert(1, "Mike", "Sally", "Sam", "Mary", "Sue")

    // // Remove
    // friends2.remove(1,2)

    // Print all the strings
    // var friend : String = " "
    // for(friend <- friends2)
    //   println(friend)

    // Reassign and print each each value in an array (Leave uncommented to test favNums further)
    // for(j <- 0 to favNums.length - 1) {
    //   favNums(j) = j
    //  // Next line can be commented out if you just want to mutate the array
      // println(favNums(j))
    //}

    // // Double each value
    // val favNumsTimes2 = for(num <- favNums) yield 2 * num
    // favNumsTimes2.foreach(println)

    // // Get only numbers divisible by 4
    // var favNumsDiv4 = for(num <- favNums if num % 4 == 0) yield num
    // favNumsDiv4.foreach(println)

    // // Multidimensional array
    // var multiTable = Array.ofDim[Int](10, 10)
    // for(i <- 0 to 9){
    //   for(j <- 0 to 9){
    //     multiTable(i)(j) = i * j
    //   }
    // }
    // for(i <- 0 to 9){
    //   for(j <- 0 to 9){
    //     printf("%d * %d = %d\n", i, j, multiTable(i)(j))
    //   }
    // }
    
    // // Get sum
    // println("Sum: " + favNums.sum)

    // // Get min
    // println("Min: " + favNums.min)

    // // Get max
    // println("Max: " + favNums.max)

    // // Sort descending
    // val sortedNums = favNums.sortWith(_>_)

    // // Sort ascending
    // val sortedNums2 = favNums.sortWith(_<_)

    // // Convert into string with commas
    // println(sortedNums.deep.mkString(", "))

    /* Maps */
    // Create a map with the keys 'Manager' and 'Secretary'
    // val employees = Map("Manager" -> "Bob Smith",
    //   "Secretary" -> "Sue Brown")
    // // Check if there is a Manager key and if there is print all of the managers
    // if(employees.contains("Manager"))
    //   printf("Manager: %s\n", employees("Manager"))
    // // Create a map of customers with unique numbers as keys
    // val customers = collection.mutable.Map(100 -> "Paul Smith",
    //   101 -> "Sally Smith")
    // printf("Cust 1: %s\n", customers(100))
    // // Assign/reassign customers and then print them out
    // customers(100) = "Tom Marks"
    // customers(102) = "Megan Swift"
    // for((k,v) <- customers)
    //   printf("%d: %s\n", k, v)

    /* Tuples */
    
  }
}