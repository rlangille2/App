package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import financial.Loan;

public class LoanRepositoryImpl extends CrudRepository implements LoanRepository {

	public void createLoan(Loan loan) {
		String sql = "INSERT INTO Loans VALUES(?,?,?);";
		execute(sql, loan.getLoanAmount().toString(), loan.getStartDate().toString(), loan.getEndDate().toString());
	}

	public void updateLoan(Loan loan) {
		String sql = "UPDATE Loans SET LoanAmount = ?, StartDate = ?, EndDate = ? WHERE LoanID = ?;";
		execute(sql, loan.getLoanAmount().toString(), loan.getStartDate().toString(), loan.getEndDate().toString(),
				String.valueOf(loan.getId()));
	}

	public void deleteLoan(Loan loan) {
		String sql = "DELETE FROM Loans WHERE LoanID = ?;";
		execute(sql, String.valueOf(loan.getId()));
	}

	public Loan findLoan(Loan loan) {
		Loan newLoan = new Loan();
		ResultSet result;
		String sql = "SELECT LoanID, LoanAmount, StartDate, EndDate FROM Loans Where LoanID = ?;";
		result = find(sql, String.valueOf(loan.getId()));
		try {
			newLoan.setId(result.getInt("LoanID"));
			newLoan.setLoanAmount(result.getBigDecimal("LoanAmount"));
			newLoan.setStartDate(result.getDate("StartDate"));
			newLoan.setEndDate(result.getDate("EndDate"));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return newLoan;
	}

	public List<Loan> findListOfLoans() {
		List<Loan> listOfLoans = new ArrayList<>();
		String sql = "SELECT LoanID, LoanAmount, StartDate, EndDate FROM Loans;";
		ResultSet result = find(sql);
		try {
			while (result.next()) {
				Loan loan = new Loan();
				loan.setId(result.getInt("LoanID"));
				loan.setLoanAmount(result.getBigDecimal("LoanAmount"));
				loan.setStartDate(result.getDate("StartDate"));
				loan.setEndDate(result.getDate("EndDate"));
				listOfLoans.add(loan);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listOfLoans;
	}

}
