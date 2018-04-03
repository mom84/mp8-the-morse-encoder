package at.refugeescode.morse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
public class MorseEndpoint {

    private String cipher;


    @GetMapping
    String getCipher1(){
        return cipher;
    }

    @PostMapping
    String setCipher(@RequestBody String s) {
        char[] toEncode = s.toCharArray();
        for (int i = 0; i < toEncode.length; i++) {
            if (Character.isLetter(toEncode[i])) {
                toEncode[i] += 2;
            }
        }
        cipher = String.valueOf(toEncode);
        return cipher;
    }



}