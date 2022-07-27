# Mavesa



## Para mostrar errores

En resources -> application.propierties y agregue la siguiente linea:

```
server.error.include-message = always
```

Luego, para generar un error con un mensaje propio:

```java
throw new Exception("El producto no existe");
```

Nota:

Si una funcion genera una excepcion, o llama a una funcion que puede generar una excepcion, hay dos operaciones que hay que hacer:

1. Indicar que la funcion genera una excepcion.

```java
public void funcion() throws Exception  {
    // ...
    throw new Exception("El producto no existe");
    // ...
}
```

2. Capturar el error

La captura de error funciona de la siguiente manera. Si dentro del bloque de codigo "try" hay un error, entonces el codigo salta al bloque "catch"

```java
public int division(int numero1,int numero2) {
    int resultado=0;
    try {
        resultado = numero1 / numero2;
    } catch(Exception ex) {
        resultado=-1;
    }

    return resultado;
}
```

# Agrupaciones

1. Saber que es lo que se espera tener de regreso. Ejemplo, crear una tabla de ejemplo con las columnas deseadas.
2. Voy a crear el objeto valioso (VO), o tambien llamado DTO (Data Transfer object). Que es solo un modelo que no tiene equivalente en la base de datos (no hay tablas)
   1. Es necesario crear el constructor con argumentos y tambien el constructor vacio
3. Determinar las columnas que se van a mostrar, y las columnas que son de funciones de agregacion (agrupacion)
4. Si hay error, verificar que los tipos de datos coincidan.

Ejemplo:

```
Caused by: java.lang.IllegalArgumentException: org.hibernate.hql.internal.ast.QuerySyntaxException: Unable to locate appropriate constructor on class [mavesa.jornada20220722.valueobject.ProductoAgrupadoVO]. Expected arguments are: java.lang.String, long, int, int, long [select new mavesa.jornada20220722.valueobject.ProductoAgrupadoVO(P.catProd.nombre,SUM(P.stockProducto),MIN(P.stockProducto),MAX(P.stockProducto),COUNT(P.stockProducto) )from mavesa.jornada20220722.entidad.Producto P group by P.catProd.nombre]
```

> **java.lang.String, long, int, int, long** indica como debe estar los parametros y el constructor.

1. Luego, crear la consulta

```java
@Query("select new mavesa.jornada20220722.valueobject."+
        "ProductoAgrupadoVO(P.catProd.nombre,SUM(P.stockProducto),MIN(P.stockProducto),MAX(P.stockProducto),COUNT(P.stockProducto) )" +
        "from Producto P group by P.catProd.nombre")
public List<ProductoAgrupadoVO> agrupar();
```

