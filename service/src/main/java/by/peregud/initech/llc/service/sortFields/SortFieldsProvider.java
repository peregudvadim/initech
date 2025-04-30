package by.peregud.initech.llc.service.sortFields;

public interface SortFieldsProvider {

    // Universal
    String ID = "id";
    String CREATED_AT = "createdAt";

    // User
    String FIRSTNAME = "firstname";
    String LASTNAME = "lastname";
    String USERNAME = "username";
    String EMAIL = "email";
    String ROLE = "role";

    // Transaction
    String PAYMENT_ID = "paymentId";
    String TRANSACTION_DATE = "transactionDate";
    String TRANSACTION_AMOUNT = "transactionAmount";
    String TRANSACTION_STATUS = "transactionStatus";

    // Payment
    String INVOICE_ID = "invoiceId";
    String PAYMENT_DATE = "paymentDate";
    String PAYMENT_AMOUNT = "paymentAmount";
    String PAYMENT_METHOD = "paymentMethod";

    // Invoice
    String INVOICE_NUMBER = "invoiceNumber";
    String CONTRACT_ID = "contractId";
    String INVOICE_DATE = "invoiceDate";
    String AMOUNT = "amount";
    String DUE_DATE = "dueDate";
    String STATUS = "status";

    // Employee
    String FIRST_NAME = "firstName";
    String LAST_NAME = "lastName";
    String POSITION = "position";
    String DEPARTMENT = "department";
    String PHONE_NUMBER = "phoneNumber";
    String DATE_OF_BIRTH = "dateOfBirth";
    String HIRE_DATE = "hireDate";

    // Department
    String DEPARTMENT_NAME = "departmentName";
    String MANAGER_ID = "managerId";

    // Contract
    String CONTRACT_NUMBER = "contractNumber";
    String CLIENT_NAME = "clientName";
    String START_DATE = "startDate";
    String END_DATE = "endDate";
    String TOTAL_AMOUNT = "totalAmount";

    // Client
    String CONTACT_PERSON = "contactPerson";
    String ADDRESS = "address";
    String INDUSTRY = "industry";


}

