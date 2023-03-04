package preprocess.plag.edu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.Tika;
import org.apache.tika.detect.AutoDetectReader;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.MSOffice;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/*
 * 2013.8.28 author:fanghong 
 * 1 ����tika jar��
 * 2 
 */
public class TextExtractor {

	/**
	 * ����Parser�õ��ĵ�������
	 * 
	 * @param f
	 * @return
	 */
	public static String getTxt(File f) {
		FileInputStream is = null;
			
		try {
			is = new FileInputStream(f);
			Tika tika = new Tika();
			Metadata metadata = new Metadata();
			metadata.set(Metadata.RESOURCE_NAME_KEY, f.getName()); //����gbk����txt�ı���ȡ����
			String str = tika.parseToString(new FileInputStream(f),metadata);
		//	System.out.println(f.getName());
		//	System.out.println(str);
			
			return str;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * ����Parser�õ��ĵ�������
	 * @param f
	 * @return
	 */
	public static String fileToTxt(File f,Metadata metadata) {
		Parser parser = new AutoDetectParser();//�Զ�����ĵ����ͣ��Զ�������Ӧ�Ľ�����
		InputStream is = null;
		try {
			
			metadata.set(Metadata.RESOURCE_NAME_KEY, f.getName());
			is = new FileInputStream(f);
			ContentHandler handler = new BodyContentHandler(); //
			ParseContext context = new ParseContext();
			context.set(Parser.class,parser);
			parser.parse(is,handler, metadata,context);
			for(String name:metadata.names()) {
				System.out.println(name+":"+metadata.get(name));
			}
	
			return handler.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		} finally {
			try {
				if(is!=null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //   File f = new File("./testdata/doccn/dongxiao-2.doc");
		 // File f = new File("./testdata/doccn/dongxiao-2.pdf");
		//  File f = new File("./testdata/doccn/dongxiaogbk.txt");
		//  File f = new File("./testdata/doccn/dongxiaoutf8-2.txt");
		  File f = new File("./testdata/doccn/dongxiao-2.html");
          System.out.println(TextExtractor.getTxt(f));  
          Metadata metadata = new Metadata();
          System.out.println(TextExtractor.fileToTxt(f,metadata));    
          System.out.println("author:"+metadata.get(Metadata.AUTHOR));
          System.out.println("create date:"+metadata.get(Metadata.CREATION_DATE));
          
	}

}
