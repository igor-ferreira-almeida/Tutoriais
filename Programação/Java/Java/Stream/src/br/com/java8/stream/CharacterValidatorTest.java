package br.com.java8.stream;

public class CharacterValidatorTest {
	
	public static void main(String[] args) {
//		f.setLogradouroLocalOcorrencia(f.getLogradouroLocalOcorrencia().replaceAll("[^\\p{ASCII}]", ""));
//		f.setComplementoLocalOcorrencia(f.getComplementoLocalOcorrencia().replaceAll("[^\\p{ASCII}]", ""));
//		f.setBairroLocalOcorrencia(f.getBairroLocalOcorrencia().replaceAll("[^\\p{ASCII}]", ""));
//		f.setHistoricoBo(f.getHistoricoBo().replaceAll("[^\\p{ASCII}]", ""));
//		f.getPessoa().setNomeMae(f.getPessoa().getNomeMae().replaceAll("[^\\p{ASCII}]", ""));
//		f.getPessoa().setNomePai(f.getPessoa().getNomePai().replaceAll("[^\\p{ASCII}]", ""));
//		f.getPessoa().setNomePessoa(f.getPessoa().getNomePessoa().replaceAll("[^\\p{ASCII}]", ""));
		
		
		// CHARACTERES_COM_ACENTOS E NÚMEROS
		String logradouroLocalOcorrencia = "";
		String complementoLocalOcorrencia = "";
		String bairroLocalOcorrencia = "";
		String historicoBo = "";
		
		// CHARACTERES_COM_ACENTOS 
		String nomePessoa = "João Batista *&";
		String nomePai = "";
		String nomeMae = "";
		
		FormatadorDeCaracteres formatadorDeCaracteres = new FormatadorDeCaracteres();
		
		System.out.println(nomePessoa);
		
		nomePessoa = formatadorDeCaracteres.removeCaracteresInvalidosPorPadrao(nomePessoa, TipoValidadorCaracter.LETRAS_COM_ACENTOS);
		
		System.out.println(nomePessoa);
	}
	
}
