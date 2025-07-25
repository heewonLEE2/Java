package pub2504.jdbc.board.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pub2504.jdbc.board.dao.ReplyDao;
import pub2504.jdbc.board.model.Reply;
import pub2504.jdbc.board.util.ConnectionUtil;

public class ReplyDaoImpl implements ReplyDao{

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ReplyDaoImpl() {
		conn = ConnectionUtil.getConnectionUtil().getConnection();
	}
	
	@Override
	public List<Reply> listReply() throws SQLException {
		String sql = " select rid, rcontent, rregdate, rdelyn, aid, mid from reply ";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Reply> replyList = new ArrayList<Reply>();
		if(rs!= null) {
			while(rs.next()) {
				Reply reply = new Reply();
				reply.setRid(rs.getInt("rid"));
				reply.setRcontent(rs.getString("rcontent"));
				reply.setRregdate(rs.getTimestamp("rregdate"));
				reply.setRdelyn(rs.getString("rdelyn"));
				reply.setAid(rs.getInt("aid"));
				reply.setMid(rs.getString("mid"));
				replyList.add(reply);
			}
		}
		return replyList;
	}

	@Override
	public Reply getReply(int rid) throws SQLException {
		String sql = " select rid, rcontent, rregdate, rdelyn, aid, mid from reply where rid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, rid);
		rs = pstmt.executeQuery();
		Reply reply = new Reply();		
		if(rs!= null) {
			if(rs.next()) {
				reply.setRid(rs.getInt("rid"));
				reply.setRcontent(rs.getString("rcontent"));
				reply.setRregdate(rs.getTimestamp("rregdate"));
				reply.setRdelyn(rs.getString("rdelyn"));
				reply.setAid(rs.getInt("aid"));
				reply.setMid(rs.getString("mid"));
			}
		}
		return reply;
	}

	@Override
	public int registReply(Reply reply) throws SQLException {
		String sql = " insert into reply values(seq_reply.nextval, ?, systimestamp, 'N', ?, ?) ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, reply.getRcontent());
		pstmt.setInt(2, reply.getAid());
		pstmt.setString(3, reply.getMid());
		return pstmt.executeUpdate();
	}
	
	@Override
	public int modifyReply(Reply reply) throws SQLException {
		String sql = " update reply set rcontent=? where rid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, reply.getRcontent());
		pstmt.setInt(2, reply.getRid());
		return pstmt.executeUpdate();
	}

	@Override
	public int removeReply(int rid) throws SQLException {
		String sql = " delete reply where rid=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,rid);
		return pstmt.executeUpdate();
	}
	
} // class


























