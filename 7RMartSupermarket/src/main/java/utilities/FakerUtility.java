package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {
	Faker faker = new Faker();

	public String createARandomFirstName() {

		return faker.name().firstName();

	}

	public String createARandomLastName() {

		return faker.name().lastName();

	}

	public String generateAddress() {

		return faker.address().fullAddress();

	}

	public String generateEmail() {

		return faker.internet().emailAddress();

	}
}
