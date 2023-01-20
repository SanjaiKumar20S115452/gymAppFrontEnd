package com.sanjai.stediofitness.data.model

@kotlinx.serialization.Serializable
data class Strengthening(
    val id: Int,
    val exerciseName: String,
    val image: String,
    val classes: List<StrengthClasses>
)
