import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;


public class Payroll {
	private List<Employee> employees;
	String payLine;
	
	/**
	 * Payroll class is an ArrayList of Employee class objects
	 */
	public Payroll() {
		employees = new ArrayList<Employee>();
	}
	
	/**
	 * addLine method adds an Employee class object to the payroll ArrayList
	 * @param empl the Employee class object being added
	 */
	public void addLine(Employee empl) {
		employees.add(empl);
	}
	
	/**
	 * getEmployee finds the employee at the position in the ArrayList
	 * @param index: the position in the ArrayList that the employee ID is listed
	 * @return the Employee class object at the specified index
	 */
	public Employee getEmployee(int index) {
		return employees.get(index);
	}
	
	/**
	 * findEmplIndex method finds the index of ArrayList which the ID is listed 
	 * @param emplID: the babysitter ID
	 * @return the index that the babysitter ID is listed in the ArrayList
	 */
	public int findEmplIndex(String emplID){
		int index = 0;
		String employeeInfo = "";
		for (int i = 0; i < employees.size(); i++)
		{
			employeeInfo = employees.get(i).getEmplID();
			if (emplID.equals(employeeInfo))
			{
				index = i;
				return index;
			}
		}
		return 0;
	}
	
	/**
	 * issuePaychecks writes the paychecks to an external file for the ArrayList of payroll employees
	 * Before printing it sorts the paychecks by last name in ascending order
	 * @throws IOException
	 */
	public void issuePaychecks() throws IOException{
		String file = "/Users/siobhan/eclipse-workspace/lowenthalhw_2/src/babysitter_payroll/babysitter_paychecks.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		Collections.sort(employees, new NameComparator());
		for (Employee empl : employees) {
			bw.write(String.format("%-20s $%-10.2f\n",empl.getEmplName(),empl.getFinalPay()));
		}
		bw.close();
	}
	
}
