package com.sanjai.stediofitness.data.repository

import com.sanjai.stediofitness.data.api.StedioFitnessApi
import com.sanjai.stediofitness.data.model.Cardio
import com.sanjai.stediofitness.data.model.StrengthClasses
import com.sanjai.stediofitness.data.model.Strengthening
import com.sanjai.stediofitness.data.util.Resource
import com.sanjai.stediofitness.domain.repository.StedioFitnessRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StedioFitnessRemoteDataSourceImpl(
    private val api: StedioFitnessApi
): StedioFitnessRemoteDataSource {

    override fun getAllCardio(): Flow<Resource<List<Cardio>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val apiResponse = api.getAllCardio()
            if(apiResponse.cardio!!.isNotEmpty()) {
                emit(Resource.Success(data = apiResponse.cardio))
                emit(Resource.Loading(isLoading = false))
            }
            emit(Resource.Loading(isLoading = false))
        }
    }

    override fun getAllStrengthening(): Flow<Resource<List<Strengthening>>> {
        return flow {
            emit(Resource.Loading(isLoading = false))
            val apiResponse = api.getAllStrengthening()
            if(apiResponse.strengthening!!.isNotEmpty()) {
                emit(Resource.Success(data = apiResponse.strengthening))
                emit(Resource.Loading(isLoading = false))
            }
            emit(Resource.Loading(isLoading = false))
        }
    }

    override fun getSelectedStrengthClasses(classId: Int): Flow<Resource<List<StrengthClasses>>> {
        return flow {
            emit(Resource.Loading(isLoading = false))
            val apiResponse = api.getAllStrengthening(classId = classId)
            if(apiResponse.strengthClasses!!.isNotEmpty()) {
                emit(Resource.Success(data = apiResponse.strengthClasses))
                emit(Resource.Loading(isLoading = false))
            }
            emit(Resource.Loading(isLoading = false))
        }
    }

}