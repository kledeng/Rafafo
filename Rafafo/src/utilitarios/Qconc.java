package utilitarios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class Qconc {

	public static void main(String[] args) {
		Integer ano;
		String banca;
		String disciplina;
		String instituicao;
		String cargo;
		String enunciado;
		String item;
		String indiceQconc;

		try {
			URL url = new URL(
					"http://qconcursos.com/questoes-de-concursos/questoes/"
							+ "search?utf8=%E2%9C%93&q=&orgao=&banca=2+&ano=2014++2013++2012++2011+&cargo=&"
							+ "escolaridade=&modalidade=&disciplina=2+&assunto=2294++16163++775+&area_atuacao=&"
							+ "area_formacao=&nivel_dificuldade=&periodo_de=&periodo_ate=&"
							+ "possui_gabarito_comentado_texto_e_video=&possui_comentarios_gerais=&possui_comentarios=&"
							+ "possui_anotacoes=&sem_dos_meus_cadernos=&sem_anuladas=&sem_desatualizadas=&sem_anuladas_impressao=&"
							+ "sem_desatualizadas_impressao=&prova=&caderno_id=&migalha=&data_comentario_texto=&data=&r=&rc=&re=&nao_resolvidas=");
			// "http://qconcursos.com/questoes-de-concursos/questoes/search?&orgao=&banca=2+&ano=&cargo=&escolaridade=&modalidade=&disciplina=&assunto=&area_atuacao=&area_formacao=&nivel_dificuldade=&periodo_de=&periodo_ate=&possui_gabarito_comentado_texto_e_video=&possui_comentarios_gerais=&possui_comentarios=&possui_anotacoes=&sem_dos_meus_cadernos=&sem_anuladas=&sem_desatualizadas=&sem_anuladas_impressao=&sem_desatualizadas_impressao=&prova=&caderno_id=&migalha=&data_comentario_texto=&data=&r=&rc=&re=&nr=");
			InputStream inpStr = url.openStream();
			BufferedReader bufferedInputStream = new BufferedReader(
					new InputStreamReader(inpStr, "ISO-8859-1"));
			String linha = "";
			StringBuilder html = new StringBuilder();
			UtilQconc utilQconc = new UtilQconc();
			for (int i = 0; i < 20; i++) {

				while ((linha = bufferedInputStream.readLine()) != null) {
					while (linha != null
							&& !linha.contains("questao-numero left")) {
						try {
							linha = bufferedInputStream.readLine();
						} catch (NullPointerException e) {
							linha = "";
							e.printStackTrace();
						}
					}
					linha = bufferedInputStream.readLine();
					indiceQconc = linha.trim();
					linha = bufferedInputStream.readLine();
					System.out.println(indiceQconc);

					while (linha != null
							&& !linha.contains("/questoes-de-concursos/disciplinas/")) {
						linha = bufferedInputStream.readLine();
					}
					disciplina = linha.substring(linha.indexOf("\">") + 2,
							linha.length() - 4);
					System.out.println(disciplina);
					linha = bufferedInputStream.readLine();

					while (linha != null && !linha.contains("uma-questao-topo")) {
						linha = bufferedInputStream.readLine();
					}

					linha = bufferedInputStream.readLine();
					if (linha.contains("Ano:")) {
						ano = Integer.parseInt(linha.substring(
								linha.indexOf(" ") + 1, linha.length() - 6));
						System.out.println(ano);
						linha = bufferedInputStream.readLine();
					}
					if (linha.contains("Banca:")) {
						banca = linha.substring(linha.indexOf(" ") + 1,
								linha.length() - 6);
						System.out.println(banca);
						linha = bufferedInputStream.readLine();
					}
					linha = utilQconc.trataLinhaHtmlEncoding(linha);

					if (linha.contains("Órgão")) {
						instituicao = linha.substring(linha.indexOf(" ") + 1,
								linha.length() - 6);
						System.out.println(instituicao);
						linha = bufferedInputStream.readLine();
					}

					while (linha != null
							&& !linha
									.contains("/questoes-de-concursos/provas/")) {
						linha = bufferedInputStream.readLine();
					}
					// TODO colocar parser para o consertar erro de codificação
					// utf-8 para Latin1
					// byte[] linhautf = linha.getBytes("UTF-8");
					// byte[] latin1 = new String(linhautf, "UTF-8")
					// .getBytes("ISO-8859-1");
					// linha = new String(latin1,
					// Charset.forName("ISO-8859-1"));
					cargo = linha.substring(linha.indexOf("'>") + 2,
							linha.length() - 4);
					System.out.println(cargo);
					linha = bufferedInputStream.readLine();

					while (linha != null
							&& !linha.contains("enunciado enunciado-class")) {
						linha = bufferedInputStream.readLine();
					}
					linha = bufferedInputStream.readLine();
					linha = utilQconc.trataLinhaHtmlEncoding(linha);
					String[] questao = linha.split("<br/><br/>");
					enunciado = questao[0].trim();
					item = questao[1].trim();
					
					System.out.println(enunciado +"\n" + item);

				}
				// html.append(linha);
				// System.out.println(linha);
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// private String htmlEncode(final String string) {
	// final StringBuffer stringBuffer = new StringBuffer();
	// for (int i = 0; i < string.length(); i++) {
	// final Character character = string.charAt(i);
	// if (CharUtils.isAscii(character)) {
	// // Encode common HTML equivalent characters
	// stringBuffer.append(
	// StringEscapeUtils.escapeHtml4(character.toString()));
	// } else {
	// // Why isn't this done in escapeHtml4()?
	// stringBuffer.append(
	// String.format("&#x%x;",
	// Character.codePointAt(string, i)));
	// }
	// }
	// return stringBuffer.toString();
	// }
}
