public class TimePunch {
	
	private String start;
	private String end;
	private Employee employee;
	double finalPay;
	
	/**
	 * TimePunch class creates a time punch from the hours listed for each babysitter
	 * @param start: the start time of a shift
	 * @param end: the end time of a shift
	 * @param employee: the employee class object placeholder for the babysitter who worked that shift 
	 */
	public TimePunch (String start, String end, Employee employee) {
		this.start = start;
		this.end = end;
		this.employee = employee;
	}
	
	// the setter methods are not necessary but I included them anyway 
	
	/**
	 * setStart method
	 * @param s the start time of the shift
	 */
	public void setStart(String s) {
		start = s;
	}
	/**
	 * setEnd method
	 * @param e the end time of the shift
	 */
	public void setEnd(String e) {
		end = e;
	}
	/**
	 * setEmployee method
	 * @param empl the employee object 
	 */
	public void setEmployee(Employee empl) {
		employee = empl;
	}
	
	/**
	 * getStart method
	 * @return the start time of the shift
	 */
	public String getStart() {
		return start;
	}
	/**
	 * getEnd method
	 * @return the end time of the shift
	 */
	public String getEnd() {
		return end;
	}
	
	/**
	 * calculatePay method calculates the pay for the different hours worked taking into account the different pay rates for each employee
	 * @return the total pay for the shift
	 */
	public double calculatePay() {
		//separate the minutes from hours for start and end times in order to calculate pay 
		String thisStart = getStart();
		int c = thisStart.indexOf(':');
		String hourStart = thisStart.substring(0, c);
		String minutesStart = thisStart.substring(c + 1);
		String thisEnd = getEnd();
		int d = thisEnd.indexOf(':');
		String hoursEnd = thisEnd.substring(0, d);
		String minutesEnd = thisEnd.substring(d + 1);
		
		//string to integer in order to carry out calculations
		int hour1 = Integer.parseInt(hourStart);
		int hour2 = Integer.parseInt(hoursEnd);
		int minutes1 = Integer.parseInt(minutesStart);
		int minutes2 = Integer.parseInt(minutesEnd);
		
		//conditional statements to determine the calculations needed for each shift worked
		//for hours worked between 6 and 9
		if (hour1>=6 && hour1<9) { 
			if (hour2>=6 && hour2<9) { 
				if (hour2<9) {
				return employee.getPay1()*((hour2-hour1) + (Math.abs(((double) minutes1/60) - ((double)minutes2/60))));
				}
			}
			//hours worked between 6 and 12
			else if (hour2>=9 && hour2<12) { 
				double paytype2 = employee.getPay1()*(9-hour1) + 
						(employee.getPay2())*((hour2-9) + ((Math.abs(((double) minutes1/60) - ((double)minutes2/60)))));
				return paytype2; 
			}
			else if (hour2<6 || hour2==12) { 
				//hours worked ending at midnight
				if (hour2==12) {
				double paytype3 = employee.getPay1()*3 + (employee.getPay2())*((hour2-6) 
						+ ((double)minutes1)/60) + (employee.getPay3())*((hour2/12)+((Math.abs(((double) minutes1/60) - ((double)minutes2/60)))));
					return paytype3;
				}
				//hours worked from 6pm until early morning (before 6am)
				else if (hour2<6){ //7pm to 5:30am
					double paytype4 = employee.getPay1()*(9-hour1) + (employee.getPay2())*3 
							+ (employee.getPay3())*(((hour2)+(Math.abs(((double) minutes1/60) 
									- ((double)minutes2/60)))));
					return paytype4;
				}
			}
			//hours worked between 9pm and midnight
		} else if (hour1>=9 && hour1<12) { 
			if (hour2<12 && hour2>=9) { 
				double paytype5 = employee.getPay2()*((hour2-hour1) + ((Math.abs(((double) minutes1/60) 
						- ((double)minutes2/60)))));
			return paytype5;
			}
			//hours worked between 9pm and 6am
			else if (hour2>0 && hour2<=6) { //9:30pm to 1am or let's say 10:15pm to 1:45am
				double paytype6 = (employee.getPay2())*((12-hour1) - ((double) minutes1/60))  //12-10 = 2
						+ (employee.getPay3())*((hour2)+ ((double)minutes2/60));
				return paytype6;
			}
		}
	//hours worked between midnight and 6am
		else if ((hour1<6 || hour1==12) && hour2<6) {
			{
				if (hour1==12) { //12:15 to 2:45
					double paytype7 = (employee.getPay3()*((hour2) - ((double)minutes2/60)-(double)minutes1/60)); 
					return paytype7;
			
				}
			//between 1am and 6am
			else if (hour1<6) { //1:15 to 4:45
				double paytype8 = (employee.getPay3()*((hour2-hour1) + (Math.abs(((double) minutes1/60) - ((double)minutes2/60))))); //
				return paytype8;
				}
			}
		
		}	
	
	return -1;
	}
}
