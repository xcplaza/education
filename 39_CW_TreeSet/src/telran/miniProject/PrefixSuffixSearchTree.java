package telran.miniProject;

import java.util.TreeSet;

public class PrefixSuffixSearchTree extends AbstractPreffixSufix {

	public PrefixSuffixSearchTree() {
		set = new TreeSet<>();
	}

	@Override
	public String[] getWordsWithPrefix(String prefix) {
		return ((TreeSet<String>) set).subSet(prefix, getPrefixLimit(prefix)).toArray(new String[0]);
	}

	private String getPrefixLimit(String prefix) {
		return prefix.substring(0, prefix.length() - 1) + (char) (prefix.charAt(prefix.length() - 1) + 1);
	}

}
