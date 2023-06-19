package telran.dto;
import java.util.Objects;

public class NewsPortal extends MassMedia {
	String url;
	int numberOfUsers;

	public NewsPortal() {
	}

	public NewsPortal(String name, String url, int numberOfUsers) {
		super(name);
		this.url = url;
		this.numberOfUsers = numberOfUsers;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getNumberOfUsers() {
		return numberOfUsers;
	}

	public void setNumberOfUsers(int numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}

	@Override
	public String toString() {
		return "NewsPortal [name=" + name + ", url=" + url + ", numberOfUsers=" + numberOfUsers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numberOfUsers, url);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof NewsPortal))
			return false;
		NewsPortal other = (NewsPortal) obj;
		return numberOfUsers == other.numberOfUsers && Objects.equals(url, other.url);
	}

	@Override
	public int getRating() {
		double rating = (double) numberOfUsers / 9291000 * 10;
		return (int) Math.round(rating);
	}

}
