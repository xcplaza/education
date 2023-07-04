package telran.miniProject;

import java.util.ArrayList;
import java.util.HashSet;

public class PrefixSuffixSearchHash extends AbstractPreffixSufix {

	public PrefixSuffixSearchHash() {
		set = new HashSet<>();
	}

	@Override
	public String[] getWordsWithPrefix(String prefix) {
		ArrayList<String> resList = new ArrayList<>();
		for (String s : set) {
			if (s.startsWith(prefix)) {
				resList.add(s);
			}
		}
		return resList.toArray(new String[0]);
	}

}
