package financial;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Loan {

	private Integer loanId;
	private BigDecimal loanAmount;
	private LocalDate startDate;
	private LocalDate endDate;

	//Getters and Setters
	
	public int getId() {
		return loanId;
	}
	
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setId(Integer _loanId) {
		loanId = _loanId;
	}

	public void setLoanAmount(BigDecimal _loanAmount) {
		loanAmount = _loanAmount;
	}

	public void setStartDate(LocalDate _startDate) {
		startDate = _startDate;
	}

	public void setEndDate(LocalDate _endDate) {
		endDate = _endDate;
	}

}
