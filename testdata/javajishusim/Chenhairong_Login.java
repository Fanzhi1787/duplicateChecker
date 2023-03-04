import java.sql.*;
import java.util.Scanner;
public class Chenhairong_Login
{
	  private static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	  private static final String URL = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=./atm.mdb";
	  public static void main(String[] args)
	  {
		System.out.println("�������û�����");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();  
		System.out.println("���������룺");
		String password = sc.nextLine();
		    try
			{
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e)
			{
				e.printStackTrace();
				System.out.println("���ݿ����ʧ�ܣ��������˳�");
				return;
			}
		   try
		{
			Connection conn =  DriverManager.getConnection(URL);
			String sql = "select * from atm where name=?";  
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, name); 
			ResultSet  rs = pst.executeQuery();
			String dbpassword = null;
			String dbname = null;
			while(rs.next()){
			dbpassword = rs.getString("password");  
			dbname = rs.getString("name");
			break;
		  }
		  if(name.equals(dbname) && password.equals(dbpassword)){
		  System.out.println(" ��¼�ɹ�");
		  }else{
		  System.out.println(" ��¼ʧ��");
		  }   
		} catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("���ݿ��ȡ����ϵͳ���˳�");
			return;
		}	
	}
}
