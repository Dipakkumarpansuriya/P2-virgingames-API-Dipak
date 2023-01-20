package com.virgin.myfirsttest;

import com.virgin.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.parsing.Parser.JSON;
import static org.hamcrest.Matchers.*;


public class MyFirstTest extends TestBase {

    List<String> a;

    static ValidatableResponse response;

    @Test()
    public void test01() {
        RestAssured.registerParser("text/plain", JSON); //This will convert text data in json
        response = given()
                .when()
                .get("/GetBingoLobbyFeed.do")//no need to pass full path as it is run in TestBase so only testing /list endpoint
                .then().log().all().statusCode(200);

        //verify diffrent senarios from get
        response.body("bingoLobbyInfoResource.streams[2].streamName", equalTo("virgingamessession"));
        response.body("bingoLobbyInfoResource.streams[2].streamId", equalTo(309));
        response.body("bingoLobbyInfoResource.ventureId", equalTo(14));


    }

}
