package pub2504.jdbc.board.dao;

import java.sql.SQLException;
import java.util.List;

import pub2504.jdbc.board.model.Afile;

public interface AfileDao {

	public abstract List<Afile> listAfile() throws SQLException;

	public abstract Afile getAfile(int afid) throws SQLException;

	public abstract int registAfile(Afile afile) throws SQLException;

	public abstract int modifyAfile(Afile afile) throws SQLException;

	public abstract int removeAfile(int afid) throws SQLException;

}
