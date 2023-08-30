package imagga;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ColorAppl {

	public static void main(String[] args) {
		String url = "https://api.imagga.com/v2/colors?image_url=";
		String img = "";
		RestTemplate rest = new RestTemplate();

		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Basic YWNjX2E2ZGE3MmNkMGVkMWNlNzo2MzczZTM0MTljOThjNzU1NzVmMjY3MmE5NTI4ODkzMQ==");
		HttpEntity<Void> request = new HttpEntity<>(header);
		ResponseEntity<TagColorApi> response = rest.exchange(url + img, HttpMethod.GET, request, TagColorApi.class);
		
		TagColorApi res = response.getBody();
		if (res.status.type.equals("success")) {
			
			
//			Arrays.stream(res.result_color.colors).filter(t -> t.color_percent_threshold > 50)
//					.forEach(t -> System.out.printf("%s -> %.2f\n", t.tag.get("en"), t.confidence));
		}		
	}

}
