package imagga;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import telran.Post;

public class ImaggaAppl {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws URISyntaxException {
		String url = "https://api.imagga.com/v2/tags?image_url=";
		String img = "https://tourweek.ru/upload/resize_cache/main/41a/800_99999_1/41abb4eea24e87ba4d2eb60503169361.jpg";
		RestTemplate rest = new RestTemplate();

//		Solution 1 -> use HttpEntity and HttpHeaders
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Basic YWNjX2E2ZGE3MmNkMGVkMWNlNzo2MzczZTM0MTljOThjNzU1NzVmMjY3MmE5NTI4ODkzMQ==");
		HttpEntity<Void> request = new HttpEntity<>(header);

		ResponseEntity<TagApiResult> response = rest.exchange(url + img, HttpMethod.GET, request, TagApiResult.class);

//		Solution 2 -> use RequestEntity and pattern builder
//		RequestEntity<Void> request1 = RequestEntity.get(new URI(url + img)).header("Authorization",
//				"Basic YWNjX2E2ZGE3MmNkMGVkMWNlNzo2MzczZTM0MTljOThjNzU1NzVmMjY3MmE5NTI4ODkzMQ==").build();
//		ResponseEntity<TagApiResult> response1 = rest.exchange(request1, TagApiResult.class);

//		General
		TagApiResult res = response.getBody();
		if (res.status.type.equals("success"))
			Arrays.stream(res.result.tags)// .filter(t -> t.confidence > 50)
					.forEach(t -> System.out.printf("%s -> %.2f\n", t.tag.get("en"), t.confidence));

//		optional
		url = "https://jsonplaceholder.typicode.com/";
		HttpMethod method = HttpMethod.GET;
		URI uri = new URI(url + "posts?userId=4");
		RequestEntity<Void> req = new RequestEntity<>(method, uri);
		ResponseEntity<Post[]> resp = rest.exchange(req, Post[].class);
		System.out.println(Arrays.toString(resp.getBody()));

//		post
		Post p = new Post(111, 1, "my title", "My body");
		RequestEntity<Post> req1 = RequestEntity.post(new URI(url + "posts")).contentType(MediaType.APPLICATION_JSON)
				.body(p);
		System.out.println(rest.exchange(req1, Post.class));
	}
}
