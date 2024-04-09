package test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import payload.User;
import utility.Log;
import utility.TestActions;

import java.security.SecureRandom;
import java.util.Random;

public class AirlineAPITest {
	Faker faker;
	User userPayload;
	long airId;
	private static final String CAPITAL_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final SecureRandom RANDOM = new SecureRandom();
	Logger logger=Log.getlogData(Log.class.getName());

	public static String generateRandomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int randomIndex = RANDOM.nextInt(CAPITAL_CHARACTERS.length());
			char randomChar = CAPITAL_CHARACTERS.charAt(randomIndex);
			sb.append(randomChar);
		}
		return sb.toString();
	}
	
	@BeforeClass
	public void setupData() {
		Faker faker= new Faker();
		
		userPayload=new User();
		userPayload.setAirlineName(faker.name().firstName());
		userPayload.setAirlineName("Airline"+" "+TestActions.generateRandomString(3));
		userPayload.setIata(TestActions.generateRandomString(3));
		userPayload.setIcao(TestActions.generateRandomString(3));
		userPayload.setAlias("TEST");
		userPayload.setCallsign("TEST");
		userPayload.setCreatedBy(154);
		userPayload.setUpdatedBy(154);
	}

	@Test(priority=1)
	public void testCreateAirline() {
		logger.info("verify POST API.");
		Response response=UserEndPoints.createUser(userPayload);
		response.then().log().all();
//		airId=response.path("airlineId") ;
//		System.out.println(airId);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("POST API working properly.");
		
	}
	
	@Test(priority=1)
	public void testGetAirlineById() {
	//	logger.info("verify POST API.");
		Response response=UserEndPoints.getUser();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	//	logger.info("POST API working properly.");
	}
	
	@Test(priority=1)
	public void testGetAirlineByName() {
	//	logger.info("verify POST API.");
		Response response=UserEndPoints.getUserByName(this.userPayload.getAirlineName());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	//	logger.info("POST API working properly.");
	}
	
	@Test(priority=2)
	public void testGetAllAirline() {
		Response response=UserEndPoints.getAllUser();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testUpdateAirline() {
		userPayload.setAlias("TEST123");
		userPayload.setCallsign("TEST123");
		Response response=UserEndPoints.updateUser(userPayload);
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
