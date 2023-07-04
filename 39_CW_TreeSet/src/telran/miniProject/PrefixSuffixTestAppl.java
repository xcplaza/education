package telran.miniProject;

public class PrefixSuffixTestAppl {

	public static void main(String[] args) {
		String[] words = { "ab", "opuy", "a", "abc" };
//		IPrefixSuffixSearch pss = new PrefixSuffixSearchHash();
		IPrefixSuffixSearch pss = new PrefixSuffixSearchTree();
		pss.addWords(words);
		for (String str : pss.getWordsWithPrefix("ab")) {
			System.out.println(str);
		}
		
		for (String str2 : pss.getWordsWithSufix("bc")) {
			System.out.println(str2);
		}
		System.out.println();
	}

}
