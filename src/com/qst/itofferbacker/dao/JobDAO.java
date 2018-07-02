package com.qst.itofferbacker.dao;

import com.qst.itofferbacker.javabean.Job;
import com.qst.itofferbacker.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {

    public void save(Job job) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO TB_JOB(JOB_ID,COMPANY_ID,JOB_NAME,JOB_HIRINGNUM,JOB_SALARY,JOB_AREA,JOB_ENDTIME,JOB_STATE" + ")VALUES(SEQ_ITOFFER_JOB.NEXTVAL,?,?,?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, job.getCompanyId());
            pstmt.setString(2, job.getJobName());
            pstmt.setInt(3, job.getJobHiringnum());
            pstmt.setString(4, job.getJobSalary());
            pstmt.setString(5, job.getJobArea());
            pstmt.setString(6, job.getJobEndtime());
            pstmt.setInt(7, job.getJobState());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(null, pstmt, conn);
        }
    }

    public List<Job> selectAll() {
        List<Job> list = new ArrayList<Job>();
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT JOB_ID,JOB_NAME,JOB_HIRINGNUM,JOB_ENDTIME,JOB_STATE" +
                " FROM TB_JOB ORDER BY JOB_ID DESC";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Job job = new Job();
                job.setJobId(rs.getInt(1));
                job.setJobName(rs.getString(2));
                job.setJobHiringnum(rs.getInt(3));
                job.setJobEndtime(rs.getString(4));
                job.setJobState(rs.getInt(5));
                list.add(job);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeJDBC(rs, pstmt, conn);
        }
        return list;
    }
}
