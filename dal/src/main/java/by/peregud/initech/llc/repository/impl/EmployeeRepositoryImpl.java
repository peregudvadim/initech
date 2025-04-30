package by.peregud.initech.llc.repository.impl;

import by.peregud.initech.llc.entity.EmployeeEntity;
import by.peregud.initech.llc.repository.AbstractSearchRepository;
import by.peregud.initech.llc.repository.EmployeeRepositoryCustom;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl extends AbstractSearchRepository<EmployeeEntity> implements EmployeeRepositoryCustom {

    private final static String FIRST_NAME = "firstName";
    private final static String LAST_NAME = "lastName";
    private final static String POSITION = "position";
    private final static String DEPARTMENT = "department";
    private final static String PHONE_NUMBER = "phoneNumber";


    @Autowired
    public EmployeeRepositoryImpl(EntityManager entityManager, Class<EmployeeEntity> entityClass) {
        super(entityManager, entityClass);
    }

    @Override
    protected List<String> getSearchableFields() {
        return List.of(FIRST_NAME,LAST_NAME,POSITION,DEPARTMENT,PHONE_NUMBER);
    }

    @Override
    protected String getDefaultSortField() {
        return LAST_NAME;
    }
}

