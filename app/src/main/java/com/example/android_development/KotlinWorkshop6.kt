package dev.lynko.cources2023

// Workshop #6 - special classes, objects, data classes



/* Рабочая зона */

// TODO 1: Добавь в data class 2-4 свойства.
data class VideoGame(val nameOfTheGame:String="game",val yearOfRelease:Int=1990, val estimation:Int=0)

// TODO 2: Создай объект "VideoGamesTest", который будет использоваться для тестирования игр.
 val videoGamesTest = VideoGame("ELDEN RING",2022,95)

      // Раскомментируй после объявления объекта.
    fun main(args: Array<String>)  {
        // TODO 3: Создай экземпляр класса "VideoGame".
        //  Создай копию игры с помощью функции ата класса ".copy()", сохрани копию в другой переменной.
         val game = videoGamesTest
         val copy = videoGamesTest.copy()

        // TODO 4: Выведи в консоль результат сравнения игры и её копии, используя оператор сравнения "==".
        //  Результат должен быть типа Boolean "true".
        val equal = game==copy
        println("Objects are equal $equal")

        // TODO 5: Создай массив игр. В момент создания, наполни его несколькими играми и массив в консоль.
        val games = arrayOf(game, copy, videoGamesTest.copy(estimation = 36),VideoGame())
        games.forEach {
             println(it)
        }
    }




// TODO 6: Добавь новое свойство класса "VideoGame", присвой ему значение "по-умолчанию".
//  Как ты можешь убедиться, новое свойство со значением "по-умолчанию" не требует делать исправлений в таком коде.
//  Но надо помнить, что поведение созданных сущностей может измениться.
//  Запусти выполнение функции "main()" и посмотри результат.