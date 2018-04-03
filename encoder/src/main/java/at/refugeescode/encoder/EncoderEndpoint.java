package at.refugeescode.encoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/encoder")
public class EncoderEndpoint {


    @GetMapping
    String getCiphertext(){
        RestTemplate restTemplate = new RestTemplate();
        String message = "ABC";
        String morseUrl = "http://localhost:8081/morse";
        String collectLetter = "";
        for(String s : message.split("")){
            restTemplate.postForEntity(morseUrl , s , String.class);
            ResponseEntity<String> forEntity = restTemplate.getForEntity(morseUrl, String.class);
            String myText = forEntity.getBody();
            collectLetter = collectLetter + myText;
        }

        return collectLetter;
    }


}
