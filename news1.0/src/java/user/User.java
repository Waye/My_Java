package user;

/**
 * Created by weiyihu on 2017-05-25.
 */

public class User {
    private int id;			// id号码
    private String username;// 用户名
    private String password;// 密码
    private String sex;		// 性别
    private String email;	// 邮箱

    //constructor
    public User(String username, String password, String sex, String email)
    {
        this.setUsername(username);
        this.setPassword(password);
        this.setSex(sex);
        this.setEmail(email);

    }

    public User()
    {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {this.sex = sex;}
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}

