import java.io.IOException;
import filemanager.leitura.Leitor;
import filemanager.escrita.Escritor;


public class Simulador {

	public static void main(String[] args) throws IOException {
		
		//Simulando entrada externa
		String caminhoLeitura = "C:\\Users\\leandro.oliveira\\Desktop\\arquivos";
		String caminhoEscrita = "C:\\dev_sad\\sgic\\workspace_sts\\FileReader\\src";
		String nomeDoArquivo = "arqFile";
		String tipoExtensao = "txt";
		
		Leitor leitor = new Leitor();
		leitor.setPath(caminhoLeitura);
		System.out.println(leitor.lerDiretorio(leitor.getPath()));
		
		Escritor escritor = new Escritor(caminhoEscrita, nomeDoArquivo, tipoExtensao);
		escritor.gerarArquivo(leitor.lerDiretorio(leitor.getPath()));
		
		escritor.setNomeArquivo("NovoArqFile");
		escritor.gerarArquivo(leitor.lerDiretorio(leitor.getPath()));
		
		
		
//		StringsPersonalizadas barra = StringsPersonalizadas.BARRA;
//		
//		System.out.println("SP: "+barra);
//		
//		for (StringsPersonalizadas sp : StringsPersonalizadas.values()) {
//		      System.out.println(sp.getDescricao());
//		}
		
		
		
	}
}
