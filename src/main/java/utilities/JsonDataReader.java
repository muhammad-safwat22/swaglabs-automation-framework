package utilities;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.CheckoutData;
import models.UserCredentials;

/*
 * JSON Test Data Reader
 *
 * Responsible for:
 * - Reading login credentials
 * - Reading checkout information
 * - Providing test data to test classes

 * printStackTrace()
 * → اطبع الخطأ وكمل التنفيذ
 * throw RuntimeException()
 * → اطبع الخطأ وأوقف التنفيذ فورًا
 */
public class JsonDataReader {

	private JsonNode rootNode;

	// Load JSON file once and store its root node
	public JsonDataReader() {

		try {

			ObjectMapper mapper = new ObjectMapper();

			File jsonFile = new File("src/test/resources/testdata/UserData.json");

			rootNode = mapper.readTree(jsonFile);

			// Fail fast if test data file is missing or corrupted.
		} catch (Exception e) {

			throw new RuntimeException("Failed to load JSON test data file", e);
		}
	}

	// Read and return valid user credentials
	public UserCredentials getValidUser() {

		return new UserCredentials(

				rootNode.get("validUser").get("username").asText(),

				rootNode.get("validUser").get("password").asText());
	}

	// Read and return invalid user credentials
	public UserCredentials getInvalidUser() {

		return new UserCredentials(

				rootNode.get("invalidUser").get("username").asText(),

				rootNode.get("invalidUser").get("password").asText());
	}

	// Read and return checkout information
	public CheckoutData getCheckoutData() {

		return new CheckoutData(

				rootNode.get("checkoutData").get("firstName").asText(),

				rootNode.get("checkoutData").get("lastName").asText(),

				rootNode.get("checkoutData").get("postalCode").asText());
	}
}