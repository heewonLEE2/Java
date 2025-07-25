package pub2504.jdbc.board.dao;

import java.sql.SQLException;
import java.util.List;

import pub2504.jdbc.board.model.Reply;

public interface ReplyDao {
	
	public abstract List<Reply> listReply() throws SQLException;

	public abstract Reply getReply(int rid)  throws SQLException;

	public abstract int registReply(Reply reply)  throws SQLException;

	public abstract int modifyReply(Reply reply)  throws SQLException;

	public abstract int removeReply(int rid)  throws SQLException;
}
