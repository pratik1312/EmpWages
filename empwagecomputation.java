public class empwagecomputation {
	public static final int IS_PART_TIME = 2;
	public static final int IS_FULL_TIME = 1;
	public static final int WAGE_PER_HOUR = 20;
	public static final int NUM_OF_DAYS_IN_MONTH = 20;
	public static final int MAX_HRS_IN_MONTH = 100;

	public static void main(String args[]) {

		int empHrs = 0;
		int empWage=0;
		int totalEmpWage = 0;
		int totalWorkingDays = 0;
		int totalEmpHrs = 0;
		while (totalEmpHrs <= MAX_HRS_IN_MONTH && totalWorkingDays <= NUM_OF_DAYS_IN_MONTH) {
			totalWorkingDays++;
			int empcheck = (int) Math.floor(Math.random() * 10 ) % 3;
			switch (empcheck) {
				case IS_FULL_TIME :
					empHrs = 8;
					break;
				case IS_PART_TIME :
					empHrs = 4;
					break;
				default :
					empHrs=0;
				}
		  totalEmpHrs += empHrs;
		  empWage = empHrs * WAGE_PER_HOUR;
		  totalEmpWage += empWage;
		  System.out.println("Emp Wage : " + empWage);
		  System.out.println("Total Employee Wage : " + totalEmpWage);
    	}
		System.out.println("Total Working Hrs : " + totalEmpHrs);
		System.out.println("Total Employee Wage : " + totalEmpWage);
    }
}
