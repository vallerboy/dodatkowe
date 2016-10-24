package oskarpolak.lombok;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Refleksje {

	public Refleksje() {

		try {
			Class<?> oskar = Class.forName("oskarpolak.lombok.OskarData");


			for (Method m : oskar.getDeclaredMethods()) {
				//System.out.println(m.getName());
				
			}
			
			Object classObject = oskar.newInstance();

			Method function = classObject.getClass().getDeclaredMethod("testGetName", String.class);
			function.setAccessible(true);

			Object result = function.invoke(classObject, "byc albo nie byc?");

			 System.out.println(result);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
