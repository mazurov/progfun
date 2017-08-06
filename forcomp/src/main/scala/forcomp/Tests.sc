import forcomp.Anagrams._

dictionary.map(x => wordOccurrences( x ) -> x ).groupBy(_._1).mapValues(_.map(_._2))