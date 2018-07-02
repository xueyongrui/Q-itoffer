package com.qst.itofferbacker.servlet;

import com.qst.itofferbacker.dao.UserDAO;
import com.qst.itofferbacker.javabean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求字符编码
        request.setCharacterEncoding("UTF-8");
        //设置响应字符编码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取操作类型
        String type = request.getParameter("type");
        if ("login".equals(type)) {
            //获取用户提交的验证码
            String validateCode = request.getParameter("validateCode");
            //获取本次请求会话中提交的验证码
            String sessionValidateCode = (String) request.getSession().getAttribute("SESSION_VALIDATECODE");
            //判断若验证码不一致，提示错误，返回登录页面
            if (sessionValidateCode == null || !sessionValidateCode.equals(validateCode)) {
                out.println("<script type = 'text/javascript'>");
                out.print("alert('验证码输入错误!');");
                out.print("window.location ='login.html';");
                out.print("</script>");
                return;
            }
            //获取用户登录信息
            String userLogname = request.getParameter("userLogname");
            String userPwd = request.getParameter("userPwd");
            //用户登录判断
            UserDAO dao = new UserDAO();
            User user = dao.login(userLogname, userPwd);
            if (user != null) {
                //登录成功，使用会话域属性记录用户信息，进入管理主界面
                request.getSession().setAttribute("SESSION_USER", user);
                response.sendRedirect("manage/main.html");
            } else {
                //登录失败，错误信息提示，返回登陆页面
                out.println("<script type = 'text/javascript'>");
                out.print("alert('用户名或密码错误，请重新输入!');");
                out.print("window.location ='login.html';");
                out.print("</script>");
            }
        } else if ("logout".equals(type)) {//用户退出
            //用户本次会话失效
            request.getSession().invalidate();
            //返回登录页面
            out.println("<script type = 'text/javascript'>");
            out.print("window.location ='login.html';");
            out.print("</script>");
        } else if ("updateServlet".equals(type)) {
            //用户信息修改预查询
            int uid = Integer.parseInt(request.getParameter("userId"));
            UserDAO dao = new UserDAO();
            User user = dao.selectById(uid);
            request.setAttribute("user", user);
            request.getRequestDispatcher("manage/userUpdate.jsp").forward(request, response);
        }else if("userList".equals(type)){
            UserDAO dao = new UserDAO();
            //用户列表查询
            List<User> userList = dao.selectAll();
            //将查询到的用户列表数据存入请求域属性中
            request.setAttribute("userList", userList);
            //请求转发到用户列表界面
            request.getRequestDispatcher("manage/userList.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
