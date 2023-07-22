import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFilesAppl {
	final static String FILE_NAME = "film.avi";
	final static String DIR_DEST = "dest/";
	final static String FILE_DEST = DIR_DEST + FILE_NAME;
	final static String OVER = "overwrite";

	public static void main(String[] args) throws Exception {
		copyFile(FILE_NAME, FILE_DEST, OVER);
	}

	private static void copyFile(String fileS, String fileD, String overwrite) throws IOException {
		if (fileS == null || fileD == null || overwrite == null) {
			System.out.println("Wrong parammetrs!");
			return;
		}
		File file1 = new File(fileS);
		if (!file1.exists()) {
			System.out.println("No such file!");
			return;
		}
		File dir = new File(DIR_DEST);
		if (!dir.isDirectory()) {
			boolean created = dir.mkdir();
			if (created)
				System.out.println("Folder has been created and wait copy...");
		}
		File file2 = new File(fileD);
		if (file2.exists() && !(overwrite.equals("overwrite") && !overwrite.isEmpty())) {
			System.out.println("can't overwrite destination file");
			return;
		} else {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(fileS);
				os = new FileOutputStream(fileD);
				byte[] buffer = new byte[16_777_216];
				int length;
				long startTime = System.currentTimeMillis();
				while ((length = is.read(buffer)) > 0) {
					os.write(buffer, 0, length);
				}
				long endTime = System.currentTimeMillis();
				long durationMillis = endTime - startTime;
				System.out.println("file has been copied with bitrate " + "<" + durationMillis + ">");
			} finally {
				is.close();
				os.close();
			}
		}
	}
}