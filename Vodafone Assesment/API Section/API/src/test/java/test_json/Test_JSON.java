package test_json;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Test_JSON {
    @Test
    public void validate_response_code_status_test1(){
        given().get("https://jsonplaceholder.typicode.com/posts/1").then().assertThat().statusCode(200);
    }
    @Test
    public void validate_response_code_status_test2(){
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
        Assert.assertEquals(200,response.statusCode());
    }
    @Test
    public void validate_response_body_test1(){
        given().get("https://jsonplaceholder.typicode.com/posts/1").then().assertThat().body("userId",equalTo(1));
    }
    @Test
    public void validate_response_body_test2(){
        given().get("https://jsonplaceholder.typicode.com/posts/1").then().assertThat().body("id",equalTo(1));
    }
    @Test
    public void validate_response_body_test3(){
        given().get("https://jsonplaceholder.typicode.com/posts/1").then().assertThat().body("title",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }
    @Test
    public void validate_response_body_test4(){
        given().get("https://jsonplaceholder.typicode.com/posts/1").then().assertThat().body("body",equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
    }
    //Another way to write the code
    @Test
    public void validate_one_time() {
        given().get("https://jsonplaceholder.typicode.com/posts/1").then().assertThat().statusCode(200).and().
                assertThat().body("userId", equalTo(1)).and().
                assertThat().body("id", equalTo(1)).and().
                assertThat().body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")).and().
                assertThat().body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
    }
}
