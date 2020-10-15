import java.util.*;

interface IComputeEmpWage {
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays,
    		int maxHoursPerMonth);
	public void computeEmpWage();
	public int getTotalWage(String company);
}

class CompanyEmpWage
{
	
	public final String company;
    public final int empRatePerHour;
    public final int numOfWorkingDays;
    public final int maxHoursPerMonth;
    public int totalEmpWage;
    
    public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays,
    		int maxHoursPerMonth) {
    	this.company = company;
    	this.empRatePerHour = empRatePerHour;
    	this.numOfWorkingDays = numOfWorkingDays;
    	this.maxHoursPerMonth = maxHoursPerMonth;
    	totalEmpWage=0;
    }
	
    public void setTotalEmpWage(int totalEmpWage) {
    	this.totalEmpWage = totalEmpWage;
    }
    
    @Override
    public String toString() {
    	return "Total Emp Wage for company: " +company+ " is : " + totalEmpWage;
    }
}


public class EmpWageBuilderArray implements IComputeEmpWage {

    public static final int IS_PART_TIME = 2;
    public static final int IS_FULL_TIME = 1;
    
    private int numOfCompany = 0;
        
    private LinkedList<CompanyEmpWage> companyEmpWageList;
    private Map<String,CompanyEmpWage> companyToEmpWageMap;
    
     
    public EmpWageBuilderArray() {
    	companyEmpWageList = new LinkedList<>();
    	companyToEmpWageMap = new HashMap<>();
    }
    
    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays,
             int maxHoursPerMonth) {    
    	
    	CompanyEmpWage companyEmpWage = new CompanyEmpWage (company,empRatePerHour,numOfWorkingDays,
    			maxHoursPerMonth);
    	companyEmpWageList.add(companyEmpWage);
    	companyToEmpWageMap.put(company,companyEmpWage);
    	    	
    }
       
    public void computeEmpWage() {
    	for(int i=0;i<companyEmpWageList.size();i++) {
    		CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
    		companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
    		System.out.println(companyEmpWage);
    	}	
   	}

    @Override
    public int getTotalWage(String company) {
    	return companyToEmpWageMap.get(company).totalEmpWage;
    }
    
    
    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
    	
    	int empHrs = 0 ,totalEmpHrs=0, totalWorkingDays = 0, DailyWage = 0;
    	
    	while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && 
    			totalWorkingDays < companyEmpWage.numOfWorkingDays)
    	{
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
			DailyWage = empHrs * companyEmpWage.empRatePerHour;
			System.out.println("Day#: " + totalWorkingDays + " Emp Hr : " +empHrs+ 
					" and Daily Wage of employee is " +DailyWage);
    	}
    	return totalEmpHrs * companyEmpWage.empRatePerHour;
    }
   	public static void main(String args[])
   	{
		
   		IComputeEmpWage empWageBuilder = new EmpWageBuilderArray();
   		empWageBuilder.addCompanyEmpWage("DMart", 20, 2 ,10);
   		empWageBuilder.addCompanyEmpWage("Jio", 10, 5, 15);
		empWageBuilder.addCompanyEmpWage("TATA", 200, 2 ,10);
		empWageBuilder.computeEmpWage();
		System.out.println("Total wage for DMart: "+empWageBuilder.getTotalWage("DMart"));
		System.out.println("Total wage for DMart: "+empWageBuilder.getTotalWage("Jio"));
		System.out.println("Total wage for DMart: "+empWageBuilder.getTotalWage("TATA"));
    }
   	
}   	   	
   	
