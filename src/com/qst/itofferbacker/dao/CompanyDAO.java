package com.qst.itofferbacker.dao;

import com.qst.itofferbacker.javabean.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qst.itofferbacker.util.DBUtil;

public class CompanyDAO {

    public void save(Company company) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO TB_COMPANY(COMPANY_ID,COMPANY_NAME,COMPANY_AREA,COMPANY_SIZE,COMPANY_TYPE,COMPANY_BRIEF,COMPANY_STATE,COMPANY_SORT,COMPANY_PIC" +
                ") VALUES(SEQ_ITOFFER_COMPANY.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, company.getCompanyName());
            pstmt.setString(2, company.getCompanyArea());
            pstmt.setString(3, company.getCompanySize());
            pstmt.setString(4, company.getCompanyType());
            pstmt.setString(5, company.getCompanyBrief());
            pstmt.setInt(6, company.getCompanyState());
            pstmt.setInt(7, company.getCompanySort());
            pstmt.setString(8, company.getcompanyPicpathName());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
    }

    public void update(Company company) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "UPDATE TB_COMPANY SET COMPANY_NAME = ?,COMPANY_AREA = ?,COMPANY_SIZE = ?,COMPANY_TYPE = ?,COMPANY_BRIEF = ?,COMPANY_STATE = ?,COMPANY_SORT = ?,COMPANY_PIC = ? "
                + "WHERE COMPANY_ID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, company.getCompanyName());
            pstmt.setString(2, company.getCompanyArea());
            pstmt.setString(3, company.getCompanySize());
            pstmt.setString(4, company.getCompanyType());
            pstmt.setString(5, company.getCompanyBrief());
            pstmt.setInt(6, company.getCompanyState());
            pstmt.setInt(7, company.getCompanySort());
            pstmt.setString(8, company.getcompanyPicpathName());
            pstmt.setInt(9, company.getCompanyId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }


    }

    public Company selectById(int cid) {
        Company c = new Company();
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT COMPANY_ID,COMPANY_NAME,COMPANY_AREA,COMPANY_SIZE,COMPANY_TYPE,COMPANY_STATE,COMPANY_SORT,COMPANY_VIEWNUM "
                + "FROM TB_COMPANY WHERE COMPANY_ID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cid);
            //此处为打log
            System.out.println(cid);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                c.setCompanyId(rs.getInt(1));
                c.setCompanyName(rs.getString(2));
                c.setCompanyArea(rs.getString(3));
                c.setCompanySize(rs.getString(4));
                c.setCompanyType(rs.getString(5));
                c.setCompanyState(rs.getInt(6));
                c.setCompanySort(rs.getInt(7));
                c.setCompanyViewnum(rs.getInt(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //此处为打log
            System.out.println(c.getCompanyName());

            DBUtil.closeJDBC(rs, pstmt, conn);
        }

        return c;
    }

    public List<Company> selectAll() {
        List<Company> list = new ArrayList<Company>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT COMPANY_ID,COMPANY_NAME,COMPANY_AREA,COMPANY_SIZE,COMPANY_TYPE,COMPANY_STATE,COMPANY_SORT,COMPANY_VIEWNUM" +
                " FROM TB_COMPANY ORDER BY COMPANY_ID DESC";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Company company = new Company();
                company.setCompanyId(rs.getInt(1));
                company.setCompanyName(rs.getString(2));
                company.setCompanyArea(rs.getString(3));
                company.setCompanySize(rs.getString(4));
                company.setCompanyType(rs.getString(5));
                company.setCompanyState(rs.getInt(6));
                company.setCompanySort(rs.getInt(7));
                company.setCompanyViewnum(rs.getInt(8));
                list.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pstmt, conn);
        }
        return list;
    }
}