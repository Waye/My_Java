package servlet;

/**
 * Created by weiyihu on 2017-06-05.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;
import database.userSql;

public class ExitServlet extends HttpServlet{
    private static final long serialVersionUID = -3009431503363456775L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 获取session
        HttpSession session = request.getSession();

        if((request.getParameter("button")).equals("sign out"))
        {
            // 获取用户对象
            session.invalidate();
            // 设置提示信息
            request.setAttribute("info", "successfully sign out");
        }
        else if((request.getParameter("button")).equals("delete account"))
        {
            User user=(User)request.getSession().getAttribute("user");
            String name=user.getUsername();
            userSql userSql=new userSql();
            userSql.deleteUser(user);
            // 设置提示信息
            request.setAttribute("info", name+" has been deleted");
        }

        // 转发到login.jsp页面
        request.getRequestDispatcher("login.jsp").forward(request, response);


    }
}
