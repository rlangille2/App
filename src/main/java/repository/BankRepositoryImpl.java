package repository;

import java.util.List;

import assembler.BankAssembler;
import domain.Bank;

public class BankRepositoryImpl extends CrudRepository<Bank> implements BankRepository {

	private static BankRepositoryImpl singleton;

	private BankRepositoryImpl() {
		super(new BankAssembler());
	}

	public static BankRepositoryImpl getInstance() {
		if (singleton == null) {
			singleton = new BankRepositoryImpl();
		}
		return singleton;
	}

	public Bank select(int bankId) {
		String sql = "SELECT BankID, BankName, Transit, Institution FROM Banks WHERE BankID = ?;";
		List<Bank> resultList = find(sql, String.valueOf(bankId));
		return resultList.get(0);
	}

	public List<Bank> selectAll() {
		String sql = "SELECT BankID, BankName, Transit, Institution FROM Banks WHERE Enabled = ?;";
		return find(sql, String.valueOf(1));
	}

	public void insert(Bank bank) {
		String sql = "INSERT INTO Banks(BankName, Transit, Institution) Values (?,?,?);";
		execute(sql, bank.getName(), bank.getTransit(), bank.getInstitution());
	}

	public void update(Bank bank) {
		String sql = "UPDATE Banks SET BankName = ?, Transit = ?, Institution = ? WHERE BankID = ?;";
		execute(sql, bank.getName(), bank.getTransit(), bank.getInstitution());
	}

	public void delete(Bank bank) {
		String sql = "DELETE FROM Banks WHERE BankID = ?;";
		execute(sql, String.valueOf(bank.getId()));
	}

}
