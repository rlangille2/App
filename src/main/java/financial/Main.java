package financial;

import java.math.BigDecimal;
import java.time.LocalDate;

import repository.LoanRepositoryImpl;

public class Main {

	public static void main(String[] args) {
		
		Loan loan = new Loan();
		loan.setId(7);
		LoanRepositoryImpl impl = LoanRepositoryImpl.getInstance();
		loan = impl.findLoan(loan);
		System.out.println(loan.getId());
		//System.out.println(loan.getLoanAmount());
		//System.out.println(loan.getStartDate());
		//System.out.println(loan.getEndDate());
	}

}
