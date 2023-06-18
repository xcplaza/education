
public class StringExpressions {

	public static boolean isEmailCoIlMailRu(String str) {
		if (str == null || str.isBlank())
			return false;
		String pattern = "[^\\s,]+@([a-zA-Z\\d-]+\\.)?(co\\.il|mail\\.ru)";
		return str.matches(pattern);
	}

}