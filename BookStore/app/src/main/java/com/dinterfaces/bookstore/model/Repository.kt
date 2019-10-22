package com.dinterfaces.bookstore.model

object Repository {

    val books = mutableListOf<Book>()

    init {

        var book1 = Book(
            "132456789",
            "Aprendiendo Kotlin",
            "Libro para principiantes en Kotlin"
        )
        books.add(book1)

        book1 = Book(
            "987654321",
            "Introduccion a Android",
            "Libro para principiantes en Android"
        )
        books.add(book1)

        book1 = Book(
            "123789456",
            "Inicio a Java",
            "Libro para principiantes en Java"
        )
        books.add(book1)

        book1 = Book(
            "987321654",
            "Empezando en JavaScrip",
            "Libro para principiantes en JavaScript"
        )
        books.add(book1)

    }

}