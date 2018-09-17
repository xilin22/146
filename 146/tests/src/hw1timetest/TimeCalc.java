package hw1timetest;

public class TimeCalc {
	private static double sec = 1E6;
	private static double min = 60E6;
	private static double hour = 3600E6;
	private static double day = 86400E6;
	private static double month = 2592000E6;
	private static double year = 31104000E6;
	
	public static double solve(int caseNum, double month2)
	{
		if(caseNum == 0)
		{
			return Math.log(month2);
		}
		else if(caseNum == 1)
		{
			return Math.sqrt(month2);
		}
		else if(caseNum == 2)
		{
			return month2;
		}
		else if(caseNum == 3)
		{
			return Math.log(month2)* month2;
		}
		else if(caseNum == 4)
		{
			return month2*month2;
		}
		else if(caseNum == 5)
		{
			return Math.pow(2, month2);
		}
		return 0;
	}
	
	public static void  main(String[] args)
	{
		System.out.println("SEC");
		for(int i = 0; i<6; i++)
		{
			System.out.println( i + ":"+ solve(i, sec));
		}
		
		System.out.println("MIN");
		for(int i = 0; i<6; i++)
		{
			System.out.println( i + ":"+ solve(i, min));
		}
		
		System.out.println("HOUR");
		for(int i = 0; i<6; i++)
		{
			System.out.println( i + ":"+ solve(i, hour));
		}
		
		System.out.println("DAY");
		
		for(int i = 0; i<6; i++)
		{
			System.out.println(i + ":"+ solve(i, day));
		}
		
		System.out.println("MONTH");
		for(int i = 0; i<6; i++)
		{
			System.out.println(i + ":"+ solve(i, month));
		}
		System.out.println("YEAR");
		for(int i = 0; i<6; i++)
		{
			System.out.println(i + ":"+ solve(i, year));
		}
	}
}
