package cs544.exercise17_1.bank.dao;

import java.util.*;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cs544.exercise17_1.bank.domain.Account;

@Repository
public class AccountDAO implements IAccountDAO {

	@Autowired
	private SessionFactory sessionFactory ;

	public AccountDAO() {
		super();
	}

	public void setSf(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void saveAccount(Account account) {
		sessionFactory.getCurrentSession().persist(account);
	}

	public void updateAccount(Account account) {

		sessionFactory.getCurrentSession().saveOrUpdate(account);

	}

	public Account loadAccount(long accountnumber) {

		return (Account) sessionFactory.getCurrentSession().get(Account.class, accountnumber);
	}

	@SuppressWarnings("unchecked")
	public Collection<Account> getAccounts() {

		return sessionFactory.getCurrentSession().createQuery("from Account").list();
	}

}
