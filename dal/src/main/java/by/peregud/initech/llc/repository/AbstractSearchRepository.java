package by.peregud.initech.llc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSearchRepository <T> implements Searchable<T> {

    protected final EntityManager entityManager;
    private final Class<T> entityClass;

    public AbstractSearchRepository(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    protected abstract List<String> getSearchableFields();


    @Override
    public Page<T> searchByData(String data, Pageable pageable) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> root = cq.from(entityClass);

        String pattern = (data == null || data.trim().isEmpty()) ? "%" : "%" + data.toLowerCase() + "%";

        List<Predicate> predicates = new ArrayList<>();
        for (String field : getSearchableFields()) {
            predicates.add(cb.like(cb.lower(root.get(field).as(String.class)), pattern));
        }

        Predicate finalPredicate = cb.or(predicates.toArray(new Predicate[0]));

        cq.select(root)
                .where(finalPredicate)
                .orderBy(cb.asc(root.get(getDefaultSortField())));

        TypedQuery<T> query = entityManager.createQuery(cq);


        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());

        List<T> result = query.getResultList();


        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<T> countRoot = countQuery.from(entityClass);
        countQuery.select(cb.count(countRoot)).where(finalPredicate);
        Long total = entityManager.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(result, pageable, total);
    }

    protected String getDefaultSortField() {
        return "id";
    }
}