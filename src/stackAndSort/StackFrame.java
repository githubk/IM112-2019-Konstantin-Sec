package stackAndSort;

import java.awt.EventQueue;

import geometry.DlgRectangle;
import geometry.DlgRectangleEdit;
import geometry.Point;
import geometry.Rectangle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JTextArea;

public class StackFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Stack<Rectangle> stack = new Stack<Rectangle>();
	private Rectangle pravougaonik;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrame frame = new StackFrame();
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
	public StackFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Stack and sort");
		setBounds(100, 100, 634, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 600, 329);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(10, 41, 580, 62);
		panel.add(textArea);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!stack.isEmpty()) {
			        Rectangle[] rectArray = stack.toArray(new Rectangle[stack.size()]);
			        Arrays.sort(rectArray, new Comparator<Rectangle>() {
			            public int compare(Rectangle rect1, Rectangle rect2) {
			                int area1 = rect1.getWidth() * rect1.getHeight();
			                int area2 = rect2.getWidth() * rect2.getHeight();
			                return area1 - area2;
			            }
			        });
			        stack.clear();
			        for (Rectangle rect : rectArray) {
			            stack.push(rect);
			        }
			        String stackString = stack.toString();
			        textArea.setText(stackString);
				} else {
					JOptionPane.showMessageDialog(null, "Prazan stek!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSort.setBounds(222, 10, 123, 21);
		panel.add(btnSort);
		
		JButton btnRemove = new JButton("Remove Rectangle");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(stack.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Prazan stek!", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					Rectangle prom = stack.pop();
					//System.out.println(stack);
					String stackString = stack.toString();
		            textArea.setText(stackString);
					}
				
				
			}
		});
		btnRemove.setBounds(362, 10, 144, 21);
		panel.add(btnRemove);
		buttonGroup.add(btnRemove);
		
		JButton btnAdd = new JButton("Add Rectangle");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DlgRectangleEdit dlgRect = new DlgRectangleEdit();
				dlgRect.setVisible(true);
				int width = Integer.parseInt(dlgRect.getTextFieldWidth().getText());
				int height = Integer.parseInt(dlgRect.getTextFieldHeight().getText());
				int x = Integer.parseInt(dlgRect.getTextFieldX().getText());
				int y = Integer.parseInt(dlgRect.getTextFieldY().getText());
				Point upperLeft = new Point(x, y);
				pravougaonik = new Rectangle(upperLeft, width, height);
						
				if(dlgRect.isComited()) {
					stack.push(pravougaonik);
					//System.out.println(stack);
					String stackString = stack.toString();
		            textArea.setText(stackString);
					
				}
				
				
				
			}
		});
		btnAdd.setBounds(74, 10, 123, 21);
		panel.add(btnAdd);
		buttonGroup.add(btnAdd);
		
		
	}
}
