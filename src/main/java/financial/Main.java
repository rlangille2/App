package financial;

import java.util.List;

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
		
		List<Loan> loansList = impl.selectAllLoans();
		System.out.println(loansList.size());

	}

}