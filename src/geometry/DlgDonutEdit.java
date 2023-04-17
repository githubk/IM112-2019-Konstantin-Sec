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

public class DlgDonutEdit extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldOR;
	private JTextField textFieldIR;
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
			DlgDonutEdit dialog = new DlgDonutEdit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonutEdit() {
		setTitle("Modify donut");
		setBounds(100, 100, 434, 251);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{74, 120, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{19, 19, 19, 19, 21, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JLabel lblNewLabel = new JLabel("Outer radius:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		textFieldOR = new JTextField();
		GridBagConstraints gbc_textFieldOR = new GridBagConstraints();
		gbc_textFieldOR.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldOR.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldOR.gridx = 2;
		gbc_textFieldOR.gridy = 0;
		contentPanel.add(textFieldOR, gbc_textFieldOR);
		textFieldOR.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Inner radius:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldIR = new JTextField();
		textFieldIR.setColumns(10);
		GridBagConstraints gbc_textFieldIR = new GridBagConstraints();
		gbc_textFieldIR.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldIR.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldIR.gridx = 2;
		gbc_textFieldIR.gridy = 1;
		contentPanel.add(textFieldIR, gbc_textFieldIR);
		
		JLabel lblNewLabel_2 = new JLabel("X:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textFieldX = new JTextField();
		textFieldX.setColumns(10);
		GridBagConstraints gbc_textFieldX = new GridBagConstraints();
		gbc_textFieldX.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldX.gridx = 2;
		gbc_textFieldX.gridy = 2;
		contentPanel.add(textFieldX, gbc_textFieldX);
		
		JLabel lblNewLabel_3 = new JLabel("Y:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textFieldY = new JTextField();
		textFieldY.setColumns(10);
		GridBagConstraints gbc_textFieldY = new GridBagConstraints();
		gbc_textFieldY.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldY.gridx = 2;
		gbc_textFieldY.gridy = 3;
		contentPanel.add(textFieldY, gbc_textFieldY);
		
		JLabel lblNewLabel_4 = new JLabel("Color:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Choose color");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				c=JColorChooser.showDialog(null, "Choose color",Color.RED);
				textFieldColor.setBackground(c);
				
			}
		});
		
		textFieldColor = new JTextField();
		textFieldColor.setEditable(false);
		textFieldColor.setColumns(10);
		GridBagConstraints gbc_textFieldColor = new GridBagConstraints();
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
						
						if(textFieldIR.getText().isEmpty()|| (textFieldIR.getText().matches("^[1-9]\\d*$")==false) ||
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

	public JTextField getTextFieldOR() {
		return textFieldOR;
	}

	public void setTextFieldOR(JTextField textFieldOR) {
		this.textFieldOR = textFieldOR;
	}

	public JTextField getTextFieldIR() {
		return textFieldIR;
	}

	public void setTextFieldIR(JTextField textFieldIR) {
		this.textFieldIR = textFieldIR;
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
}
