import java.sql.*;
import java.util.Scanner;
public class zhuyan_Login
{
	private static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	private static final String URL = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=./atm.mdb";
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("�����û�����");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("�������룺");
		String password = sc.nextLine();
	    try
		{
			Class.forName(DRIVER);
		}
	    catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("���ݿ���������ʧ�ܣ������˳�");
			return ;
		}

	}

}
