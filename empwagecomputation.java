public class empwagecomputation {
    public static final int IS_PART_TIME = 2;
    public static final int IS_FULL_TIME = 1;
    
    private final String company;
    private final int empRatePerHour;
    private final int numOfWorkingDays;
    private final int maxHoursPerMonth;
    
    public empwagecomputation(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
	}
    
    private int computeWage() {
    	
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
    	return totalEmpHrs * empRatePerHour;
    }

	public static void main(String args[]) {
		empwagecomputation dMart = new empwagecomputation ("DMart",20,5,100);
		empwagecomputation TATA = new empwagecomputation ("TATA",25,2,10);	
		empwagecomputation Jio = new empwagecomputation ("Jio",20,4,10);
		System.out.println("Total Employee Wage for Company " + dMart.company + " is : " + dMart.computeWage());
		System.out.println("Total Employee Wage for Company " + TATA.company + " is : " + TATA.computeWage());
		System.out.println("Total Employee Wage for Company " + Jio.company + " is : " + Jio.computeWage());
    	}
    }
