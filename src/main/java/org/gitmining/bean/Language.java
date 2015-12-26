package org.gitmining.bean;

public class Language {
	private static String[] languages = { "java", "Ruby", "Python", "C",
			"JavaScript", "Perl", "PHP", "C++", "HTML", "Shell", "Objective-C",
			"VimL", "C#", "Emacs Lisp", "Erlang", "Lua", "Clojure", "CSS",
			"Haskell", "Scala", "Common Lisp", "R", "Others" };

	private static Language lan = null;

	public static Language getInstance() {
		if (lan == null) {
			lan = new Language();
		}
		return lan;
	}

	public static String[] getLanguages() {
		return languages;
	}

	public static void setLanguages(String[] languages) {
		Language.languages = languages;
	}

}
