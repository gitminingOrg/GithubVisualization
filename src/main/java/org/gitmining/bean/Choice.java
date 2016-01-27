package org.gitmining.bean;

public class Choice {
	private static String[] languages = { "all","java", "Ruby", "Python", "C",
			"JavaScript", "Perl", "PHP", "C++", "HTML", "Shell", "Objective-C",
			"VimL", "C#", "Emacs Lisp", "Erlang", "Lua", "Clojure", "CSS",
			"Haskell", "Scala", "Common Lisp", "R", "Others" };
	
	private static String[] create_years={"all","2007","2008","2009","2010","2011"};

	private static Choice lan = null;

	public static Choice getInstance() {
		if (lan == null) {
			lan = new Choice();
		}
		return lan;
	}

	public static String[] getLanguages() {
		return languages;
	}

	public static void setLanguages(String[] languages) {
		Choice.languages = languages;
	}

	public static String[] getCreate_years() {
		return create_years;
	}

	public static void setCreate_years(String[] create_years) {
		Choice.create_years = create_years;
	}

}
