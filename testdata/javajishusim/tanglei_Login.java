import java.util.Scanner;
import java.sql.*;
public class tanglei_Login {
private static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
private static final String URL = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=./atm.mdb";


public static void main(String[] args) {
System.out.println("�������û���:");
Scanner t = new Scanner(System.in);
		String name = t.nextLine();
System.out.println("���������룺");
	String password = t.nextLine();
	
		 	   try
			{
		Connection conn =  DriverManager.getConnection(URL);
		   String sql = "select * from atm where name=?";
		   PreparedStatement pst = conn.prepareStatement(sql);
				   ResultSet  rs = pst.executeQuery();
			   String dbpassword = null;
		   String dbname = null;
					   while(rs.next()){
					   dbname = rs.getString("name");
				   break;
					   }
		   if(name.equals(dbname) && password.equals(dbpassword)){
				   System.out.println("��¼�ɹ�");
					   }else{
			   System.out.println("��¼ʧ��");
					  }
					   
				  
				} catch (SQLException e)
		{
					e.printStackTrace();
					System.out.println("���ݿ��ȡ����ϵͳ�˳�");
					return;
	}
	}
}
