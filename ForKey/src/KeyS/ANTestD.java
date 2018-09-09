package KeyS;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ANTestD {
	public static void main(String[] args) {
		AntPojo anp = new AntPojo();
		anp.setId("0");
		AntPojo anp1 = new AntPojo();
		anp1.setId("2");
		anp1.setName("user");
		String fitterSQL = FitterSQL(anp);
		System.out.println(fitterSQL);
	}

	public static String FitterSQL(AntPojo an) {
		StringBuilder sbl = new StringBuilder();
		Class c = an.getClass();
		//该类是否是标签类
	      boolean annotation = c.isAnnotationPresent(Table.class);
	      if(annotation) {
	    	  Table  table=  (Table) c.getAnnotation(Table.class);
	    	sbl.append("select * from ").append(table.value()).append("  where 1=1  ");
	      }
	       Field[] fields = c.getDeclaredFields();
	       for (Field field : fields) {
	    	   boolean annotationPresent = field.isAnnotationPresent(Column.class);
	    	   if(annotationPresent) {
	    		   Annotation[] annotations = field.getAnnotations();
	    		   for (Annotation annotation2 : annotations) {
	    			   Column column= (Column) annotation2;
	    			   sbl.append("  and  ").append(column.name()).append("=").append(column.length());
				}
	    		   
	    	   }
		}
               	      

		return sbl.toString();
	}
}
