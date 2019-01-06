package financial;

import java.math.BigDecimal;
import java.util.Date;

public class Loan {

	private int loanId;
	private BigDecimal loanAmount;
	private Date startDate;
	private Date endDate;

	//Getters and Setters
	
	public int getId() {
		return loanId;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setId(int _loanId) {
		loanId = _loanId;
	}

	public void setLoanAmount(BigDecimal _loanAmount) {
		loanAmount = _loanAmount;
	}

	public void setStartDate(Date _startDate) {
		startDate = _startDate;
	}

	public void setEndDate(Date _endDate) {
		endDate = _endDate;
	}

}
