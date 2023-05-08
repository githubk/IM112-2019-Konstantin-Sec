package geometry;

import java.awt.BorderLayout


;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import stackAndSort.StackFrame;

import java.awt.List;
import java.awt.Panel;

public class Main extends JFrame {

	private JPanel contentPane;
	private PnlDrawing canvas;
	private DlgRectangle dlgrectangle;
	private DlgCircle dlgcircle;
	private DlgDonut dlgdonut;
	boolean twoPoints=false;
	Point nextPoint;
	private DlgPoint dlgpoint;
	DlgLine dlgline;
	Point previousPoint;
	private DlgCircleEdit dlgcircleEdit;
	private DlgRectangleEdit dlgrectangleEdit;
	private DlgDonutEdit dlgdonutEdit;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 837, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{803, 0};
		gbl_contentPane.rowHeights = new int[]{27, 407, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(null);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.setBounds(27, 0, 70, 21);
		panel.add(tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.setBounds(105, 0, 67, 21);
		panel.add(tglbtnLine);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.setBounds(182, 0, 69, 21);
		panel.add(tglbtnCircle);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setBounds(261, 0, 102, 21);
		panel.add(tglbtnRectangle);
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.setBounds(373, 0, 92, 21);
		panel.add(tglbtnDonut);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.setBounds(472, 0, 71, 21);
		panel.add(tglbtnSelect);
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.setBounds(553, 0, 78, 21);
		panel.add(tglbtnDelete);
		
		JButton btnNewButton = new JButton("Stack & Sort");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StackFrame sf=new StackFrame();
				sf.show();
				
				
				
				
			}
		});
		btnNewButton.setBounds(641, 0, 111, 21);
		panel.add(btnNewButton);
		
		tglbtnPoint.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED)
				{
					tglbtnLine.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnDelete.setSelected(false);
					
					
				}
				
			}
		});
		
		tglbtnLine.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==e.SELECTED)
				{
					tglbtnPoint.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnDelete.setSelected(false);
					
				
					
				}
				
			}
		});
		
		tglbtnCircle.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
				if(e.getStateChange()==e.SELECTED)
				{
					tglbtnLine.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnDelete.setSelected(false);
					
				
					
				}
				
			}
		});
		
		tglbtnRectangle.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
				if(e.getStateChange()==e.SELECTED )
				{
					tglbtnLine.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnDelete.setSelected(false);
					
				
					
				}
			
			}
		});
		
		tglbtnDonut.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
				if(e.getStateChange()==e.SELECTED )
				{
					tglbtnLine.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnDelete.setSelected(false);
					

					
				}
			}
		});
		
		tglbtnSelect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
				if(e.getStateChange()==e.SELECTED )
				{
					tglbtnLine.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnRectangle.setSelected(false);
					tglbtnDelete.setSelected(false);
					

				}
				
			
			}
		});
		
		tglbtnDelete.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
				if(e.getStateChange()==e.SELECTED )
				{
					tglbtnLine.setSelected(false);
					tglbtnCircle.setSelected(false);
					tglbtnPoint.setSelected(false);
					tglbtnDonut.setSelected(false);
					tglbtnSelect.setSelected(false);
					tglbtnRectangle.setSelected(false);

				}

			
			}
		});
		
		canvas=new PnlDrawing();
		canvas.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints gbc_canvas = new GridBagConstraints();
		gbc_canvas.fill = GridBagConstraints.BOTH;
		gbc_canvas.gridx = 0;
		gbc_canvas.gridy = 1;
		contentPane.add(canvas, gbc_canvas);
		
		JPanel panel_3 = new JPanel();
		canvas.add(panel_3);
		panel_3.setLayout(null);
		
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				if(tglbtnPoint.isSelected())
				{
					Point p=new Point(e.getX(),e.getY());
					canvas.getShapes().add(p);
					
					repaint();
					
				}
				
				if(tglbtnLine.isSelected())
				{

					if(twoPoints==false){
		                nextPoint = new Point(e.getX(),e.getY());
		                twoPoints = true;
		            }
		            else{
		                
		                previousPoint = nextPoint;
		                nextPoint = new Point(e.getX(),e.getY());

					Line l=new Line(previousPoint,nextPoint);
					canvas.getShapes().add(l);
					repaint();
					previousPoint=new Point();
					twoPoints=false;
				}
				}

				if(tglbtnRectangle.isSelected())
				{
					Point upperLeft=new Point(e.getX(),e.getY());
					dlgrectangle = new DlgRectangle();
					dlgrectangle.setVisible(true);

					if(dlgrectangle.check==true)
					{
					 int width=Integer.parseInt(dlgrectangle.textFieldWidth.getText());
					 int height=Integer.parseInt(dlgrectangle.textFieldHeight.getText());
					 
					 Rectangle r=new Rectangle(upperLeft,width,height);
					 
					 
					canvas.getShapes().add(r);
					repaint();
					
					}
				}
				
				if(tglbtnCircle.isSelected())
				{
					Point center=new Point(e.getX(),e.getY());
					dlgcircle = new DlgCircle();
					dlgcircle.setVisible(true);

					if(dlgcircle.check==true)
					{
					 int radius=Integer.parseInt(dlgcircle.textFieldRadius.getText());
					 
					 Circle c=new Circle(center,radius);
					 
					 
					 canvas.getShapes().add(c);
					 repaint();
					 
					}
				}
				
				if(tglbtnDonut.isSelected())
				{
					Point center=new Point(e.getX(),e.getY());
					dlgdonut=new DlgDonut();
					dlgdonut.setVisible(true);

					if(dlgdonut.check==true)
					{
					 int radius=Integer.parseInt(dlgdonut.textFieldRadius.getText());
					 int innerRadius=Integer.parseInt(dlgdonut.textFieldInnerRadius.getText());
					 
					 Donut d=new Donut(center,radius,innerRadius);
	
					 canvas.getShapes().add(d);
					 repaint();
					 
					}
				}
				
				if(tglbtnSelect.isSelected())
				{

					try {
						for(Shape s:canvas.getShapes())
						{
							if(s.contains(e.getX(),e.getY()))
							{

								if(s instanceof Point)
								{
									Point temp=(Point)s;
									Point novi=new Point();
									
									dlgpoint=new DlgPoint();
									
									dlgpoint.getTextFieldX().setText(Integer.toString(temp.getX()));
									dlgpoint.getTextFieldY().setText(Integer.toString(temp.getY()));
									
									dlgpoint.setVisible(true);
									if(dlgpoint.check) 
									{
										novi.setSelected(true);
										novi.setC(dlgpoint.c);
									novi.moveOn(Integer.parseInt(dlgpoint.getTextFieldX().getText()), Integer.parseInt(dlgpoint.getTextFieldY().getText()));
		
									canvas.getShapes().set(canvas.getShapes().indexOf(temp), novi);
									
									repaint();
									}
									
								}
								
								if(s instanceof Line)
								{
									Line temp=(Line)s;
									Line novi=new Line();
									
									dlgline=new DlgLine();
									
									
									dlgline.getTextFieldStartX().setText(Integer.toString(temp.getStartPoint().getX()));
									dlgline.getTextFieldStartY().setText(Integer.toString(temp.getStartPoint().getY()));
									dlgline.getTextFieldEndX().setText(Integer.toString(temp.getEndPoint().getX()));
									dlgline.getTextFieldEndY().setText(Integer.toString(temp.getEndPoint().getY()));
									dlgline.setVisible(true);
									
									if(dlgline.check)
									{
										
									novi.setSelected(true);
									novi.setC(dlgline.c);
									novi.setStartPoint(new Point(Integer.parseInt(dlgline.getTextFieldStartX().getText()),Integer.parseInt(dlgline.getTextFieldStartY().getText())));
									novi.setEndPoint(new Point(Integer.parseInt(dlgline.getTextFieldEndX().getText()),Integer.parseInt(dlgline.getTextFieldEndY().getText())));		
									canvas.getShapes().remove(s);
									canvas.getShapes().add(novi);

									repaint();
									
									}	
									
								}
								
							if(s instanceof Rectangle)
									{
										Rectangle temp=(Rectangle)s;
										Rectangle novi=new Rectangle();
										
										dlgrectangleEdit=new DlgRectangleEdit();

										dlgrectangleEdit.getTextFieldWidth().setText(Integer.toString(temp.getWidth()));
										dlgrectangleEdit.getTextFieldHeight().setText(Integer.toString(temp.getHeight()));
										dlgrectangleEdit.getTextFieldX().setText(Integer.toString(temp.getUpperLeft().getX()));
										dlgrectangleEdit.getTextFieldY().setText(Integer.toString(temp.getUpperLeft().getY()));
										dlgrectangleEdit.setVisible(true);
										
										if(dlgrectangleEdit.check)
										{
											novi.setSelected(true);
											novi.setC(dlgrectangleEdit.c);
											novi.setWidth(Integer.parseInt(dlgrectangleEdit.getTextFieldWidth().getText()));
											novi.setHeight(Integer.parseInt(dlgrectangleEdit.getTextFieldHeight().getText()));
											novi.setUpperLeft(new Point(Integer.parseInt(dlgrectangleEdit.getTextFieldX().getText()),Integer.parseInt(dlgrectangleEdit.getTextFieldY().getText())));
											canvas.getShapes().remove(s);
											canvas.getShapes().add(novi);
											repaint();
										}
										
									}
										
								
									if(s instanceof Circle)
									{
										if(s.getClass() == Donut.class) {
											Donut temp=(Donut)s;
											Donut novi=new Donut();
											
											dlgdonutEdit=new DlgDonutEdit();
											
											dlgdonutEdit.getTextFieldOR().setText(Integer.toString(temp.getRadius()));
											dlgdonutEdit.getTextFieldIR().setText(Integer.toString(temp.getInnerRadius()));
											dlgdonutEdit.getTextFieldX().setText(Integer.toString(temp.getCenter().getX()));
											dlgdonutEdit.getTextFieldY().setText(Integer.toString(temp.getCenter().getY()));
											
											dlgdonutEdit.setVisible(true);
											
											if(dlgdonutEdit.check)
											{
												novi.setSelected(true);
												novi.setC(dlgdonutEdit.c);
												novi.setCenter(new Point(Integer.parseInt(dlgdonutEdit.getTextFieldX().getText()),Integer.parseInt(dlgdonutEdit.getTextFieldY().getText())));
												try {
													novi.setRadius(Integer.parseInt(dlgdonutEdit.getTextFieldOR().getText()));
												} catch (NumberFormatException e1) {
								
													e1.printStackTrace();
												} catch (Exception e1) {
													e1.printStackTrace();
												}
												
												novi.setInnerRadius(Integer.parseInt(dlgdonutEdit.getTextFieldIR().getText()));
												
												canvas.getShapes().set(canvas.getShapes().indexOf(temp), novi);
											repaint();
										}
									}else {
										Circle temp=(Circle)s;
										Circle novi=new Circle();
										
										dlgcircleEdit=new DlgCircleEdit();
										
										
										dlgcircleEdit.getTextFieldRadius().setText(Integer.toString(temp.getRadius()));
										dlgcircleEdit.getTextFieldX().setText(Integer.toString(temp.getCenter().getX()));
										dlgcircleEdit.getTextFieldY().setText(Integer.toString(temp.getCenter().getY()));
										
										dlgcircleEdit.setVisible(true);
										
										if(dlgcircleEdit.check)
										{
											novi.setSelected(true);
											novi.setCenter(new Point(Integer.parseInt(dlgcircleEdit.getTextFieldX().getText()),Integer.parseInt(dlgcircleEdit.getTextFieldY().getText())));
											try {
												novi.setRadius(Integer.parseInt(dlgcircleEdit.getTextFieldRadius().getText()));
											} catch (NumberFormatException e1) {
												
												e1.printStackTrace();
											} catch (Exception e1) {
												
												e1.printStackTrace();
											}
											novi.setC(dlgcircleEdit.c);
											
											canvas.getShapes().set(canvas.getShapes().indexOf(temp), novi);
											repaint();	
										
										}
										}
										
									}
							}
								
								
						}
					}catch(Exception iob) {
						
					}
				}
					
					
					if(tglbtnDelete.isSelected())
					{
						
						for(int j=0; j< canvas.getShapes().size(); j++)
						{

							if(canvas.getShapes().get(j).contains(e.getX(),e.getY()))
							{
								
								int res = JOptionPane.showConfirmDialog(null, 
								         "Da li ste sigurni da zelite da obrisete?", 
								         "Brisanje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								if(res==JOptionPane.YES_OPTION)
								{
									canvas.getShapes().remove(canvas.getShapes().get(j));
	
								}
							}
						
							repaint();
						}
						
							
							
					
					}
			
			}
		});
		
		
	}
}
