package imagga;

import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ImaggaAppl {

	public static void main(String[] args) throws URISyntaxException {
		String url = "https://api.imagga.com/v2/tags?image_url=";
		String img = "https://tourweek.ru/upload/resize_cache/main/ff4/800_99999_1/ff4e50877729f51038803131160c8077.jpg";
		RestTemplate rest = new RestTemplate();

//		solution 1 -> use HttpEntity and HttpHeaders
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Basic YWNjX2E2ZGE3MmNkMGVkMWNlNzo2MzczZTM0MTljOThjNzU1NzVmMjY3MmE5NTI4ODkzMQ==");
		HttpEntity<Void> request = new HttpEntity<>(header);
		ResponseEntity<TagApiResult> response = rest.exchange(url + img, HttpMethod.GET, request, TagApiResult.class);

//		solution 2 -> use RequestEntity and pattern  builder
//		RequestEntity<Void> request1 = RequestEntity.get(new URI(url + img)).header("Authorization",
//				"Basic YWNjX2E2ZGE3MmNkMGVkMWNlNzo2MzczZTM0MTljOThjNzU1NzVmMjY3MmE5NTI4ODkzMQ==").build();
//		ResponseEntity<TagApiResult> response1 = rest.exchange(request1, TagApiResult.class);

//		General
		TagApiResult res = response.getBody();
		if (res.status.type.equals("success")) {
			Arrays.stream(res.result.tags).filter(t -> t.confidence > 50)
					.forEach(t -> System.out.printf("%s -> %.2f\n", t.tag.get("en"), t.confidence));
		}
	}

}
