package servlet;

/**
 * Created by weiyihu on 2017-05-31.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.User;
import database.userSql;

public class IndividualServlet extends HttpServlet {
    private static final long serialVersionUID = -3009431503363456888L;


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String post=request.getParameter("post");
        User user=(User)request.getSession().getAttribute("user");

        //insert post into database
        userSql userSql=new userSql();
        userSql.insertBlog(post,user.getId());

        //System.out.println(post+user.getId());

        //forward to public page
        //将post放到session中
        request.getSession().setAttribute("post", post);
        //转发到individual.jsp个人主页
        request.getRequestDispatcher("public.jsp").forward(request, response);




    }


}
