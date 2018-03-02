package example

import rx.lang.scala._

object Hello extends App {

  val o = Observable.just(1, 2, 2, 1, 4, 5, 4, 4, 3, 2, 3)
  o.foreach(i => println(i))

  val list2 = o.distinctUntilChanged.take(6).toBlocking.toList
  println(list2)
  
}
