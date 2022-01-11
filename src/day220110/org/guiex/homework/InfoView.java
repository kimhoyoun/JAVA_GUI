package day220110.org.guiex.homework;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import day220110.org.guiex.myframe.Myframe;

public class InfoView extends Myframe{
	Panel westpan = new Panel(new GridLayout(8,1,5,5));
	Panel centerpan = new Panel(new BorderLayout());
	Panel southpan = new Panel(new GridBagLayout());
	
	Panel nopan = new Panel(new GridLayout(1,2));
	Panel namepan = new Panel(new GridLayout(1,2));
	Panel emailpan = new Panel(new GridLayout(1,2));
	Panel telpan = new Panel(new GridLayout(1,2));
	Button btn1 = new Button("AllList");
	Button btn2 = new Button("Add");
	Button btn3 = new Button("Delete");
	Button btn4 = new Button("Search");
	Button btn5 = new Button("Cancel");
	Label nolbl = new Label("No");
	Label namelbl = new Label("Name");
	Label emaillbl = new Label("E-mail");
	Label tellbl = new Label("Tel");
	TextField no = new TextField(10);
	TextField name = new TextField(10);
	TextField email = new TextField(10);
	TextField tel = new TextField(10);
	TextArea area = new TextArea();
	
	public InfoView() {
		setSize(550,300);
		run();
	}
	
	
	private void run() {
		nopan.add(nolbl);
		nopan.add(no);
		westpan.add(nopan);
		
		namepan.add(namelbl);
		namepan.add(name);
		westpan.add(namepan);
		
		emailpan.add(emaillbl);
		emailpan.add(email);
		westpan.add(emailpan);
		
		telpan.add(tellbl);
		telpan.add(tel);
		westpan.add(telpan);

		this.add(BorderLayout.WEST, westpan);
		
		btn1.setPreferredSize(new Dimension(50, 30));
		btn2.setPreferredSize(new Dimension(50, 30));
		btn3.setPreferredSize(new Dimension(50, 30));
		btn4.setPreferredSize(new Dimension(50, 30));
		btn5.setPreferredSize(new Dimension(50, 30));
		southpan.add(btn1);
		southpan.add(btn2);
		southpan.add(btn3);
		southpan.add(btn4);
		southpan.add(btn5);
		this.add(BorderLayout.SOUTH,southpan);
		centerpan.add(area);
		this.add(centerpan);
	}

	public static void main(String[] args) {
		new InfoView().setVisible(true);;
		
	}

}
