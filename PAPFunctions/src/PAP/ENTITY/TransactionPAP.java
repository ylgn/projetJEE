package PAP.ENTITY;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class TransactionPAP implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int numTransact;
	@JoinColumn(name="OWNER")
	private UserPAP owner;
	@JoinColumn(name="SELLER")
	private UserPAP seller;
	@JoinColumn(name="OBJECT")
	private ObjectPAP objectTransact;
	@Column(name="DATE")
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
