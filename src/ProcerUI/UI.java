package ProcerUI;

/**
 * @author etuna
 */
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;

public class UI extends JFrame implements ActionListener {

	JTextField browseText, exportText;
	JTextArea outputText;
	JButton browseButton, exportBrowse, submitButton, exportButton, clearButton, cancelButton;
	JCheckBox detailedCB, reportCB;
	JPanel browsePanel, exportPanel, checkBoxPanel, actionPanel, mainPanel, outputPanel, container, browseContainer;
	JLabel detailedLabel, reportLabel, iconLabel, logoLabel;
	JScrollPane scrollPane;
	ImageIcon icon, logo;
	JLabel procerLabel;

	public UI() {

		// ################################################################
		// ################################################################
		// ################################################################
		/**
		 * FRAME, this
		 * 
		 */
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\etuna\\Desktop\\bot.png"));
		setLayout(new BorderLayout());
		setTitle("Procer - Procedure Impact Analyzer by Softtech");
		setDefaultCloseOperation(PFrame.EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\etuna\\Desktop\\coolgray.jpg")));
		getContentPane().setPreferredSize(new Dimension(900, 600));
		// setPreferredSize(new Dimension(1200,800));
		setVisible(true);
		setResizable(false);

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3, 3, 3, 3);
		Border border = BorderFactory.createLineBorder(Color.BLACK);

		// ################################################################
		// ################################################################
		// ################################################################
		/**
		 * JPanels
		 */
		browsePanel = new JPanel();
		browsePanel.setPreferredSize(new Dimension(600, 30));
		browsePanel.setOpaque(false);
		browsePanel.setLayout(new GridBagLayout());

		exportPanel = new JPanel();
		exportPanel.setPreferredSize(new Dimension(600, 30));
		exportPanel.setOpaque(false);
		exportPanel.setLayout(new GridBagLayout());

		checkBoxPanel = new JPanel();
		checkBoxPanel.setLayout(new GridBagLayout());
		checkBoxPanel.setOpaque(false);

		browseContainer = new JPanel();
		browseContainer.setLayout(new GridLayout(3, 1));
		browseContainer.setPreferredSize(new Dimension(600, 80));
		browseContainer.setOpaque(false);

		actionPanel = new JPanel();
		actionPanel.setLayout(new GridBagLayout());
		actionPanel.setOpaque(false);

		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(5, 1));
		mainPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		mainPanel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
		mainPanel.setOpaque(false);
		mainPanel.setPreferredSize(new Dimension(900, 500));

		outputPanel = new JPanel();
		outputPanel.setOpaque(false);

		container = new JPanel();
		container.setLayout(new BorderLayout());
		container.setSize(900, 600);
		container.setOpaque(false);
		container.setPreferredSize(new Dimension(900, 600));

		// ################################################################
		// ################################################################
		// ################################################################
		/**
		 * ImageIcons
		 */

		// icon = new ImageIcon("C:\\Users\\etuna\\Desktop\\bot.png");
		icon = new ImageIcon(new ImageIcon("C:\\Users\\etuna\\Desktop\\bot.png").getImage().getScaledInstance(50, 50,
				Image.SCALE_DEFAULT));
		logo = new ImageIcon(new ImageIcon("C:\\Users\\etuna\\Desktop\\procerlogo.png").getImage()
				.getScaledInstance(160, 80, Image.SCALE_DEFAULT));

		iconLabel = new JLabel(icon);
		iconLabel.setPreferredSize(new Dimension(80, 80));
		logoLabel = new JLabel(logo);
		logoLabel.setPreferredSize(new Dimension(80, 80));

		// ################################################################
		// ################################################################
		// ################################################################
		/**
		 * JButtons
		 */
		browseButton = new JButton("Browse");
		browseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser chooser;
				chooser = new JFileChooser(new File(System.getProperty("user.home") + "\\Downloads")); // Downloads
																										// Directory as
																										// default
				chooser.setDialogTitle("Select Location");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
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
				chooser = new JFileChooser(new File(System.getProperty("user.home") + "\\Downloads")); // Downloads
																										// Directory as
																										// default
				chooser.setDialogTitle("Select Location");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					String fileID = chooser.getSelectedFile().getPath();
					exportText.setText(fileID);
				}
			}
		});

		submitButton = new JButton("Submit");
		exportButton = new JButton("Export");
		clearButton = new JButton("Clear");
		cancelButton = new JButton("Cancel");

		// ################################################################
		// ################################################################
		// ################################################################
		/**
		 * TextFields
		 */

		browseText = new JTextField();
		browseText.setPreferredSize(new Dimension(300, 30));

		exportText = new JTextField();
		exportText.setPreferredSize(new Dimension(300, 30));

		outputText = new JTextArea(5000, 1000);
		outputText.setOpaque(false);
		outputText.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(1, 1, 1, 1)));
		outputText.setEditable(false);
		// ################################################################
		// ################################################################
		// ################################################################
		/**
		 * TextAreas
		 */

		// ################################################################
		// ################################################################
		// ################################################################
		/**
		 * CheckBoxes
		 */

		detailedCB = new JCheckBox();
		reportCB = new JCheckBox();

		// ################################################################
		// ################################################################
		// ################################################################
		/**
		 * JLabels
		 */

		detailedLabel = new JLabel("Detailed Info");
		reportLabel = new JLabel("Report");
		// ################################################################
		// ################################################################
		// ################################################################
		/**
		 * ScrollPanes
		 */

		scrollPane = new JScrollPane(outputText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(900, 200));
		scrollPane.setOpaque(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getViewport().setView(outputText);

		// ################################################################
		// ################################################################
		// ################################################################
		/**
		 * Generation
		 */

		browsePanel.add(browseText);
		browsePanel.add(browseButton);

		exportPanel.add(exportText);
		exportPanel.add(exportBrowse);

		checkBoxPanel.add(detailedCB);
		checkBoxPanel.add(detailedLabel);
		checkBoxPanel.add(reportCB);
		checkBoxPanel.add(reportLabel);

		actionPanel.add(submitButton, c);
		actionPanel.add(exportButton, c);
		actionPanel.add(clearButton, c);
		actionPanel.add(cancelButton, c);

		mainPanel.add(iconLabel);
		mainPanel.add(logoLabel);
		// mainPanel.add(browsePanel);
		// mainPanel.add(exportPanel);
		// mainPanel.add(checkBoxPanel);
		browseContainer.add(browsePanel);
		browseContainer.add(exportPanel);
		browseContainer.add(checkBoxPanel);
		mainPanel.add(browseContainer);
		mainPanel.add(actionPanel);

		container.add(mainPanel, BorderLayout.NORTH);
		container.add(scrollPane, BorderLayout.SOUTH);

		add(container);
		pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	private Image getScaledImage(Image icon2, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(icon2, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}
}
