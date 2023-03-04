package gui.plag.edu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import utils.edu.AntFile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FileConvertFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtSrc;
	private JTextField txtDest;
	private JComboBox combType;

	private PlagGUI pgui ;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileConvertFrame frame = new FileConvertFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FileConvertFrame() {
		setTitle("\u63D0\u53D6\u6587\u4EF6");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 300, 450, 300);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSrc = new JTextField();
		txtSrc.setBounds(21, 54, 240, 21);
		contentPane.add(txtSrc);
		txtSrc.setColumns(10);
		
		JButton btnNewButton = new JButton("\u9009\u62E9\u6E90\u76EE\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ѡ��ԴĿ¼
				 JFileChooser dlg = new JFileChooser(".");  //��ʼ·���ǳ���ǰ·��
				 dlg.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
				 dlg.setDialogTitle("ѡ��Դ·�� "); 
				 int result = dlg.showOpenDialog(null); 
				 if (result == JFileChooser.APPROVE_OPTION) { 
				   String path = dlg.getSelectedFile().getAbsolutePath(); 
				   txtSrc.setText(path);
				 }
			}
		});
		btnNewButton.setBounds(306, 53, 114, 23);
		contentPane.add(btnNewButton);
		
		txtDest = new JTextField();
		txtDest.setBounds(20, 131, 241, 21);
		contentPane.add(txtDest);
		txtDest.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u9009\u62E9\u76EE\u6807\u76EE\u5F55");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ѡ��Ŀ��Ŀ¼
				 JFileChooser dlg = new JFileChooser(".");  //��ʼ·���ǳ���ǰ·��
				 dlg.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
				 dlg.setDialogTitle("ѡ��Ŀ��·�� "); 
				 int result = dlg.showOpenDialog(null); 
				 if (result == JFileChooser.APPROVE_OPTION) { 
				   String path = dlg.getSelectedFile().getAbsolutePath(); 
				   txtDest.setText(path);
				 }				
			}
		});
		btnNewButton_1.setBounds(306, 130, 114, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u63D0 \u53D6");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  //ת���ļ�
				String srcstr = txtSrc.getText();
				String deststr = txtDest.getText();
				File srcf = new File(srcstr);
				File destf = new File(deststr);
				if(srcf.exists() && destf.exists() && destf.isDirectory()){
				    String type =  (String)combType.getSelectedItem();
					AntFile.unzip(srcf,false); //�Ƚ�srcf�µ�zip�ļ���ѹ��Դzip���� 
					
					String[] filter = new String[1];
					filter[0]="**/*."+type; //ɨ��������Ŀ¼ָ����չ��
					if("python".equals(type)) {
						filter[0]="**/*.py";
					}
					if("doc".equals(type)){  //�ĵ����ͣ�֧��doc txt docx pdf html
						filter = new String[6];
						filter[0] = "**/*.doc";
						filter[1] = "**/*.txt";
						filter[2] = "**/*.docx";
						filter[3] = "**/*.pdf";
						filter[4] = "**/*.html";
						filter[5] = "**/*.htm";
					}
					
					String[] filestrs = AntFile.scanFiles(srcf, filter); //���غ���Ŀ¼������ļ���
					if(filestrs!=null){
						 int cnt1 = 0;
						 int cnt2 = 0;
						 for(String str:filestrs){
							String filename = null;
							if(str.indexOf("\\")>=0)
							  filename = str.substring(str.lastIndexOf("\\")); 
							if(filename.indexOf("_")>0 || filename.indexOf("-")>0){ //�ļ��������������
								cnt1++;
								if(cnt1>1){  //�ļ���ǰ��������ע���������ԭ�ļ�ֱ�Ӹ��Ƶ�Ŀ��Ŀ¼
								  for(int i=0;i<filestrs.length;i++){ 	
									AntFile.copy(new File(srcf.getAbsoluteFile()+"\\"+filestrs[i]), destf);
								  }
								  break; //�������ֱ���˳����ѭ��
								}									
							}else{ //�ļ�������_- ,˵���ļ���δ������ƴ�������java��ҵ����2��3���ļ���������ǰ׺�����
								cnt2++;
								if(cnt2>1){
									File[] dics = srcf.listFiles(); // ��ȡ��Ŀ¼��������Ŀ¼����Ϊǰ׺
									for(int i=0;i<dics.length;i++){
									 if(dics[i].isDirectory()){	
										String dicname = dics[i].getName()+"_";
										String[] fstrs = AntFile.scanFiles(dics[i], filter);
										if(fstrs!=null){
										 for(String tempstr:fstrs){  //��������Ƶ�Ŀ��Ŀ¼���ٸ���
											String fn = tempstr;
								 		    if(tempstr.indexOf("\\")>=0)
												  fn = tempstr.substring(tempstr.lastIndexOf("\\")+1); 
											AntFile.copy(new File(dics[i].getAbsoluteFile()+"\\"+ tempstr), destf);
											AntFile.rename(new File(destf.getAbsoluteFile()+"\\"+fn), 
													        new File(destf.getAbsoluteFile()+"\\"+dicname+fn));
										 }
										}
									 }
									}
									
								  break;	//�˳������ѭ��
								}//		
							}							
						 }//for
						 JOptionPane.showMessageDialog(FileConvertFrame.this, "�ļ�ת������");
					     pgui.getTxtAssignPath().setText(txtDest.getText());  //��Ŀ��·�����õ������ڵ���ҵ·����
					}else{
						JOptionPane.showMessageDialog(FileConvertFrame.this, "ָ�����͵��ļ�������");
					}
					
					
				}else{
					JOptionPane.showMessageDialog(FileConvertFrame.this, "Դ·����Ŀ��·��ѡ�����������ѡ��");
				}
					
					
				
			}
		});
		btnNewButton_2.setBounds(306, 199, 114, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\u63D0\u53D6\u7684\u6587\u4EF6\u7C7B\u578B");
		lblNewLabel.setBounds(21, 203, 101, 15);
		contentPane.add(lblNewLabel);
		
		combType = new JComboBox();
		combType.setModel(new DefaultComboBoxModel(new String[] {"java", "c", "cpp", "python", "doc"}));
		combType.setBounds(170, 200, 91, 21);
		contentPane.add(combType);
	}

	public void setPgui(PlagGUI pgui) {
		this.pgui = pgui;
	}
}
