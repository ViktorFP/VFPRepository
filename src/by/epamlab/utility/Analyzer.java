package by.epamlab.utility;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import by.epamlab.annotations.Equal;

public final class Analyzer {
	private final static Class<? extends Annotation> ANNOTATION_CLASS = Equal.class;

	public static boolean equalObjects(Object o1, Object o2) {
		Class<?> class1 = o1.getClass();
		Class<?> class2 = o2.getClass();

		if (class1 != class2) {
			System.out.println("Objects belong another classes:");
			System.out.println("class1 = " + class1.getSimpleName()
					+ " || class2 = " + class2.getSimpleName());
			return false;
		}

		Field[] fieldsObject1 = class1.getDeclaredFields();
		Field[] fieldsObject2 = class2.getDeclaredFields();

		for (Field fieldObj1 : fieldsObject1) {
			if (fieldObj1.isAnnotationPresent(ANNOTATION_CLASS)) {

				for (Field fieldObj2 : fieldsObject2) {
					if (fieldObj2.isAnnotationPresent(ANNOTATION_CLASS)) {

						String name1 = fieldObj1.getName();
						String name2 = fieldObj2.getName();

						if (name1.equals(name2)) {
							try {
								fieldObj1.setAccessible(true);
								fieldObj2.setAccessible(true);
								Object data1 = fieldObj1.get(o1);
								Object data2 = fieldObj2.get(o2);

								if (equalByReference(fieldObj1, fieldObj2,
										data1, data2)) {
									System.out
											.println(name1
													+ "1 and "
													+ name2
													+ "2 referensed on the same object");
								}

								if (!data1.equals(data2)) {
									System.out.println(name1 + "1 = " + data1
											+ " || " + name2 + "2 = " + data2);
									return false;
								}
							} catch (IllegalArgumentException
									| IllegalAccessException e) {
								System.out.println("Error in get data");
							}
						}
					}
				}
			}
		}
		return true;
	}

	private static boolean equalByReference(Field field1, Field field2,
			Object obj1, Object obj2) {
		Equal equal1 = (Equal) field1.getAnnotation(ANNOTATION_CLASS);
		Equal equal2 = (Equal) field2.getAnnotation(ANNOTATION_CLASS);
		Equal.DataType dataType = Equal.DataType.REFERENCE;

		return equal1.compareBy() == dataType && equal2.compareBy() == dataType
				&& obj1 == obj2;
	}
}
