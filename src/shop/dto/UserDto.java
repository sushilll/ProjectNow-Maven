package shop.dto;

public class UserDto {
	private int id;
	private String userid;
	private String pwd;
	private String name;
	private String email;
	private String userRole;
	private String isactive;
	
	
	public UserDto(int id, String userid, String name, String email, String userRole, String isactive) {
		super();
		this.id = id;
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.userRole = userRole;
		this.isactive = isactive;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive.toLowerCase();
	}
	
	
}
