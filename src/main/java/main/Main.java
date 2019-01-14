package main;

import java.util.List;

import domain.Loan;
import repository.LoanRepositoryImpl;

public class Main {

	public static void main(String[] args) {

		LoanRepositoryImpl impl = LoanRepositoryImpl.getInstance();
//		Loan loan = new Loan();
//		loan = impl.selectLoan(3);
//		System.out.println(loan.getId());
//		System.out.println(loan.getLoanAmount());
//		System.out.println(loan.getStartDate());
//		System.out.println(loan.getEndDate());
		
		List<Loan> loansList = impl.selectAll();
		System.out.println(loansList.size());
		Loan loan1 = loansList.get(0);
		Loan loan2 = loansList.get(1);
		System.out.println(loan1.getId());
		System.out.println(loan1.getLoanAmount());
		System.out.println(loan1.getStartDate());
		System.out.println(loan1.getEndDate());
		System.out.println(loan2.getId());
		System.out.println(loan2.getLoanAmount());
		System.out.println(loan2.getStartDate());
		System.out.println(loan2.getEndDate());

	}

}