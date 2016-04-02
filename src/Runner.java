import by.epamlab.beans.Bean1;
import by.epamlab.beans.Bean2;
import by.epamlab.utility.Analyzer;

public class Runner {
	public static void main(String[] args) {
		Bean1 bean11 = new Bean1();
		Bean1 bean12 = new Bean1("hasName", 2);

		String name = "newName";
		Bean2 bean21 = new Bean2();
		Bean2 bean22 = new Bean2(1, name, 2.2);
		Bean2 bean23 = new Bean2(2, name, 2.2);
		Bean2 bean24 = new Bean2(2, name, 2.4);

		Object[] objects = { bean11, bean12, bean21, bean22, bean23, bean24 };

		int size = objects.length;

		try {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (i == j) {
						break;
					}
					System.out.println();

					String message = "The objects " + i + " and " + j;
					if (Analyzer.equalObjects(objects[i], objects[j])) {
						System.out.println(message + " are equals");
					} else {
						System.out.println(message + " aren't equals");
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			System.out.println("Error in get data");
		}
	}
}
