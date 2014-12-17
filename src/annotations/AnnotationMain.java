//$Id$
package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationMain 
{
	 public static void main(String args[]) throws SecurityException, ClassNotFoundException 
	 {
		   for (Method method : Class.forName("annotations.BuildHouse").getMethods()) 
		   {
		     // checks if there is annotation present of the given type Developer
		     if (method.isAnnotationPresent(annotations.DevelopersTool.class)) 
		     {
		       try 
		       {
		         // iterates all the annotations available in the method
		         for (Annotation anno : method.getDeclaredAnnotations()) 
		         {
		           System.out.println("Annotation in Method '" + method + "' : " + anno);
		           DevelopersTool a = method.getAnnotation(DevelopersTool.class);
		           if ("Popeye".equals(a.value())) 
		           {
		             System.out.println("Popeye the sailor man! " + method);
		           }
		         }
		       } 
		       catch (Throwable ex) 
		       {
		         ex.printStackTrace();
		       }
		     }
		  }
	 }
	 
}
