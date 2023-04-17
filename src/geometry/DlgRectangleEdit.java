package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class DlgRectangleEdit extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private boolean comited;
	private JTextField textFieldWidth;
	private JTextField textFieldHeight;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldColor;
	protected Color c;
	protected boolean check;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangleEdit dialog = new DlgRectangleEdit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangleEdit() {
		setTitle("Modify rectangle");
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{45, 28, 103, 0};
		gbl_contentPanel.rowHeights = new int[]{19, 19, 19, 19, 21, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JLabel lblNewLabel = new JLabel("Width:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		textFieldWidth = new JTextField();
		GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
		gbc_textFieldWidth.anchor = GridBagConstraints.NORTHEAST;
		gbc_textFieldWidth.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldWidth.gridx = 2;
		gbc_textFieldWidth.gridy = 0;
		contentPanel.add(textFieldWidth, gbc_textFieldWidth);
		textFieldWidth.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height:");
		GridBagConstraints gbc_lblHeight = new GridBagConstraints();
		gbc_lblHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeight.gridx = 0;
		gbc_lblHeight.gridy = 1;
		contentPanel.add(lblHeight, gbc_lblHeight);
		
		textFieldHeight = new JTextField();
		textFieldHeight.setColumns(10);
		GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
		gbc_textFieldHeight.anchor = GridBagConstraints.NORTHEAST;
		gbc_textFieldHeight.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldHeight.gridx = 2;
		gbc_textFieldHeight.gridy = 1;
		contentPanel.add(textFieldHeight, gbc_textFieldHeight);
		
		JLabel lblX = new JLabel("X:");
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.gridx = 0;
		gbc_lblX.gridy = 2;
		contentPanel.add(lblX, gbc_lblX);
		
		textFieldX = new JTextField();
		textFieldX.setColumns(10);
		GridBagConstraints gbc_textFieldX = new GridBagConstraints();
		gbc_textFieldX.anchor = GridBagConstraints.NORTHEAST;
		gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldX.gridx = 2;
		gbc_textFieldX.gridy = 2;
		contentPanel.add(textFieldX, gbc_textFieldX);
		
		JLabel lblY = new JLabel("Y:");
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblY.insets = new Insets(0, 0, 5, 5);
		gbc_lblY.gridx = 0;
		gbc_lblY.gridy = 3;
		contentPanel.add(lblY, gbc_lblY);
		
		textFieldY = new JTextField();
		textFieldY.setColumns(10);
		GridBagConstraints gbc_textFieldY = new GridBagConstraints();
		gbc_textFieldY.anchor = GridBagConstraints.NORTHEAST;
		gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldY.gridx = 2;
		gbc_textFieldY.gridy = 3;
		contentPanel.add(textFieldY, gbc_textFieldY);
		
		JLabel lblColor = new JLabel("Color:");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblColor.insets = new Insets(0, 0, 0, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 4;
		contentPanel.add(lblColor, gbc_lblColor);
		
		JButton btnNewButton = new JButton("Change color");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				c = JColorChooser.showDialog(null, "Choose color",Color.RED);
				textFieldColor.setBackground(c);
				
			}
		});
		
		textFieldColor = new JTextField();
		textFieldColor.setEditable(false);
		textFieldColor.setColumns(10);
		GridBagConstraints gbc_textFieldColor = new GridBagConstraints();
		gbc_textFieldColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldColor.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldColor.gridx = 1;
		gbc_textFieldColor.gridy = 4;
		contentPanel.add(textFieldColor, gbc_textFieldColor);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		contentPanel.add(btnNewButton, gbc_btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(!textFieldWidth.getText().isEmpty() && !textFieldHeight.getText().isEmpty() 
								&& !textFieldX.getText().isEmpty() && !textFieldY.getText().isEmpty()) {
							if(Integer.parseInt(textFieldWidth.getText().toString()) > 0 && 
									Integer.parseInt(textFieldHeight.getText().toString()) > 0
									&& Integer.parseInt(textFieldX.getText().toString()) > 0
									&& Integer.parseInt(textFieldY .getText().toString()) > 0) {
								setComited(true);
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "You have to enter values greather than 0!", "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "You have to enter all fields!", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setComited(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTextFieldWidth() {
		return textFieldWidth;
	}

	public void setTextFieldWidth(JTextField textFieldWidth) {
		this.textFieldWidth = textFieldWidth;
	}

	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}

	public void setTextFieldHeight(JTextField textFieldHeight) {
		this.textFieldHeight = textFieldHeight;
	}

	public JTextField getTextFieldX() {
		return textFieldX;
	}

	public void setTextFieldX(JTextField textFieldX) {
		this.textFieldX = textFieldX;
	}

	public JTextField getTextFieldY() {
		return textFieldY;
	}

	public void setTextFieldY(JTextField textFieldY) {
		this.textFieldY = textFieldY;
	}

	public JTextField getTextFieldColor() {
		return textFieldColor;
	}

	public void setTextFieldColor(JTextField textFieldColor) {
		this.textFieldColor = textFieldColor;
	}
	public boolean isComited() {
		return comited;
	}

	public void setComited(boolean comited) {
		this.comited = comited;
	}
}
