package dev.lynko.cources2023

import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.random.nextInt

val myСoroutineScope = CoroutineScope(Dispatchers.IO)

suspend fun main() {
    val job = myСoroutineScope.async {
        while (true) {
            val number = getRandomNumber()
            if (number >= 15) {
                return@async withContext(Dispatchers.Default) {
                    "Congrats! Your number is $number"
                }
            } else {
                println(number)
                delay(2000)
            }
        }
    }.await()
    println(job)

    myСoroutineScope.launch {
    val job3 = myСoroutineScope.launch {
        println("Coroutine TODO 3 start")
        delay(15000)
        throw NoSuchFieldError()
    }
    delay(10_000)
    if (job3.isActive) {
        println("Coroutine TODO 3 end")
        job3.cancel()
    }
}
    //TODO 4 Исправьте написанный код в корутине так, чтобы добиться вывода текста в таком порядке:
    // "Coroutine TODО 4 start"
    // "Start delay"
    // "Start work..."
    // "Work complete. Number: $value"
    // "End delay"
    // "Last step."
    // "Coroutine TODО 4 end".
    // Написаные println трогать и добавлять новые запрещается)))


    val jobFinal = myСoroutineScope.launch {
        println("Coroutine TODO 4 start")
        launch(Dispatchers.Default) {
            doWork(getRandomNumber())

        }
        println("Start delay")
        delay(7000L)
        println("End delay")
        launch(Dispatchers.IO) {
            delay(1000L)
            println("Last step.")
        }.join()
        println("Coroutine TODO 4 end")
    }
    jobFinal.join()
    //Не убирать
    while (jobFinal.isActive) {

    }


}

const val TEST = "TEST"
suspend fun getRandomNumber(): Int = Random(System.currentTimeMillis()).nextInt(0..20)

suspend fun doWork(value: Int) {
    delay(1000)
    println("Start work...")
    println("Work complete. Number: $value")
}

