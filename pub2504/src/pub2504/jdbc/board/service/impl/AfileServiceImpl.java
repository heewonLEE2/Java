package pub2504.jdbc.board.service.impl;

import java.sql.SQLException;
import java.util.List;

import pub2504.jdbc.board.dao.AfileDao;
import pub2504.jdbc.board.dao.impl.AfileDaoImpl;
import pub2504.jdbc.board.model.Afile;
import pub2504.jdbc.board.service.AfileService;

public class AfileServiceImpl implements AfileService {

	private AfileDao afileDao;
	
	public AfileServiceImpl(){
		afileDao = new AfileDaoImpl();
	}

	@Override
	public List<Afile> listAfile() throws SQLException {
		return afileDao.listAfile();
	}

	@Override
	public Afile getAfile(int afid) throws SQLException {
		return afileDao.getAfile(afid);
	}

	@Override
	public int registAfile(Afile afile) throws SQLException {
		return afileDao.registAfile(afile);
	}

	@Override
	public int modifyAfile(Afile afile) throws SQLException {
		return afileDao.modifyAfile(afile);
	}

	@Override
	public int removeAfile(int afid) throws SQLException {
		return afileDao.removeAfile(afid);
	}

}









