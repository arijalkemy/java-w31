INSERT INTO vehicle (license_plate, brand, model, manufacture_year, number_of_wheels)
VALUES
    ('ABC123', 'Toyota', 'Corolla', 2018, 4),
    ('XYZ789', 'Ford', 'Focus', 2020, 4),
    ('MOTO555', 'Honda', 'CBR500R', 2019, 2),
    ('DEF456', 'Chevrolet', 'Malibu', 2021, 4),
    ('GHI789', 'Nissan', 'Sentra', 2022, 4),
    ('JKL012', 'Tesla', 'Model 3', 2023, 4),
    ('MOTO777', 'Yamaha', 'MT-07', 2025, 2),
    ('RST345', 'BMW', 'X5', 2024, 4),
    ('UVW678', 'Audi', 'Q3', 2025, 4),
    ('XYZ999', 'Kawasaki', 'Ninja', 2017, 2),
    ('NOP123', 'Hyundai', 'Tucson', 2025, 4),
    ('QRS456', 'Mazda', 'CX-5', 2020, 4),
    ('TUV789', 'Subaru', 'Impreza', 2019, 4);

INSERT INTO claim (claim_date, economic_loss, vehicle_id)
VALUES
    ('2023-01-15', 1200.50, 1),
    ('2023-03-10', 750.00, 1),
    ('2023-05-20', 5000.00, 2),
    ('2024-02-01', 300.00, 3),
    ('2024-03-11', 15000.00, 3),
    ('2023-06-15', 2000.00, 4),
    ('2023-07-10', 10800.00, 5),
    ('2023-08-20', 1500.00, 6),
    ('2024-01-05', 12500.00, 7),
    ('2024-02-25', 11000.00, 8),
    ('2024-04-01', 25400.00, 9),
    ('2024-05-10', 600.00, 10),
    ('2024-06-15', 1200.00, 11),
    ('2024-07-18', 95600.00, 12),
    ('2024-08-20', 1300.00, 13);
