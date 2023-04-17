package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class DlgCircleEdit extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldRadius;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldColor;
	protected boolean check;
	protected Color c;
	
	public Color getC() {
		return c;
	}
	
	public void setC(Color c) {
		this.c=c;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircleEdit dialog = new DlgCircleEdit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircleEdit() {
		setBounds(100, 100, 313, 214);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{34, 60, 113, 0};
		gbl_contentPanel.rowHeights = new int[]{19, 21, 26, 21, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Radius:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textFieldRadius = new JTextField();
			GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
			gbc_textFieldRadius.anchor = GridBagConstraints.NORTH;
			gbc_textFieldRadius.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldRadius.gridx = 2;
			gbc_textFieldRadius.gridy = 0;
			contentPanel.add(textFieldRadius, gbc_textFieldRadius);
			textFieldRadius.setColumns(10);
		}
		{
			JLabel lblX = new JLabel("X:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.NORTH;
			gbc_lblX.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridwidth = 2;
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 1;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			textFieldX = new JTextField();
			textFieldX.setColumns(10);
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.anchor = GridBagConstraints.SOUTH;
			gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX.gridx = 2;
			gbc_textFieldX.gridy = 1;
			contentPanel.add(textFieldX, gbc_textFieldX);
		}
		{
			JLabel lblY = new JLabel("Y:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.NORTH;
			gbc_lblY.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridwidth = 2;
			gbc_lblY.gridx = 0;
			gbc_lblY.gridy = 2;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			textFieldY = new JTextField();
			textFieldY.setColumns(10);
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.anchor = GridBagConstraints.SOUTH;
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY.gridx = 2;
			gbc_textFieldY.gridy = 2;
			contentPanel.add(textFieldY, gbc_textFieldY);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Color:");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_1.gridwidth = 2;
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 3;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			textFieldColor = new JTextField();
			textFieldColor.setEditable(false);
			textFieldColor.setColumns(10);
			GridBagConstraints gbc_textFieldColor = new GridBagConstraints();
			gbc_textFieldColor.anchor = GridBagConstraints.NORTH;
			gbc_textFieldColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldColor.insets = new Insets(0, 0, 0, 5);
			gbc_textFieldColor.gridx = 1;
			gbc_textFieldColor.gridy = 3;
			contentPanel.add(textFieldColor, gbc_textFieldColor);
		}
		{
			JButton btnNewButton = new JButton("Change color");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					c = JColorChooser.showDialog(null, "Choose color",Color.RED);
					textFieldColor.setBackground(c);
					
				}
			});
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
			gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnNewButton.gridx = 2;
			gbc_btnNewButton.gridy = 3;
			contentPanel.add(btnNewButton, gbc_btnNewButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(textFieldRadius.getText().isEmpty()|| (textFieldRadius.getText().matches("^[1-9]\\d*$")==false) ||
								textFieldX.getText().isEmpty()|| (textFieldX.getText().matches("^[1-9]\\d*$")==false)||
								textFieldY.getText().isEmpty()|| (textFieldY.getText().matches("^[1-9]\\d*$")==false)) 
						{
							JOptionPane.showMessageDialog(null, "Unesite pozitivan broj!", "Pogresan unos", JOptionPane.ERROR_MESSAGE);
						}
						else {
							check = true;
							dispose();
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTextFieldRadius() {
		return textFieldRadius;
	}

	public void setTextFieldRadius(JTextField textFieldRadius) {
		this.textFieldRadius = textFieldRadius;
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
	
	

}
