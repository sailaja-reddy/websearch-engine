package com.wsptt;
import java.awt.BorderLayout;
import java.io.File;
import java.net.MalformedURLException;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Query_Processor_Main implements ActionListener {
	String str;
	Socket client;
	String filename;
	String content;
	String us;
	byte[] b;
	String hash;
	public Font f = new Font("Times new roman", Font.BOLD, 25);
	public Font f1 = new Font("Times new roman", Font.BOLD, 18);
	public Font f2 = new Font("Times new roman", Font.BOLD, 16);
	public Font f3 = new Font("Times new roman", Font.BOLD, 18);
	public Font f4 = new Font("Times new roman", Font.BOLD, 15);
	public JLabel T0 = new JLabel("User");

	public JLabel T11 = new JLabel("          ");

	public JLabel T12 = new JLabel("                    ");

	public JTextField head = new JTextField();
	
	public JButton siteMAP = new JButton("Process SiteMAP");
	
	

	public JButton btn = new JButton("Search Efficient Query Results");
	public JButton verify = new JButton("VERIFY");

	public JTextArea tf = new JTextArea();

	public JScrollPane pane = new JScrollPane();

	public JButton btn1 = new JButton("Process Query");

	JLabel imageLabel = new JLabel();
	JLabel image = new JLabel();
	JLabel imageLabel1 = new JLabel();
	JLabel image1 = new JLabel();

	JLabel imageLabel2 = new JLabel();
	JLabel image12 = new JLabel();

	JPanel jp = new JPanel();
	JPanel jp1 = new JPanel();

	public JFrame jf;
	public Container c;
	DataOutputStream out;

	Key secKey;

	JLabel image11,image122;
	ImageIcon im,im1;
	
	MenuBar mbr = new MenuBar();
	Menu file = new Menu("File");

	
	MenuItem item4 = new MenuItem("Exit");
	MenuItem item5 = new MenuItem("Open Generated Log");
	
JLabel lb1,lb2,lb3,lb4,lb5,lb6,lig1,lig2,lig3,low,ldbs,leu,lve,ltm;
	
	JLabel l1,l2,l3,l4,l5,l6;
	private static Connection con;
	ImageIcon ow = new ImageIcon(this.getClass().getResource("do.jpg"));
	String keyword = "2d2b3bef2bfa3a8cfdb0277b25ed94d79ca0cb99";

	Query_Processor_Main(String username) {
		this.us=username;
		jf = new JFrame();
		jf.setTitle(us+"::Energy-efficient Query Processing in Web Search Engines");
		c = jf.getContentPane();
		c.setLayout(null);
		jf.setSize(700, 610);
		
		low=new JLabel();
		low.setIcon(ow);
		low.setBounds(80, 60, 520, 240);
		c.add(low);
		
		l1=new JLabel("Data Owner");
		l1.setFont(f2);
		l1.setForeground(Color.BLUE);
		l1.setBounds(80, 200, 200, 200);
		//c.add(l1);
		
		jf.setMenuBar(mbr);
		mbr.add(file);
		
		//file.add(item3);
		file.add(item5);
		file.add(item4);

		T11.setBounds(180, -3, 1200, 50);
		T12.setBounds(230, 29, 1000, 50);
		//T12.setForeground(Color.MAGENTA);
		//T11.setForeground(Color.MAGENTA);
		T11.setFont(f);
		T12.setFont(f);

		//im = new ImageIcon(this.getClass().getResource("DataOwner.png"));

		Border b11=BorderFactory.createLineBorder(Color.black,2);
		TitledBorder t1=new TitledBorder(b11);
		//t1.setTitle("Adding Query");
		t1.setTitleColor(Color.RED);
		t1.setTitleFont(f1);
		
		JLabel l1=new JLabel();
		l1.setBorder(t1);
		l1.setBounds(5,90,670,380);
		c.add(l1);
		
		
		TitledBorder t2=new TitledBorder(b11);
		//t2.setTitle("Query Retrival Using RASP");
		t2.setTitleColor(Color.RED);
		t2.setTitleFont(f1);
		
		JLabel l2=new JLabel();
		l2.setBorder(t2);
		l2.setBounds(5,480,670,60);
		c.add(l2);
		
		
		image11 = new JLabel();
		image11.setIcon(im);
		image11.setBounds(0, -20, 1200, 110);
		
		ImageIcon banner1 = new ImageIcon(this.getClass().getResource("DataOwner.png"));
		JLabel title1=new JLabel();
		title1.setIcon(banner1);
		title1.setBounds(0, 0, 700, 75);
		

		c.setBackground(Color.white);
		T0.setBounds(440, 60, 350, 45);
		T0.setFont(f);

		T0.setForeground(Color.RED);

		head.setBounds(400, 220, 200, 25);
		head.setFont(f2);
		head.setForeground(Color.cyan);

		btn1.setBounds(190, 500, 150, 30);
		btn1.setFont(f3);
		//btn1.setBackground(Color.black);
		//btn1.setForeground(Color.WHITE);

		jp.setBounds(40, 80, 800, 540);
		jp.setBackground(Color.yellow);

		jp1.setBounds(35, 75, 765, 550);
     
		btn.setBounds(350, 500, 300, 30);
		btn.setFont(f3);
		//btn.setBackground(Color.black);
		//btn.setForeground(Color.WHITE);

		siteMAP .setBounds(10, 500, 170, 30);
		siteMAP .setFont(f3);
	

		verify.setBounds(350, 550, 130, 30);
		verify.setFont(f3);
		//verify.setBackground(Color.black);
		//verify.setForeground(Color.WHITE);

	
		pane.setBounds(120, 270, 350, 200);

		tf.setColumns(100);
		tf.setForeground(Color.black);
		tf.setFont(f1);
		tf.setRows(200);
		tf.setName("tf");
		
		pane.setName("pane");
		pane.setViewportView(tf);

		
		
		btn.addActionListener(this);

		btn1.setMnemonic(KeyEvent.VK_B);
		btn.setMnemonic(KeyEvent.VK_S);
		jf.setVisible(true);

		c.add(btn);
		c.add(siteMAP);
		//c.add(delete);
		//c.add(update);
		c.add(pane, BorderLayout.CENTER);
		c.add(btn1);
	//	c.add(verify);
		c.add(imageLabel1);
		c.add(title1);
		//c.add(jp);
		//c.add(jp1);
		//c.add(image11);
		//c.add(image122);

		verify.addActionListener(this);
		btn1.addActionListener(this);
		siteMAP.addActionListener(this);
		
	
		item4.addActionListener(this);
		item5.addActionListener(this);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent win) {
				System.exit(0);
			}
		});

		
	}

	
	public void actionPerformed(ActionEvent e) {

		String strLine = null;
		
		if (e.getSource() == item5) {
			
			
			try
			{
			
			String filename="crawler.txt";
			
			 File f=new File("D:/1718Workspace1/Energy-efficient Query Processing in Web Search Engines/"+filename);
			 
			 int len = filename.length();
			 
				boolean success= f.isFile();
				
				if (success)
				{
					
					

					int choice=JOptionPane.showConfirmDialog(null, "File Available!!! Do u want to Openit");
					
					if(choice==0){
						
						System.out.println("Yes");
						
						FileInputStream fstream = new FileInputStream(f);
						  // Get the object of DataInputStream
						  DataInputStream in = new DataInputStream(fstream);
						  BufferedReader br = new BufferedReader(new InputStreamReader(in));
						  String strLine1;
							StringBuffer buffer = new StringBuffer();
						  
						  //Read File Line By Line
						  while ((strLine1 = br.readLine()) != null)   {
						  // Print the content on the console
						  System.out.println (strLine);
						  
						  buffer.append(strLine1 + "\n");
						  
						  }
							tf.setText(buffer.toString());
						
						  //Close the input stream
						 
						  
						 
						
						
					}
					if(choice==1){
						
						
						System.out.println("No");
						
						tf.setText("No Log Available ");
					}
					
				}
			}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
		  
		}
		
		if (e.getSource() == siteMAP)
		{
			tf.append("WEB MAP GENERATING STARTED -->"+"\n"+"\n");
			tf.append("QUERY WILL BE PROCESSESING -->"+"\n"+"\n");
			tf.append("OUTPUT WILL BE SHOWN IN CONSOLE -->"+"\n"+"\n");
			
			 final  String header = "<html><head><title>Site Map</title></head><body><ul>";
			 final  String trailer = "</ul></body></html>";
			 String args1=JOptionPane.showInputDialog("Enter Url Name");
			 WebMapGenCrawler s = new WebMapGenCrawler(args1);
				s.generate();
			 
			 
			
		}
		if (e.getSource() == item4) {System.exit(0);}
		if (e.getSource() == btn1) {
			
			tf.append("WEB SEARCH ENGINE STARTING -->"+"\n"+"\n");
			tf.append("QUERY WILL BE PROCESSESING -->"+"\n"+"\n");
			tf.append("OUTPUT WILL BE SHOWN IN FOLDER -->"+"\n"+"\n");
			String args1=JOptionPane.showInputDialog("Enter Url Name");
			String args2=JOptionPane.showInputDialog("Enter Folder Name");
			
			
			File outdir = new File(args2);
			if (outdir.isDirectory() == false || outdir.canWrite() == false)
			{
				System.out.println("Cannot access directory " + args2);
				System.exit(-1);
			}
			ImageSpider spider = null;
			try
			{
				spider = new ImageSpider(args1, outdir);
				
			}
			catch (Exception e1)
			{
				System.out.println(e1);
				System.out.println("Invalid URL: " + args1);
				System.exit(-1);
			}
			
						System.out.println("Get Graphics Crawler:");
			spider.traverse();
			System.out.println("Finished");
			
			
		}
		
		


		if (e.getSource() == btn) {
			
			tf.append("QUERY PROCESSING STARTING -->"+"\n"+"\n");
			tf.append("PROCESSESING EFFICIENTLY -->"+"\n"+"\n");
			tf.append("OUTPUT WILL BE SHOWN IN CONSOLE -->"+"\n"+"\n");
			
			String baseUrl = JOptionPane.showInputDialog("Enter Url Name");
			if (baseUrl == null || baseUrl.length() == 0)
			{
				System.out.println("Missing URL");
				
				System.exit(-1);
			}
			int cnt = 1;
			int maxcnt = 100;
			
			
			final Energy_Efficient_Query_Processing test = new Energy_Efficient_Query_Processing(baseUrl);
			Thread threadList[] = new Thread[cnt];
			for (int i = 0; i < cnt; ++i)
			{
				Runnable r = new Runnable()
				{
					public void run()
					{
						test.spiderSite();
					}
				};
				threadList[i] = new Thread(r);
				System.out.println(threadList[i].toString() + " started");
				threadList[i].start();
			}

			try
			{
				for (int i = 0; i < cnt; ++i)
					threadList[i].join();
			}
			catch (Exception e1)
			{ // Ignore
			}

			System.out.println("QUERY PROCESSING STARTING");
			System.out.println("Traversed " + StressTestSpider.getPageCnt() + " pages");
			System.out.println("Found " + StressTestSpider.getBadPages() + " bad pages");
			System.out.println("I/O errors in " + StressTestSpider.getBadIO() + " pages");
			
			
			
		}

		


	}


	public static void main(String args[]) {
		new Query_Processor_Main("TMKS Infotech ");
		
	}
}
