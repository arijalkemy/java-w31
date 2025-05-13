<h1 style="text-align: center;">Ejercicio 2</h1>

Una vez modelada y planteada la base de datos, responder a las siguientes preguntas:

1. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
2. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.
3. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.

---

1. La primary key para la tabla de clientes es el DNI.
    - El DNI es un dato único para cada persona, lo que garantiza que no existan dos clientes con el mismo identificador. **(Unicidad)**
    - Toda persona cuenta con un DNI, por lo que se cumple el requisito de que la primary key no acepte valores nulos. **(No nulo)**
    - Permite identificar de manera inequívoca a cada registro en la tabla, facilitando la integridad y las relaciones con otras tablas. **(Identificación)**

2. La primary key de la tabla de planes de internet es el identificador del plan (id -> podría ser un número entero autoincrementable).
    - El campo id es único para cada plan, lo que evita duplicados. **(Unicidad)**
    - Un identificador permitirá identificar a cada registro en la tabla. **(Identificación)**
    - No será nulo para ningún registro de la tabla. **(No nulo)**

3. Los clientes contratan planes de internet. En este escenario, cada cliente contrata exactamente un plan de internet, mientras que un mismo plan puede ser contratado por cero, uno o muchos clientes. Esto establece una relación de muchos a uno entre la tabla de clientes y la tabla de planes de internet.
La foreign key debe estar en la tabla de clientes, ya que cada cliente debe estar asociado a un plan de internet específico. Esta foreign key hará referencia al campo id (la primary key) de la tabla de planes de internet.
Al almacenar la foreign key en la tabla de clientes, se asegura que cada registro de cliente indique a cuál plan de internet está asociado.
