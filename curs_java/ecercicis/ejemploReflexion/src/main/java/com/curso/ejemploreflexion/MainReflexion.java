/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploreflexion;

import com.curso.ejemploreflexion.customAnnot.MyAnotacion;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author Toni
 */
public class MainReflexion {
    
    public static void main(String[] args) {
    //Obtenemos la class
        //Class classAlumno = Alumno.class;
        // Class classAlumno = new Alumno.getClass();
        // Class classAlumno = Class.forName("com.example.modelos.Alumno");
        Alumno alu = new Alumno();
        alu.setEdad(20);
        Class classAlumno = alu.getClass();
        
        System.out.println(classAlumno.getSimpleName());
        System.out.println(classAlumno.getName());
        System.out.println(classAlumno.getCanonicalName());

        System.out.println("Superclass: "+classAlumno.getSuperclass());

        
        System.out.println("Interfaces: " );
        for (Class interfaceClass : classAlumno.getInterfaces()) {
            System.out.println(interfaceClass.getName());
        }

        System.out.println("Fields: " );
        for (Field field : classAlumno.getDeclaredFields()) {
            System.out.println("** Field ** ");    
            System.out.println("name:"+field.getName());    
            System.out.println("type:"+field.getType().getName());    
            System.out.println("privado?:"+field.canAccess(alu));
            field.setAccessible(true);
            System.out.println("privado?:"+field.canAccess(alu));
            
            
            System.out.println("Anotaciones:");
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annot : annotations) {
                System.out.println("-> " + annot.getClass().getName() );
                if(annot instanceof MyAnotacion){
                    System.out.println("atributo() => "+((MyAnotacion) annot).atributo());
                }
            }

            System.out.println(" \n ");
        }
        
        System.out.println("Methods: " );
        Method[] methods = classAlumno.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getReturnType().getName()+ " " + method.getName());
            //TODO compltar para mostrar los argumentos de entrada
        }
        
        

        try {
            Field fEdad = classAlumno.getDeclaredField("edad");
            fEdad.setAccessible(true);
            System.out.println("edad: "+fEdad.get(alu));
            fEdad.set(alu, 30);
            System.out.println("edad: "+fEdad.get(alu));
            System.out.println("edad: "+alu.getEdad());
        } catch(IllegalAccessException | NoSuchFieldException iae) {
            System.out.println("error");
            System.out.println(iae);
        }
    }
}
