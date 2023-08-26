package test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * JDBC : Java Database Conectivity Framework
 * 1. Driver class load & register (DriverManager)
 * 2. get Connection (url, user, pwd)
 * 3. create Statement
 * 4. execute (sql)
 * 5. result ( , int, recordset)
 * 6. get data
 * 7. close (5, 3, 2)
 * 
 * @author gaiasun
 *
 */
public class TestJDBC {
	private static Statement stmt;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// * 1. Driver class load & register (DriverManager)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// (��) url���� xe -> hr�� ������
		String url = "jdbc:oracle:thin:@localhost:1521:hr"; // database���� url�� ��� �ٸ���. �� DBȸ�� Ȩ���������� ã�ƾ� ��.
		String user = "SYSTEM";  // (��) hr���� SYSTEM���� ����
		String password = "hr";
		
		// * 2. get Connection (url, user, pwd)
		Connection conn = DriverManager.getConnection(url, user, password); 
		// tr������ connection(commit(), rollback())
		// conn.getMetadata() :: DatabaseMetaData, DBA������ �ʿ�.
		
		// * 3. create Statement
		stmt = conn.createStatement(); //db session (1 stmt : 1 resultset)
		// statement : 3����(Statement, PreparedStatement, CallableStatement)
		
		
		// 20230825 �ǽ�
		int result = 0;
		Board board1 = new Board(0, "ȫ�浿", "mrhong@mt.co.kr", "1111", "���� �꿡 ���", "�ڿ����̴�, �꿡 ���. ����...", new Date(), 0, 0, 0, 0, "1");
		Board board2 = new Board("ȫ�浿", "mrhong@mt.co.kr", "1111", "���� �꿡 ���", "�ڿ����̴�, �꿡 ���. ����...", 0, 0, 0, "1");
		
		result = insert(board1);
		result += insert(board2);
		System.out.println("insert:: " + result);
		
		board1 = null;
		int num = 1;
		
		board1 = select(num);
		System.out.println("select:: " + board1);
		
		board1.setName("��浿");
		board1.setEmail("gdkoh@ssangmun.com");
		
		result = update(num, board1);
		board1 = select(num);
		System.out.println("select:: " + board1);
		
		result = delete(num);
		board1 = select(num);
		System.out.println("select:: " + board1);
		
		// * 7. close (5, 3, 2)
		stmt.close();
		conn.close();
	}
	
	// Thread�� �������� �ڵ�: JDBC 2~7���� ��� �������
	// �Լ��� �ʹ� ��������. -> Connection -> Pool�� �����ؾ���.
	private static int delete(int num) throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:hr"; // database���� url�� ��� �ٸ���. �� DBȸ�� Ȩ���������� ã�ƾ� ��.
		String user = "SYSTEM";
		String password = "hr";
		
		// * 2. get Connection (url, user, pwd)
		Connection conn = DriverManager.getConnection(url, user, password); 
		// tr������ connection(commit(), rollback())
		// conn.getMetadata() :: DatabaseMetaData, DBA������ �ʿ�.
		
		// * 3. create Statement
		Statement stmt = conn.createStatement(); //db session (1 stmt : 1 resultset)
		// statement : 3����(Statement, PreparedStatement, CallableStatement)
		
		String sql = "delete from board where num =" + num;
		int result = stmt.executeUpdate(sql);
		
		// * 7. close (5, 3, 2)
		stmt.close();
		conn.close();
		
		return result;
	}

	private static int update(int num, Board board) throws SQLException {
		String sql = "update board set name="
				+ "'" + board.getName() + "',"
				+ "email="
				+ "'" + board.getEmail() + "',"
				+ " subject="
				+ "'" + board.getSubject() + "',"
				+ " content="
				+ "'" + board.getContent() + "',"
				+ " regdate = sysdate"
				+ " where num = " + num;

		// * 4. execute Update(sql)
		int result = stmt.executeUpdate(sql);
		return result;
	}

	private static Board select(int num) throws SQLException{
		String sql = "select * from board where num = " + num;
		
		// * 4. execute (sql)
		ResultSet result = stmt.executeQuery(sql);
		//execute : execute(anySQL-callableSQL), executeUpdate(otherSQL), executeQuery(selectSQL) 
		Board board = null;
		
		// * 5. result ( , int, recordset)
		// ��ü �÷� ���� �����ؼ� ��� �����͸� ���
		// ResultSetMetaData meta = result.getMetaData();
		// result.getMetadata() :: ResultSetMetaData

		// * 6. get data
		while (result.next()) {
			board = new Board(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getDate(7), result.getInt(8), result.getInt(9), result.getInt(10), result.getInt(11), result.getString(12));
		}
		System.out.println(board);
		result.close();
		return board;
	}

	private static int insert(Board board) throws SQLException {
		String sql = "insert into board(num, name, email, pwd, subject, content, regdate, hit, parent, sort, tab, originalfile)\r\n"
				+ "values((select NVL(max(num),0)+1 from board), "
				+ "'" + board.getName() + "',"
				+ "'" + board.getEmail() + "',"
				+ "'" + board.getPwd() + "',"
				+ "'" + board.getSubject() + "',"
				+ "'" + board.getContent() + "',"
				+ "SYSDATE,"
				+ board.getHit() + ","
				+ "(select NVL(max(num),0)+1 from board),"
				+ board.getSort() + ","
				+ board.getTab() + ","
				+ "'" + board.getOriginal() + "')";
		
		// * 4. execute Update(sql): insert, delete, update
		int result = stmt.executeUpdate(sql);
		return result;
	}

}
