
import java.sql.*;

import java.util.Scanner;

public class weiqi_Login
{
	  private static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	  private static final String URL = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=./atm.mdb";
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("�������û�����");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();  
		
		System.out.println("���������룺");
		String password = sc.nextLine();
	  
	 
		try{
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.out.println("���ݿ���������ʧ�ܣ������˳���");
				//return ;
			    }
	  
		    try{
			   Connection conn =  DriverManager.getConnection(URL);

			   String sql = "select * from atm where name=?";  
			   PreparedStatement y = conn.prepareStatement(sql);
			   y.setString(1, name); 
			   ResultSet  x = y.executeQuery();
			   
			   String dbpassword = null;
			   String dbname = null;
			   while(x.next()){
				   dbpassword = x.getString("password"); 
				   dbname = x.getString("name");
				   break;
			   }
 
			   if(name.equals(dbname)&&password.equals(dbpassword))
			   {
				   System.out.println(" ��¼�ɹ�");
			   }else{
				   System.out.println(" ��¼ʧ��");
			   }
		  } catch (SQLException e)
		  {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			//System.out.println("���ݿ��ȡ����ϵͳ�˳���");
			//return;
		}
		   
		
	}

}

