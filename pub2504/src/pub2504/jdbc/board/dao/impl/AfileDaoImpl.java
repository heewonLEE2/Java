package pub2504.jdbc.board.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pub2504.jdbc.board.dao.AfileDao;
import pub2504.jdbc.board.model.Afile;
import pub2504.jdbc.board.util.ConnectionUtil;

public class AfileDaoImpl implements AfileDao{

	private Connection conn; 
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public AfileDaoImpl() {
		conn = ConnectionUtil.getConnectionUtil().getConnection();
	}
	
	@Override
	public List<Afile> listAfile() throws SQLException{
		String sql = " select afid, afsfname, afcfname, afregdate, afdelyn, aid from afile ";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Afile> afileList = new ArrayList<Afile>();
		if(rs!=null) {
			while(rs.next()) {
				Afile afile = new Afile();
				afile.setAfid(rs.getInt("afid"));
				afile.setAfsfname(rs.getString("afsfname"));
				afile.setAfcfname(rs.getString("afcfname"));
				afile.setAfregdate(rs.getTimestamp("afregdate"));
				afile.setAfdelyn(rs.getString("afdelyn"));
				afile.setAid(rs.getInt("aid"));
				afileList.add(afile);
			}
		}
		return afileList;
	}

	@Override
	public Afile getAfile(int afid)  throws SQLException{
		String sql = " select afid, afsfname, afcfname, afregdate, afdelyn, aid from afile where afid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, afid);
		rs = pstmt.executeQuery();
		Afile afile = new Afile();
		if(rs!=null) {
			if(rs.next()) {
				afile.setAfid(rs.getInt("afid"));
				afile.setAfsfname(rs.getString("afsfname"));
				afile.setAfcfname(rs.getString("afcfname"));
				afile.setAfregdate(rs.getTimestamp("afregdate"));
				afile.setAfdelyn(rs.getString("afdelyn"));
				afile.setAid(rs.getInt("aid"));
			}
		}
		return afile;
	}
	
	@Override
	public int registAfile(Afile afile)  throws SQLException{
		String sql = " insert into afile values(seq_afile.nextval, ?, ?, systimestamp, 'N', ?) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, afile.getAfsfname());
		pstmt.setString(2, afile.getAfcfname());
		pstmt.setInt(3, afile.getAid());
		return pstmt.executeUpdate();
	}

	@Override
	public int modifyAfile(Afile afile)  throws SQLException{
		String sql = " update afile set afsfname=?, afcfname=? where afid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, afile.getAfsfname());
		pstmt.setString(2, afile.getAfcfname());
		pstmt.setInt(3, afile.getAfid());
		return pstmt.executeUpdate();
	}

	@Override
	public int removeAfile(int afid)  throws SQLException{
		String sql = " delete afile where afid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, afid);
		return pstmt.executeUpdate();
	}
	
}






