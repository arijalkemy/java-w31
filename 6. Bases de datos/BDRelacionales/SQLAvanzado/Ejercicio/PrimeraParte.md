<h1 style="text-align: center;">Ejercicio consultas SQL avanzadas</h1>

### Primera parte

1. **¿A qué se denomina JOIN en una base de datos y para qué se utiliza?**

<div style="text-align: justify;">

En base de datos, un *JOIN* es una operación SQL que permite combinar datos de dos o más tablas relacionadas en una única consulta. Se utiliza para unir filas de diferentes tablas mediante columnas comunes, lo que facilita el acceso y análisis de información distribuida en diversas tablas. Existen distintos tipos de *JOIN* (como *INNER JOIN*, *LEFT JOIN*, *RIGHT JOIN*, y *FULL OUTER JOIN*, entre otros), los cuales determinan cómo se manejan las filas que no tienen valores coincidentes en ambas tablas.

</div>

2. **Explicar dos tipos de JOIN.**

<div style="text-align: justify;">

*INNER JOIN*: Devuelve únicamente las filas en las que existe coincidencia en ambas tablas; es decir, solo se incluyen aquellas filas que cumplen el criterio de relación en ambos lados.

*LEFT JOIN*: Retorna todas las filas de la tabla de la izquierda, junto con las filas coincidentes de la tabla de la derecha. Si no existe una coincidencia, las columnas de la tabla derecha se completan con valores nulos.

*RIGHT JOIN*: Similar al *LEFT JOIN*, pero en este caso se incluyen todas las filas de la tabla de la derecha y, cuando no hay coincidencia en la tabla de la izquierda, se asignan valores nulos a las columnas correspondientes.

*FULL OUTER JOIN*: Combina las características de los *LEFT* y *RIGHT JOIN*, devolviendo todas las filas de ambas tablas. Para las filas sin coincidencia en alguna de las tablas, se rellenan los valores con nulos.

</div>

3. **¿Para qué se utiliza el GROUP BY?**

<div style="text-align: justify;">

El comando *GROUP BY* en SQL se utiliza para agrupar filas que comparten uno o varios valores en común en las columnas especificadas.

</div>

4. **¿Para qué se utiliza el HAVING?**

<div style="text-align: justify;">

*HAVING* se utiliza para filtrar los resultados de una consulta que involucra una agrupación con *GROUP BY*. A diferencia de la cláusula *WHERE*, que filtra filas antes de la agrupación, *HAVING* se aplica después de que se han formado los grupos, permitiendo establecer condiciones de filtrado sobre los resultados agregados.

</div>

5. **Escribir una consulta genérica para cada uno de los siguientes diagramas:**

<img src="https://res.cloudinary.com/pym/image/upload/c_scale,f_auto,q_auto,w_258/articles/2019/sql/INNER_JOIN" alt="Inner Join" width="150">

```SQL
SELECT t1.campo1, t2.campo2
FROM tabla1 AS t1
INNER JOIN tabla2 AS t2
  ON t1.campo1 = t2.campo1;
```

<div style="text-align: justify;">

Esta consulta utiliza un INNER JOIN para combinar los datos de dos tablas, "tabla1" y "tabla2". Mediante el alias t1 y t2 se facilita la referencia a cada tabla. La cláusula ON especifica que la unión se realiza cuando los valores de "campo1" en ambas tablas coinciden. Así, se devuelven únicamente las filas en las que ambas tablas tienen un valor idéntico en "campo1".

</div>

<img src="https://res.cloudinary.com/pym/image/upload/c_scale,f_auto,q_auto,w_258/articles/2019/sql/LEFT_JOIN" alt="Left join" width="150">

```SQL
SELECT t1.campo1, t2.campo2
FROM tabla1 AS t1
LEFT JOIN tabla2 AS t2
  ON t1.campo1 = t2.campo1;
```

<div style="text-align: justify;">

Esta consulta utiliza un LEFT JOIN para combinar los datos de dos tablas, "tabla1" y "tabla2". Se establecen alias (t1 y t2) para facilitar la referencia a cada tabla. La cláusula ON especifica que la unión se realiza cuando los valores de "campo1" coinciden en ambas tablas. Con un LEFT JOIN, se devuelven todas las filas de "tabla1" (tabla izquierda) y únicamente las filas de "tabla2" (tabla derecha) que presenten coincidencias; en caso de no encontrar correspondencia, los campos provenientes de "tabla2" se completarán con valores nulos.

</div>