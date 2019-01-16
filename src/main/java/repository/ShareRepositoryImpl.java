package repository;

import java.util.List;

import assembler.ShareAssembler;
import domain.Share;

public class ShareRepositoryImpl extends CrudRepository<Share> implements ShareRepository {

	private static ShareRepositoryImpl singleton;

	private ShareRepositoryImpl() {
		super(new ShareAssembler());
	}

	public static ShareRepositoryImpl getInstance() {
		if (singleton == null) {
			singleton = new ShareRepositoryImpl();
		}
		return singleton;
	}

	public Share select(int shareId) {
		String sql = "SELECT ShareID, LoanID, BankID, Account, StartDate, EndDate FROM Shares WHERE ShareID = ?;";
		List<Share> resultList = find(sql, String.valueOf(shareId));
		return resultList.get(0);
	}

	public List<Share> selectAll() {
		String sql = "SELECT ShareID, LoanID, BankID, Account, StartDate, EndDate FROM Shares WHERE Enabled = ?;";
		return find(sql, String.valueOf(1));
	}

	public void insert(Share share) {
		String sql = "INSERT INTO Shares(LoanID, BankID, Account, StartDate, EndDate) VALUES(?,?,?,?,?);";
		execute(sql, String.valueOf(share.getLoanId()), String.valueOf(share.getBankId()), share.getAccount(),
				share.getStartDate().toString(), share.getEndDate().toString());
	}

	public void update(Share share) {
		String sql = "UPDATE Shares SET LoanID = ?, BankID = ?, Account = ?, StartDate = ?, EndDate = ? WHERE ShareID = ?;";
		execute(sql, String.valueOf(share.getLoanId()), String.valueOf(share.getBankId()), share.getAccount(),
				share.getStartDate().toString(), share.getEndDate().toString(), String.valueOf(share.getId()));
	}

	public void delete(Share share) {
		String sql = "DELETE FROM Shares WHERE ShareID = ?;";
		execute(sql, String.valueOf(share.getId()));
	}
}
