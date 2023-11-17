package filemanager.leitura;

import java.io.File;

import filemanager.util.Constantes;

public class Leitor {

	//public static boolean isDiretorioRaiz = true;
	private String path;
	private int nivel;
	
	public Leitor() {
		this.path = "";
		this.nivel = 1;
	}
	
	public String gerarLayout(int nivel,String comeco, String sequencia, String termino) {		
		String espacamento ="";	
		
		for(int i = 0;i <= nivel-2;i++) {
			espacamento += sequencia;
		}
		
		return comeco+espacamento+termino;
	}
	
	
	public String buscaArquivoELe(String caminho) {
		try {
			int contadorArquivos = 0;	
			
			File pasta = new File(caminho);			
			File[] lista = pasta.listFiles();
			String listaArquivos = "";
			String subPasta = "";
			String diretorioAtual = "";
			String caminhoRecursivo = "";
			
			for (File file : lista) {
			    if (file.isFile()) {
			    	
			    	contadorArquivos ++;
			    	
			    	//Compara o diretório analisado com o diretório informado no path e define sua tabulação.
			    	if(path.equals(file.getParent())) {
				    	listaArquivos += file.getName()+Constantes.QUEBRA_LINHA;
			    	}else {
			    		listaArquivos += gerarLayout(nivel,Constantes.BARRA_INVERTIDA, "  ", "  ")+file.getName()+Constantes.QUEBRA_LINHA;
			    	}
			    	
			    	diretorioAtual = pasta.getName();
			    }else {
			    	nivel += 1;
			    	
			    	caminhoRecursivo = caminho+Constantes.BARRA_INVERTIDA+file.getName();
			    	subPasta += gerarLayout(nivel,Constantes.BARRA_INVERTIDA, "__", " ")
			    			 +buscaArquivoELe(caminhoRecursivo)+"";
			    }
			}
			
			nivel -= 1;
			
			return "["+diretorioAtual+"] | Nível "+nivel+"| "+contadorArquivos+" arquivos."
					+ Constantes.QUEBRA_LINHA+listaArquivos+Constantes.QUEBRA_LINHA+subPasta;
			
		} catch (Exception e) {
			return "Ocorreu um erro@"+e.getMessage();
		}
		
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