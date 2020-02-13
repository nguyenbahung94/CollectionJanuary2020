package com.example.collectionjanuary2020.builder

import com.example.collectionjanuary2020.builder.Student.Companion.student

class Student(
    val name: String?,
    val standard: Int,
    val rollNumber: Int
) {
    private constructor(builder: Builder) : this(
        builder.name,
        builder.standard,
        builder.rollNumber
    )

    //for DSLifying builder
    companion object {
        inline fun student(block: Builder.() -> Unit) =
            Builder().apply(block).build()
    }

    // class for dsl
    class Builder {
        var name: String? = null
        var standard: Int = 0
        var rollNumber: Int = 0

        fun build() = Student(this)
    }


    // class normal
    /* class Builder {
         var name: String? = null
             private set
         var standard: Int = 0
             private set
         var rollNumber: Int = 0
             private set

         fun name(name: String) = apply { this.name = name }
         fun standard(standard: Int) = apply { this.standard = standard }
         fun rollNumber(rollNumber: Int) = apply { this.rollNumber = rollNumber }

         fun build() = Student(this)
     }*/
}

class test {
    //create object normal
    /*  val tam = Student.Builder()
          .name("allex")
          .standard(123)
          .build()*/

    //create with dsl
    val temp = student {
        name = "allex"
        standard = 10
        rollNumber = 11
    }
}

