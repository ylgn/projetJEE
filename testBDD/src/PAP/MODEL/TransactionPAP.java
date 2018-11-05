package PAP.MODEL;

import java.io.Serializable;
import java.sql.Date;

public class TransactionPAP implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private int numTransact;
	private UserPAP owner;
	private UserPAP seller;
	private ObjectPAP objectTransact;
	private Date dateTransact;
	
	
	public TransactionPAP() {
		
	}

	public TransactionPAP(int numTransact, UserPAP owner, UserPAP seller, ObjectPAP objectTransact, Date dateTransact) {
		super();
		this.numTransact = numTransact;
		this.owner = owner;
		this.seller = seller;
		this.objectTransact = objectTransact;
		this.dateTransact = dateTransact;
		this.objectTransact.setSelled();
	}

	public int getNumTransact() {
		return numTransact;
	}

	public void setNumTransact(int numTransact) {
		this.numTransact = numTransact;
	}

	public UserPAP getOwner() {
		return owner;
	}

	public void setOwner(UserPAP owner) {
		this.owner = owner;
	}

	public UserPAP getSeller() {
		return seller;
	}

	public void setSeller(UserPAP seller) {
		this.seller = seller;
	}

	public ObjectPAP getObjectTransact() {
		return objectTransact;
	}

	public void setObjectTransact(ObjectPAP objectTransact) {
		this.objectTransact = objectTransact;
	}

	public Date getDateTransact() {
		return dateTransact;
	}

	public void setDateTransact(Date dateTransact) {
		this.dateTransact = dateTransact;
	}
	
	public double getPAPFeesAmount() {
		return this.objectTransact.getPriceObject() * 0.2;
	}
	
	
}
