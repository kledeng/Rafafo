package utilitarios;

public class UtilQconc {

	public String trataLinhaHtmlEncoding(String ln) {
		if (ln != null && !ln.equals("")) {
			ln = ln.replaceAll("&Agrave;", "À");
			ln = ln.replaceAll("&agrave;", "à");
			ln = ln.replaceAll("&Aacute;", "Á");
			ln = ln.replaceAll("&aacute;", "á");
			ln = ln.replaceAll("&Acirc;", "Â");
			ln = ln.replaceAll("&acirc;", "â");
			ln = ln.replaceAll("&Atilde;", "Ã");
			ln = ln.replaceAll("&atilde;", "ã");
			ln = ln.replaceAll("&Ccedil;", "Ç");
			ln = ln.replaceAll("&ccedil;", "ç");
			ln = ln.replaceAll("&Egrave;", "È");
			ln = ln.replaceAll("&egrave;", "è");
			ln = ln.replaceAll("&Eacute;", "É");
			ln = ln.replaceAll("&eacute;", "é");
			ln = ln.replaceAll("&Ecirc;", "Ê");
			ln = ln.replaceAll("&ecirc;", "ê");
			ln = ln.replaceAll("&Igrave;", "Ì");
			ln = ln.replaceAll("&igrave;", "ì");
			ln = ln.replaceAll("&Iacute;", "Í");
			ln = ln.replaceAll("&iacute;", "í");
			ln = ln.replaceAll("&Iuml;", "Ï");
			ln = ln.replaceAll("&iuml;", "ï");
			ln = ln.replaceAll("&Ograve;", "Ò");
			ln = ln.replaceAll("&ograve;", "ò");
			ln = ln.replaceAll("&Oacute;", "Ó");
			ln = ln.replaceAll("&oacute;", "ó");
			ln = ln.replaceAll("&Otilde;", "Õ");
			ln = ln.replaceAll("&otilde;", "õ");
			ln = ln.replaceAll("&Ugrave;", "Ù");
			ln = ln.replaceAll("&ugrave;", "ù");
			ln = ln.replaceAll("&Uacute;", "Ú");
			ln = ln.replaceAll("&uacute;", "ú");
			ln = ln.replaceAll("&Uuml;", "Ü");
			ln = ln.replaceAll("&uuml;", "ü");
		}

		return ln;
	}

}
