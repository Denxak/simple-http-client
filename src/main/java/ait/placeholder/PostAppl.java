package ait.placeholder;

import ait.placeholder.dto.PostDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;

public class PostAppl {
    public static void main(String[] args) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI url = new URI("https://jsonplaceholder.typicode.com/posts?userId=7");
        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, url);
        ResponseEntity<HashSet<PostDto>> response =
                restTemplate.exchange(request, new ParameterizedTypeReference<HashSet<PostDto>>() {});
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders().get("Content-Type"));
        response.getBody().forEach(System.out::println);
    }
}
