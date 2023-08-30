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
 * make method(transaction method) : single thread, API�� ������� �ʴ´�.
 * 4. execute (sql)
 * 5. result ( , int, recordset)
 * 6. get data
 * 
 * make method(transaction method) : multi-thread, API(= common module)
 * 2. get Connection (url, user, pwd)
 * 3. create Statement
 * 4. execute (sql)
 * 5. result ( , int, recordset)
 * 6. get data
 * 7. close (5, 3, 2)
 * 
 * total process
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
public class TestJDBC2 {
	/* 
	 * ���ؼ� Ǯ�� ���� �Լ��� �־� �Ѱ� �����ؼ� ���? -> ����
	 * ���ؼ� Ǯ�� �ʵ�(static ����� �����ؼ� �� �Լ����� ���� �Ǵ� Ư���Լ����� �����ؼ� ���?
	 */
	static String url = "jdbc:oracle:thin:@localhost:1521:xe"; // database���� url�� ��� �ٸ���. �� DBȸ�� Ȩ���������� ã�ƾ� ��.
	static String user = "hr";
	static String password = "hr";
//	private static Statement stmt;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ConnectionPool pool = ConnectionPool.getInstance(url, user, password, 3, 5, true, 500);
		int result = 0;
		Board board1 = new Board(0, "ȫ�浿1", "mrhong1@mt.co.kr", "1111", "���� �꿡 ���",
				"�ڿ����̴�, �꿡 ���. ����...", new Date(), 0, 0,0,0,"1");
		Board board2 = new Board("ȫ�浿2", "mrhong2@mt.co.kr", "1111", "���� �꿡 ���",
				"�ڿ����̴�, �꿡 ���. ������?...", 0, 0, 0,"1");
		result = insert(board1);	
		result += insert(board2);
		System.out.println("insert :: " + result);
		board1 = null;
		int num = 5;
		board1 = select(num);
		System.out.println("select :: " + board1);
		board1.setName("��浿");
		board1.setEmail("gdkoh@ssangmun.com");
		/* �� �����尡 ������Ʈ ó�� �߿� �ٸ� �����尡 ����ó���� ���� ������ ��� 
		 * ������Ʈ�� �ϴ� �����忡�� exception�� �߻��Ͽ� �ش� �����尡 �����.
		 * -> �׷���, �� Ʈ������ �Լ����� Connection�� ���� ����(����)�ؾ� ��. 
		 * result = update(num, board1, conn); result = delete(num, conn);
		 */
		result = update(num, board1);
		board1 = select(num);
		System.out.println("select :: " + board1);
//		result = delete(num, pool);
//		board1 = select(num, pool);
//		System.out.println("select :: " + board1);
	}
	/**
	 * Thread�� �������� �ڵ� : JDBC 2 ~ 7���� ��� ����� ��
	 * �Լ��� �ʹ� ��������. -> Connection -> Pool�� �����ؾ� ��.
	 * @param num
	 * @param pool 
	 * @return
	 * @throws SQLException
	 */
	private static int delete(int num) throws SQLException {
		ConnectionPool pool = ConnectionPool.getInstance(url, user, password, 3, 5, true, 500);
		Connection conn = pool.getConnection(); 
		Statement stmt = conn.createStatement();
		String sql = "delete from board where num ="+num;
		int result = stmt.executeUpdate(sql);
		stmt.close();
		pool.releaseConnection(conn);
		return result;
	}

	private static int update(int num, Board board) throws SQLException {
		ConnectionPool pool = ConnectionPool.getInstance(url, user, password, 3, 5, true, 500);
		Connection conn = pool.getConnection(); 
		Statement stmt = conn.createStatement();
		String sql = "update board set name="
				+ "'"+board.getName()+"',"
				+ "email="
				+ "'"+board.getEmail()+"', "
				+ " subject="
				+ "'"+board.getSubject()+"', "
				+ " content="
				+ "'"+board.getContent()+"',"
				+ " regdate = sysdate" + 
				"     where num = "+num;
		int result = stmt.executeUpdate(sql);
		stmt.close();
		pool.releaseConnection(conn);
		return result;
	}

	private static Board select(int num) throws SQLException {
		ConnectionPool pool = ConnectionPool.getInstance(url, user, password, 3, 5, true, 500);
		Connection conn = pool.getConnection(); 
		Statement stmt = conn.createStatement();
		String sql = "select * from board where num = " + num;
		// * 4. execute (sql)
		ResultSet result = stmt.executeQuery(sql);
		//execute : execute(anySQL-callableSQL), executeUpdate(otherSQL), executeQuery(selectSQL) 
		Board board = null;
		// * 5. result ( , int, recordset)
		// * 6. get data
		while (result.next()) {
			board  = new Board(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), 
					result.getString(5), result.getString(6), result.getDate(7), result.getInt(8), 
					result.getInt(9), result.getInt(10), result.getInt(11), result.getString(12));
		}
		System.out.println(board);
		result.close();
		stmt.close();
		pool.releaseConnection(conn);
		return board;
	}

	private static int insert(Board board) throws SQLException {
		ConnectionPool pool = ConnectionPool.getInstance(url, user, password, 3, 5, true, 500);
		Connection conn = pool.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "insert into board(num, name, email, pwd, subject, content, regdate, hit, "
				+ "parent, sort, tab, originalfile)\r\n" + 
				"	values( (select NVL(max(num),0)+1 from board), "
				+ "'"+board.getName()+"',"
				+ "'"+board.getEmail()+"', "
				+ "'"+board.getPwd()+"',"
				+ "'"+board.getSubject()+"', "
				+ "'"+board.getContent()+"',"
				+ "SYSDATE,"
				+ board.getHit()+","
				+ "(select NVL(max(num),0)+1 from board),"
				+ board.getSort()+","
				+ board.getTab()+","
				+ "'"+board.getOriginal()+"')";
		// * 4. execute Update(sql) : insert, delete, update
		int result = stmt.executeUpdate(sql);
		stmt.close();
		pool.releaseConnection(conn);
		return result;
	}

}
