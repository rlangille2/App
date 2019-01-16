package domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Share {
	
	private int shareId;
	private int loanId;
	private int bankId;
	private String account;
	private BigDecimal amount;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public int getId() {
		return shareId;
	}
	
	public int getLoanId() {
		return loanId;
	}
	
	public int getBankId() {
		return bankId;
	}
	
	public String getAccount() {
		return account;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public void setId(int _shareId) {
		shareId = _shareId;
	}
	
	public void setLoanId(int _loanId) {
		loanId = _loanId;
	}
	
	public void setAccount(String _account) {
		account = _account;
	}
	
	public void setAmount(BigDecimal _amount) {
		amount = _amount;
	}
	
	public void setStartDate(LocalDate _startDate) {
		startDate = _startDate;
	}
	
	public void setEndDate(LocalDate _endDate) {
		endDate = _endDate;
	}
	
}
