package com.kanyideveloper.starwars.network


import com.kanyideveloper.starwars.models.PeopleResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    //MUESTRA TODOS LOS PERSONAJES PAGE PASA LOS DETALLES AL SIGUIENTE FRAGMENTO
    @GET("people/?page/")
    suspend fun getCharacters(@Query("page") page: Int): PeopleResponse


}