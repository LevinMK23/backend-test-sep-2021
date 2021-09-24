package com.geekbrains;

import java.io.IOException;
import java.time.Duration;
import java.util.stream.Stream;

import com.geekbrains.retrofit.api.MiniMarketService;
import com.geekbrains.retrofit.model.ProductDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тесты функциональности HelloWorld")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HelloWorldTest {

    private HelloWorld helloWorld;
    private static MiniMarketService miniMarketService;

    @BeforeAll
    static void beforeAll() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8189/market/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        miniMarketService = retrofit.create(MiniMarketService.class);
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 2, 4)
        );
    }

    @BeforeEach
    void setUp() {
        helloWorld = new HelloWorld();
    }

    @Test
    @DisplayName("Тест функции foo")
    @Order(value = 1)
    void testFoo() throws IOException {
        assertEquals(1, helloWorld.foo());
        System.out.println(1);
        ProductDto dto = miniMarketService.getProduct(1).execute().body();
        System.out.println(dto);
    }

    @Order(value = 2)
    @DisplayName("Тесты для суммы двух чисел")
    @ParameterizedTest(name = "Тест №{index}. {0} + {1} = {2}")
    @MethodSource("data")
    void testSum(int a, int b, int expected) {
        assertEquals(expected, helloWorld.sum(a, b));
        System.out.println(2);
    }

    @Order(value = 3)
    @Test
    @DisplayName("Тест деление на 0")
    void testThrowException() {
        assertThrows(
                ArithmeticException.class,
                () -> helloWorld.badFoo(3)
        );
        System.out.println(3);
    }

    @Order(value = 4)
    @Test
    @DisplayName("Тест на скорость и качество сортировки")
    void testArraySorted() {

        assertTimeoutPreemptively(
                Duration.ofMillis(500),
                () -> helloWorld.longFoo()
        );

        int[] foo = helloWorld.longFoo();
        for (int i = 0; i < foo.length - 1; i++) {
            assertTrue(foo[i] <= foo[i + 1]);
        }

        System.out.println(4);
    }
}