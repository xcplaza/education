package telran;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RestClientAppl {

	public static void main(String[] args) {
		String base_url = "https://jsonplaceholder.typicode.com/";
		RestTemplate rest = new RestTemplate();

//		ResponseEntity<String> response = rest.exchange(base_url + "posts/1", HttpMethod.GET, null, String.class);
//		System.out.println(response);

		ResponseEntity<List<Post>> res = rest.exchange(base_url + "posts", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Post>>() {});
		Post post = res.getBody().stream().max((p1, p2) -> p1.title.length() - p2.title.length()).orElse(null);
		System.out.println(post);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(base_url).queryParam("tId", 1).queryParam("postId", 1).queryParam("p", 1);
		System.out.println(builder.toString());
		
//		https://jsonplaceholder.typicode.com/comments?tId=1&postId=1&p=1 - request params
//		https://jsonplaceholder.typicode.com/posts/1/comments - path variable
		
//		Basic YWNjX2E2ZGE3MmNkMGVkMWNlNzo2MzczZTM0MTljOThjNzU1NzVmMjY3MmE5NTI4ODkzMQ==
		

	}

}
