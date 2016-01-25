package za.co.absa.cib.trade.credit;

public class CreditEvaluation {

	private CreditApplication application;
	
	public CreditEvaluation(CreditApplication application) {
		super();
		this.application = application;
	}

	public void execute() {
		if ("Absa".equalsIgnoreCase(application.getBank()) && application.getRating() > 2.0)
			application.setStatus(Status.APPROVED.name());
		else if (application.getRating() > 3.0)
			application.setStatus(Status.APPROVED.name());
		else application.setStatus(Status.DECLINED.name());
	}
}
