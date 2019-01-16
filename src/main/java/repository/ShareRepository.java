package repository;

import java.util.List;

import domain.Loan;
import domain.Share;

public interface ShareRepository {

	public Share select(int shareId);

	public List<Share> selectAll();

	public void insert(Share share);

	public void update(Share share);

	public void delete(Share share);

}
