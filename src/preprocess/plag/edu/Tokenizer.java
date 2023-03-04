package preprocess.plag.edu;

import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
import com.hankcs.hanlp.tokenizer.NotionalTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

public class Tokenizer {
    //��������ַ���ת��ָ���ָ��������ķִʹ����ַ���
	public static String segment(String text,String sep) {
		   StringBuilder sb = new StringBuilder();
	       HanLP.Config.Normalization = true; //������->���壬ȫ��->��ǣ���д->Сд��
	       List<Term> tokens = NotionalTokenizer.segment(text);//�ִʣ�ȥ��ͣ�ô�
	       for(Term token : tokens) {
	    	   sb.append(token.word+sep);
	       }
	       return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        HanLP.Config.Normalization = true; //������->���壬ȫ��->��ǣ���д->Сд��
	        CustomDictionary.insert("����4G", "nz 1000");
	        String text = "i am from china."
	        		+ "С�������еķ���ι������è�����еľ���ȴ���޳ɡ�ι����ЩС����,i will go back Home���Ґ� ����";
	        System.out.println(text);
	        //��ȷ�ִ�
	        List<Term> tokens = HanLP.segment(text);
	        System.out.println(tokens);    // ͣ�ôʵ�λ��data/dictionary/stopwords.txt�����������޸�
	        for (Term token : tokens) {
	        	System.out.print("("+token.word+","+token.offset+","+token.length()+")");
	        	
	        }
	        System.out.println();
	        System.out.println("��ȷ�ִ�");
	        //��׼�ִ�
	        tokens = StandardTokenizer.segment("��Ʒ�ͷ���");
	        System.out.println(tokens);
	        for (Term token : tokens) {
	        	System.out.print("("+token.word+","+token.offset+","+token.length()+")");
	        	
	        }
	        System.out.println();
	        System.out.println("�����ִʣ�");
	        //�����ִ�
	        List<Term> termList = IndexTokenizer.segment("����ʳƷ");
	        for (Term term : termList)
	        {
	            System.out.println(term + " [" + term.offset + ":" + (term.offset + term.word.length()) + "]");
	        }
	        System.out.println();
	        System.out.println("ȥ��ͣ�ôʡ������ŷִʣ�");
	        // �Զ�ȥ��ͣ�ô�,�ᶪʧ����ԭ�ļ��е�λ����Ϣ
	        tokens = NotionalTokenizer.segment(text); 
	        System.out.println(tokens);    // ͣ�ôʵ�λ��data/dictionary/stopwords.txt�����������޸�
	        for (Term token : tokens) {
	        	System.out.print("("+token.word+","+token.offset+","+token.length()+")");
	        	
	        }
	        System.out.println();
	        // �Զ��Ͼ�+ȥ��ͣ�ô�
	        for (List<Term> sentence : NotionalTokenizer.seg2sentence(text))
	        {
	            System.out.println(sentence);
	        }
	        //Ӣ���е�ͣ�ô�Ҳ�ᱻȥ��
	        String str = Tokenizer.segment(text," ");
	        System.out.println(str);  
	}

}
