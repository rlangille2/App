package assembler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import domain.Share;

public class ShareAssembler implements Assembler<Share> {

	public Share convert(ResultSet resultSet) throws SQLException {
		Share share = new Share();
		share.setId(resultSet.getInt("ShareID"));
		share.setLoanId(resultSet.getInt("LoanID"));
		share.setAccount(resultSet.getString("Account"));
		share.setAmount(resultSet.getBigDecimal("Amount"));
		share.setStartDate(LocalDate.parse(resultSet.getString("StartDate")));
		share.setEndDate(LocalDate.parse(resultSet.getString("EndDate")));
		return share;
	}

}
