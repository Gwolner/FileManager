import java.io.File;

public class Leitor {


	//public static boolean isDiretorioRaiz = true;
	
	public static String buscaArquivoELe(String caminho) {
		try {
			int contadorArquivos = 0;		
			File pasta = new File(caminho);
			File[] lista = pasta.listFiles();
			String listaArquivos = "";
			String listaNaoArquivos = "";
			String subPasta = "";
			String diretorioAtual = "";
			
			for (File file : lista) {
			    if (file.isFile()) {
//			    	System.out.println("file.getName(): "+file.getAbsolutePath());
			    	System.out.println(caminho+"\\"+pasta);
			    	if(file.getName().equals(pasta.getName())) {
			    		System.out.println(pasta.getName());
			    	}
			    	
			    	contadorArquivos ++;
//			    	if(file.getParent() == file.getName()) {
//			    		
//			    	}else {
//			    		
//			    	}
			    	listaArquivos += "    "+file.getName()+"\n";
			    	diretorioAtual = pasta.getName();
			    }else {
			    	//isDiretorioRaiz = false;
			    	//System.out.println(caminho+"\\"+file.getName());
			    	subPasta += "\\__ "+buscaArquivoELe(caminho+"\\"+file.getName())+"";
			    	//listaNaoArquivos += file.getName()+" ";
			    	//System.out.println(listaNaoArquivos);
			    	
			    }
			}
			
			//System.out.println(listaNaoArquivos);
			
			return "["+diretorioAtual+"] || "+contadorArquivos+" arquivos."
					+ "\n"+listaArquivos+"\n"+subPasta;
			
//			return "ok";
			
		} catch (Exception e) {
			return "Ocorreu um erro | "+e.getMessage();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		//Contém 3 .txt e 2 diretórios: um com 2 imagens e outro com dois .txt
		String caminho = "C:\\Users\\Wolner\\Documents\\Books";
		System.out.println(buscaArquivoELe(caminho));
	}

}