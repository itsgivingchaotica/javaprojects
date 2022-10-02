public class Paycheck extends Payroll{
	
	String line="";
	double finalPay=0;
	
	public Paycheck(String payLine, double finalPay) {
		this.line = payLine;
		this.finalPay = finalPay;
		
	}
	@Override
	public String toString() {
		return String.format("%10s $%10.2f",payLine,finalPay);
	}
	
	
}
