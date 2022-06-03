package binar.greta.latihan_pert4

import binar.greta.latihan_pert4.api.ApiService
import binar.greta.latihan_pert4.data.ResponseStafItem
import javax.inject.Inject

class StafRepository @Inject constructor(private val stafapi : ApiService) {
    suspend fun getStaf() : List<ResponseStafItem>{
        return stafapi.getAllStaf()
    }
}