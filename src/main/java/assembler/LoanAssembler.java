package assembler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import domain.Loan;

public class LoanAssembler implements Assembler<Loan> {

	public Loan convert(ResultSet resultSet) throws SQLException {
		Loan loan = new Loan();
		loan.setId(resultSet.getInt("LoanID"));
		loan.setLoanAmount(resultSet.getBigDecimal("LoanAmount"));
		loan.setStartDate(LocalDate.parse(resultSet.getString("StartDate")));
		loan.setEndDate(LocalDate.parse(resultSet.getString("EndDate")));
		return loan;
	}

}
