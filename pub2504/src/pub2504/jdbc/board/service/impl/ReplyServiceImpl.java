package pub2504.jdbc.board.service.impl;

import java.sql.SQLException;
import java.util.List;

import pub2504.jdbc.board.dao.ReplyDao;
import pub2504.jdbc.board.dao.impl.ReplyDaoImpl;
import pub2504.jdbc.board.model.Reply;
import pub2504.jdbc.board.service.ReplyService;

public class ReplyServiceImpl implements ReplyService{

	private ReplyDao replyDao;

	public ReplyServiceImpl() {
		replyDao = new ReplyDaoImpl();
	}
	
	@Override
	public List<Reply> listReply()  throws SQLException{
		return replyDao.listReply();
	}
	
	@Override
	public Reply getReply(int rid)  throws SQLException{
		return replyDao.getReply(rid);
	}
	
	@Override
	public int registReply(Reply reply)  throws SQLException{
		return replyDao.registReply(reply);
	}
	
	@Override
	public int modifyReply(Reply reply)  throws SQLException{
		return replyDao.modifyReply(reply);
	}
	@Override
	public int removeReply(int rid)  throws SQLException{
		return replyDao.removeReply(rid);
	}
	
}

