package oskarpolak.lombok;


import java.util.regex.Pattern;

public class Regex {

	public Regex() {
		// Sprwadzamy czy druga litera wynosi "s".
		System.out.println(Pattern.matches("\\d", "as"));

		// Sprawdzamy czy wyrażenie zawiera więcej niż jeden nondigit
		System.out.println(Pattern.matches("\\D+", "aaa"));

		
		System.out.println(Pattern.matches("[789][0-9]{8}","781234560"));
		
		System.out.println(Pattern.matches("[[a]{1,}&&[s]{1,}]", "asdasdad"));

		// Przykład z hasłem które ma zawierać jedynie znaki od a do c i ma być
		// ich 5 lub więcej
		if (!Pattern.matches("[[a]{1,}&&[s]{1,}]", "asdasda")) {
			// wykonujemy kod gdy hasło jest ok
		} else {
			// to hasło nie pasuje
		}

	}

}
