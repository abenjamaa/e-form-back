package fr.ea.abj.eattestationback;

import fr.ea.abj.eattestationback.web.v1.dto.EnterpriseV1;
import lombok.NonNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EAttestationBackApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	@Test
	public void shouldReturn500WhenSiretIsNull() throws URISyntaxException
	{
		//GIVEN
		EnterpriseV1 enterpriseV1 = getEnterpriseV1("enterprise",null, true, false, true);
		HttpEntity<EnterpriseV1> request = getEnterpriseV1HttpEntity(enterpriseV1);
		URI uri = getUri();

		//WHEN
		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		//THEN
		assertThat(result.getStatusCode().value()).isEqualTo(500);
		assertThat(result.getBody()).contains("siret cannot be null or Empty");
	}

	@Test
	public void shouldReturn500WhenSiretIsNotOnlyNumeric() throws URISyntaxException
	{
		//GIVEN
		EnterpriseV1 enterpriseV1 = getEnterpriseV1("enterprise","AZEERRZZER", true, false, true);
		HttpEntity<EnterpriseV1> request = getEnterpriseV1HttpEntity(enterpriseV1);
		URI uri = getUri();

		//WHEN
		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		//THEN
		assertThat(result.getStatusCode().value()).isEqualTo(500);
		assertThat(result.getBody()).contains("siret length must contain only numbers");
	}

	@Test
	public void shouldReturn500WhenSiretLengthDifferentThenFourteen() throws URISyntaxException
	{
		//GIVEN
		EnterpriseV1 enterpriseV1 = getEnterpriseV1("enterprise","12345679456", true, false, true);
		HttpEntity<EnterpriseV1> request = getEnterpriseV1HttpEntity(enterpriseV1);
		URI uri = getUri();

		//WHEN
		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		//THEN
		assertThat(result.getStatusCode().value()).isEqualTo(500);
		assertThat(result.getBody()).contains("siret length must be 14");
	}

	@Test
	public void shouldReturn500WhenEnterpriseIsNull() throws URISyntaxException
	{
		//GIVEN
		EnterpriseV1 enterpriseV1 = getEnterpriseV1(null,"12345678912345", true, false, true);
		HttpEntity<EnterpriseV1> request = getEnterpriseV1HttpEntity(enterpriseV1);
		URI uri = getUri();

		//WHEN
		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		//THEN
		assertThat(result.getStatusCode().value()).isEqualTo(500);
		assertThat(result.getBody()).contains("enterprise cannot be null or Empty");
	}

	@Test
	public void shouldReturn500WhenEnterpriseIsEmpty() throws URISyntaxException
	{
		//GIVEN
		EnterpriseV1 enterpriseV1 = getEnterpriseV1("","12345678912345", true, false, true);
		HttpEntity<EnterpriseV1> request = getEnterpriseV1HttpEntity(enterpriseV1);
		URI uri = getUri();

		//WHEN
		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		//THEN
		assertThat(result.getStatusCode().value()).isEqualTo(500);
		assertThat(result.getBody()).contains("enterprise cannot be null or Empty");
	}

	@Test
	public void shouldReturn500WhenEIso9001IsNull() throws URISyntaxException
	{
		//GIVEN
		EnterpriseV1 enterpriseV1 = getEnterpriseV1("enterprise","12345678912345", null, false, true);
		HttpEntity<EnterpriseV1> request = getEnterpriseV1HttpEntity(enterpriseV1);
		URI uri = getUri();

		//WHEN
		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		//THEN
		assertThat(result.getStatusCode().value()).isEqualTo(500);
		assertThat(result.getBody()).contains("iso9001 cannot be null");
	}

	@Test
	public void shouldReturn500WhenEIso27001IsNull() throws URISyntaxException
	{
		//GIVEN
		EnterpriseV1 enterpriseV1 = getEnterpriseV1("enterprise","12345678912345", true, null, true);
		HttpEntity<EnterpriseV1> request = getEnterpriseV1HttpEntity(enterpriseV1);
		URI uri = getUri();

		//WHEN
		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		//THEN
		assertThat(result.getStatusCode().value()).isEqualTo(500);
		assertThat(result.getBody()).contains("iso27001 cannot be null");
	}

	@Test
	public void shouldReturn500WhenEIso45001IsNull() throws URISyntaxException
	{
		//GIVEN
		EnterpriseV1 enterpriseV1 = getEnterpriseV1("enterprise","12345678912345", true, true, null);
		HttpEntity<EnterpriseV1> request = getEnterpriseV1HttpEntity(enterpriseV1);
		URI uri = getUri();

		//WHEN
		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		//THEN
		assertThat(result.getStatusCode().value()).isEqualTo(500);
		assertThat(result.getBody()).contains("iso45001 cannot be null");
	}

	@Test
	public void shouldRetrunOkWhenCreateNewEnterprise() throws URISyntaxException
	{
		//GIVEN
		EnterpriseV1 enterpriseV1 = getEnterpriseV1("enterprise","98765432198765", true, true, true);
		HttpEntity<EnterpriseV1> request = getEnterpriseV1HttpEntity(enterpriseV1);
		URI uri = getUri();

		//WHEN
		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		//THEN
		assertThat(result.getStatusCode().value()).isEqualTo(200);
		assertThat(result.getBody()).isEqualTo("enterprise : enterprise with SIRET : 98765432198765 saved !");
	}

	@Test
	public void shouldRetrunEnterpriseAlreadyCreatedWhenSiretExistInDataBase() throws URISyntaxException
	{
		//GIVEN
		EnterpriseV1 enterpriseV1 = getEnterpriseV1("enterprise","12345678912345", true, true, true);
		HttpEntity<EnterpriseV1> request = getEnterpriseV1HttpEntity(enterpriseV1);
		URI uri = getUri();

		//WHEN
		this.restTemplate.postForEntity(uri, request, String.class);
		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

		//THEN
		assertThat(result.getStatusCode().value()).isEqualTo(200);
		assertThat(result.getBody()).isEqualTo("Siret already exist in database");
	}


	private static EnterpriseV1 getEnterpriseV1(String enterprise, String siret, Boolean iso9001, Boolean iso27001, Boolean iso45001 ) {

		return EnterpriseV1.builder()
				.enterprise(enterprise)
				.siret(siret)
				.iso9001(iso9001)
				.iso27001(iso27001)
				.iso45001(iso45001)
				.build();
	}

	@NonNull
	private URI getUri() throws URISyntaxException {
		final String baseUrl = "http://localhost:"+randomServerPort+"/v1/certifications/add-enterprise";
		return new URI(baseUrl);
	}

	@NonNull
	private static HttpEntity<EnterpriseV1> getEnterpriseV1HttpEntity(EnterpriseV1 enterpriseV1) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");
		return new HttpEntity<>(enterpriseV1, headers);
	}

}
