/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploreflexion.customAnnot;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Toni
 */

//Tipo de anotacion
//RetentionPolicy.SOURCE — Retenida sólo a nivel de código; ignorada por el compilador.
//RetentionPolicy.CLASS — Retenida en tiempo de compilación, pero ignorada en tiempo de ejcución.
//RetentionPolicy.RUNTIME — Retenida en tiempo de ejecución, sólo se puede acceder a ella en este tiempo.
@Retention(RetentionPolicy.RUNTIME) 

//Donde se puede usar la anotacion
//ElementType.TYPE – se puede aplicar a cualquier elemento de la clase.
//ElementType.FIELD – se puede aplicar a un miebro de la clase.
//ElementType.METHOD – se puede aplicar a un método
//ElementType.PARAMETER – se puede aplicar a parámetros de un método.
//ElementType.CONSTRUCTOR – se puede aplicar a constructores
//ElementType.LOCAL_VARIABLE – se puede aplicar a variables locales
//ElementType.ANNOTATION_TYPE – indica que el tipo declarado en sí es un tipo de anotación.
@Target(ElementType.FIELD)        

@Documented     //Hará que la anotación se mencione en el javadoc.
@Inherited      //Indica que la anotación será heredada automáticamente.
public @interface MyAnotacion {
    String atributo() default "Sin valor";
}
