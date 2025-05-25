INSERT INTO VEHICULO (id, patente, marca, modelo, anio_fabricacion, cantidad_ruedas) VALUES
                                                                                         (1, 'AAA111', 'Ford', 'Fiesta', 2024, 4),
                                                                                         (2, 'BBB222', 'Toyota', 'Hilux', 2024, 6),
                                                                                         (3, 'CCC333', 'Renault', 'Kangoo', 2023, 4),
                                                                                         (4, 'DDD444', 'Mercedes', 'Sprinter', 2024, 6);

INSERT INTO SINIESTRO (id, fecha, perdida_economica, vehiculo_id) VALUES
                                                                      (1, '2024-05-01', 8000, 1),
                                                                      (2, '2024-05-02', 15000, 2),
                                                                      (3, '2024-05-03', 12000, 2),
                                                                      (4, '2024-05-04', 20000, 4),
                                                                      (5, '2024-05-05', 5000, 3);