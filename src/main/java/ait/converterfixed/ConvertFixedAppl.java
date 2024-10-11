package ait.converterfixed;

import ait.converterfixed.dto.ResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class ConvertFixedAppl {
    public static void main(String[] args) {
        String from = "usd";
        String to = "eur";
        double amount = 1000.0;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("apikey", "APIKEY");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.apilayer.com/fixer/convert")
                .queryParam("from", from)
                .queryParam("to", to)
                .queryParam("amount", amount);
        System.out.println(builder.toUriString());
        URI url = builder.build().toUri();
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, url);
        ResponseEntity<ResponseDto> response = restTemplate.exchange(request, ResponseDto.class);
        System.out.println(response.getBody().getInfo().getRate());
        System.out.println(response.getBody().getQuery().getAmount());
        System.out.println(response.getBody().getResult());
    }
}
