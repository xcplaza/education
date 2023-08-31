package telran;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post
{
	public int userId;
	public int id;
	public String title;
	public String body;
}
