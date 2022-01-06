package virtual_library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

//this class would be opened when one of the 3 buttons in the main window is clicked
public class createFrame implements Serializable{
	private static final long serialVersionUID = 1L;
	private JFrame newFrame;
	private JButton cancel;
	private JButton save;
	private JButton remove;
	private JPanel south_panel;
	private JPanel north_panel;
	private JPanel center_panel;
	private JLabel bg;
	private Shelf myshelf = new Shelf();
	private JButton book;
	private int i;
		
	public createFrame() {
		newFrame = new JFrame();
		newFrame.setSize(1920,1200);
		newFrame.setBackground(new Color(165,125,33));
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		center_panel = new JPanel();
		center_panel = new JPanel();
		center_panel.setSize(1920,1200);
		center_panel.setBackground(new Color(102,51,0));
	    center_panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	    
	    south_panel = new JPanel();
		south_panel.setSize(1920,1200);
		south_panel.setBackground(new Color(165,125,33));
	    south_panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	    south_panel.setLayout(new GridLayout(0,2));
	    
	    north_panel = new JPanel();
		north_panel.setBackground(new Color(165,125,33));
	    north_panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	    north_panel.setLayout(new GridLayout(4, 2));
	    
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Papyrus", Font.BOLD|Font.ITALIC, 30));
		cancel.setBorder(BorderFactory.createRaisedBevelBorder());
		cancel.setForeground(Color.black);
		cancel.setBackground(new Color(179,110,6));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				newFrame.dispose();
				new Library();
	        }
		});
		
	
		newFrame.add(north_panel,BorderLayout.NORTH);
		newFrame.add(center_panel,BorderLayout.CENTER);
		newFrame.add(south_panel,BorderLayout.SOUTH);
        newFrame.pack();
        newFrame.setLocationRelativeTo(null);
        newFrame.setVisible(true);
        
	}
	
	public void for_add() {
		//this particular window would open when the useer decides to add a new book to the shelf
		
		newFrame.setTitle("Add a Book");
		
		
	    
	    //this will get the title, author, decided book code and the book path or directory of the pdf file
	    //which will then be added to the shelf or to the list of books once all criterias are met
		JLabel T = new JLabel("Title :");
		T.setFont(new Font("goudy old style", Font.BOLD, 40));
		JTextField t = new JTextField(50);
		String Title = t.getText();
		north_panel.add(T);
		north_panel.add(t);
		
		JLabel A = new JLabel("Author :");
		A.setFont(new Font("goudy old style", Font.BOLD, 40));
		JTextField a = new JTextField(50);
		String Author = a.getText();
		north_panel.add(A);
		north_panel.add(a);
		
		JLabel B = new JLabel("Book Code (use 5 digits only without zeroes) :");
		B.setFont(new Font("goudy old style", Font.BOLD, 30));
		JTextField b = new JTextField(50);
		String BookCode = b.getText();
		
		north_panel.add(B);
		north_panel.add(b);
		
		JLabel F = new JLabel("Book File :");
		F.setFont(new Font("goudy old style", Font.BOLD, 30));
		JTextField f = new JTextField(50);
		String BookPath = f.getText();
		north_panel.add(F);
		north_panel.add(f);
		
		bg = new JLabel("Start another adventure now!");
	    bg.setHorizontalAlignment(SwingConstants.CENTER);
        bg.setFont(new Font("Courier", Font.BOLD, 50));
        bg.setForeground(Color.white);
	    center_panel.add(bg);
		
		save = new JButton("Save");
		save.setFont(new Font("Papyrus", Font.BOLD|Font.ITALIC, 30));
		save.setBorder(BorderFactory.createRaisedBevelBorder());
		save.setForeground(Color.black);
		save.setBackground(new Color(179,110,6));
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent v) {
			
				if(myshelf.bookAdded(Title, Author, BookCode, BookPath) == false) {
					JOptionPane.showMessageDialog(null,"The book already exists!");
				}
				else {
					JOptionPane.showMessageDialog(null,"Book added successfully!");
					newFrame.dispose();
					new Library();
				}
				
	        }
		});
		
        south_panel.add(save);
		south_panel.add(cancel);	
        
       
        
	}
	
	public void for_remove() {
		//this section is where the user gives the bookcode and title of the  book he/she wants to remove from the shelf
		
		newFrame.setTitle("Remove a Book");
	    
		bg = new JLabel("Time to end one of your adventures.");
	    bg.setHorizontalAlignment(SwingConstants.CENTER);
        bg.setFont(new Font("Courier", Font.BOLD, 50));
        bg.setForeground(Color.white);
	    center_panel.add(bg);
	    
		JLabel RT = new JLabel("Title to  Remove:");
		RT.setFont(new Font("goudy old style", Font.BOLD, 70));
		RT.setForeground(new Color(165,125,33));
    	JTextField rt = new JTextField(70);
    	String rem = rt.getText();
    	center_panel.add(RT);
    	center_panel.add(rt);
    	
    	JLabel C = new JLabel("Book code to Remove: ");
    	C.setFont(new Font("goudy old style", Font.BOLD, 50));
    	C.setForeground(new Color(165,125,33));
    	JTextField c = new JTextField(70);
    	String remc = c.getText();
    	center_panel.add(C);
    	center_panel.add(c);
    	
    	remove = new JButton("Remove");
		remove.setFont(new Font("Papyrus", Font.BOLD|Font.ITALIC, 30));
		remove.setBorder(BorderFactory.createRaisedBevelBorder());
		remove.setForeground(Color.black);
		remove.setBackground(new Color(179,110,6));
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent m) {
				if(myshelf.bookRemoved(rem,remc) == false) {
					JOptionPane.showMessageDialog(null,"The book does not exist!");
				}
				else {
					JOptionPane.showMessageDialog(null,"Book removed successfully!");
					newFrame.dispose();
					new Library();
				}
				newFrame.dispose();
				new Library();
	        }
		});
    	south_panel.add(remove);
    	south_panel.add(cancel);
	}
	
	public void for_shelf() {
		
		
		newFrame.setTitle("Shelf");
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Papyrus", Font.BOLD|Font.ITALIC, 12));
		back.setBorder(BorderFactory.createRaisedBevelBorder());
		back.setForeground(Color.black);
		back.setBackground(new Color(179,110,6));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent s) {
				new Library();
	        }
		});
		south_panel.add(back);
		java.util.List<Book> myBooks = myshelf.getList();
		
		int w = 120;
		int h = 180;
		int x = 90;
		int y = 40;
		int row = 1;
		for(i= 0; i<myBooks.size();i++) {
			String title_author = myBooks.get(i).bookFront();
			book = new JButton(title_author);
			book.setFont(new Font("Papyrus", Font.PLAIN, 10));
			book.setBorder(BorderFactory.createRaisedBevelBorder());
			book.setForeground(Color.white);
			book.setBackground(new Color(179,110,6));
			if(i == 0) {
				book.setBounds(x,y,w,h);
			}
			else if(i < 8) {
				if(row > 1 && row < 9) {
					x = x + 140;
				}
				book.setBounds(x, y, w, h);
				row++;
				
				if(row == 8) {
					row = 1;
					x = 90;
					y = y + 200;
				}
			}
			else if(i < 16) {
				if(row > 1 && row < 9) {
					x = x + 140;
				}
				book.setBounds(x,y,w,h);
				row++;
				
				if(row == 8) {
					row = 1;
					x = 90;
					y = y + 200;
				}
			}
			else {
				if(row > 1 && row < 9) {
					x = x + 140;
				}
				book.setBounds(x,y,w,h);
				row++;
				
				if(row == 8) {
					row = 1;
					x = 90;
					y = y + 200;				
				}
				
			}
			
			book.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent b) {
					try {
						Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler"+ myBooks.get(i).getBookPath());
					}catch(Exception exception) {
						JOptionPane.showMessageDialog(null, "Cannot open the book.");
					}
					
				}
			});
			
			newFrame.add(book);
		}
	}	
}
