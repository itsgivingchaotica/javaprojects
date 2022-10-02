import java.util.Comparator;

public class NameComparator implements Comparator<Employee>{
	/**
	 * compares Employee objects by name
	 */
	public int compare(Employee e1, Employee e2)
	{
		return e1.getEmplName().compareTo(e2.getEmplName());
	}

}
