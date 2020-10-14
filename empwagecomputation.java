public class empwagecomputation {

    public static final int IS_PART_TIME = 2;
    public static final int IS_FULL_TIME = 1;
    
    private final String company;
    private final int empRatePerHour;
    private final int numOfWorkingDays;
    private final int maxHoursPerMonth;
    private int totalEmpWage;
    
    public empwagecomputation (String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
	}
    
    private void computeWage() {
    	
    	int empHrs = 0 ,totalEmpHrs=0, totalWorkingDays = 0;
    	while (totalEmpHrs <= maxHoursPerMonth && totalWorkingDays < numOfWorkingDays) {
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
			System.out.println("Day#: " + totalWorkingDays + " Emp Hr : " +empHrs);
    	}
    	totalEmpWage = totalEmpHrs * empRatePerHour;
    	//return totalEmpHrs * empRatePerHour;
    }
    @Override
    public String toString() {
    	return "Total Emp Wage for company " +company+" is : " + totalEmpWage;
    }

	public static void main(String args[]) {
		empwagecomputation dMart = new empwagecomputation("DMart", 20, 2 ,10);
		empwagecomputation Jio = new empwagecomputation("Jio", 10, 2 ,10);
		dMart.computeWage();
		System.out.println(dMart);
		Jio.computeWage();
		System.out.println(Jio);
    	}
    }



