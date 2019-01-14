package domain;

public class Bank {

	private int bankId;
	private String bankName;
	private String transit;
	private String institution;

	public Bank() {
	};

	public Bank(int _bankId, String _bankName, String _transit, String _institution) {
		bankId = _bankId;
		bankName = _bankName;
		transit = _transit;
		institution = _institution;
	}

	public int getId() {
		return bankId;
	}

	public String getName() {
		return bankName;
	}

	public String getTransit() {
		return transit;
	}

	public String getInstitution() {
		return institution;
	}

	public void setId(int _bankId) {
		bankId = _bankId;
	}

	public void setName(String _bankName) {
		bankName = _bankName;
	}

	public void setTransit(String _transit) {
		transit = _transit;
	}

	public void setInstitution(String _institution) {
		institution = _institution;
	}

}
