package login.sumit.registration;

public interface UserDAO {
	
	public int insertUser(User u);
	public User getUser(String username, String pass);
	public User searchUser(String username);
}
