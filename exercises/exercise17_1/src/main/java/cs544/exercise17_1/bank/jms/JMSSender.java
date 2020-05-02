package cs544.exercise17_1.bank.jms;

import org.springframework.stereotype.Repository;

@Repository
public class JMSSender implements IJMSSender{
	
	public void sendJMSMessage (String text){
		System.out.println("JMSSender: sending JMS message ="+text);
	}

}
