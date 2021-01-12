import java.util.Scanner;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;

import java.awt.Container;
import java.awt.*;
import javax.swing.*;

public class Teller {
	public static void main(String[] args) throws ParseException, AccountTypeAlreadyExistsException {
		JFrame atmg = new ATMGUI();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Customer c = new Customer("Jan", "Nowak", sdf.parse("12.12.1999"));
		c.setAddress("Strzelecka", "Opole", "15-445");
		c.setEmail("Og@dotmail.com");
		c.setPhone("953753678");
		c.addAccount(new Savings(c, 5000));
		Bank.addCustomer(c);
		Customer c2 = new Customer("Betsy", "Smith", sdf.parse("05.7.1950"));
		c2.setAddress(" 890 W Street ", "Mesa", " 890 W Street");
		c2.setEmail("ASDASD@ASDASD.com");
		c2.setPhone("99123");
		Savings s = new Savings(c2, 3500);
		c2.addAccount(s);
		c2.addAccount(new OverDraftProtect(c2, 4302, s));
		Bank.addCustomer(c2);
		Customer c3 = new Customer("Betsy", "Smith", sdf.parse("05.7.1950"));
		c3.setAddress(" 890 W Street ", "Mesa", " 890 W Street");
		c3.setEmail("ASDASD@ASDASD.com");
		c3.setPhone("99123");
		Savings s2 = new Savings(c2, 3500);
		c3.addAccount(s);
		c3.addAccount(new OverDraftProtect(c2, 4302, s2));
		Bank.addCustomer(c3);
		JFrame list = new ListOfCustomersGUI();
		for(int i=4;i<20;i++)
			Bank.addCustomer(c);
		atmg.setVisible(true);
		list.setVisible(true);
		Bank.clearList();
		
	}
}
