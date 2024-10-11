package ait.imagga;

import ait.imagga.dto.TagsResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class ImaggaTagsAppl {
    public static void main(String[] args) throws URISyntaxException {
        String imgUrl = "https://static.insales-cdn.com/images/products/1/2006/258369494/fa4a474aa7f6b013fb7d3791ccbda094.jpg";
        String lang = "uk";
        int threshold = 30;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWNjXzI5NzNmYjU3ZGI1ZjQxNjpjMTE0OWYzM2M5NTFjMTE5ZTYyYzJjMTYzOTgzMjdmMw==");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.imagga.com/v2/tags")
                .queryParam("image_url", imgUrl)
                .queryParam("language", lang)
                .queryParam("threshold", threshold);
//        System.out.println(builder.toUriString());
        URI url = builder.build().toUri();
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, url);
        ResponseEntity<TagsResponseDto> response = restTemplate.exchange(request, TagsResponseDto.class);
        response.getBody().getResult().getTags().forEach(System.out::println);
    }
}
