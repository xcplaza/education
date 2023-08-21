
public class ATestAppl {

	public static void main(String[] args) {
		System.out.println("Y annotated by A1: " + AnnotationRecognition.a1_recognition(Y.class));
		System.out.println("X annotated by A1: " + AnnotationRecognition.a1_recognition(X.class));
		System.out.println("A1 annotated by A1: " + AnnotationRecognition.a1_recognition(A1.class));

		X x = new X(1, 5, "Hello");
		AnnotationRecognition.dispayFieldsInfo(x);
	}

}
