package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;

import static io.restassured.RestAssured.*;

public class UserEndPoints {

	
	public static Response createUser(User payload){
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
        .body(payload)
        .header("Authorization", Routes.auth)
        .header("H-CompId", Routes.compId)
        .header("H-BranchId", Routes.branchId)
        .header("H-RequesterId", Routes.requesterId)
		.when()
		.post(Routes.post_url);
		return response;
	}
	
	public static Response getUser(){
		Response response =given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
		        .header("Authorization", Routes.auth)
		        .header("H-CompId", Routes.compId)
		        .header("H-BranchId", Routes.branchId)
		        .header("H-RequesterId", Routes.requesterId)
				.when()
				.get(Routes.getSingle_url);
		return response;
	}
	
	public static Response getUserByName(String name){
		Response response =given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
		        .header("Authorization", Routes.auth)
		        .header("H-CompId", Routes.compId)
		        .header("H-BranchId", Routes.branchId)
		        .header("H-RequesterId", Routes.requesterId)
				.when()
				.get(Routes.getSingle_url);
		return response;
	}
	
	public static Response getAllUser(){
		Response response =given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
		        .header("Authorization", Routes.auth)
		        .header("H-CompId", Routes.compId)
		        .header("H-BranchId", Routes.branchId)
		        .header("H-RequesterId", Routes.requesterId)
				.when()
				.get(Routes.get_url);
		return response;
	}


	public static Response updateUser(User payload){
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
        .body(payload)
        .header("Authorization", Routes.auth)
        .header("H-CompId", Routes.compId)
        .header("H-BranchId", Routes.branchId)
        .header("H-RequesterId", Routes.requesterId)
		.when()
		.put(Routes.put_url);
		return response;
	}

	public static Response deleteUser(String userName){
		Response response =given()
				.pathParam("username", userName)
				.when()
				.delete(Routes.delete_url);
		return response;
	}














	}
