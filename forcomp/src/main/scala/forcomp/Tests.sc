import forcomp.Anagrams._



def subsets(lst: Occurrences): List[Occurrences] = {
  def helper(src: Occurrences, acc: List[Occurrences]): List[Occurrences] = {
    src match {
      case Nil => acc
      case (el,n)::xs => helper(xs, acc ::: (for (x <- 1 to n) yield acc.map((el,x) :: _)).flatten.toList)
    }
  }
  helper( lst, List(List())).map(_.sortBy(_._1))

}
val abba = List(('a', 2), ('b', 2))

subsets(abba).toSet