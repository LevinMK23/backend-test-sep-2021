package com.geekbrains.mybatis;

import java.util.List;

import com.geekbrains.User;
import com.geekbrains.db.dao.ProductsMapper;
import com.geekbrains.db.model.Products;
import com.geekbrains.db.model.ProductsExample;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

    public static void main(String[] args) {
        SqlSessionFactory sessionFactory =
                new SqlSessionFactoryBuilder()
                        .build(Test.class.getResourceAsStream("mybatis-config.xml"));

        SqlSession session = sessionFactory.openSession();

        ProductsMapper mapper = session.getMapper(ProductsMapper.class);
        Products product = mapper.selectByPrimaryKey(1L);
        System.out.println(product);

        ProductsExample example = new ProductsExample();
        example.createCriteria()
                .andTitleEqualTo("Milk");

        List<Products> example1 = mapper.selectByExample(example);
        System.out.println(example1);
    }
}
