package repository;

import java.util.List;

import domain.Bank;

public interface BankRepository {

	public Bank select(int bankId);

	public List<Bank> selectAll();

	public void insert(Bank bank);

	public void update(Bank bank);

	public void delete(Bank bank);

}
