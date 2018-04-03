package at.refugeescode.morse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class MorseEndpointTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @SpyBean
    private MorseEndpoint morseEndpoint;

    private String endpoint = "/morse";

    private String url;

    @BeforeEach
    void before() {
        // prepares the URL of our endpoint
        url = "http://localhost:" + port + endpoint;
    }


    @Test
    void getCipher1() {

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        String result = response.getBody();

        assertEquals(null , result);
        verify(morseEndpoint).getCipher1();

    }

    @Test
    void setCipher() {
        String text = "AAB";
        ResponseEntity<String> response = restTemplate.postForEntity(url, text, String.class);
        System.out.println(response.getBody());
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        String cipher = "CCD";
        assertEquals(cipher, response.getBody());
        verify(morseEndpoint).setCipher(text);
    }
}