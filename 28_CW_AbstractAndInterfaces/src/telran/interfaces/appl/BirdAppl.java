package telran.interfaces.appl;

import telran.interfaces.dto.*;

public class BirdAppl {
	public static void main(String[] args) {
		Bird[] birds = {
				new Parrot("parrot", "Gosha"),
				new Parrot("parrot", "Kesha"),
				new Crow("crow", 56),
				new Ostrich("ostrich", 79),
				new Crow("crow", 12)
		};
			runCroak(birds);	
	}

	private static void runCroak(Bird[] birds) {
		for(int i =0; i < birds.length; i++) {
			if(birds[i] instanceof ICroakable) {
				ICroakable temp = (ICroakable) birds[i];
				temp.croak();
			}
		}
	}

}
