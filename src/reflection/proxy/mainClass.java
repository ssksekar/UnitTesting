
package reflection.proxy;

import java.lang.reflect.Proxy;

public class mainClass {
    
    public static void main(String[] args) throws Exception {
        
        System.out.println("Loading Cricket and going to creat a Proxy object");
        cricket game = (cricket) createProxyObject("reflection.proxy.india");
        System.out.println("Calling a getPlayerState method for dravid");
        String playerState = game.getPlayerState("dada");
        System.out.println("finally Player State = " + playerState);        
        
    }
    
    
    public static Object createProxyObject(String dynamicClass) throws Exception
    {
        /* whatever cricket team can be loaded dynamically */
        Object dynamicObject = Class.forName(dynamicClass).newInstance();
        
        /* get the classloader by which dynamic class is loaded. */
        ClassLoader dynamicClassesLoders = dynamicObject.getClass().getClassLoader();
        
        /* get the list of interfaces, that are implemented by dynamic class */
        Class [] interfacesList = dynamicObject.getClass().getInterfaces();
        
        /* define a proxy class that should be executed and create an object for that proxy class */
        isHeCricketer ourProxyObject = (isHeCricketer) Class.forName("reflection.proxy.isHeCricketer").newInstance();
        
        /* set dynamicClassobject in our proxy class, then only it will know the class that needs to be called */
        ourProxyObject.setProxyObject(dynamicObject);
        
        /*create java proxy instance and returns it*/
        Object javaProxyObject = Proxy.newProxyInstance(dynamicClassesLoders, interfacesList, ourProxyObject);
        
        return javaProxyObject;
    }
    
}
