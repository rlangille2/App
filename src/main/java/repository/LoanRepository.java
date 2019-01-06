package repository;

import java.util.List;

import financial.Loan;

public interface LoanRepository {

	public void createLoan(Loan loan);

	public void updateLoan(Loan loan);

	public void deleteLoan(Loan loan);

	public Loan findLoan(Loan loan);

	public List<Loan> findListOfLoans();

}
