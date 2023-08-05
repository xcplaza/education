package telran.statist;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import telran.library.cli.LibraryItem;
import telran.library.entities.Reader;
import telran.library.model.ILibrary;
import telran.view.InputOutput;

public class GetMostActiveReadersItem extends LibraryItem {

	public GetMostActiveReadersItem(InputOutput inOut, ILibrary library) {
		super(inOut, library);
	}

	@Override
	public String displayName() {

		return "Get Most Active Readers";
	}

	@Override
	public void perform() {
	    try {
	        LocalDate fromDate = inOut.inputDate("Enter from Date", "yyyy-MM-dd");
	        List<Reader> readers = library.getMostActiveReaders(fromDate, LocalDate.now());
	        if (fromDate == null)
	            return;
	        if (readers == null) {
	            inOut.outputLine("No readers to display");
	            return;
	        }
	        readers.forEach(inOut::outputLine);
	    } catch (NoSuchElementException e) {
	        // Обработка исключения, когда ввод отсутствует или некорректен.
	        inOut.outputLine("No readers to display");
	    }
	}

}
