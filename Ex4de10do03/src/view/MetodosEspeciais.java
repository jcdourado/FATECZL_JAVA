package view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import controller.OpCorrer;

public class MetodosEspeciais implements ActionListener {
	private static JLabel lblCarro1;
	private static JLabel lblCarro2;
	private JButton btnCorrer;
	public MetodosEspeciais(JLabel lblCarro1, JLabel lblCarro2, JButton btnCorrer) {
		this.lblCarro1 = lblCarro1;
		this.lblCarro2 = lblCarro2;
		this.btnCorrer = btnCorrer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		btnCorrer.setEnabled(false);
		Thread carro1 = new OpCorrer(btnCorrer,lblCarro1);
		Thread carro2 = new OpCorrer(btnCorrer,lblCarro2);
		
		carro1.start();
		carro2.start();
	}
	
	public static void setaPosicao(Rectangle posicaoCarro1, Rectangle posicaoCarro2){
		posicaoCarro1.x = 20;
		posicaoCarro2.x = 20;
		posicaoCarro1.y = 73;
		posicaoCarro2.y = 136;
		lblCarro1.setBounds(posicaoCarro1);
		lblCarro2.setBounds(posicaoCarro2);	
	}
}
