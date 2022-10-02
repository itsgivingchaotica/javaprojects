public class Employee {
	private String emplID, emplName, address1, address2;
	private double pay1, pay2, pay3, finalPay;
	
	/**
	 * Employee class saves information about each babysitter
	 * @param id: the babysitter's employee ID
	 * @param name: the babysitter's last name,first name
	 * @param street: the first line of the address
	 * @param cityStateZip: the second line of the address
	 * @param early: the 6pm-9pm pay rate
	 * @param mid: the 9pm-12am pay rate
	 * @param late: the 12am-6am pay rate
	 */
	public Employee(String id, String name, String street, String cityStateZip, double early, double mid, double late)
	{
		emplID = id;
		emplName = name;
		address1 = street;
		address2 = cityStateZip;
		pay1 = early;
		pay2 = mid;
		pay3 = late;
		finalPay = 0;
	}
	/**
	 * addPay method accumulates the pay for each employee
	 * @param pay: the amount paid for the shift
	 */
	public void addPay(double pay) {
		this.finalPay+=pay;
	}
	/**
	 * getFinalPay method
	 * @return the total pay for the employee
	 */
	public double getFinalPay() {
		return finalPay;
	}
	
	// the setter methods are not necessary but I included them anyway 
	
	/**
	 * setEmplID method 
	 * @param id: the babysitter's employee ID
	 */
	public void setEmplID(String id) {
		this.emplID = id;
	}
	/**
	 * setEmplName method
	 * @param name: the babysitter's name
	 */
	public void setEmplName(String name) {
		this.emplName = name;
	}
	/**
	 * setAddress1 method
	 * @param street: the street address, first line
	 */
	public void setAddress1(String street) {
		this.address1 = street;
	}
	/**
	 * setAddress2 method
	 * @param cityStateZip: the second line of the address
	 */
	public void setAddress2(String cityStateZip) {
		this.address2 = cityStateZip;
	}
	/**
	 * setEarlyPay method
	 * @param early: the first tier pay 6pm to 9pm
	 */
	public void setEarlyPay(double early) {
		this.pay1 = early;
	}
	/**
	 * setMidPay method
	 * @param mid: the second tier pay 9pm to 12am
	 */
	public void setMidPay(double mid) {
		this.pay2 = mid;
	}
	/**
	 * setLatePay method
	 * @param late: the third tier pay 12am to 6am
	 */
	public void setLatePay(double late) {
		this.pay3 = late;
	}
	/**
	 * getEmplID
	 * @return the babysitter's employee id
	 */
	public String getEmplID() {
		return emplID;
	}
	/**
	 * getEmplName method
	 * @return the babysitter's name
	 */
	public String getEmplName() {
		return emplName;
	}
	/**
	 * getAddress1 method
	 * @return the street number and name
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * getAddress2 method
	 * @return the city,state,zip code of the employee
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * getPay1 method
	 * @return the first tier pay 6pm to 9pm
	 */
	public double getPay1() {
		return pay1;
	}
	/**
	 * getPay2 method
	 * @return the second tier pay 9pm to 12am
	 */
	public double getPay2() {
		return pay2;
	}
	/**
	 * getPay3 method
	 * @return the third tier pay 12am to 6am
	 */
	public double getPay3() {
		return pay3;
	}

}
