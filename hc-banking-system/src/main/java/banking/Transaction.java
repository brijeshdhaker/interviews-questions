package banking;

/**
 *
 * Private Variables:<br>
 * {@link #accountNumber}: Long<br>
 * {@link #bank}: Bank<br>
 */
public class Transaction implements TransactionInterface{

	private Long accountNumber;
	private Bank bank;

	/**
	 *
	 * @param bank The bank where the account is housed.
	 * @param accountNumber The customer's account number.
	 * @param attemptedPin  The PIN entered by the customer.
	 * @throws Exception Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
		if(bank.authenticateUser(accountNumber,attemptedPin)){
			this.bank = bank;
			this.accountNumber = accountNumber;
		}else {
			throw new Exception("Provide PIN not  verified.");
		}
	}

	public double getBalance() {
        return bank.getBalance(this.accountNumber);
	}

	public void credit(double amount) {
		bank.credit(accountNumber,amount);
	}

	public boolean debit(double amount) {
		return bank.debit(accountNumber,amount);
	}
}
