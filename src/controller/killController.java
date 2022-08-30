package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class killController {

	public killController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void listaProcessos() {
		String sis;
		String comando;
		sis = os();
		if (sis.contains("Windows")) {
			comando = "TASKLIST /FO TABLE";
		} else {
			comando = "ps -ef";
		}
		try {
			Process p = Runtime.getRuntime().exec(comando);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha!= null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			fluxo.close();
			leitor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void mataPid(int pid) {
		String sis;
		String comando;
		sis = os();
		if (sis.contains("Windows")) {
			comando = "TASKKILL /PID "+Integer.toString(pid);
		} else {
			comando = "kill -9 "+Integer.toString(pid);
		}
		try {
			Runtime.getRuntime().exec(comando);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void mataNome(String nome) {
		String sis;
		String comando;
		sis = os();
		if (sis.contains("Windows")) {
			comando = "TASKKILL /IM "+nome;
		} else {
			comando = "pkill -f "+nome;
		}
		try {
			Runtime.getRuntime().exec(comando);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
