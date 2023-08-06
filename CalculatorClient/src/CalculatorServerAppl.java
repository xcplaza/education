import server.ProtocolCalculator;

public class CalculatorServerAppl {

	public static void main(String[] args) throws Exception {
		CalculatorServer srv = new CalculatorServer(new ProtocolCalculator(), 2000);
		srv.run();
	}
}
