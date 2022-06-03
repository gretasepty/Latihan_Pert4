package binar.greta.latihan_pert4.api

import binar.greta.latihan_pert4.data.ResponseStafItem
import retrofit2.http.GET

interface ApiService {
    @GET("staf")
    suspend fun getAllStaf() : List<ResponseStafItem>
}