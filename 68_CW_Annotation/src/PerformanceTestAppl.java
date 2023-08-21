
public class PerformanceTestAppl {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("at least one class should be in the arguments");
			return;
		}
		for (int i = 0; i < args.length; i++) {
			try {
				Object obj = Class.forName(args[i]).getConstructor().newInstance();
				PerformanceFrameWork.run(obj);
			} catch (Exception e) {
				System.out.printf("class %s doesn't exist", args[i]);
			}
		}
	}

}
