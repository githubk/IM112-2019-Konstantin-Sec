package geometry;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dodaj extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField textFieldX;
	protected JTextField textFieldY;
	protected JTextField textFieldWidth;
	protected JTextField textFieldHeight;
	protected boolean check;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dodaj dialog = new Dodaj();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dodaj() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{45, 96, 0};
		gbl_contentPanel.rowHeights = new int[]{19, 19, 19, 19, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JLabel lblNewLabel = new JLabel("X:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		textFieldX = new JTextField();
		GridBagConstraints gbc_textFieldX = new GridBagConstraints();
		gbc_textFieldX.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldX.gridx = 1;
		gbc_textFieldX.gridy = 0;
		contentPanel.add(textFieldX, gbc_textFieldX);
		textFieldX.setColumns(10);
		
		JLabel lblY = new JLabel("Y:");
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblY.insets = new Insets(0, 0, 5, 5);
		gbc_lblY.gridx = 0;
		gbc_lblY.gridy = 1;
		contentPanel.add(lblY, gbc_lblY);
		
		textFieldY = new JTextField();
		textFieldY.setColumns(10);
		GridBagConstraints gbc_textFieldY = new GridBagConstraints();
		gbc_textFieldY.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldY.gridx = 1;
		gbc_textFieldY.gridy = 1;
		contentPanel.add(textFieldY, gbc_textFieldY);
		
		JLabel lblWidth = new JLabel("Width:");
		GridBagConstraints gbc_lblWidth = new GridBagConstraints();
		gbc_lblWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
		gbc_lblWidth.gridx = 0;
		gbc_lblWidth.gridy = 2;
		contentPanel.add(lblWidth, gbc_lblWidth);
		
		textFieldWidth = new JTextField();
		textFieldWidth.setColumns(10);
		GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
		gbc_textFieldWidth.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldWidth.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldWidth.gridx = 1;
		gbc_textFieldWidth.gridy = 2;
		contentPanel.add(textFieldWidth, gbc_textFieldWidth);
		
		JLabel lblHeight = new JLabel("Height:");
		GridBagConstraints gbc_lblHeight = new GridBagConstraints();
		gbc_lblHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblHeight.insets = new Insets(0, 0, 0, 5);
		gbc_lblHeight.gridx = 0;
		gbc_lblHeight.gridy = 3;
		contentPanel.add(lblHeight, gbc_lblHeight);
		
		textFieldHeight = new JTextField();
		textFieldHeight.setColumns(10);
		GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
		gbc_textFieldHeight.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldHeight.gridx = 1;
		gbc_textFieldHeight.gridy = 3;
		contentPanel.add(textFieldHeight, gbc_textFieldHeight);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(textFieldX.getText().isEmpty() || textFieldY.getText().isEmpty() || textFieldWidth.getText().isEmpty() || textFieldHeight.getText().isEmpty() ||
								(textFieldX.getText().matches("^[1-9]\\d*$")==false) || (textFieldY.getText().matches("^[1-9]\\d*$")==false) || (textFieldWidth.getText().matches("^[1-9]\\d*$")==false) 
								|| (textFieldHeight.getText().matches("^[1-9]\\d*$")==false))
						{
							JOptionPane.showMessageDialog(null, "Unesite pozitivan broj!", "Pogresan unos", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
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
}
