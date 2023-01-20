package com.sanjai.stediofitness.domain.repository

import com.sanjai.stediofitness.data.model.Cardio
import com.sanjai.stediofitness.data.model.StrengthClasses
import com.sanjai.stediofitness.data.model.Strengthening
import com.sanjai.stediofitness.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface StedioFitnessRemoteDataSource {
    fun getAllCardio(): Flow<Resource<List<Cardio>>>
    fun getAllStrengthening(): Flow<Resource<List<Strengthening>>>
    fun getSelectedStrengthClasses(classId: Int): Flow<Resource<List<StrengthClasses>>>
}