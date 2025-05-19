INSERT INTO tester (name) VALUES ('Juan Perez');
INSERT INTO tester (name) VALUES ('Maria Lopez');
INSERT INTO tester (name) VALUES ('Carlos Gomez');
INSERT INTO tester (name) VALUES ('Ana Martinez');
INSERT INTO tester (name) VALUES ('Luis Fernandez');

INSERT INTO test_case (description, tested, passed, number_of_tries, last_update, tester_id)
VALUES
    ('Prueba inicial del sistema', TRUE, FALSE, 3, '2024-06-01', 1),
    ('Validación de login', TRUE, TRUE, 1, '2024-06-02', 2),
    ('Chequeo de permisos', FALSE, FALSE, 0, '2024-06-01', 3),
    ('Test de respuesta a errores', TRUE, TRUE, 2, '2024-06-03', 4),
    ('Prueba de carga', TRUE, FALSE, 5, '2024-06-04', 5);