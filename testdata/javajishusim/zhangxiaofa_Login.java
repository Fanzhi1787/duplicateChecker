import java.sql.*;
import java.util.Scanner;
    public class zhangxiaofa_Login
    {
	  private static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	  private static final String URL = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=./atm.mdb";
	  public static void main(String[] args)
	  {  System.out.println("�����û�����");
		 Scanner _sc = new Scanner(System.in);
		  String name = _sc.nextLine();  
		   System.out.println("�������룺");
		  String password = _sc.nextLine();
		 try
			{
				Class.forName(DRIVER);
			} 
		     catch (ClassNotFoundException e)
			{	// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   try
		   {
			Connection conn =  DriverManager.getConnection(URL);

			        String _sql = "select * from atm where name=?";
			          PreparedStatement pst = conn.prepareStatement(_sql);
			        pst.setString(1, name); 
			           ResultSet  _rs = pst.executeQuery();
	                String yonghupassword = null;
		            String yonghuname = null;
                while(_rs.next()){
		        yonghupassword = _rs.getString("password");  
		        yonghuname = _rs.getString("name");
				   break;
			   }
  
			        if(name.equals(yonghuname) && password.equals(yonghupassword))
			   {
				    System.out.println(" ��¼�ɹ�");
			   }
			        else
			   {
				     System.out.println(" ��¼ʧ��");
			   }	   
			   
		        }
		   catch (SQLException e)
		   {	
			e.printStackTrace();
	
		    }	   	
	}
}