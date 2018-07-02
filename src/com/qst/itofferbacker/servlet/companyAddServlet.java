package com.qst.itofferbacker.servlet;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import com.qst.itofferbacker.dao.CompanyDAO;
import com.qst.itofferbacker.javabean.Company;

import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@WebServlet("/companyAddServlet")
@MultipartConfig
public class companyAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public companyAddServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码为UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取html中提交的数据
        String companyName = request.getParameter("companyName");
        String companyArea = request.getParameter("companyArea");
        String companySize = request.getParameter("companySize");
        String companyType = request.getParameter("companyType");
        String companyBrief = request.getParameter("companyBrief");
        int companyState = (request.getParameter("companyState") == null) ? 3 : Integer.parseInt(request.getParameter("companyState"));
        int companySort = Integer.parseInt(request.getParameter("companySort"));
        //定义Part对象part来获取提交的图片属性
        Part part = request.getPart("companyPic");
        //创建company对象
        Company company = new Company();
        //创建路径为path的文件夹来存放提交的图片
        String path = "D:/aaa";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        //定义SimpleDateFormat对象sdf并设定输出格式为yyyyMMddHHmmss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        //获取当前系统时间，并以yyyyMMddHHmmss格式输出
        String date = sdf.format(new Date());
        //Date date = new Date();
        //String data = sdf.format(date);
        part.write(path + "/" + date + ".png");

        company.setCompanyName(companyName);
        company.setCompanyArea(companyArea);
        company.setCompanySize(companySize);
        company.setCompanyType(companyType);
        company.setCompanyState(companyState);
        company.setCompanyBrief(companyBrief);
        company.setCompanySort(companySort);
        company.setCompanyPic(part);

        //String filepath = getServletContext().getRealPath("/");
        //String filepathname = filepath+filename;
        //定义路径名称变量并赋值
        String filepathname = path + "/" + date + ".png";
        company.setcompanyPicpathName(filepathname);

        //filepath getRealPath("/")
        //part.getSubmitedFileName
        //创建companydao对象
        CompanyDAO companydao = new CompanyDAO();
        //执行向数据库插入数据保存操作
        companydao.save(company);
        out.println("<script type = 'text/javascript'>");
        out.print("alert('添加成功!');");
        out.print("window.location ='CompanyServlet?type=list';");
        out.print("</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}