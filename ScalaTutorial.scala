object ScalaTutorial {
  def main(args: Array[String]) {
    var i = 0

    /* Loops */

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

    
  }
}