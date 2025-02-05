package com.example.apple.api

import com.example.apple.utils.PRODUCT
import com.example.apple.utils.PRODUCTS
import com.example.apple.data.ResponseProducts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET(PRODUCTS)
    suspend fun getAllProduct(): Response<ResponseProducts>
    @GET(PRODUCT)
    suspend fun getProduct(@Path("id") id: Int): Response<ResponseProducts.Product>

}