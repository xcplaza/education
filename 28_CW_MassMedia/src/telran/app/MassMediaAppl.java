package telran.app;

import telran.dto.*;
import telran.intrf.IPrintable;

public class MassMediaAppl {

	public static void main(String[] args) {
		MassMedia[] media = { new Newspaper("Times", 156, 20, 9290999), new Newspaper("Build", 5, 12, 3250089),
				new Newspaper("Paper", 120, 10, 6879800), new Journal("PB", 78, 25, false, 9291000),
				new Journal("Glamur", 10, 30, true, 2645800), new Journal("Watch", 10, 10, true, 150),
				new NewsPortal("1Portal", "www.1portal.com", 9291000),
				new NewsPortal("GosDep", "www.gosdep.com", 650650),
				new NewsPortal("OleHadash", "www.olehadash.co.il", 1520970),
				new NewsPortal("Goverment", "www.gov.il", 9291000) };

		displayPrintable(media);
		System.out.println("------ element -------");
		getPrintableElements(media);
		System.out.println("------ rating -------");
		displayMassMediaRatingMoreThen(media, 0);
	}

	private static void displayPrintable(MassMedia[] ar) {
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] instanceof IPrintable) {
				((IPrintable) ar[i]).print();
			}
		}
	}

	private static IPrintable[] getPrintableElements(MassMedia[] ar) {
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] instanceof IPrintable) {
				count++;
			}
		}
		IPrintable[] arr = new IPrintable[count];
		count =0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] instanceof IPrintable) {
				arr[count] = (IPrintable) ar[i];
				count++;
			}
		}
		return arr;
	}

	private static void displayMassMediaRatingMoreThen(MassMedia[] ar, int thresholdRating) {
		for (int i = 0; i < ar.length; i++) {
			MassMedia media = ar[i];
			if (media.getRating() > thresholdRating) {
				System.out.println(media.getName() + ": " + media.getRating());
			}
		}

	}

}
