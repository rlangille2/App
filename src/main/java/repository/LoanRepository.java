package repository;

import java.util.List;

import domain.Loan;

public interface LoanRepository {

	public Loan select(int loanId);

	public List<Loan> selectAll();

	public void insert(Loan loan);

	public void update(Loan loan);

	public void delete(Loan loan);

}
