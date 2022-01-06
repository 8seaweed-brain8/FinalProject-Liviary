package virtual_library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class openBook implements Serializable{
	private static final long serialVersionUID = 1L;
	private JFrame SFrame;
	private JPanel SPanel;
	private JButton back;
	private JButton book;
	private Shelf myShelf;
	private int i;
	private int w;
	private int h;
	private int x;
	private int y;
	private int row;
	
	public openBook() {
		SFrame = new JFrame();
		SFrame.setSize(1920,1200);
		SFrame.setBackground(new Color(165,125,33));
		SFrame.setTitle("My Shelf");
		SFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SPanel = new JPanel();
		SPanel.setBackground(new Color(165,125,33));
	    SPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
	    SPanel.setLayout(new GridLayout(0,1));
		
	    back = new JButton("Back");
	    back.setFont(new Font("Papyrus", Font.BOLD|Font.ITALIC, 12));
		back.setBorder(BorderFactory.createRaisedBevelBorder());
		back.setForeground(Color.black);
		back.setBackground(new Color(179,110,6));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent s) {
				new Library();
	        }
		});
		
		SPanel.add(back);
		SFrame.add(SPanel,BorderLayout.SOUTH);
        SFrame.pack();
        SFrame.setLocationRelativeTo(null);
        SFrame.setVisible(true);
		
	}
	
	public void displayShelf() {
		//for the shelf, there is a specific height and width for each button which will serve as the book cover of the books
		java.util.List<Book> myBooks = myShelf.getList();
		
		w = 120;
		h = 180;
		x = 90;
		y = 40;
		row = 1;
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
			
			SFrame.add(book);
		}
	}
}
