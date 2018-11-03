package PAP.MODEL;

import java.io.Serializable;
import java.sql.Date;

public class TransactionPAPForClient implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private int numTransact;
	private UserPAPForClient owner;
	private UserPAPForClient seller;
	private ObjectPAPForClient objectTransact;
	private Date dateTransact;
	
	
	public TransactionPAPForClient() {
		
	}

	public TransactionPAPForClient(int numTransact, UserPAPForClient owner, UserPAPForClient seller, ObjectPAPForClient objectTransact, Date dateTransact) {
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

	public UserPAPForClient getOwner() {
		return owner;
	}

	public void setOwner(UserPAPForClient owner) {
		this.owner = owner;
	}

	public UserPAPForClient getSeller() {
		return seller;
	}

	public void setSeller(UserPAPForClient seller) {
		this.seller = seller;
	}

	public ObjectPAPForClient getObjectTransact() {
		return objectTransact;
	}

	public void setObjectTransact(ObjectPAPForClient objectTransact) {
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
