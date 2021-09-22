package com.geekbrains;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ImgurApiTest {

    private static int commentId;

    void common() {

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .build();

        given()
                .spec(requestSpecification)
                .response()
                .spec(responseSpecification);
    }

    @Test
    @DisplayName("Получение информации об аккаунте")
    @Order(1)
    void testGetAccountBase() {
        given()
                .header("Authorization", "Client-ID 245e10b28ddc002")
                .log()
                .all()
                .expect()
                .statusCode(200)
                .body("data.id", is(153514053))
                .body("data.url", is("levinmk23"))
                .body("success", is(true))
                .log()
                .all()
                .when()
                .get("https://api.imgur.com/3/account/levinmk23");
    }

    @Test
    @DisplayName("Не валидный токен при создании комментария")
    @Order(2)
    void testPostComment() {

        commentId = given().auth()
                .oauth2("76ee37117ac4d779519a9a287ef92c40e543334e")
                .formParam("image_id", "4jZlZEJ")
                .formParam("comment", "My comment 3")
                .expect()
                .statusCode(200)
                .body("success", is(true))
                .body("data.id", Matchers.notNullValue())
                .log()
                .body()
                .when()
                .post("https://api.imgur.com/3/comment")
                .jsonPath()
                .getInt("data.id");

    }

    @Test
    @Order(3)
    void testGetComment() {
        given()
                .header("Authorization", "Client-ID 245e10b28ddc002")
                .log()
                .all()
                .expect()
                .body("data.id", is(commentId))
                .body("data.image_id", is("4jZlZEJ"))
                .body("data.comment", is("My comment 3"))
                .statusCode(200)
                .log()
                .all()
                .when()
                .get("https://api.imgur.com/3/comment/" + commentId);
    }

    @Test
    @Order(4)
    void testDeleteComment() {
        given()
                .auth()
                .oauth2("76ee37117ac4d779519a9a287ef92c40e543334e")
                .expect()
                .statusCode(200)
                .log()
                .all()
                .when()
                .delete("https://api.imgur.com/3/comment/" + commentId);
    }

    @Test
    @Order(5)
    void testCommentNotExist() {
        String actually = given()
                .header("Authorization", "Client-ID 245e10b28ddc002")
                .expect()
                .log()
                .all()
                .when()
                .get("https://api.imgur.com/3/comment/1")
                .body()
                .prettyPrint();
        Assertions.assertTrue(actually.contains("<title>imgur: the simple 404 page</title>"));
    }


}
