import java.io.File;
import filemanager.util.Ctt;
import filemanager.util.Layout;
import filemanager.util.MensagemPersonalizada;

public class Leitor {

	//public static boolean isDiretorioRaiz = true;
	private String path;
	private int nivel;
	
	public Leitor() {
		this.path = Ctt .VAZIO;
		this.nivel = Ctt.UM;
	}	
	
	public void reiniciarLeitor() {
		this.nivel = Ctt.UM;
	}
	
	public String lerDiretorio(String caminho) {
		try {
			int contadorArquivos = Ctt.ZERO;			
			File pasta = new File(caminho);			
			File[] lista = pasta.listFiles();
			String listaArquivos = Ctt.VAZIO;
			String subPasta = Ctt.VAZIO;
			String diretorioAtual = Ctt.VAZIO;
			String caminhoRecursivo = Ctt.VAZIO;
			
			for (File file : lista) {
			    if (file.isFile()) {			    	
			    	contadorArquivos ++;
			    	
			    	//Compara o diretório analisado com o diretório informado no path e define sua tabulação.
			    	if(path.equals(file.getParent())) {
				    	listaArquivos += file.getName()+Ctt.QUEBRA;
			    	}else {
			    		listaArquivos += Layout.tabulacao(nivel,Ctt.ESPACO,Ctt.ESPACO_DUPLO,Ctt.ESPACO_DUPLO)
			    				+file.getName()+Ctt.QUEBRA;
			    	}
			    	
			    	diretorioAtual = pasta.getName();
			    }else {
			    	nivel += Ctt.UM;			    	
			    	caminhoRecursivo = caminho+Ctt.BARRA_INVERTIDA+file.getName();
			    	subPasta += Layout.tabulacao(nivel,Ctt.BARRA_INVERTIDA,Ctt.LINHA_DUPLA, Ctt.ESPACO)
			    			 +lerDiretorio(caminhoRecursivo)+Ctt.VAZIO;
			    }
			}
			
			nivel -= 1;			
			return Layout.hierarquia(diretorioAtual, nivel, contadorArquivos, listaArquivos, subPasta, true, true);
			
		} catch (Exception e) {
			return MensagemPersonalizada.excecao(e);
		}finally {
			
			//Reinicia o nível após encerrar a chamada recursiva (encerra com nível <= 0, exceto o primeiro 0).
			if(nivel <=0) {
				reiniciarLeitor();
//				System.out.println("Nível: "+nivel);
			}
//			
		}
		
	}
	
	public String lerExcel(String caminho) {
		//Melhoria futura
		return "Lendo Excel";
	}
	
	public String lerXML(String caminho) {
		//Melhoria Futura
		return "Lendo XMl";
	}
	
	public String lerPOM(String caminho) {
		//Melhoria Futura
		return "Lendo POM";
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public int getNivel() {
		return this.nivel;
	}

}
