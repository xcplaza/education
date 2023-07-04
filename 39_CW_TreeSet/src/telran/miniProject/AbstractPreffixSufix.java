package telran.miniProject;

import java.util.ArrayList;
import java.util.Set;

public abstract class AbstractPreffixSufix implements IPrefixSuffixSearch {
	Set<String> set;

	@Override
	public void addWords(String[] words) {
		for (String str : words) {
			set.add(str);
		}
	}

	@Override
	public String[] getWordsWithSufix(String sufix) {
		ArrayList<String> resList = new ArrayList<>();
		for (String s : set) {
			if (s.endsWith(sufix)) {
				resList.add(s);
			}
		}
		return resList.toArray(new String[0]);
	}

	public boolean containsWord(String word) {
		return set.contains(word);
	}
}
