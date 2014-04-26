package lee;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.*;

public class sam{
	JFrame f = new JFrame("Test");
	Icon okIcon = new ImageIcon("ioc/ok.png");
	JButton ok = new JButton("Ok", okIcon);
	JRadioButton male = new JRadioButton("Male", true);
	JRadioButton female = new JRadioButton("Female", false);
	ButtonGroup bg = new ButtonGroup();
	JCheckBox married = new JCheckBox("Married", false);
	String [] colors = new String[]{"Red","Green","Blue"};
	JComboBox<String> colorChooser = new JComboBox<String>(colors);
	JList<String> colorList = new JList<>(colors);
	JTextArea ta = new JTextArea(8,120);
	JTextField name = new JTextField(40);
	JMenuBar mb = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenu edit = new JMenu("Edit");
	
	System.out.println("haha");
	System.out.println("hoho");
	
	this should be resetted.
	
	aaaeeeeeff;
	Icon newIcon = new ImageIcon("ico/new.png");
	JMenuItem newItem = new JMenuItem("New", newIcon);
	
	Icon saveIcon = new ImageIcon("ico/save.png");
	
	JMenuItem saveItem = new JMenuItem("Save", saveIcon);
	
	Icon exitIcon = new ImageIcon("ico/exit.png");
	JMenuItem exitItem = new JMenuItem("Exit",exitIcon);
	
	JCheckBoxMenuItem autoWrap = new JCheckBoxMenuItem("auto wrapp");
	
	JMenuItem copyItem = new JMenuItem("Copy", new ImageIcon("ico/copy.png"));
	JMenuItem pasteItem = new JMenuItem("Paste", new ImageIcon("ico/paste.png"));
	
	JMenu format = new JMenu("Format");
	
	JMenuItem commentItem = new JMenuItem("Comment");
	JMenuItem cancelItem = new JMenuItem("cancel comment");
	
	JPopupMenu pop = new JPopupMenu();
	ButtonGroup flavorGroup = new ButtonGroup();
	
	JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal", true);
	JRadioButtonMenuItem nimbuslItem = new JRadioButtonMenuItem("Nimbus", true);
	JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows", true);
	JRadioButtonMenuItem classicItem = new JRadioButtonMenuItem("Classic", true);
	JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif", true);
	
	public void init()
	{
		JPanel bottom = new JPanel();
		bottom.add(name);
		bottom.add(ok);
		f.add(bottom, BorderLayout.SOUTH);
		
		JPanel checkPanel = new JPanel();
		checkPanel.add(colorChooser);
		
		bg.add(male);
		bg.add(female);
		
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);
		
		Box topLeft = Box.createVerticalBox();
		
		JScrollPane taJsp = new JScrollPane(ta);
		
		topLeft.add(taJsp);
		topLeft.add(checkPanel);
		
		Box top = Box.createHorizontalBox();
		top.add(topLeft);
		top.add(colorList);
		
		f.add(top);
		
		newItem.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
		newItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				ta.append("User clicked 'New' menu\n");
			}
		});
		
		male.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JDialog jg = new JDialog();
				jg.setSize(new Dimension(100,140));
				jg.setTitle("Hello, Sam");
				jg.setLocation(f.getLocation().x+f.getSize().width/2, f.getLocation().y+f.getHeight()/2);
				jg.show();
			}
		});
		
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		
		edit.add(autoWrap);
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		
		commentItem.setToolTipText("comment code by sam");
		format.add(commentItem);
		format.add(cancelItem);
		edit.add(new JMenuItem("-"));
		
		edit.add(format);
		
		mb.add(file);
		mb.add(edit);
		
		f.setJMenuBar(mb);
		
		flavorGroup.add(metalItem);
		flavorGroup.add(nimbuslItem);
		flavorGroup.add(windowsItem);
		flavorGroup.add(classicItem);
		flavorGroup.add(motifItem);
		
		pop.add(metalItem);
		pop.add(nimbuslItem);
		pop.add(windowsItem);
		pop.add(classicItem);
		pop.add(motifItem);
		
		ActionListener flavorListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					switch (e.getActionCommand())
					{
					case "Metal":
						changeFlavor(1);
						break;
					case "Nimbus":
						changeFlavor(2);
						break;
					case "Windows":
						changeFlavor(3);
						break;
					case "Classic":
						changeFlavor(4);
						break;
					case "Motif":
						changeFlavor(5);
						break;
					}
				}
				catch (Exception ee){
					ee.printStackTrace();
				}
			}
		};
		
		metalItem.addActionListener(flavorListener);
		nimbuslItem.addActionListener(flavorListener);
		windowsItem.addActionListener(flavorListener);
		classicItem.addActionListener(flavorListener);
		motifItem.addActionListener(flavorListener);
		
		Clipboard cpb = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		ta.setComponentPopupMenu(pop);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setSize(300, 400);
		f.setVisible(true);
	}
	
	private void changeFlavor(int flavor) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		switch(flavor)
		{
		case 1:
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			break;
		case 2:
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			break;
		case 3:
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			break;
		case 4:
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
			break;
		case 5:
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			break;
		}
		
		SwingUtilities.updateComponentTreeUI(f.getContentPane());
		SwingUtilities.updateComponentTreeUI(mb);
		SwingUtilities.updateComponentTreeUI(pop);
		
	}
	
	
	public static void main(String [] args)
	{
		new sam().init();
	}
	
	
	
	
	
}