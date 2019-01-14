package assembler;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Bank;

public class BankAssembler implements Assembler<Bank>{

	public Bank convert(ResultSet resultSet) throws SQLException {
		Bank bank = new Bank();
		bank.setId(resultSet.getInt("BankID"));
		bank.setName(resultSet.getString("BankName"));
		bank.setTransit(resultSet.getString("Transit"));
		bank.setInstitution(resultSet.getString("Institution"));
		return bank;
	}

}
