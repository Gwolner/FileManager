import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import filemanager.util.Ctt;

public class Escritor {

	private String path;
	private String nomeArquivo;
	private String extensao;
	
	public Escritor(String path, String nomeArquivo, String extensao){
		this.path = path;
		this.nomeArquivo = nomeArquivo;
		this.extensao = extensao;
	}
	
	
	public void gerarArquivo(String conteudo) throws IOException {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(path+Ctt.BARRA_INVERTIDA+nomeArquivo+"."+extensao));
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


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getNomeArquivo() {
		return nomeArquivo;
	}


	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}


	public String getExtensao() {
		return extensao;
	}


	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	
	
}
