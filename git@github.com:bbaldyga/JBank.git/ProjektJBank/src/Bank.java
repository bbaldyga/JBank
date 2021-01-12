import java.util.*;
import java.text.*;

public class Bank {
	private static Bank INSTANCE;
	static private double creditInterestRate;
	static private Date closeTim;
	static private double investmentInterestRate;
	static private int lastCustId;
	static private int nextCustId;
	static private double premiumInterestRate;
	static private Date startTim;
	static public final String BANK_ADDRESS = "1234 JavaStreet, anyCity, ThisState,34567";
	static private final int MAX_NUM_OF_CUSTOMERS = 20;
	static public final String BANK_NAME = "JBANK";
	static private String phone;
	static private String website;
	static private int numOfCurrentCustomers;
	static private Customer[] customers = new Customer[MAX_NUM_OF_CUSTOMERS];

	private Bank() {
	};

	public static Bank getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Bank();
		return INSTANCE;
	}

	public static double getCreditRate() {
		return creditInterestRate;
	}

	public static double getInvestmentRate() {
		return investmentInterestRate;
	}

	public static String getHoursOfOperating() {
		SimpleDateFormat sdf = new SimpleDateFormat("k:mm");
		return "Hours of operating are form " + sdf.format(startTim) + " to " + sdf.format(closeTim);
	}

	public static int getLastId() {
		return lastCustId;
	}

	public static int getNextId() {
		int returnValue = 0;
		if (nextCustId == 0) {
			nextCustId = 1000;
			returnValue = nextCustId;
			numOfCurrentCustomers++;
		} else if (numOfCurrentCustomers != MAX_NUM_OF_CUSTOMERS) {
			lastCustId = nextCustId;
			nextCustId += 1;
			numOfCurrentCustomers++;
			returnValue = nextCustId;
		} else
			returnValue = 0;
		return returnValue;
	}

	/*
	 * public static int getMaxCustomers() { return maxNumOfCustomers; }
	 */
	public static String getPhone() {
		return phone;
	}

	public static double getPremiumRate() {
		return premiumInterestRate;
	}

	public static String getWebsite() {
		return website;
	}

	public static Date getOpenTim() {
		return startTim;
	}

	public static Date getCloseTim() {
		return closeTim;
	}

	/*
	 * public static String getName() { return bankName; }
	 * 
	 * public static String getAddress() { return bankAddress; }
	 */
	public static int getNumOfCurrentCustomers() {
		return numOfCurrentCustomers;
	}

	public static boolean addCustomer(Customer customer) {
		for (int ArraySearch = 0; ArraySearch < MAX_NUM_OF_CUSTOMERS; ArraySearch++) {
			if (customers[ArraySearch] == null) {
				customers[ArraySearch] = customer;
				return true;
			}
		}
		return false;
	}

	public static Customer getCustomer(int custId) {
		for (int i = 0; i < numOfCurrentCustomers; i++) {
			if (custId == customers[i].getCustId())
				return customers[i];
		}
		return null;
	}

	public static void removeCustomer(int custId) {
		for (int i = 0; i < numOfCurrentCustomers; i++) {
			if (custId == customers[i].getCustId()) {
				if (numOfCurrentCustomers == i) {
					customers[i] = null;
					numOfCurrentCustomers--;
				}
				else
				{
					customers[i] = null;
					for(int sort=i;sort<numOfCurrentCustomers;sort++) {
						customers[sort] = customers[sort+1];
					}
					numOfCurrentCustomers--;
				}
			}
		}
	}

	public static Customer[] getCustomers() {
		return customers;
	}

	public static void setCreditRate(double rate) {
		creditInterestRate = rate;
	}

	public static void setInvestmentRate(double rate) {
		investmentInterestRate = rate;
	}

	public static void setPremiumRate(double rate) {
		premiumInterestRate = rate;
	}

	public static void setWebSite(String site) {
		website = site;
	}

	public static void setPhone(String phoneNum) {
		phone = phoneNum;
	}

	public static void setOpenTim(Date sTim) {
		startTim = sTim;
	}

	public static void setCloseTim(Date cTim) {
		closeTim = cTim;
	}
	public static void clearList() {
		for(int i=19;i>2;i--)
		{
			customers[i] = null;
		}
		numOfCurrentCustomers = 3;
	}
	public static void updateCustomer(Customer c)
	{
		for (int i = 0; i < numOfCurrentCustomers; i++) {
			if (c.getCustId() == customers[i].getCustId())
				customers[i] = c;
		}
	}

}
