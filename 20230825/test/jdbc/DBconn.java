package test.jdbc;
// JDBC�� ����Ŭ ���� Ȯ��
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:hr";
		String user = "SYSTEM";
		String password = "hr";
		
		try {
			//driver �ε�
			Class.forName(driver);
			System.out.println("jdbc driver �ε� ����");
			//DB�� ����
			DriverManager.getConnection(url, user, password);
			System.out.println("����Ŭ ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver �ε� ����");
		} catch (SQLException e) {
			System.out.println("����Ŭ ���� ����");
		}
	}
}