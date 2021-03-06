package com.allaboutscala.exercises.basics

/**
  * Created by Nadim Bahadoor on 01/20/2020.
  *
  * Tutorial: Source code for the scala-exercises section at http://allaboutscala.com
  *
  * [[http://allaboutscala.com/tutorials/scala-exercises/]]
  *
  *
  * Copyright 2016 Nadim Bahadoor (http://allaboutscala.com)
  *
  * Licensed under the Apache License, Version 2.0 (the "License"); you may not
  * use this file except in compliance with the License. You may obtain a copy of
  * the License at
  *
  *  [http://www.apache.org/licenses/LICENSE-2.0]
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  * License for the specific language governing permissions and limitations under
  * the License.
  */
object ClassFxTraits_12 extends App {

  // 11. This exercise is very similar to the previous one. You will write a
  // basic Scala program to represent a car inventory. You should use
  // a case class to model a Car object with a name property of type String, and a price
  // property of type Double. Next, you should extend - so to speak - the Car type
  // by having a uuid method, but without modifying the source code of the Car class.
  // Furthermore, and unlike the previous scala practice exercise, you should use
  // an implicit class as opposed to an implicit function to solve this particular
  // problem set. The uuid method should have an output with the combined car name
  // and the car name's hashCode. To verify your uuid method, you can define the
  // following car sample:
  // - a bmw 3 series priced at 20,000
  // - a bmw 5 series priced at 50,000
  // - a vw passat priced at 10,000
  // - a vw golf priced at 12,000
  // - a mazda 3 priced at 15,000
  // Use an appropriate data structure from Scala's collection types to store
  // the above car sample. Finally, you should output each car's uuid method
  // as shown below.
  // Output:
  //  car uuid = bmw 3 series - -2034747624
  //  car uuid = bmw 5 series - 1450873046
  //  car uuid = vw passat - 44703299
  //  car uuid = vw golf - 790852193
  //  car uuid = mazda 3 - 846423990


  final case class Car(name: String, price: Double)

  object CarExtensions {
    implicit class CarUUID(car: Car) {
      def uuid: String = s"car uuid = ${car.name} - ${car.name.hashCode}"
    }
  }

  import CarExtensions._
  val bmw3 = Car("bmw 3 series", 20000)
  val bmw5 = Car("bmw 5 series", 50000)
  val vwPassat = Car("vw passat", 10000)
  val vwGolf = Car("vw golf", 12000)
  val mazda3 = Car("mazda 3", 15000)

  val cars = List(bmw3, bmw5, vwPassat, vwGolf, mazda3)
  cars.foreach(car => println(car.uuid))


}
