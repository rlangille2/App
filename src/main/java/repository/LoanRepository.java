package repository;

import java.util.List;

import financial.Loan;

public interface LoanRepository {

	public void createLoan(Loan loan);

	public void updateLoan(Loan loan);

	public void deleteLoan(Loan loan);

	public Loan selectLoan(int loanId);

	public List<Loan> selectAllLoans();

}
