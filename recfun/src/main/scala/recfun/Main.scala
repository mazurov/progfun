package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c == r) 1
      else pascal(c-1, r-1) + pascal(c, r - 1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      @tailrec
      def f(nopen:Int, lst:List[Char]):Boolean = {
        if (lst.isEmpty) nopen == 0
        else {
          val head = lst.head
          val n = if (head == '(') nopen + 1 else if (head == ')')  nopen - 1 else nopen
          n >= 0 && f(n, lst.tail)  
        }
      }
      f(0, chars)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1 else if (money < 0 || coins.isEmpty) 0 else (countChange(money - coins.head, coins) + countChange(money, coins.tail))
    }
  }
