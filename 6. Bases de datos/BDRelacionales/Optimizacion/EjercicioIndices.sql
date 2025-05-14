-- Seleccionar la base de datos
USE movies_db;

-- Crear un índice en la columna 'release_date'
CREATE INDEX idx_release_year ON movies(release_date);

-- Verificar creación del índice
SHOW INDEX FROM movies;

-- Los índices aceleran la búsqueda y el filtrado de datos. Por ejemplo, si se realizan consultas
-- frecuentes para obtener películas de una fecha determinada (empleando condiciones sobre el
-- campo release_date), un índice en esta columna puede reducir significativamente el tiempo de respuesta.

-- En este caso, se selecciona la columna release_date, ya que es probable que se utilice habitualmente
-- para consultar películas según su año de lanzamiento.

-- Además, los índices optimizan otras operaciones, como los ordenamientos y los agrupamientos, cuando se utilizan las columnas indexadas.