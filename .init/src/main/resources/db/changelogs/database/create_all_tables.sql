-- Таблица employees
CREATE TABLE employees (
                           id SERIAL PRIMARY KEY,
                           first_name VARCHAR(50) NOT NULL,
                           last_name VARCHAR(50) NOT NULL,
                           position VARCHAR(100) NOT NULL,
                           department VARCHAR(100),
                           phone_number VARCHAR(15),
                           email VARCHAR(100),
                           date_of_birth DATE,
                           hire_date DATE,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблица contracts
CREATE TABLE contracts (
                           id SERIAL PRIMARY KEY,
                           contract_number VARCHAR(50) NOT NULL,
                           client_name VARCHAR(100) NOT NULL,
                           start_date DATE NOT NULL,
                           end_date DATE NOT NULL,
                           status VARCHAR(50) NOT NULL,
                           total_amount DECIMAL(10, 2) NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблица clients
CREATE TABLE clients (
                         id SERIAL PRIMARY KEY,
                         client_name VARCHAR(100) NOT NULL,
                         contact_person VARCHAR(100),
                         phone_number VARCHAR(15),
                         email VARCHAR(100),
                         address VARCHAR(255),
                         industry VARCHAR(100),
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблица invoices
CREATE TABLE invoices (
                          id SERIAL PRIMARY KEY,
                          invoice_number VARCHAR(50) NOT NULL,
                          contract_id INTEGER NOT NULL,
                          invoice_date DATE NOT NULL,
                          amount DECIMAL(10, 2) NOT NULL,
                          due_date DATE NOT NULL,
                          status VARCHAR(50) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT fk_invoice_contract FOREIGN KEY (contract_id) REFERENCES contracts(id) ON DELETE CASCADE
);

-- Таблица payments
CREATE TABLE payments (
                          id SERIAL PRIMARY KEY,
                          invoice_id INTEGER NOT NULL,
                          payment_date DATE NOT NULL,
                          payment_amount DECIMAL(10, 2) NOT NULL,
                          payment_method VARCHAR(50),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT fk_payment_invoice FOREIGN KEY (invoice_id) REFERENCES invoices(id) ON DELETE CASCADE
);

-- Таблица departments
CREATE TABLE departments (
                             id SERIAL PRIMARY KEY,
                             department_name VARCHAR(100) NOT NULL,
                             manager_id INTEGER NOT NULL,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             CONSTRAINT fk_department_manager FOREIGN KEY (manager_id) REFERENCES employees(id) ON DELETE CASCADE
);

-- Таблица transactions
CREATE TABLE transactions (
                              id SERIAL PRIMARY KEY,
                              payment_id INTEGER NOT NULL,
                              transaction_date DATE NOT NULL,
                              transaction_amount DECIMAL(10, 2) NOT NULL,
                              transaction_status VARCHAR(50) NOT NULL,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              CONSTRAINT fk_transaction_payment FOREIGN KEY (payment_id) REFERENCES payments(id) ON DELETE CASCADE
);

CREATE TABLE users
(
    id        SERIAL PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname  VARCHAR(255) NOT NULL,
    email     VARCHAR(255) NOT NULL UNIQUE,
    username  VARCHAR(255) NOT NULL UNIQUE,
    password  VARCHAR(255) NOT NULL,
    role      VARCHAR(255) NOT NULL
);
