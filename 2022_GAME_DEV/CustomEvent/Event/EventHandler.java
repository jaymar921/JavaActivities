package com.jaymar921.CustomEvent.Event;

import java.lang.reflect.Method;
import java.util.*;

public class EventHandler {

    // holds the registered methods
    public Map<Listener, Set<Method>> REGISTERED_EVENTS = new HashMap<>();
    // holds the instance of the classes that is being used by the registered methods
    public Map<String,Listener> REGISTERED_CLASSES = new HashMap<>();

    // register a new event that implements the Listener interface
    public void registerEvent(Listener listener){
        if(listener == null) // checks if listener is null, if yes then return
            return;

        // create a set of methods
        Set<Method> methods;

        try {
            // get the all the methods of the class (private and public)
            Method[] publicMethods = listener.getClass().getMethods();
            Method[] privateMethods = listener.getClass().getDeclaredMethods();

            methods = new HashSet<>(publicMethods.length + privateMethods.length, 1.0f);

            // add all the methods into the hash set
            methods.addAll(Arrays.asList(publicMethods));
            methods.addAll(Arrays.asList(privateMethods));

        } catch (NoClassDefFoundError e) {
            return;
        }

        // loop through the methods set
        for(Method method : methods){
            final CustomEvent eh = method.getAnnotation(CustomEvent.class); // check if the method has a CustomEvent annotation
            if(eh == null) // if CustomEvent is null then return
                continue;

            /*
             *  We have to make sure that the method parameter is only set to 1
             *  We also must check if the parameter is assignable from Event.class
             *
             *  if method parameter length is 1 and the parameter is assignable from Event.class, then
             *  it's good to go else we continue.
             */
            if(method.getParameterTypes().length!=1 || !Event.class.isAssignableFrom(method.getParameterTypes()[0])){
                continue;
            }

            // set the method accessible
            method.setAccessible(true);

            // add the registered methods into the map
            REGISTERED_EVENTS.put(listener,Set.of(method));
            // add the instance of the class that implements the listener interface into the map
            REGISTERED_CLASSES.put(listener.getClass().getName(),listener);
        }
    }
}
