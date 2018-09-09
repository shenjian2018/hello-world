package KeyS;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

	String name();

	int length();

	String type();
}
