import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {
	
	public void gerarTXT(String conteudo) throws IOException {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter("C:\\dev_sad\\sgic\\workspace_sts\\FileReader\\src\\arqFile.txt"));
			bufferedWriter.write(conteudo);
		} catch (IOException e) {
			System.out.println("Exception occurred: " + e.getMessage());
		} finally {
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}				
		}
		
		System.out.println("Fim da execução!");
	}
	
}
