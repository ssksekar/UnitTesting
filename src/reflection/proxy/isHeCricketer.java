package reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class isHeCricketer implements InvocationHandler {

    public static Object dynamicClassObject = null;
    public static List playerList = new ArrayList();

    public void setProxyObject(Object obj) {
        
        
        /*adding a players for country, india. same check can be done even for other countries.*/
        if ( obj.getClass().getName().equals("com.india")) {
            
            System.out.println("Adding indian players in a list");
            playerList.add("sachin");
            playerList.add("dada");
            playerList.add("dravid");
            playerList.add("virat");
        }

        dynamicClassObject = obj;
    }

    public Object invoke(Object proxyObject, Method methodWeCalled, Object[] paramForMethodWeCalled) throws Throwable {

        Object result = null;
        try {

            System.out.println("Checking whether he is an indian player");
            if (playerList.contains(paramForMethodWeCalled[0])) {
                result = methodWeCalled.invoke(dynamicClassObject, paramForMethodWeCalled);
            }
            else
            {
                throw new Exception("He is not an indian player.");
            }
            
        } 
        catch (Exception ex) {
            System.out.println("Exception occurred and exception message = " + ex.getMessage());
        }
        return result;
    }
}
