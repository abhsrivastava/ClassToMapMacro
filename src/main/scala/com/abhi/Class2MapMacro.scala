package com.abhi

import scala.annotation.StaticAnnotation
import scala.meta._

/**
  * Created by ASrivastava on 7/4/17.
  */

class ToMap extends StaticAnnotation {
   inline def apply(defn: Any) : Any = meta {
      defn match {
         case cls: Defn.Class =>
            val list = for {
               param <- cls.ctor.paramss.flatten
            } yield q"(${param.name.syntax}, ${Term.Name(param.name.value)}.toString)"
            val t : Term = q"_root_.scala.collection.Map[String, String](..$list)"
            val func = q"def toMap() : _root_.scala.collection.Map[String, String] = $t"
            val newStats = cls.templ.stats.getOrElse(Nil) :+ func
            cls.copy(templ = cls.templ.copy(stats = Some(newStats)))
         case _ => abort("Attribute is only allowed on classes")
      }
   }
}
