package telran.librarian;

import java.time.LocalDate;

import telran.books.dto.Reader;
import telran.library.cli.LibraryItem;
import telran.books.model.ILibrary;
import telran.view.InputOutput;

public class AddReaderItem extends LibraryItem {

	public AddReaderItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
	}

	@Override
	public String displayName() {
		return "Add reader";
	}

	@Override
	public void perform() {
		Integer readerId = inOut.inputInteger("Enter reader ID");
		if (readerId == null || readerId < 0)
			return;
		String nameReader = inOut.inputString("Enter name reader");
		if (nameReader == null || nameReader.isEmpty())
			return;
		String phone = inOut.inputString("Enter number phone reader");
		if (phone == null || phone.isEmpty())
			return;
		LocalDate birthDate = inOut.inputDate("Enter birth date reader in format", "yyyy-MM-dd");
		if (birthDate == null)
			return;
		Reader reader = new Reader(readerId, nameReader, phone, birthDate);
		inOut.outputLine(library.addReader(reader));
	}

}
