package telran.books.model;

import java.util.Arrays;
import java.util.concurrent.locks.*;

public class LibraryLocks {
	static final ReadWriteLock booksLock = new ReentrantReadWriteLock();
	static final ReadWriteLock readersLosk = new ReentrantReadWriteLock();
	static final ReadWriteLock recordsLock = new ReentrantReadWriteLock();
	static final ReadWriteLock autorsLock = new ReentrantReadWriteLock();

	static final int BOOKS_INDEX = 0;
	static final int READERS_INDEX = 1;
	static final int RECORDS_INDEX = 2;
	static final int AUTORS_INDEX = 3;

	static final int WRITE_INDEX = 0;
	static final int READ_INDEX = 1;

	static Lock[][] locks;
	static {
		locks = new Lock[2][4];
		ReadWriteLock[] rwl = { booksLock, readersLosk, recordsLock, autorsLock };
		for (int i = 0; i < rwl.length; i++) {
			locks[WRITE_INDEX][i] = rwl[i].writeLock();
			locks[READ_INDEX][i] = rwl[i].readLock();
		}
	}

	private static void lockUnlock(boolean flag, int typeLock, int... indexes) {
		if (flag)
			lock(typeLock, indexes);
		else {
			unlock(typeLock, indexes);
		}
	}

	private static void unlock(int typeLock, int[] indexes) {
		Arrays.sort(indexes);
		for (int i : indexes) {
			locks[typeLock][i].unlock();
		}
	}

	private static void lock(int typeLock, int[] indexes) {
		Arrays.sort(indexes);
		for (int i : indexes) {
			locks[typeLock][i].lock();
		}
	}

	public static void lockUnlock_save(boolean flag) {
		lockUnlock(flag, READ_INDEX, 0, 1, 2, 3);
	}

	public static void lockUnlock_addBookItem(boolean flag) {
		lockUnlock(flag, WRITE_INDEX, BOOKS_INDEX);
		lockUnlock(flag, READ_INDEX, AUTORS_INDEX);
	}

	public static void lockUnlock_addReader(boolean flag) {
		lockUnlock(flag, WRITE_INDEX, READ_INDEX);
	}

	public static void lockUnlock_addBookExemplars(boolean flag) {
		lockUnlock(flag, WRITE_INDEX, BOOKS_INDEX);
	}

	public static void lockUnlock_getReader(boolean flag) {
		lockUnlock(flag, READ_INDEX, READ_INDEX);
	}

	public static void lockUnlock_getBookItem(boolean flag) {
		lockUnlock(flag, READ_INDEX, BOOKS_INDEX);
	}

	public static void lockUnlock_pickBook(boolean flag) {
		lockUnlock(flag, READ_INDEX, READERS_INDEX);
		lockUnlock(flag, WRITE_INDEX, RECORDS_INDEX, BOOKS_INDEX);
	}

	public static void lockUnlock_getBooksPickedByReader(boolean flag) {
		lockUnlock(flag, READ_INDEX, RECORDS_INDEX);
	}

	public static void lockUnlock_getReadersPickedBook(boolean flag) {
		lockUnlock(flag, READ_INDEX, RECORDS_INDEX);
	}

	public static void lockUnlock_getBooksAuthor(boolean flag) {
		lockUnlock(flag, READ_INDEX, AUTORS_INDEX);
	}

	public static void lockUnlock_getPickedRecordsAtDates(boolean flag) {
		lockUnlock(flag, READ_INDEX, RECORDS_INDEX);
	}

	public static void lockUnlock_removeBook(boolean flag) {
		lockUnlock(flag, WRITE_INDEX, BOOKS_INDEX, RECORDS_INDEX, AUTORS_INDEX);
	}

	public static void lockUnlock_removeAuthor(boolean flag) {
		lockUnlock(flag, WRITE_INDEX, AUTORS_INDEX);
	}

	public static void lockUnlock_returnBook(boolean flag) {
		lockUnlock(flag, WRITE_INDEX, RECORDS_INDEX, BOOKS_INDEX);
	}

	public static void lockUnlock_getReadersDelayingBooks(boolean flag) {
		lockUnlock(flag, READ_INDEX, RECORDS_INDEX);
	}

	public static void lockUnlock_getReadersDelayedBooks(boolean flag) {
		lockUnlock(flag, READ_INDEX, RECORDS_INDEX);
	}

	public static void lockUnlock_getMostPopularBooks(boolean flag) {
		lockUnlock(flag, READ_INDEX, RECORDS_INDEX);
	}

	public static void lockUnlock_getMostPopularAuthors(boolean flag) {
		lockUnlock(flag, READ_INDEX, RECORDS_INDEX);
	}

	public static void lockUnlock_getMostActiveReaders(boolean flag) {
		lockUnlock(flag, READ_INDEX, RECORDS_INDEX);
	}

	public static void lockUnlock_getAuthors(boolean flag) {
		lockUnlock(flag, READ_INDEX, RECORDS_INDEX);
	}

}
