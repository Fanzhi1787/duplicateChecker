import java.sql.*;
import java.util.Scanner;
public class nixinlei_Login
{
	  private static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	  private static final String URL = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=./atm.mdb";
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		System.out.println("�����û�����");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();  
		System.out.println("�������룺");
		String password = sc.nextLine();

		    try
			{
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				
				return ;
			}
	 
		   try
		{
			Connection hd =  DriverManager.getConnection(URL);

			   String sql = "select * from atm where name=?";  
			   PreparedStatement gr = hd.prepareStatement(sql);
			   gr.setString(1, name); 
    
			   ResultSet  dg = gr.executeQuery();

			   String dbpassword = null;
			   String dbname = null;
			   while(dg.next())
			   {
				   dbpassword = dg.getString("password");  
				   dbname = dg.getString("name");
				   break;
			   }
 
			   if(name.equals(dbname) && password.equals(dbpassword))
			   {
				   System.out.println(" ��¼�ɹ�");
			   }
			   else
			   {
				   System.out.println(" ��¼ʧ��");
			   }
			   dg.close();
			   gr.close();
			   hd.close();
		} 
		   catch (SQLException e)
		{
			// TODO Auto-generated catch block
		   return;
		}
		   
		
	}

}