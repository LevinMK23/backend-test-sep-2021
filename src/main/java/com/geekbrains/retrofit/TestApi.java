package com.geekbrains.retrofit;

import java.io.IOException;
import java.util.List;

import com.geekbrains.retrofit.api.MiniMarketService;
import com.geekbrains.retrofit.model.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestApi {

    private static final Logger log = LoggerFactory.getLogger(TestApi.class);

    public static void main(String[] args) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8189/market/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MiniMarketService marketService = retrofit.create(MiniMarketService.class);

        ProductDto product = marketService.getProduct(1)
                .execute()
                .body();

        List<ProductDto> products = marketService.getProducts()
                .execute()
                .body();

        System.out.println("product: " + product);
        System.out.println("products: " + products);


        System.out.println(1);
        System.out.println(2);

        ProductDto dto = ProductDto.builder()
                .title("Coca cola")
                .categoryTitle("Food")
                .price(35)
                .build();

        ProductDto body = marketService.createProduct(dto).execute().body();
        System.out.println(body);

    }
}
