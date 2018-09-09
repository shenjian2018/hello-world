package KeyS;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@testAn("class annatation")
public class anTest0 {
	@testAn("method annatation")
	public void testx() {

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		try {
			Class an = Class.forName("KeyS.anTest0");
			boolean d = an.isAnnotationPresent(testAn.class);
			if (d) {
				testAn testan = (testAn) an.getAnnotation(testAn.class);
				System.out.println(testan.value());
			}
			Method[] methods = an.getMethods();
			for (Method method : methods) {
				boolean annotationPresent = method.isAnnotationPresent(testAn.class);
				if (annotationPresent) {
					testAn test = method.getAnnotation(testAn.class);
					System.out.println(test.value());
				}
			}
			
			for (Method method : methods) {
				Annotation[] annotations = method.getAnnotations();
				for (Annotation annotation : annotations) {
					if(annotation instanceof testAn) {
						testAn  testan	=(testAn) annotation;
						System.out.println(testan.value());
					}
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
