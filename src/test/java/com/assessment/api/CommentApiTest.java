package com.assessment.api;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommentApiTest {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Test
    public void getCommentById3() {
        Response res = RestAssured.get(BASE_URL + "/comments/3");
        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertEquals(res.jsonPath().getString("name"), "odio adipisci rerum aut animi");
        Assert.assertEquals(res.jsonPath().getString("email"), "Nikita@garfield.biz");
    }

    @Test
    public void postComment() {
        String body = """
        {
            "postId": 1,
            "name": "Melissa",
            "email": "abc@gmail.com"
        }
        """;

        Response res = RestAssured
                .given()
                .header("Content-type", "application/json")
                .body(body)
                .post(BASE_URL + "/comments");

        Assert.assertEquals(res.statusCode(), 201);
        Assert.assertTrue(res.jsonPath().getInt("id") > 0);
    }

    @Test
    public void getUserById6() {
        Response res = RestAssured.get(BASE_URL + "/users/6");
        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertEquals(res.jsonPath().getString("address.street"), "Norberto Crossing");
        Assert.assertEquals(res.jsonPath().getString("address.city"), "South Christy");
    }
}
