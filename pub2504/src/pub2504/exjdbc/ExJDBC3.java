package pub2504.exjdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleArray;
import oracle.jdbc.internal.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import oracle.sql.STRUCT;
import pub2504.util.ConnectionUtil;

public class ExJDBC3 {

	public static void main(String[] args) {
		
		Connection conn = ConnectionUtil.getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			
			cstmt = conn.prepareCall(" {? = call SELECT_STUDENT(?)} ");
			cstmt.setInt(2, 4);
			cstmt.registerOutParameter(1, OracleTypes.STRUCT, "OBJ_STU");
			
			cstmt.execute();
			
			STRUCT result = (STRUCT)cstmt.getObject(1);
			Object[] attributes = result.getAttributes();
			List<Object> list = new ArrayList();
			
			for(Object att : attributes) {
				list.add(att);
			}
			
			list.stream().forEach(System.out::println);
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		ConnectionUtil.closeConnection(conn, cstmt, rs);
		
	} // main
} // class




















































