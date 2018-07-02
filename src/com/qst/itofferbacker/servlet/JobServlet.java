package com.qst.itofferbacker.servlet;

import com.qst.itofferbacker.dao.JobDAO;
import com.qst.itofferbacker.javabean.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/JobServlet")
public class JobServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        JobDAO dao = new JobDAO();
        if("list".equals(type)){
            //职位列表查询
            List<Job> list = dao.selectAll();
            //将查询到的职位数据存入请求域属性中
            request.setAttribute("list",list);
            //请求转发到职位列表界面
            request.getRequestDispatcher("manage/jobList.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
