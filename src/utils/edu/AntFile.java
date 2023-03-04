package utils.edu;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Copy;
import org.apache.tools.ant.taskdefs.Delete;
import org.apache.tools.ant.taskdefs.Expand;
import org.apache.tools.ant.taskdefs.Mkdir;
import org.apache.tools.ant.taskdefs.Move;
import org.apache.tools.ant.types.FileSet;



/**
 * 2013.12.19
 * ant �ļ�Ŀ¼�Ľ������ƶ���ѹ����ɾ���ȵĲ���
 * @author zq
 *
 */
public class AntFile {
	//��ѹ���ļ�,src��ѹ���ļ���dest�ǽ�ѹ��Ŀ��Ŀ¼���ɹ�����1��ʧ�ܷ���-1
	public static int unzip(File src,File dest){
		int res = -1;
		try {
			Project prj=new Project(); 
			Expand expand=new Expand(); 
			expand.setProject(prj); 
			expand.setSrc(src); 
			expand.setOverwrite(true); 
			expand.setDest(dest); 
			expand.execute();
			res = 1;
		} catch (BuildException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		} 
		return res;
	}
	
	//ɾ��Ŀ¼�����������ļ�����Ŀ¼,�ɹ�����1��ʧ�ܷ���-1
	public static int deleteDir(File f){
		int res = -1;
    	try {
			Project prj=new Project(); 
			Delete delete=new Delete(); 
			delete.setProject(prj); 
			delete.setDir(f); //��ͬʱ����Ŀ¼�������ļ�ɾ�� 
			delete.execute();
			res = 1;
		} catch (BuildException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return res;
	}
	
	//ɾ���ļ�,�ɹ�����1��ʧ�ܷ���-1
	public static int deleteFile(File f){
		int res = -1;
    	try {
			Project prj=new Project(); 
			Delete delete=new Delete(); 
			delete.setProject(prj); 
			delete.setFile(f); //��ͬʱ����Ŀ¼�������ļ�ɾ�� 
			delete.execute();
			res = 1;
		} catch (BuildException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return res;
	}
	// �ļ�ɨ��.f��ɨ���·����filterָ�����˵����������ط����������ļ��������·��������, ʧ��Ϊ���򷵻�null
	// filter={"**/*.java"} ��
	public static String[] scanFiles(File f,String[] filter){
		String[] includeFiles = null;
		try {
			DirectoryScanner ds=new DirectoryScanner(); 
			
			ds.setBasedir(f); 
			ds.setIncludes(filter);  //**/*.java
			ds.scan(); 
			if(ds.getIncludedFilesCount()>0) { 	 
			 includeFiles=ds.getIncludedFiles(); 
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return includeFiles;
		 
	}
	//����Ŀ¼���ɹ�����1��ʧ�ܷ���-1
	public static int makeDir(File f){
		int res = -1;
		try {
			Project prj=new Project(); 
			Mkdir mkdir=new Mkdir(); 
			mkdir.setProject(prj); 
			mkdir.setDir(f); 
			mkdir.execute(); 
			res = 1;
		} catch (BuildException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	//�����ļ���src�������ļ���destĿ��·�����ɹ�����1��ʧ�ܷ���-1
	public static int copy(File src ,File dest){
		int res = -1;
		try {
			Project prj=new Project(); 
			Copy copy=new Copy(); 
			copy.setProject(prj); 
			copy.setFile(src); 
			copy.setTodir(dest); 
			copy.execute(); //��f1.txt�ļ�copy��dir1�� 
			res = 1;
		} catch (BuildException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
	}
	//�ļ�����
	public static int rename(File srcf,File destf){
		int res = -1;
		
		try {
			Project prj=new Project(); 
			Move copy=new Move(); 
			copy.setProject(prj); 
			copy.setFile(srcf); 
			copy.setTofile(destf); 
			copy.execute(); //��f1.txt�ļ�����Ϊf2.txt�� 
			res = 1;
		} catch (BuildException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	//��f�µ�zip�ļ���ѹ��f�£�ԭzip�ļ�ɾ����
	public static void unzip(File f,boolean bdel){
		String[] filter={"*.zip"};  
		String[] files = AntFile.scanFiles(f, filter);
		if(files!=null){ //��zip�ļ�
		  for(String file:files){	
			int res = AntFile.unzip(new File(f.getAbsoluteFile()+"\\"+file), f);
			if(res>0 && bdel){ //��ѹ�ɹ�, ������ɾ������ɾ��ԭzip�ļ�
				AntFile.deleteFile(new File(f.getAbsoluteFile()+"\\"+file));  //ɾ��ѹ���ļ�
			}
		  }
		}
	}
		
	//�� ָ��Ŀ¼�µ��ļ����Ƶ�Ŀ��Ŀ¼��
	public static void copy(File  srcdir,File desdir,String match){
		
		Project prj=new Project(); 
		Copy copy=new Copy(); 
    	copy.setProject(prj);
    	FileSet fileset=new FileSet(); 
		fileset.setProject(prj);
		fileset.setDir(srcdir);
	    if(match==null)
		  fileset.setIncludes("**/*.*");  //Ŀ¼�µ������ļ�,����Ŀ¼��
	    else
	      fileset.setIncludes(match);	
	    
	    copy.addFileset(fileset);
		copy.setTodir(desdir);
		copy.execute();		
	}
	
	
	public static void main(String[] args){
		File src =new File("./demo/7/Selenium.zip"); //��֧��rar�ļ��Ľ�ѹ
		File dest=new File("./testdata/doccn/");
	//	AntFile.unzip(src, dest);
		
		 //AntFile.deleteFile(src); //pass test
		//AntFile.deleteDir(new File(dest.getAbsoluteFile()+"\\zhengchaota_atm"));
		//��ȡָ��Ŀ¼�µ�����java�ļ�������Ŀ¼�µ�
		String[] filter={"**/*.doc"};  //"*.zip"
		String[] files = AntFile.scanFiles(dest, filter);
		if(files!=null){
			for(String str:files){
				System.out.println(str);
			}
		}
		
		//�ڵ�ǰ·���´���һ��Ŀ¼
	//	AntFile.makeDir(new File("./temp"));
		
	}
 
}
