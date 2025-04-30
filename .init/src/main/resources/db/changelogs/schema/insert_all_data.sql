INSERT INTO employees (first_name, last_name, position, department, phone_number, email, date_of_birth, hire_date)
VALUES
    ('Ivan', 'Ivanov', 'General Manager', 'Management', '+375291234567', 'ivanov@example.com', '1980-12-01', '2010-01-15'),
    ('Petr', 'Petrov', 'Accountant', 'Finance', '+375291234568', 'petrov@example.com', '1985-07-23', '2015-03-05'),
    ('Mikhail', 'Mikhaylov', 'HR Specialist', 'Human Resources', '+375291234569', 'mikhaylov@example.com', '1990-03-10', '2018-11-01'),
    ('Olga', 'Semenova', 'Marketing Manager', 'Marketing', '+375291234570', 'semenova@example.com', '1988-02-25', '2019-06-14'),
    ('Dmitry', 'Dmitriev', 'Legal Advisor', 'Legal', '+375291234571', 'dmitriev@example.com', '1983-09-18', '2016-07-22'),
    ('Svetlana', 'Sokolova', 'Office Manager', 'Operations', '+375291234572', 'sokolova@example.com', '1992-11-30', '2020-01-10'),
    ('Evgeny', 'Kuznetsov', 'Software Developer', 'IT', '+375291234573', 'kuznetsov@example.com', '1995-05-10', '2022-04-05'),
    ('Natalia', 'Alexandrova', 'Product Manager', 'Product', '+375291234574', 'alexandrova@example.com', '1987-08-14', '2017-09-01'),
    ('Andrey', 'Nikolaev', 'Sales Director', 'Sales', '+375291234575', 'nikolaev@example.com', '1982-04-19', '2014-11-20'),
    ('Tatiana', 'Kozlova', 'Customer Support', 'Customer Service', '+375291234576', 'kozlova@example.com', '1993-10-06', '2021-07-16');


INSERT INTO contracts (contract_number, client_name, start_date, end_date, status, total_amount)
VALUES
    ('CON12345', 'ABC Ltd.', '2023-01-01', '2023-12-31', 'active', 10000.00),
    ('CON12346', 'XYZ Corp.', '2022-05-10', '2023-05-10', 'expired', 15000.00),
    ('CON12347', 'GreenTech', '2023-03-15', '2024-03-15', 'active', 25000.00),
    ('CON12348', 'Vega Enterprises', '2022-08-01', '2023-08-01', 'terminated', 5000.00),
    ('CON12349', 'SolarPower Co.', '2023-07-10', '2024-07-10', 'active', 30000.00),
    ('CON12350', 'TechNow Solutions', '2023-02-05', '2024-02-05', 'active', 20000.00),
    ('CON12351', 'DigitalFuture', '2022-10-15', '2023-10-15', 'expired', 18000.00),
    ('CON12352', 'BuildMasters', '2023-06-01', '2024-06-01', 'active', 22000.00),
    ('CON12353', 'SmartTech', '2022-09-20', '2023-09-20', 'terminated', 12000.00),
    ('CON12354', 'PowerLine', '2023-04-01', '2024-04-01', 'active', 28000.00);

INSERT INTO clients (client_name, contact_person, phone_number, email, address, industry)
VALUES
    ('ABC Ltd.', 'Sergey Ivanov', '+375291234577', 'sergey@abcltd.com', '123 Main Street, Minsk', 'IT Services'),
    ('XYZ Corp.', 'Olga Petrovna', '+375291234578', 'olga@xyzcorp.com', '456 Second Street, Vitebsk', 'Retail'),
    ('GreenTech', 'Alexey Pavlov', '+375291234579', 'alexey@greentech.com', '789 Green Lane, Gomel', 'Renewable Energy'),
    ('Vega Enterprises', 'Dmitry Mikhailov', '+375291234580', 'dmitry@vegaenterprises.com', '101 Vega Avenue, Brest', 'Construction'),
    ('SolarPower Co.', 'Natalia Kuznetsova', '+375291234581', 'natalia@solarpower.com', '202 Solar Street, Mogilev', 'Solar Energy'),
    ('TechNow Solutions', 'Evgeny Vasiliev', '+375291234582', 'evgeny@technowsolutions.com', '303 Tech Road, Grodno', 'Software Development'),
    ('DigitalFuture', 'Tatiana Markova', '+375291234583', 'tatiana@digitalfuture.com', '404 Digital Blvd, Minsk', 'Marketing'),
    ('BuildMasters', 'Andrey Pankov', '+375291234584', 'andrey@buildmasters.com', '505 Build Way, Brest', 'Real Estate'),
    ('SmartTech', 'Yana Soboleva', '+375291234585', 'yana@smarttech.com', '606 Smart Street, Vitebsk', 'Technology'),
    ('PowerLine', 'Kirill Andreev', '+375291234586', 'kirill@powerline.com', '707 Power Road, Gomel', 'Energy');

INSERT INTO invoices (invoice_number, contract_id, invoice_date, amount, due_date, status)
VALUES
    ('INV001', 1, '2023-01-10', 10000.00, '2023-01-30', 'paid'),
    ('INV002', 2, '2022-05-15', 15000.00, '2022-06-15', 'paid'),
    ('INV003', 3, '2023-03-20', 25000.00, '2023-04-10', 'pending'),
    ('INV004', 4, '2022-08-10', 5000.00, '2022-09-01', 'overdue'),
    ('INV005', 5, '2023-07-15', 30000.00, '2023-08-05', 'paid'),
    ('INV006', 6, '2023-02-10', 20000.00, '2023-02-20', 'pending'),
    ('INV007', 7, '2022-11-01', 18000.00, '2022-11-21', 'overdue'),
    ('INV008', 8, '2023-06-10', 22000.00, '2023-06-30', 'paid'),
    ('INV009', 9, '2022-09-25', 12000.00, '2022-10-15', 'paid'),
    ('INV010', 10, '2023-04-05', 28000.00, '2023-04-25', 'pending');

INSERT INTO payments (invoice_id, payment_date, payment_amount, payment_method)
VALUES
    (1, '2023-01-25', 10000.00, 'bank transfer'),
    (2, '2022-06-01', 15000.00, 'credit card'),
    (3, '2023-04-05', 15000.00, 'bank transfer'),
    (4, '2022-09-05', 5000.00, 'cash'),
    (5, '2023-08-01', 30000.00, 'credit card'),
    (6, '2023-02-18', 15000.00, 'bank transfer'),
    (7, '2022-11-10', 10000.00, 'credit card'),
    (8, '2023-06-20', 22000.00, 'bank transfer'),
    (9, '2022-10-10', 12000.00, 'cash'),
    (10, '2023-04-15', 28000.00, 'credit card');

INSERT INTO departments (department_name, manager_id)
VALUES
    ('Management', 1),
    ('Finance', 2),
    ('Human Resources', 3),
    ('Marketing', 4),
    ('Legal', 5),
    ('Operations', 6),
    ('IT', 7),
    ('Product', 8),
    ('Sales', 9),
    ('Customer Service', 10);

INSERT INTO transactions (payment_id, transaction_date, transaction_amount, transaction_status)
VALUES
    (1, '2023-01-25', 10000.00, 'success'),
    (2, '2022-06-01', 15000.00, 'success'),
    (3, '2023-04-05', 15000.00, 'success'),
    (4, '2022-09-05', 5000.00, 'failed'),
    (5, '2023-08-01', 30000.00, 'success'),
    (6, '2023-02-18', 15000.00, 'success'),
    (7, '2022-11-10', 10000.00, 'success'),
    (8, '2023-06-20', 22000.00, 'success'),
    (9, '2022-10-10', 12000.00, 'failed'),
    (10, '2023-04-15', 28000.00, 'success');

INSERT INTO users (username, password, email, firstname, lastname, role)
VALUES
    ('@vadimperegud', '$2a$10$6svccuZSRFOSNTOvZQqS2OrrQlg0zkGuIpON7sEMBGiQONxuexjL2', 'vadim@example.com', 'Vadim', 'Peregud', 'ADMIN'),
    ('@ivanov', '$2a$10$yLJCD3OvQ6FwQwR3zSVuvOKPQ3GcKq3DuRkH9zx.Xpx8NYTDOSd8i', 'ivan@example.com', 'Ivan', 'Ivanov', 'USER');