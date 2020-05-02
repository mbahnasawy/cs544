package cs544.exercise17_1.bank.service;

import java.util.Collection;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cs544.exercise17_1.bank.dao.IAccountDAO;
import cs544.exercise17_1.bank.domain.Account;
import cs544.exercise17_1.bank.domain.Customer;
import cs544.exercise17_1.bank.jms.IJMSSender;
import cs544.exercise17_1.bank.logging.ILogger;

@Service("accountService")
@Component
public class AccountService implements IAccountService {
	@Autowired
	private IAccountDAO accountDAO;
	@Autowired
	private ICurrencyConverter currencyConverter;
	@Autowired
	private IJMSSender jmsSender;
	@Autowired
	private ILogger logger;
	@Autowired
	private SessionFactory sessionFactory;

	
	public IAccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(IAccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public ICurrencyConverter getCurrencyConverter() {
		return currencyConverter;
	}

	public void setCurrencyConverter(ICurrencyConverter currencyConverter) {
		this.currencyConverter = currencyConverter;
	}

	public IJMSSender getJmsSender() {
		return jmsSender;
	}

	public void setJmsSender(IJMSSender jmsSender) {
		this.jmsSender = jmsSender;
	}

	public ILogger getLogger() {
		return logger;
	}

	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	public SessionFactory getSf() {
		return sessionFactory;
	}

	public void setSf(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public AccountService() {

	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);

		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		accountDAO.saveAccount(account);
		tx.commit();
		logger.log(
				"createAccount with parameters accountNumber= " + accountNumber + " , customerName= " + customerName);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		logger.log("deposit with parameters accountNumber= " + accountNumber + " , amount= " + amount);
		if (amount > 10000) {
			jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
		}
		tx.commit();
	}

	public Account getAccount(long accountNumber) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();

		Account account = accountDAO.loadAccount(accountNumber);
		tx.commit();
		return account;
	}

	public Collection<Account> getAllAccounts() {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		Collection<Account> accounts = accountDAO.getAccounts();
		for(Account a: accounts) {
			Hibernate.initialize(a.getEntryList());
		}
		
		tx.commit();
		return accounts ; 
	}

	public void withdraw(long accountNumber, double amount) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();

		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		tx.commit();
		logger.log("withdraw with parameters accountNumber= " + accountNumber + " , amount= " + amount);
	}

	public void depositEuros(long accountNumber, double amount) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();

		Account account = accountDAO.loadAccount(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.deposit(amountDollars);
		accountDAO.updateAccount(account);
		tx.commit();
		logger.log("depositEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
		if (amountDollars > 10000) {
			jmsSender.sendJMSMessage("Deposit of $ " + amount + " to account with accountNumber= " + accountNumber);
		}
	}

	public void withdrawEuros(long accountNumber, double amount) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();

		Account account = accountDAO.loadAccount(accountNumber);
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.withdraw(amountDollars);
		accountDAO.updateAccount(account);
		tx.commit();
		logger.log("withdrawEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		tx.commit();
		logger.log("transferFunds with parameters fromAccountNumber= " + fromAccountNumber + " , toAccountNumber= "
				+ toAccountNumber + " , amount= " + amount + " , description= " + description);
		if (amount > 10000) {
			jmsSender.sendJMSMessage("TransferFunds of $ " + amount + " from account with accountNumber= " + fromAccount
					+ " to account with accountNumber= " + toAccount);
		}
	}
}
