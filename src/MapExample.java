import java.util.HashMap;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) {
		String wyraz = "matematyka";

		Map<Character, Integer> charsMap = new HashMap<>();

		for (char c : wyraz.toCharArray()) {
			if (!charsMap.containsKey(c)) {
				charsMap.put(c, 1);
			} else {
				int was = charsMap.get(c);
				charsMap.put(c, was + 1);
			}
		}

		charsMap.forEach((k, v) -> System.out.println("litera: " + k + ", ilosc powtorzen: " + v));
	}
}
