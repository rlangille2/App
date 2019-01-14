package repository;

import java.util.List;

import assembler.LoanAssembler;
import financial.Loan;

public class LoanRepositoryImpl extends CrudRepository<Loan> implements LoanRepository {

	private static LoanRepositoryImpl singleton;

	private LoanRepositoryImpl() {
		super(new LoanAssembler());
	}

	public static LoanRepositoryImpl getInstance() {
		if (singleton == null) {
			singleton = new LoanRepositoryImpl();
		}
		return singleton;
	}
	
	public Loan selectLoan(int loanId) {
		String sql = "SELECT LoanID, LoanAmount, StartDate, EndDate FROM Loans WHERE LoanID = ?;";
		List<Loan> resultList = find(sql, String.valueOf(loanId));
		return resultList.get(0);
	}
	
	public List<Loan> selectAllLoans() {
		String sql = "SELECT LoanID, LoanAmount, StartDate, EndDate FROM Loans WHERE Enabled = ?;";
		return find(sql, String.valueOf(1));
	}	

	public void createLoan(Loan loan) {
		String sql = "INSERT INTO Loans(LoanAmount, StartDate, EndDate) VALUES(?,?,?);";
		execute(sql, loan.getLoanAmount().toString(), loan.getStartDate().toString(),
				loan.getEndDate().toString());
	}

	public void updateLoan(Loan loan) {
		String sql = "UPDATE Loans SET LoanAmount = ?, StartDate = ?, EndDate = ? WHERE LoanID = ?;";
		execute(sql, loan.getLoanAmount().toString(), loan.getStartDate().toString(),
				loan.getEndDate().toString(), String.valueOf(loan.getId()));
	}

	public void deleteLoan(Loan loan) {
		String sql = "DELETE FROM Loans WHERE LoanID = ?;";
		execute(sql, String.valueOf(loan.getId()));
	}

}
