package tr.com.bgss.core;

public class CoreFields {
	
	private final String username = "USER1";
	private final String password = "1";
	private final String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	//private final String url = "jdbc:mysql://localhost/satisvestok?useUnicode=true&characterEncoding=UTF-8";
	
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUrl() {
		return url;
	}
	

}
