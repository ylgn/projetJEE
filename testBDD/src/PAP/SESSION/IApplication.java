package PAP.SESSION;


public interface IApplication {
	public void connect();
	public void subscribe(String name,String email,String pass,String city) ;
	public void dropObject();
	public void search();
	public void buyObject();
	public void calculateTurnover();
	
	
}
