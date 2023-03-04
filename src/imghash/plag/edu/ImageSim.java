package imghash.plag.edu;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.kilianB.hash.Hash;
import com.github.kilianB.hashAlgorithms.HashingAlgorithm;
import com.github.kilianB.hashAlgorithms.PerceptiveHash;
import com.github.kilianB.hashAlgorithms.RotPHash;

import data.plag.edu.SimData;
import utils.edu.FileIO;

public class ImageSim {
	 String dic = null;  //��ҵ·����
     float  threshold = 0.8f; //ͼƬ��������Ĭ����0.8
     List<File> filels = new ArrayList<File>(); //��Ҫ�Ƚϵ��ļ�
	 List<SimData> listsd = new ArrayList<SimData>(); //�ļ��ȽϵĽ��

		 //������Ŀ¼�µķ�����չ��Ҫ����ļ�������Ŀ¼�µģ�����ȡ����
		public void explore(File file) {
			if (file != null && file.isDirectory()) {
				File[] files = file.listFiles(new Fileter());
				for (File tempfile : files) {
					if (tempfile.isDirectory()) {
						explore(tempfile);// �������Ŀ¼����ݹ����
					} else {
						filels.add(tempfile);

					}
				}

			}
		}

		// ʵ���ļ����˽ӿڣ��ڲ��෽ʽ,ֻ����ָ����չ�����ļ�����Ŀ¼
		class Fileter implements FileFilter {
			@Override
			public boolean accept(File arg0) {
				// TODO Auto-generated method stub
				String fn = arg0.getName().toLowerCase();
				if (fn.endsWith(".png")  //
						|| fn.endsWith(".jpg")
						|| fn.endsWith(".jpeg") 
						|| fn.endsWith(".gif") 
						|| fn.endsWith(".bmp")
						|| fn.endsWith(".tiff")
						|| arg0.isDirectory())
					return true;
				return false;
			}
		}

		
		
		//�Ƚ�ָ��Ŀ¼�µ�ͼƬ�ļ����ƶȣ����س���ָ������ֵ�������ļ�����
		void ImageSimFiles(float threshold){	
			  List<Hash> listhashs = 	new ArrayList<Hash>();
			  HashingAlgorithm hasher = new PerceptiveHash(128);  //128λphash
			  // HashingAlgorithm hasher = new RotPHash(256);  //���ж���ת����ͼƬ
			   //�ȶ�ȡͼƬ�ļ�������hashֵ			
			   for(int i=0;i<filels.size();i++){
				  File file = filels.get(i);
				  try {
				    Hash hash = hasher.hash(file);				  
				    listhashs.add(hash);
				  }catch(Exception e) {
					  e.printStackTrace();
					  continue ;
				  }				
			   }
			
			   for(int i=0;i<filels.size();i++){				
					
					Hash hash1 = listhashs.get(i);
					
					for(int j=i+1;j<filels.size();j++){
					   
					   Hash hash2 = listhashs.get(j);;
					   
					   double score = hash1.normalizedHammingDistance(hash2);
					   if(score<1-threshold/100){   //scoreԽСԽ����
						 //  System.out.println(score+" "+filels.get(i).getName()+" "+
					       //                      filels.get(j).getName());	
						   SimData sim = new SimData();
						   sim.setSimilar((float)(1-score)*100);
						   sim.setFile1(filels.get(i).getName());
						   sim.setFile2(filels.get(j).getName());
						   listsd.add(sim);
					   }
					  
				    }//for
				   
				  }			
			
		}
		
		//���ȽϽ���ɴ�С���
		void report(){
			
			Collections.sort(listsd); //���б�Ԫ�ذ�����ֵ��С��������
			//Arrays.sort(listsd.toArray());
			
			for(int i=listsd.size()-1;i>=0;i--){  //�ɴ�С���
				System.out.println(listsd.get(i).getSimilar()+" "+listsd.get(i).getFile1()
						+" "+listsd.get(i).getFile2());
			}
		}
		

			

		//���������в������ɹ�0��ʧ��-1
		int setParams(String[] args){
			int res = 0;
			if(args.length<2){
				System.out.println("usage:"+"java -jar ImageSim.jar dic threshold");
				return -1;
			}
			this.dic = args[0];
			File dic = new File(this.dic);
			if(!dic.isDirectory()){
			  System.out.println("dic is not exsit!");
			  return  -1;
			}
			try {
				this.threshold = Float.valueOf(args[1]);
				if(this.threshold<0 || this.threshold>100){
					System.out.println("threshold is outof 0-100");
					return -1;
				}
					
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("threshold is 0-100 number");
				return -1;
			}
	         return res;		
				
		}
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			
			try {
				ImageSim testsc = new ImageSim();
				 
				int res = testsc.setParams(args);
				if(res>=0){
				 long st = System.currentTimeMillis();
				 File file = new File(testsc.dic);		
				
				 testsc.explore(file);  //��ȡ������ͼƬ�ļ�hashֵ
				
				 testsc.ImageSimFiles(testsc.threshold); //����hashֵ�Ƚ�����ֵ
				
				 testsc.report();  //���ɽ��
				 
				 File outfile = new File("out.txt");
				 FileIO.saveFile(outfile, testsc.listsd,2,"from fh"); //������ɴ�С�ŵ�
				 
				 System.out.println("handle documents:"+testsc.filels.size());
				 System.out.println("time:"+(System.currentTimeMillis()-st));
				}else{
					System.out.println("��������");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}


}
