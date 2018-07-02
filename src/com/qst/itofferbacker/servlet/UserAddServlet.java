package com.qst.itofferbacker.servlet;
import com.qst.itofferbacker.dao.UserDAO;
import com.qst.itofferbacker.javabean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserAddServlet")

public class UserAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserAddServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String userLogname = request.getParameter("userLogname");
        String userPwd = request.getParameter("userPwd");
        String userRealname = request.getParameter("userRealname");
        String userEmail = request.getParameter("userEmail");
        //获取下拉列表的数据（带默认值）
        int userRole = (request.getParameter("userRole") == null) ? 3 : Integer.parseInt(request.getParameter("userRole"));
        int userState = (request.getParameter("userState") == null) ? 1 : Integer.parseInt(request.getParameter("userState"));
        User user = new User(userLogname, userPwd, userRealname, userEmail, userRole, userState);

        UserDAO dao = new UserDAO();
        dao.save(user);
        response.sendRedirect("manage/userList.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
