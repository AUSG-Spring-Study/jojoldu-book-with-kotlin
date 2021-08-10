package me.ausg.purplebookwithkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PurpleBookWithKotlinApplication

fun main(args: Array<String>) {
    runApplication<PurpleBookWithKotlinApplication>(*args)
}
