package za.co.absa.cib.trade.credit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CREDIT_APPLICATION")
public class CreditApplication {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="APPLICANT")
	private String applicantName;
	
	@Column(name="BANK")
	private String bank;
	
	@Column(name="RATING")
	private int rating;
	
	@Column(name="STATUS")
//	@Enumerated(EnumType.STRING)
	private String status;

	protected CreditApplication() {
		
	}
	
	
	public CreditApplication(String applicantName, String bank, int rating) {
		super();
		this.applicantName = applicantName;
		this.bank = bank;
		this.rating = rating;
		this.status = Status.INITIATED.name();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
}
