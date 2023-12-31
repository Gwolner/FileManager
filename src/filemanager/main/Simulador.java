package filemanager.main;

import java.io.IOException;

import filemanager.escrita.GeradorDeArquivo;
import filemanager.leitura.Leitor;

public class Simulador {

	public static void main(String[] args) throws IOException {
		Leitor leitor = new Leitor();
		leitor.setPath("C:\\Users\\leandro.oliveira\\Desktop\\arquivos");
		System.out.println(leitor.buscaArquivoELe(leitor.getPath()));
		
		GeradorDeArquivo gda = new GeradorDeArquivo();
		gda.gerarTXT(leitor.buscaArquivoELe(leitor.getPath()));
		
	}
}