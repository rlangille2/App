package domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ShareSnapshot {
	
	private int shareId;
	private int loanId;
	private int bankId;
	private String bankName;
	private String shareAccount;
	private BigDecimal shareAmount;
	private BigDecimal loanAmount;
	private LocalDate shareStartDate;
	private LocalDate shareEndDate;
	
	public int getShareId() {
		return shareId;
	}
	
	public int getLoanId() {
		return loanId;
	}
	
	public int getBankId() {
		return bankId;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public String getShareAccount() {
		return shareAccount;
	}
	
	public BigDecimal getShareAmount() {
		return shareAmount;
	}
	
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
	
	public LocalDate getShareStartDate() {
		return shareStartDate;
	}
	
	public LocalDate getShareEndDate() {
		return shareEndDate;
	}
	
	public void setShareId(int _shareId) {
		shareId = _shareId;
	}
	
	public void setLoanId(int _loanId) {
		loanId = _loanId;
	}
	
	public void setBankId(int _bankId) {
		bankId = _bankId;
	}
	
	public void setBankName(String _bankName) {
		bankName = _bankName;
	}
	
	public void setShareAccount(String _shareAccount) {
		shareAccount = _shareAccount;
	}
	
	public void setShareAmount(BigDecimal _shareAmount) {
		shareAmount = _shareAmount;
	}
	
	public void setLoanAmount(BigDecimal _loanAmount) {
		loanAmount = _loanAmount;
	}
	
	public void setShareStartDate(LocalDate _shareStartDate) {
		shareStartDate = _shareStartDate;
	}
	
	public void setShareEndDate(LocalDate _shareEndDate) {
		shareEndDate = _shareEndDate;
	}
	
}
