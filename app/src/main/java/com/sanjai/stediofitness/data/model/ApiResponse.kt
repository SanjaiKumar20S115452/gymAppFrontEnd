package com.sanjai.stediofitness.data.model

@kotlinx.serialization.Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val cardio: List<Cardio>? = null,
    val strengthening: List<Strengthening>? = null,
    val strengthClasses: List<StrengthClasses>? = null
)
