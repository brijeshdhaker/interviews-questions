package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {

	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		accounts = new LinkedHashMap();
	}

	private static long accNo = 10000L;

	private Account getAccount(Long accountNumber) {
	    return accounts.get(accountNumber);
	}

	private long generateAccountNumber(){
		return Bank.accNo++;
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		long accountNo = generateAccountNumber();
		Account ca = new CommercialAccount(company,accountNo,pin,startingDeposit);
		accounts.put(accountNo,ca);
		return accountNo;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		long accountNo = generateAccountNumber();
		Account pa = new ConsumerAccount(person,accountNo,pin,startingDeposit);
		accounts.put(accountNo,pa);
        return accountNo;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		return getAccount(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		return getAccount(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		getAccount(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		return getAccount(accountNumber).debitAccount(amount);
	}
}
