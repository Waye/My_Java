package servlet;

/**
 * Created by weiyihu on 2017-05-25.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.userSql;
import user.User;

public class RegisterServlet extends HttpServlet{
    private static final long serialVersionUID=5280356329609002908L;

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
        //获取用户信
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String sex=request.getParameter("sex");
        String email=request.getParameter("email");

        //实体化userSql对象
        userSql usersql;
        usersql = new userSql();

            if(usersql.emailNotExist(email))
            {
                //实例一个user对象
                User user =new User(username,password,sex,email);

                //保存用户注册信息
                usersql.insertUser(user);

                //get full user information and direct to session
                User user1;
                userSql usersql1=new userSql();

                user1=usersql1.login(user.getUsername(),user.getPassword());

                //将用户放到session中
                request.getSession().setAttribute("user", user1);
                //转发到individual.jsp个人主页
                request.getRequestDispatcher("individual.jsp").forward(request, response);

            }
            else{
                request.setAttribute("info", "Error:this user exists");
                //转到register.jsp界面
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }



    }

}
