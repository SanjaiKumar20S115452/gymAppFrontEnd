package com.sanjai.stediofitness.data.model

@kotlinx.serialization.Serializable
data class StrengthClasses(
    val id: Int,
    val className: String,
    val rep: String
)