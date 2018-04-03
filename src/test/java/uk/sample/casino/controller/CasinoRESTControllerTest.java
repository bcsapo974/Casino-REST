package uk.sample.casino.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test class for the CasinoREST Controller
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ConditionalOnWebApplication
public class CasinoRESTControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    public CasinoRESTControllerTest() {
    }

    /**
     * Test of getAllPerson method, of class CasinoRESTController.
     */
    @Test
    public void testGetAllPerson() {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/person/all", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).contains("Cathy");    }

}
