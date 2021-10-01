package com.geekbrains;

import java.io.IOException;

import com.geekbrains.retrofit.RetrofitHelper;
import com.geekbrains.retrofit.api.MiniMarketService;
import com.geekbrains.retrofit.model.ProductDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.reflectionassert.ReflectionAssertions.assertReflectiveThat;

public class MiniMarketTest {

    private static MiniMarketService service;

    @BeforeAll
    static void beforeAll() {
        service = RetrofitHelper.getService();
    }

    @Test
    void testGetProductById() throws IOException {
        ProductDto actually = service.getProduct(1).execute().body();
        ProductDto expected = ProductDto.builder()
                .id(1L)
                .title("Milk")
                .price(95)
                .categoryTitle("Food")
                .build();
        assertReflectiveThat(actually).isEqualTo(expected);
    }
}
