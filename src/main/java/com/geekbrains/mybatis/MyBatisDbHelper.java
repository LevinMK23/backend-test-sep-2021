package com.geekbrains.mybatis;

import com.geekbrains.db.dao.CategoriesMapper;
import com.geekbrains.db.dao.ProductsMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisDbHelper {

    private final SqlSession session;

    public MyBatisDbHelper() {
        SqlSessionFactory sessionFactory =
                new SqlSessionFactoryBuilder()
                        .build(getClass().getResourceAsStream("mybatis-config.xml"));

        session = sessionFactory.openSession();
    }

    public ProductsMapper getProductsMapper() {
        return session.getMapper(ProductsMapper.class);
    }

    public CategoriesMapper getCategoriesMapper() {
        return session.getMapper(CategoriesMapper.class);
    }

}
