
public class Layout {

	
	public static String tabulacao(int nivel,String comeco, String sequencia, String termino) {		
		String espacamento = Ctt.VAZIO;	
		
		for(int i = Ctt.ZERO;i <= nivel-Ctt.DOIS;i++) {
			espacamento += sequencia;
		}
		
		return comeco+espacamento+termino;
	}
	
	public static String hierarquia(String diretorioAtual, int nivel,
			int contadorArquivos,String listaArquivos,String subPasta, 
			boolean exibirNivel, boolean exibirContadorArquivos) {
		
		if(exibirNivel || exibirContadorArquivos) {
			if(exibirNivel && exibirContadorArquivos) {					
				return "["+diretorioAtual+"] | Nível "+nivel+" | "+contadorArquivos+" arquivos."
						+ Ctt.QUEBRA+listaArquivos+Ctt.QUEBRA+subPasta;				
			}else if(exibirNivel) {				
				return "["+diretorioAtual+"] | Nível "+nivel
						+ Ctt.QUEBRA+listaArquivos+Ctt.QUEBRA+subPasta;
			}else{				
				return "["+diretorioAtual+"] | "+contadorArquivos+" arquivos."
						+ Ctt.QUEBRA+listaArquivos+Ctt.QUEBRA+subPasta;
			}
		}else {
			return "["+diretorioAtual+"]"
					+ Ctt.QUEBRA+listaArquivos+Ctt.QUEBRA+subPasta;
		}
		
		
	}
	
}
