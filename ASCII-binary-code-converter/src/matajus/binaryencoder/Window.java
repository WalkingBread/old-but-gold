package matajus.binaryencoder;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Window extends JFrame {

	private JPanel contentPane;

	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 303);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea input = new JTextArea();
		input.setBounds(10, 11, 668, 80);
		contentPane.add(input);
		
		JTextArea output = new JTextArea();
		output.setBounds(10, 154, 668, 77);
		output.setEditable(false);
		contentPane.add(output);
		
		JRadioButton encode = new JRadioButton("encode");
		encode.setBounds(601, 98, 77, 23);
		contentPane.add(encode);
		
		JRadioButton decode = new JRadioButton("decode");
		decode.setBounds(601, 124, 77, 23);
		contentPane.add(decode);
		
		JButton convert = new JButton("Convert");
		convert.setBounds(300, 102, 89, 23);
		convert.setBackground(Color.WHITE);
		convert.setFocusPainted(false);
		convert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(encode.isSelected()) {
					output.setText(Encoder.encode(input.getText()));
				}
				else if(decode.isSelected()) {
					output.setText(Decoder.decode(input.getText()));
				}
			}
		});
		contentPane.add(convert);
		
		ButtonGroup group = new ButtonGroup();
		group.add(encode);
		group.add(decode);
		
		encode.setSelected(true);
		
		JButton copy = new JButton("Copy");
		copy.setBounds(589, 241, 89, 23);
		copy.setBackground(Color.WHITE);
		copy.setFocusPainted(false);
		copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
				clip.setContents(new StringSelection(output.getText()), null);
			}
			
		});
		contentPane.add(copy);
		
		//JScrollPane scrollInput = new JScrollPane(input);
		//JScrollPane scrollOutput = new JScrollPane(output);
	}
}
