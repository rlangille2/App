package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import financial.Loan;

public class LoanRepositoryImpl extends CrudRepository implements LoanRepository {

	private static LoanRepositoryImpl singleton;

	private LoanRepositoryImpl() {
		
	};

	public static LoanRepositoryImpl getInstance() {
		if (singleton == null) {
			singleton = new LoanRepositoryImpl();
		}
		return singleton;
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

	public Loan findLoan(Loan loan) {
		String sql = "SELECT LoanID, LoanAmount, StartDate, EndDate FROM Loans WHERE LoanID = ?;";
		Map<String, List<Object>> map = find(sql, String.valueOf(loan.getId()));
		Loan newLoan = new Loan();
		newLoan.setId(Integer.valueOf((map.get("LoanID").toString().replace("[", "").replace("]", ""))));
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
				loan.setStartDate(LocalDate.parse(result.getString("StartDate")));
				loan.setEndDate(LocalDate.parse(result.getString("EndDate")));
				listOfLoans.add(loan);
			}
			return listOfLoans;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
