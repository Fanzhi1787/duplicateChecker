package utils.edu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * moss��java�ͻ��ˣ�����mossnet
 * 
 *
 */
public class MossClient {
	String server = "moss.stanford.edu";
	int port = 7690;
	String userid="280579252";
	String opt_l = "c";   // default language is c
	int opt_m = 10;
	int opt_d = 0;
	int opt_x = 0;
	String  opt_c = "";
	int opt_n = 2000;
	int bindex = 0;   //this becomes non-zero if we have any base files
	
	
	Socket socket=null;;
	BufferedReader in=null;;
	PrintWriter out=null;
	
	public MossClient(){
		
	}
	
	public MossClient(File file){
		if(file!=null && file.exists()){
			try {
				PrintStream  pw = new PrintStream(file);
				System.setOut(pw);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void upFile(File file,int id){
		System.out.print("Uploading "+file);
		BufferedReader fin = null;
		try {
			long size = file.length();			
			char[] bufs = new char[(int)size];
			fin = new BufferedReader(new FileReader(file) );
			fin.read(bufs);
		//	System.out.println(bufs);
			//д�ļ�������Ϣ
			String optstr = "file "+id+" "+opt_l+" "+size+" "+file+'\n';
			out.print(optstr);
			out.flush();
			//д�ļ�����			
			out.write(bufs, 0, (int)size);
			out.flush();
			System.out.println("...done");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//����ָ��Ŀ¼dir�µ��ļ���moss���������ɹ�����0��ʧ��-1��
	public int sendMoss(File dir , String opt_l){
	    int res = -1;
		try {			
			this.opt_l = opt_l;
			socket = new Socket(server, port);
			socket.setKeepAlive(true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);	//true��ʾ����ˢ��
			
			//1 �����ϴ�����
			String str = "moss "+userid+'\n';
			out.print(str); //�����û���		
			str = "directory "+opt_d+'\n';
			out.print(str);
			str = "X "+opt_x+'\n';
			out.print(str) ;
			str = "maxmatches "+opt_m+'\n';
			out.print(str);
			str = "show "+opt_n+'\n';
			out.print(str);
			str = "language " + this.opt_l+'\n';
			out.print(str);
			out.flush();   //����ˢ�£���������Ӧ
			
			//2 ��ȡ��Ӧ
			String msg = in.readLine();
		  //  System.out.println(msg);   //��������yes
			if("no".equals(msg)){
				return res;
			}
			//�ϴ�dir�µ��ļ�
			File[] files = dir.listFiles();
			for(int i=0;i<files.length;i++){
			  if(files[i].isFile()){	
				upFile(files[i],i+1);
			  }
			}
			
			
			// ������Ӧ
			str = "query 0 "+opt_c+'\n';
			out.print(str);
			out.flush();
		
			System.out.print("Query submitted.  Waiting for the server's response.\n");
			char[] chars = new char[200];
			in.read(chars);
			str = new String(chars).trim()+'\n'; //url��ʽӦ�ϸ񣬷��������ȡurl�������
			System.out.print(str);
			out.print("end\n");
			res = 0;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		   try {
			System.out.close();
			if(in!=null)	
				in.close();
	    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   if(out!=null)
			 out.close();
		   try {
			if(socket!=null)
				socket.close();
		   } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		}
		
		
        return res;		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  String filestr = "mossout.txt";
	  
      MossClient mc = new MossClient(new File(filestr));
      File dir = new File("./testdata/tempsrc");
      mc.sendMoss(dir,"java");
		
		
	}

}
