package by.epamlab.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Equal {
	DataType compareBy();

	enum DataType {
		REFERENCE, VALUE
	}
}
