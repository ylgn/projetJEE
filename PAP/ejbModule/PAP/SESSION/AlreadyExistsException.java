package PAP.SESSION;

public class AlreadyExistsException extends Exception {
	String name;
	public AlreadyExistsException(String name) {
		super();
		this.name = name;
	}
}
