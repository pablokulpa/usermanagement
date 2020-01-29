package pl.kulpa.usermanagement.repository;

import org.springframework.data.jpa.domain.Specification;
import pl.kulpa.usermanagement.model.Employee;
import pl.kulpa.usermanagement.model.Employee_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

public class EmployeeSpecification implements Specification<Employee> {

    private Map<String, Object> search;

    public EmployeeSpecification(Map<String, Object> search) {
        this.search = search;
    }

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<String> searchOption = Arrays.asList(Employee_.id.getName(), Employee_.name.getName(),
                Employee_.surname.getName(), Employee_.grade.getName(), Employee_.salary.getName());

        List<Predicate> predicateList = new LinkedList<>();

        for (String option : searchOption) {

            Optional.ofNullable(search.get(option)).ifPresent(value -> {
                        if (search.get(option) instanceof Integer) {
                            predicateList.add(criteriaBuilder.like(root.get(option).as(String.class), "%" + search.get(option) + "%"));
                        } else {
                            predicateList.add(criteriaBuilder.like(root.get(option), (String) search.get(option)));
                        }
        });}

        return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
    }
}
