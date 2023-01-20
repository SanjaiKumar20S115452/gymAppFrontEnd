package com.sanjai.stediofitness.data.model

@kotlinx.serialization.Serializable
data class Cardio(
    val id: Int,
    val exerciseName: String,
    val time: String,
    val image: String,
    val benefits: String
)
