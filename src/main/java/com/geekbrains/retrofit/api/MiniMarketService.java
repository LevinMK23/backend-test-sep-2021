package com.geekbrains.retrofit.api;

import java.util.List;

import com.geekbrains.retrofit.model.ProductDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MiniMarketService {

    @GET("api/v1/products/{id}")
    Call<ProductDto> getProduct(@Path("id") long id);

    @GET("api/v1/products")
    Call<List<ProductDto>> getProducts();

    @POST("api/v1/products")
    Call<ProductDto> createProduct(@Body ProductDto dto);

    // остальные endpoints в соответствии со swagger
    // swagger - http://localhost:8189/market/swagger-ui.html

}
