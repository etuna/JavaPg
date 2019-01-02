package ProcerUI;
/**
 * @author etuna
 */
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;

public class PFrame extends JFrame implements ActionListener {

	JTextField browseText, exportText;
	JTextArea outputText;
	JButton browseButton, exportBrowse, submitButton,exportButton, clearButton, cancelButton;
	JCheckBox detailedCB, reportCB;
	JPanel browsePanel, exportPanel, checkBoxPanel, actionPanel, mainPanel,outputPanel,container;
	JLabel detailedLabel, reportLabel,iconLabel;
	JScrollPane scrollPane;
	ImageIcon icon;
	JLabel procerLabel;

	public PFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\etuna\\Desktop\\bot.png"));
	setLayout(new BorderLayout());
		setTitle("Procer - Procedure Analyzer by Softtech");
		setPreferredSize(new Dimension(1200,800));
		
		setDefaultCloseOperation(PFrame.EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\etuna\\Desktop\\coolgray.jpg")));
		
		icon = new ImageIcon("C:\\Users\\etuna\\Desktop\\bot.png");
		iconLabel= new JLabel(icon);
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3,3,3,3);
		
		
		browseText = new JTextField();
		browseText.setPreferredSize(new Dimension(300,30));
		
		exportText = new JTextField();
		exportText.setPreferredSize(new Dimension(300,30));
		
		
		

	
		
		outputText = new JTextArea(5000,1000);
		outputText.setOpaque(false);
		
		//outputText.setEditable(false);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		outputText.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(1, 1, 1, 1)));
			
		scrollPane = new JScrollPane(outputText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(1000,300));
		scrollPane.setOpaque(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		outputText.setEditable(false);
		scrollPane.getViewport().setView(outputText);

		browseButton = new JButton("Browse");
		browseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser chooser;
				chooser = new JFileChooser(new File(System.getProperty("user.home") + "\\Downloads")); //Downloads Directory as default
		        chooser.setDialogTitle("Select Location");
		        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        chooser.setAcceptAllFileFilterUsed(false);

		        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		        { 
		           String fileID = chooser.getSelectedFile().getPath();
		            browseText.setText(fileID);
		        }
			}
		});
		
		exportBrowse = new JButton("Export Path");
		exportBrowse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser chooser;
				chooser = new JFileChooser(new File(System.getProperty("user.home") + "\\Downloads")); //Downloads Directory as default
		        chooser.setDialogTitle("Select Location");
		        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        chooser.setAcceptAllFileFilterUsed(false);

		        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		        { 
		           String fileID = chooser.getSelectedFile().getPath();
		            exportText.setText(fileID);
		        }
			}
		});
		
		submitButton = new JButton("Submit");
		exportButton = new JButton("Export");
		clearButton = new JButton("Clear");
		cancelButton = new JButton("Cancel");
		
		detailedCB  = new JCheckBox();
		reportCB  = new JCheckBox();
		
		browsePanel = new JPanel();
		exportPanel = new JPanel();
		checkBoxPanel = new JPanel();
		actionPanel = new JPanel();
		mainPanel = new JPanel();
		outputPanel = new JPanel();
		
		container = new JPanel();
		container.setLayout(new BorderLayout());
		container.setSize(1200,800);
		container.setOpaque(false);
		
		detailedLabel = new JLabel("Detailed Info");
		reportLabel = new JLabel("Report");
		
		
		browsePanel.setPreferredSize(new Dimension(600,30));
		browsePanel.setOpaque(false);
		browsePanel.setLayout(new GridBagLayout());
		browsePanel.add(browseText);
		browsePanel.add(browseButton);
		
		exportPanel.setPreferredSize(new Dimension(600,30));
		exportPanel.setOpaque(false);
		exportPanel.setLayout(new GridBagLayout());
		exportPanel.add(exportText);
		exportPanel.add(exportBrowse);
		
		checkBoxPanel.setLayout(new GridBagLayout());
		checkBoxPanel.setOpaque(false);
		checkBoxPanel.add(detailedCB);
		checkBoxPanel.add(detailedLabel);
		checkBoxPanel.add(reportCB);
		checkBoxPanel.add(reportLabel);
		
		actionPanel.setLayout(new GridBagLayout());
		actionPanel.setOpaque(false);
		actionPanel.add(submitButton,c);
		actionPanel.add(exportButton,c);
		actionPanel.add(clearButton,c);
		actionPanel.add(cancelButton,c);
		
		outputPanel.setOpaque(false);
		//outputPanel.add(outputText);
	

		
		mainPanel.setLayout(new GridLayout(10,1));
		mainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		mainPanel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
		mainPanel.setOpaque(false);
		mainPanel.add(iconLabel);
		mainPanel.add(browsePanel);
		mainPanel.add(exportPanel);
		mainPanel.add(checkBoxPanel);
		mainPanel.add(actionPanel);
		
		mainPanel.setSize(1200,600);
		container.add(scrollPane, BorderLayout.NORTH);
		container.add(mainPanel,BorderLayout.SOUTH);
		add(container);
		pack();
		setVisible(true);
		setResizable(false);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
