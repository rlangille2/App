package financial;

import repository.LoanRepositoryImpl;

public class Main {

	public static void main(String[] args) {
		
		Loan loan = new Loan();
		loan.setId(3);
		LoanRepositoryImpl impl = LoanRepositoryImpl.getInstance();
		Loan newLoan = impl.findLoan(loan);
		System.out.println(newLoan.getId());
		System.out.println(newLoan.getLoanAmount());
		System.out.println(newLoan.getStartDate());
		System.out.println(newLoan.getEndDate());
		
	}

}
