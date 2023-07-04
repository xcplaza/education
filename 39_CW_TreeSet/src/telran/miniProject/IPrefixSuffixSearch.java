package telran.miniProject;

public interface IPrefixSuffixSearch {
	void addWords(String[] words);
	String[] getWordsWithPrefix(String prefix);
	String[] getWordsWithSufix(String sufix);
	boolean containsWord(String word);
}
