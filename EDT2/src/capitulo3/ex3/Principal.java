package capitulo3.ex3;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		Estacionamento estacionamento = new Estacionamento();
		while(true) {
			switch(JOptionPane.showInputDialog("Entre C para chegada e P para partida")) {
				case "C": case "c": JOptionPane.showMessageDialog(null, estacionamento.chegada(JOptionPane.showInputDialog("Entre com a placa:")));
				break;
				case "P": case "p": JOptionPane.showMessageDialog(null, estacionamento.saida(JOptionPane.showInputDialog("Entre com a placa:")));
				break;
				default: JOptionPane.showMessageDialog(null, "Entrada inválida!");
			}
		}

	}

}
