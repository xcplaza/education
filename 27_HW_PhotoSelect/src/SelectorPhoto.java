import java.util.regex.Pattern;

public class SelectorPhoto {

	public static String[] selectPictures(String[] pictures, String regExp) {
		int selectedCount = 0;
		Pattern pattern = Pattern.compile(regExp);

		for (String picture : pictures) {
			if (pattern.matcher(picture).find()) {
				selectedCount++;
			}
		}

		String[] selectedPictures = new String[selectedCount];
		int index = 0;
		for (String picture : pictures) {
			if (pattern.matcher(picture).find()) {
				selectedPictures[index++] = picture;
			}
		}

		return selectedPictures;
	}
}
