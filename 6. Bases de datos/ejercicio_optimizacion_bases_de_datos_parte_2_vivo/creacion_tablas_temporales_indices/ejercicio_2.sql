USE movies_db;

-- 1 En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
SELECT * FROM series WHERE title like 'The Walking%';
EXPLAIN SELECT * FROM series WHERE title like 'The Walking%';

-- id, select_type, table, partitions, type, possible_keys, key, key_len, ref, rows, filtered, Extra
-- '1', 'SIMPLE', 'series', NULL, 'ALL', NULL, NULL, NULL, NULL, '6', '16.67', 'Using where'

CREATE INDEX idx_title ON series(title);
SHOW INDEX FROM series;
EXPLAIN SELECT * FROM series WHERE title like 'The Walking%';

-- id, select_type, table, partitions, type, possible_keys, key, key_len, ref, rows, filtered, Extra
-- '1', 'SIMPLE', 'series', NULL, 'range', 'idx_title', 'idx_title', '1502', NULL, '1', '100.00', 'Using index condition'

-- DROP INDEX idx_title ON series;

-- 2 Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

/* 
Se crearía un índice en la columna title de la tabla series porque lo más comun es buscar por un nombre de una serie y no siempre es el nombre completo 
(por ejemplo, LIKE 'The Walking%'), lo que permite que el índice mejore mucho el rendimiento. Antes de crear el índice, 
EXPLAIN mostraba que la consulta realizaba un recorrido completo de la tabla (type: ALL, key: NULL, rows: 6, filtered: 16.67), 
lo cual es ineficiente porque se examinan todas las filas y solo una pequeña parte es relevante. Luego de agregar el índice, 
EXPLAIN cambió a type: range, key: idx_title, rows: 1, filtered: 100.00, lo que indica que sólo se leen las filas candidatas y 
el filtro es mucho más eficiente. El criterio principal para elegir los campos a indexar se basa en su uso frecuente en las consultas y 
en que los patrones de búsqueda permitan que el índice sea efectivo, como ocurre cuando se busca por prefijo en una columna con alta selectividad.
*/


