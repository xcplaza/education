package telran.dto;
import java.util.Objects;

public class WebSite extends MassMedia {
	String url;
	String author;
	int numberOfUsers;

	public WebSite() {
	}

	public WebSite(String name, String url, String author, int numberOfUsers) {
		super(name);
		this.url = url;
		this.author = author;
		this.numberOfUsers = numberOfUsers;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOfUsers() {
		return numberOfUsers;
	}

	public void setNumberOfUsers(int numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}

	@Override
	public String toString() {
		return "WebSite [name=" + name + ", url=" + url + ", author=" + author + ", numberOfUsers=" + numberOfUsers
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(author, numberOfUsers, url);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof WebSite))
			return false;
		WebSite other = (WebSite) obj;
		return Objects.equals(author, other.author) && numberOfUsers == other.numberOfUsers
				&& Objects.equals(url, other.url);
	}

	@Override
	public int getRating() {
		double rating = (double) numberOfUsers / 9291000 * 10;
		return (int) Math.round(rating);
	}

}
