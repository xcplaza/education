package color;

import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ImaggaClientColorAppl 
{
	public static void main(String[] args) throws URISyntaxException 
	{
		String endPoint = "https://api.imagga.com/v2/colors?image_url=";
		String image_url = "https://www.drusillas.co.uk/images/whats-on-card/redpanda-profile-400x400-984.jpg";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", 
				"Basic YWNjX2ZiMjljYWM3ZDhmZWM4YzozZTIwYmU1ZWQwZmQ4YTRlMzM3Nzk3OTZjYmQwMDJlYQ==");
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<ColorsApiResult> response = restTemplate.exchange(endPoint + image_url, 
				HttpMethod.GET, requestEntity, 
					new ParameterizedTypeReference<ColorsApiResult>() {});

		System.out.println("background_colors");
		printColors(response.getBody().result.colors.background_colors);
		System.out.println();
		System.out.println("foreground_colors");
		printColors(response.getBody().result.colors.foreground_colors);
		System.out.println();
		System.out.println("image_colors");
		printColors(response.getBody().result.colors.image_colors);
	}

	private static void printColors(Color[] colors) 
	{
		System.out.println("name of color | name of parent color | coverage percent");
		System.out.println("-------------------------------------------------------");
		Arrays.stream(colors).forEach(c -> System.out.printf("%13s | %20s | %10.2f\n", 
				c.closest_palette_color, c.closest_palette_color_parent, c.percent));
	}

}
