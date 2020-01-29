package pl.kulpa.usermanagement.model;


import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Employee.class)
public class Employee_ {
    public static volatile SingularAttribute<Employee, Long> id;
    public static volatile SingularAttribute<Employee, String> name;
    public static volatile SingularAttribute<Employee, String> surname;
    public static volatile SingularAttribute<Employee, Integer> grade;
    public static volatile SingularAttribute<Employee, Integer> salary;
}
