import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class FileAppl {

	public static void main(String[] args) throws IOException {
		File node = new File("file1");
		System.out.println(node.exists());
		System.out.println(node.createNewFile());
		System.out.println(node.exists());

		File node1 = new File("dir1");
		System.out.println(node1.mkdir());

		File node2 = new File("dir1/dir2/dir3");
		System.out.println(node2.mkdirs());

		File node3 = new File("dir1/dir2", "file1");
		System.out.println(node3.createNewFile());

		File node4 = new File(node2, "file2");
		System.out.println(node4.createNewFile());

		String path = String.format("dir1%1$sdir2%1$sdir3%1$sdir14%1$s", File.separator);
		File node5 = new File(path);
//		File node5 = new File("dir1" + File.separator + "dir2" + File.separator + "dir3");
		System.out.println(node5.mkdir());

		System.out.println("------------------------");
		node5.delete();
		System.out.println(node.isFile());
		System.out.println(node.isDirectory());
		System.out.println(node.canRead());
		System.out.println(node.canWrite());
		System.out.println(node.isHidden());
		System.out.println(node.getAbsolutePath());
		System.out.println(node.getPath());
		System.out.println(node.getParent());
		System.out.println(node5.getParent());
		System.out.println(node.length());
		System.out.println(node.getTotalSpace());
		System.out.println(node.getUsableSpace());
		System.out.println(node.setWritable(false));
		System.out.println(node.setReadable(false));
		System.out.println(node.lastModified());

		System.out.println("------------------------");
		File node6 = new File("dir1/dir2");
		String[] listDir = node6.list();
		System.out.println(Arrays.toString(listDir));

		System.out.println("------------------------");
		pintDir("dir1/dir2");
//		System.out.println("------------------------");
//		pintDir("file1");
//		System.out.println("------------------------");
//		pintDir(".");
//		System.out.println("------------------------");
//		pintDir("..");

		Path p = Paths.get("dir1", "dir12");
		Path p1 = node.toPath();
		File file = p.toFile();
		file.createNewFile();
	}

	private static void pintDir(String path) {
//		dir3 -> is directory
//		file1 -> if file
		File node = new File(path);
		if (!node.exists())
			throw new RuntimeException(path + "not found");
		if (node.isFile())
			System.out.println(node.getName() + " -> " + "is file");
		else {
//			String[] array = node.list();
//			for (String s : array) {
//				File temp = new File(path, s);
//				System.out.printf("%s -> %s\n", temp.getName(), temp.isDirectory() ? "is directory" : "is file");
//			}
//			OR
			Arrays.stream(node.listFiles()).forEach(
					f -> System.out.printf("%s -> %s\n", f.getName(), f.isDirectory() ? "is directory" : "is file"));
		}
	}

}
