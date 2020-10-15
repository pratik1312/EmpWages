package empWage;

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
    private CompanyEmpWage[]  companyEmpWageArray;


    public EmpWageBuilderArray() {
    	companyEmpWageArray = new CompanyEmpWage[5];

    }

    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays,
             int maxHoursPerMonth) {    
    companyEmpWageArray[numOfCompany] = new CompanyEmpWage (company,empRatePerHour,numOfWorkingDays,
    		maxHoursPerMonth);
  		numOfCompany++;

    }

    public void computeEmpWage() {
    	for (int i=0;i<numOfCompany;i++) {
       		companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
    		System.out.println(companyEmpWageArray[i]);
    	}
   	}

	@Override
	public int getTotalWage(String company) {
		// TODO Auto-generated method stub
		return 0;
	}
    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
 	int empHrs = 0 ,totalEmpHrs=0, totalWorkingDays = 0;

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
			System.out.println("Day#: " + totalWorkingDays + " Emp Hr : " +empHrs);
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

    }
}
