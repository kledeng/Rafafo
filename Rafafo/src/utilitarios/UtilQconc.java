package utilitarios;

public class UtilQconc {

	public String trataLinhaHtmlEncoding(String ln) {
		if (ln != null && !ln.equals("")) {
			ln = ln.replaceAll("&Agrave;", "�");
			ln = ln.replaceAll("&agrave;", "�");
			ln = ln.replaceAll("&Aacute;", "�");
			ln = ln.replaceAll("&aacute;", "�");
			ln = ln.replaceAll("&Acirc;", "�");
			ln = ln.replaceAll("&acirc;", "�");
			ln = ln.replaceAll("&Atilde;", "�");
			ln = ln.replaceAll("&atilde;", "�");
			ln = ln.replaceAll("&Ccedil;", "�");
			ln = ln.replaceAll("&ccedil;", "�");
			ln = ln.replaceAll("&Egrave;", "�");
			ln = ln.replaceAll("&egrave;", "�");
			ln = ln.replaceAll("&Eacute;", "�");
			ln = ln.replaceAll("&eacute;", "�");
			ln = ln.replaceAll("&Ecirc;", "�");
			ln = ln.replaceAll("&ecirc;", "�");
			ln = ln.replaceAll("&Igrave;", "�");
			ln = ln.replaceAll("&igrave;", "�");
			ln = ln.replaceAll("&Iacute;", "�");
			ln = ln.replaceAll("&iacute;", "�");
			ln = ln.replaceAll("&Iuml;", "�");
			ln = ln.replaceAll("&iuml;", "�");
			ln = ln.replaceAll("&Ograve;", "�");
			ln = ln.replaceAll("&ograve;", "�");
			ln = ln.replaceAll("&Oacute;", "�");
			ln = ln.replaceAll("&oacute;", "�");
			ln = ln.replaceAll("&Otilde;", "�");
			ln = ln.replaceAll("&otilde;", "�");
			ln = ln.replaceAll("&Ugrave;", "�");
			ln = ln.replaceAll("&ugrave;", "�");
			ln = ln.replaceAll("&Uacute;", "�");
			ln = ln.replaceAll("&uacute;", "�");
			ln = ln.replaceAll("&Uuml;", "�");
			ln = ln.replaceAll("&uuml;", "�");
		}

		return ln;
	}

}
