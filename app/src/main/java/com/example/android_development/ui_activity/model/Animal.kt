package dev.lynko.cources2023.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android_development.R
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@Entity(tableName = "animal")
data class Animal(
    val type: String,
    val name: String,
    val age: Int,
    val weight: Double,
    val description: String,
    val avatar: Int,
    val createdAt: String, // Можем сразу его заполнять как System.currentTimeMillis, и лучше изменить на Long
//    val createdAt: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

