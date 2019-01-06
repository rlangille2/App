package repository;

import java.util.ArrayList;

import financial.Loan;

public interface LoanRepository {

	public void createLoan(Loan loan);

	public void updateLoan(Loan loan);

	public void deleteLoan(Loan loan);

	public Loan findLoan(Loan loan);

	public ArrayList<Loan> findListOfLoans();

}
