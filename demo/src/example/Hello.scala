package example

import java.util.{Timer, TimerTask}

import rx.lang.scala._

object Hello extends App {

  val o = Observable.apply[Long] { subscriber =>
    val timer = new Timer(true)
    timer.scheduleAtFixedRate(new TimerTask {
      override def run(): Unit = {
        subscriber.onNext(System.currentTimeMillis())
      }
    }, 0, 100)
  }
  
  o.take(3).toBlocking.foreach(println)

}
