package com.geekbrains;

import com.geekbrains.db.dao.CategoriesMapper;
import com.geekbrains.db.dao.ProductsMapper;
import com.geekbrains.db.model.Products;
import com.geekbrains.mybatis.MyBatisDbHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.reflectionassert.ReflectionAssertions.assertReflectiveThat;

public class DbTests {

    private static MyBatisDbHelper dbHelper;
    private static ProductsMapper productsMapper;
    private static CategoriesMapper categoriesMapper;

    @BeforeAll
    static void beforeAll() {
        dbHelper = new MyBatisDbHelper();
        productsMapper = dbHelper.getProductsMapper();
        categoriesMapper = dbHelper.getCategoriesMapper();
    }

    @Test
    void testGetProductById() {
        Products actually = productsMapper.selectByPrimaryKey(1L);
        Products expected = new Products();
        expected.setId(1L);
        expected.setTitle("Milk");
        expected.setPrice(95);
        expected.setCategoryId(1L);

        assertReflectiveThat(actually).isEqualTo(expected);
    }

}
