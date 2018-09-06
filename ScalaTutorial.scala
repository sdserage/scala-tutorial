import scala.io.StdIn.{readLine, readInt}
import scala.math._
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter
import scala.io.Source

object ScalaTutorial {
  def main(args: Array[String]) {
    if (args.length > 0) {
      val mode: String = args(0)

      mode match {
        case "loops" => loops
        case "handle-input/output" => handleInputAndOutput
        case "strings" => strings
        case "functions" => functions
        case "arrays" => arrays
        case "maps" => maps
        case "tuples" => tuples
        case "classes" => classes
        case "abstract-classes" => abstractClasses
        case "traits" => traits
        case "higher-order-functions" => higherOrderFunctions
        case "file-IO" => fileIO
        case "exception-handling" => exceptionHandling
        case _ => displayOptions(true)
      }
    } else {
      displayOptions(false)
    }
  } // END OF MAIN

  // Traits

  trait Flyable {
    def fly: String
  }

  trait BulletProof {
    def hitByBullet: String
    def ricochet(startSpeed: Double): String = {
      "The bullet ricochets at a speed of %.1f ft/sec".format(startSpeed * .75)
    }
  }

  class Superhero(val name: String) extends Flyable with BulletProof {
    def fly = "%s flys through the air".format(this.name)

    def hitByBullet = "The bullet bounces off of %s".format(this.name)
  }

  // Abstract Classes

  abstract class Mammal(val name: String){
    var moveSpeed: Double
    def move: String
  }

  class Wolf(name: String) extends Mammal(name){
    var moveSpeed = 35.0
    def move = "The wolf %s runs %.2f mph".format(this.name, this.moveSpeed)
  }

  // Classes and Inheritance

  class Animal(var name: String, var sound: String){
    // Default contructor
    this.setName(name)
    val id = Animal.newIdNum

    def getName(): String = name
    def getSound(): String = sound
    def setName(name: String){
      if(!(name.matches(".*\\d+.*")))
        this.name = name
      else
        this.name = "No Name"
    }
    def setSound(sound: String){
      this.sound = sound
    }
    // Constructor with only name passed in
    def this(name: String){
      this("No Name", "No Sound")
      this.setName(name)
      this.setSound(sound)
    }
    // Constructor with no name or sound passed in
    def this(){
      this("No Name", "No Sound")
    }
    // Override toString
    override def toString(): String = {
      "%s with the id %d says %s".format(this.name, this.id, this.sound)
    }
  }
  // Companion object (Notice that it is outside of the Animal class)
  object Animal {
    private var idNumber = 0
    private def newIdNum = {idNumber += 1; idNumber}
  }

  class Dog(name: String, sound: String, growl: String) extends Animal(name, sound){
    def this(name: String, sound: String){
      this("No Name", sound, "No Growl")
      this.setName(name)
    }
    def this(name: String){
      this("No Name", "No Sound", "No Growl")
      this.setName(name)
    }
    def this(){
      this("No Name", "No Sound", "No Growl")
    }
    override def toString(): String = {
      "%s with the id %d says %s or %s".format(this.name, this.id, this.sound, this.growl)
    }
  }


  def loops() {
    /* Loops */
    var i = 0

    // While loop
    while(i <= 10){
      println(i)
      i += 1
    }

    // Do loop
    do {
      println(i)
      i += 1
    } while (i <=20)

    // For loop (without brackets)
    for (i <- 1 to 10)
      println(i)

    // Until for loop (commonly used for interating through strings)
    val randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    for (i <- 0 until randLetters.length)
      println(randLetters(i))

    // Loop over a List
    val aList = List(1,2,3,4,5)
    for (i <- aList) {
      println("List items" + i)
    }

    // Loop over a List only store even numbers (then print them)
    var evenList = for {i <- 1 to 20
      if (i % 2) == 0
    } yield i

    for(i <- evenList)
      println(i)

    // Increment multiple variables (i only increments after j reaches 10, j then starts over)
    for (i <- 1 to 5; j <- 6 to 10){
      println("i: " + i)
      println("j: " + j)
    }

    // Loop that 'breaks' and 'continues' (these are not native to scala according to the tutorial)
    // Bonus, demonstrates calling a function
    def printPrimes() {
      val primeList = List(1,2,3,5,7,11)
      for(i <- primeList) {
        if(i == 11) {
          return
        }
        if(i != 1){
          println(i)
        }
      }
    }
    printPrimes
  }

  def handleInputAndOutput {
    /* Handle input and output */
    
    // Use terminal input to output different information depending on given input
    var numberGuess = 0
    do {
      print("Guess a number ")
      numberGuess = readLine.toInt
      // readInt readDouble readByte readShort readLong
    } while(numberGuess != 15)
    printf("You guessed the secret number %d\n", 15)

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

  def strings {
    /* Strings */

    var randSent = "I saw a dragon fly by"
    
    // Display index of string
    println("3rd index :" + randSent(3))

    // Display length of string
    println("String length: " + randSent.length)

    // Concatonate string
    println(randSent.concat(" and explode"))

    // Compare strings
    println("Are strings equal " + "I saw a dragon".equals(randSent))
    
    // Get index of first letter of substring
    println("dragon starts at index " + randSent.indexOf("dragon"))
    
    // Convert string to an array
    val randSentArray = randSent.toArray
    for(v <- randSentArray)
      println(v)
  }

  def functions {
    /* Functions */
    /*
      Function basic layout:

      def funcName (param1: dataType, param2: dataType) : returnType = {
        function body
        return value toReturn
      }
    */
    // Simple number sum function * Note: 'return' can be used but isn't needed, Scala will return value of last line
    def getSum(num1: Int = 1, num2: Int = 1): Int = {
      num1 + num2
    }
    println("5 + 4 = " + getSum(5, 4))

    // Has no return value
    def sayHi() : Unit = {
      println("Hi, how are you?")
    }
    sayHi

    // Function takes any number of arguments of the same type
    def getSumV2(args: Int*) : Int = {
      var sum : Int = 0
      for(num <- args){
        sum += num
      }
      sum
    }
    println("Get Sum " + getSumV2(1,2,3,4,5,6))

    // Recursion Example
    def factorial(num: BigInt) : BigInt = {
      if(num <= 1)
        1
      else
        num * factorial(num - 1)
    }
    println("Factorial of 4 = " + factorial(4))
  }

  def arrays {
    /* Arrays */

    // Create an Array of 20 indexes (all values defaulted to 0)
    val favNums = new Array[Int](20)
    
    // Create an array of 2 strings
    val friends = Array("Bob", "Tom")

    // Reassign index
    friends(0) = "Sue"

    // Print specific index
    println("Best friends " + friends(0))
    
    // ArrayBuffer for arrays of indeterminate length
    val friends2 = ArrayBuffer[String]()

    // Insert
    friends2.insert(0, "Phil")

    // 
    friends2 += "Mark"

    friends2 ++= Array("Susy", "Paul")

    // Insert mulitiple
    friends2.insert(1, "Mike", "Sally", "Sam", "Mary", "Sue")

    // Remove
    friends2.remove(1,2)

    // Print all the strings
    var friend : String = " "
    for(friend <- friends2)
      println(friend)

    // Reassign and print each each value in an array (Leave uncommented to test favNums further)
    for(j <- 0 to favNums.length - 1) {
      favNums(j) = j
     // Next line can be commented out if you just want to mutate the array
      println(favNums(j))
    }

    // Double each value
    val favNumsTimes2 = for(num <- favNums) yield 2 * num
    favNumsTimes2.foreach(println)

    // Get only numbers divisible by 4
    var favNumsDiv4 = for(num <- favNums if num % 4 == 0) yield num
    favNumsDiv4.foreach(println)

    // Multidimensional array
    var multiTable = Array.ofDim[Int](10, 10)
    for(i <- 0 to 9){
      for(j <- 0 to 9){
        multiTable(i)(j) = i * j
      }
    }
    for(i <- 0 to 9){
      for(j <- 0 to 9){
        printf("%d * %d = %d\n", i, j, multiTable(i)(j))
      }
    }
    
    // Get sum
    println("Sum: " + favNums.sum)

    // Get min
    println("Min: " + favNums.min)

    // Get max
    println("Max: " + favNums.max)

    // Sort descending
    val sortedNums = favNums.sortWith(_>_)

    // Sort ascending
    val sortedNums2 = favNums.sortWith(_<_)

    // Convert into string with commas
    println(sortedNums.deep.mkString(", "))
  }

  def maps {
    /* Maps */

    // Create a map with the keys 'Manager' and 'Secretary'
    val employees = Map("Manager" -> "Bob Smith",
      "Secretary" -> "Sue Brown")

    // Check if there is a Manager key and if there is print all of the managers
    if(employees.contains("Manager"))
      printf("Manager: %s\n", employees("Manager"))

    // Create a map of customers with unique numbers as keys
    val customers = collection.mutable.Map(100 -> "Paul Smith",
      101 -> "Sally Smith")
    printf("Cust 1: %s\n", customers(100))

    // Assign/reassign customers and then print them out
    customers(100) = "Tom Marks"
    customers(102) = "Megan Swift"
    for((k,v) <- customers)
      printf("%d: %s\n", k, v)
  }

  def tuples {
    /* Tuples */
    
    // Create a tuple and print values from it
    var tupleMarge = (105, "Marge Simpson", 10.25)
    printf("%s owes us $%.2f\n", tupleMarge._2, tupleMarge._3)

    // Print each value in a tuple (without knowing how big it is)
    tupleMarge.productIterator.foreach{i => println(i)}

    // Print a tuple as a string
    println(tupleMarge.toString())
  }

  def classes {
    /* Classes */

    // Create an animal and then set its values
    val rover = new Animal
    rover.setName("Rover")
    rover.setSound("Woof")
    printf("%s says %s\n", rover.getName, rover.getSound)

    // Create an animal with values passed in to begin with
    val whiskers = new Animal("Whiskers", "Meow")
    println(s"${whiskers.getName} with id ${whiskers.id} says ${whiskers.sound}")

    // Use overridden toString
    println(whiskers.toString)

    // Inheritance

    val spike = new Dog("Spike", "Woof", "Grrrrr")
    spike.setName("Spike")
    println(spike.toString)
  }

  def abstractClasses {
    /* Abstract Classes */

    val fang = new Wolf("Fang")
    fang.moveSpeed = 36.0
    println(fang.move)
  }

  def traits {
    /* Traits */

    val superman = new Superhero("Superman")
    println(superman.fly)
    println(superman.hitByBullet)
    println(superman.ricochet(2500))
  }

  def higherOrderFunctions {
    /* Higher Order Functions */

    // Store log10 as a variable and then call it using the created variable
    val log10Func = log10 _
    println(log10Func(1000))

    // Map over a list and perform a function (and then print the result)
    List(1000.0, 10000.0).map(log10Func).foreach(println)

    // Multiply the input by 50 for each item in the list
    List(1,2,3,4,5).map((x: Int) => x * 50).foreach(println)

    // Filter example
    List(1,2,3,4,5).filter(_ % 2 == 0).foreach(println)

    // Functions to be passed in
    def times3(num: Int) = num * 3
    def times4(num: Int) = num * 4

    // Takes a function that returns and Int and changes it to a double,
    // also takes an Int to be passed into the function it recieves
    def multIt(func: (Int) => Double, num: Int) = {
      func(num)
    }
    printf("4 * 100 = %.1f\n", multIt(times4, 100))

    // Closure example
    val divisorVal = 5

    val divisor5 = (num: Double) => num/divisorVal

    println("5/5 = " + divisor5(5.0))
  }

  def fileIO {
    /* File IO */

    val writer = new PrintWriter("test.txt")
    writer.write("Just some random text\nSome more random text")
    writer.close()

    val textFromFile = Source.fromFile("test.txt", "UTF-8")

    val lineIterator = textFromFile.getLines

    for(line <- lineIterator)
      println(line)

    textFromFile.close()
  }

  def exceptionHandling {
    /* Exception Handling */

    def divideNums(num1: Int, num2: Int) = try {
      (num1/num2)
    } catch {
      case ex: java.lang.ArithmeticException => "Can't divide by zero"
    } finally {
      // clean up after exception
    }

    println("3/0 = " + divideNums(3,0))
  }

  def displayOptions(nonValidArg: Boolean) {
    val options = Array (
      "loops",
      "handle-input/output",
      "strings",
      "functions",
      "arrays",
      "maps",
      "tuples",
      "classes",
      "abstract-classes",
      "traits",
      "higher-order-functions",
      "exception-handling"
    )
    if (nonValidArg) {
      println("The argument you entered in was invalid.")
    }
      println("Please run this tutorial with one of the following arguments:")
      options.map(option => println(option))
  }

} // END OF ScalaTutorial