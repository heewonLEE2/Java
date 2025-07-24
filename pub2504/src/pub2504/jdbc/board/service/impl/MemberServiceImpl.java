package pub2504.jdbc.board.service.impl;

import java.sql.SQLException;
import java.util.List;

import pub2504.jdbc.board.dao.MemberDao;
import pub2504.jdbc.board.dao.impl.MemberDaoImpl;
import pub2504.jdbc.board.model.Member;
import pub2504.jdbc.board.service.MemberService;

public class MemberServiceImpl implements MemberService{
	
	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}

	@Override
	public List<Member> listMember() throws SQLException {
		return memberDao.listMember();
	}
	
	@Override
	public Member getMember(String mid) throws SQLException {
		return memberDao.getMember(mid);
	}
	
	@Override
	public int registMember(Member member) throws SQLException {
		return memberDao.registMember(member);
	}
	
	@Override
	public int modifyMember(Member member) throws SQLException {
		return memberDao.modifyMember(member);
	}
	
	@Override
	public int removeMember(String mid) throws SQLException {
		return memberDao.removeMember(mid);
	}
}











