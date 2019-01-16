package assembler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import domain.ShareSnapshot;

public class ShareSnapshotAssembler implements Assembler<ShareSnapshot>{
	
	public ShareSnapshot convert(ResultSet resultSet) throws SQLException {
		ShareSnapshot shareSnapshot = new ShareSnapshot();
		shareSnapshot.setShareId(resultSet.getInt("ShareID"));
		shareSnapshot.setLoanId(resultSet.getInt("LoanID"));
		shareSnapshot.setBankId(resultSet.getInt("BankID"));
		shareSnapshot.setShareAccount(resultSet.getString("ShareAccount"));
		shareSnapshot.setShareAmount(resultSet.getBigDecimal("ShareAmount"));
		shareSnapshot.setLoanAmount(resultSet.getBigDecimal("BankAmount"));
		shareSnapshot.setShareStartDate(LocalDate.parse(resultSet.getString("ShareStartDate")));
		shareSnapshot.setShareEndDate(LocalDate.parse(resultSet.getString("ShareEndDate")));
		return shareSnapshot;
	}

}
