package com.qst.itofferbacker.servlet;

import com.qst.itofferbacker.dao.CompanyDAO;
import com.qst.itofferbacker.javabean.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/CompanyServlet")
@MultipartConfig
public class CompanyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求字符编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取请求操作
        String type = request.getParameter("type");

        if("list".equals(type)) {
            CompanyDAO dao = new CompanyDAO();
            //企业列表查询
            List<Company> list = dao.selectAll();
            //将查询到的企业列表数据存入请求域属性中
            request.setAttribute("list", list);
            //请求转发到企业列表界面
            request.getRequestDispatcher("manage/companyList.jsp").forward(request, response);
        }
        else if("updateServlet".equals(type)){
            //企业信息查询
            int companyId = Integer.parseInt(request.getParameter("companyId"));
            CompanyDAO dao = new CompanyDAO();
            Company company = dao.selectById(companyId);
            //将公司基本信息存入request对象进行请求转发
            request.setAttribute("company",company);
            //System.out.println("test"+request.getAttribute(company.getCompanyName()));
            //请求转发到企业修改界面
            request.getRequestDispatcher("manage/companyUpdate.jsp").forward(request,response);
        }
        else if("update".equals(type)){
            int companyId = Integer.parseInt(request.getParameter("companyId"));
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
            part.write(path + "/" + date + ".png");
            company.setCompanyId(companyId);
            company.setCompanyName(companyName);
            company.setCompanyArea(companyArea);
            company.setCompanySize(companySize);
            company.setCompanyType(companyType);
            company.setCompanyState(companyState);
            company.setCompanyBrief(companyBrief);
            company.setCompanySort(companySort);
            company.setCompanyPic(part);
            //定义路径名称变量并赋值
            company.setcompanyPicpathName(path + "/" + date + ".png");
            //创建companydao对象
            CompanyDAO companydao = new CompanyDAO();
            //执行向数据库插入数据保存操作
            companydao.update(company);
            //企业列表查询
            List<Company> list = companydao.selectAll();
            //将查询到的企业列表数据存入请求域属性中
            request.setAttribute("list", list);
            //请求转发到企业列表界面
            request.getRequestDispatcher("manage/companyList.jsp").forward(request, response);

        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
