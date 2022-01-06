package virtual_library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



//this is the main part of the program where it displays the main window
public class Library  {
	private JFrame library_window;
	private JLabel welcome;
	private JLabel background;
	private JButton Add;
	private JButton Shelf;
	private JButton Remove;
	private JPanel panel;
	private JPanel panel2;
	
	//this simple library will enable users to add books to their shelf, read them, and remove any book they want
	private void initialize() {
		library_window = new JFrame();
		library_window.setSize(1920,1200);
		library_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		background = new JLabel(new ImageIcon("background.jpg"));
		background.setSize(1920,1200);
		background.setLayout(new BorderLayout());
		library_window.add(background);
		 
		welcome = new JLabel("Welcome to Liviary!");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setFont(new Font("Edwardian Script ITC", Font.BOLD, 120));
        welcome.setForeground(Color.white);
		background.add(welcome);
		
		Add = new JButton("Add a Book");
		Add.setFont(new Font("Papyrus", Font.BOLD|Font.ITALIC, 20));
		Add.setBorder(BorderFactory.createRaisedBevelBorder());
		Add.setForeground(Color.black);
		Add.setBackground(new Color(179,110,6));
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				library_window.dispose();
				createFrame a_b = new createFrame();
	            a_b.for_add();
	            
	        }
		});
		
		Remove = new JButton("Remove a Book");
		Remove.setFont(new Font("Papyrus", Font.BOLD|Font.ITALIC, 20));
		Remove.setBorder(BorderFactory.createRaisedBevelBorder());
		Remove.setForeground(Color.black);
		Remove.setBackground(new Color(179,110,6));
		Remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent r) {
				library_window.dispose();
				createFrame rb = new createFrame();
	            rb.for_remove();
	        }
		});

		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,2));
		panel.setBackground(new Color(102,51,0));
		panel.add(Add);
		panel.add(Remove);
		
		Shelf = new JButton("Go to Shelf");
		Shelf.setFont(new Font("Papyrus", Font.BOLD|Font.ITALIC, 20));
		Shelf.setBorder(BorderFactory.createRaisedBevelBorder());
		Shelf.setForeground(Color.black);
		Shelf.setBackground(new Color(179,110,6));
		Shelf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent s) {
				library_window.dispose();
				new openBook();
	            
	        }
		});
		
		panel2 = new JPanel();
		panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setLayout(new GridLayout(0,1));
		panel2.setBackground(new Color(102,51,0));
		panel2.add(Shelf);
		
		library_window.add(panel,BorderLayout.NORTH);
		library_window.add(panel2,BorderLayout.SOUTH);
        library_window.setTitle("LIVIARY");
        library_window.pack();
        library_window.setLocationRelativeTo(null);
        library_window.setVisible(true);

	}
	
	public Library() {
		initialize();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library window = new Library();
					window.library_window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}


	

	
