package br.com.ufape.petshare.auth;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/token")
@RestController
public class TokenController {

    @PostMapping("/")
    public Object token(@RequestBody User user){

        HttpHeaders headers = new HttpHeaders();
        RestTemplate rt = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", user.clientId);
        formData.add("username", user.username);
        formData.add("password", user.password);
        formData.add("grant_type", user.grantType);

        HttpEntity<MultiValueMap<String, String>> entity 
         = new HttpEntity<MultiValueMap<String, String>>(formData, headers);

        var result = rt.postForEntity("http://keycloak:8080/realms/petshare/protocol/openid-connect/token", entity, String.class);

        return result;
    }

    public record User(String password, String clientId, String grantType, String username) {}
    
}
