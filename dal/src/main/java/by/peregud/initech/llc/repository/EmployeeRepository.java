package by.peregud.initech.llc.repository;

import by.peregud.initech.llc.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends BaseRepository<EmployeeEntity>,EmployeeRepositoryCustom{


}


