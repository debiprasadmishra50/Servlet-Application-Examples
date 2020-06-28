package bank.model;

import bank.db.Customer;

public class CustomerService 
{

	public static int doDeposit(Customer c) 
	{
		int status = 0;
		double db_amount = CustomerDao.getAmount(c);
		if (db_amount <= 0) 
		{
			return -1;
		}
		else
		{
			double total = db_amount + c.getAmount();
			c.setAmount(total);
			status = CustomerDao.updateAmount(c);
		}
		return status;
	}

}
