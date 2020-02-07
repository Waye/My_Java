package servlet;

/**
 * Created by weiyihu on 2017-05-25.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User;
import database.userSql;

public class LoginServlet extends HttpServlet{
    private static final long serialVersionUID = -3009431503363456775L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        User User;
        //得到输入名
        String username = request.getParameter("username");
        //得到密码
        String password = request.getParameter("password");

        //创建usersql使用对象
        userSql usersql= new userSql();

        //创建一个user对象
        User = usersql.login(username, password);



        //判断user是否为空
        if(User != null){
            //将用户放到session中
            request.getSession().setAttribute("user", User);
            //转发到individual.jsp个人主页
            request.getRequestDispatcher("individual.jsp").forward(request, response);


        }else{
            //登入失败转到信息提示页面，再等待做下步计划
            request.setAttribute("info", "Error:wrong with username and password");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }

    }

}

