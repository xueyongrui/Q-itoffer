package com.qst.itofferbacker.servlet;

import com.qst.itofferbacker.dao.JobDAO;
import com.qst.itofferbacker.javabean.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/JobAddServlet")
@MultipartConfig
public class JobAddServlet extends HttpServlet {
    public JobAddServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取html中提交的数据
        int companyId = Integer.parseInt(request.getParameter("companyId"));
        String jobName = request.getParameter("jobName");
        int hiringNum = Integer.parseInt(request.getParameter("hiringNum"));
        String jobSalary = request.getParameter("jobSalary");
        String jobArea = request.getParameter("jobArea");
        String endTime = request.getParameter("endTime");
        int hiringState = (request.getParameter("hiringState") == null) ? 3 : Integer.parseInt(request.getParameter("hiringState"));

        //创建job对象来存放获取的属性值
        Job job = new Job();
        job.setCompanyId(companyId);
        job.setJobName(jobName);
        job.setJobHiringnum(hiringNum);
        job.setJobSalary(jobSalary);
        job.setJobArea(jobArea);
        job.setJobEndtime(endTime);
        job.setJobState(hiringState);

        JobDAO jobdao = new JobDAO();
        //执行向数据库插入数据保存操作
        jobdao.save(job);
        out.println("<script type = 'text/javascript'>");
        out.print("alert('添加成功!');");
        out.print("window.location ='JobServlet?type=list';");
        out.print("</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
