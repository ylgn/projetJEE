package PAP.MODEL.CLIENT;

public class MailPAPForClient {
	private String recipiant;
	private String ob;
	private String content;
	
	public MailPAPForClient() {
		
	}
	public MailPAPForClient(String recipiant, String ob,String content) {
		this.recipiant = recipiant;
		this.ob = ob;
		this.content = content;
	}
	public String getRecipiant() {
		return recipiant;
	}
	public void setRecipiant(String recipiant) {
		this.recipiant = recipiant;
	}
	public String getOb() {
		return ob;
	}
	public void setOb(String ob) {
		this.ob = ob;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
