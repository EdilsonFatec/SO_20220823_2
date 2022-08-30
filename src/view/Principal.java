package view;
import javax.swing.JOptionPane;

import controller.killController;
public class Principal {

	public static void main(String[] args) {
		int opcao;
		int pid;
		String nome;

		killController process = new killController();
		
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção\n"+
		                                                         "1 - Lista processos\n"+
					                                             "2 - Mata processo pelo PID\n"+
					                                             "3 - Mata processo pelo nome\n"+		                                                         
		                                                         "9 - Fim"));
			if (opcao==1) {
				process.listaProcessos();
			}
			if (opcao==2) {
				pid = Integer.parseInt(JOptionPane.showInputDialog("Informe o PID"));
				process.mataPid(pid);
			}
			if (opcao==3) {
				nome = JOptionPane.showInputDialog("Informe o nome do processo");
				process.mataNome(nome);
			}
		}
		while (opcao != 9);
	}

}
