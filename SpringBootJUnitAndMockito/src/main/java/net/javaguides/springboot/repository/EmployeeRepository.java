package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Pentru a face interfata EmployeeRepository spring data jpa repository trebuie sa extindem interfata JpaRepository.
 * JpaRepository contine 2 parametri: primul este tipul entității(Employee), iar al doilea este tipul variabilei id din entitate(Long).
 * De ce nu avem nevoie de @Repository: Spring Data Jpa model furnizeaza clasa SimpleJpaRepository(care contine deja adnotarea @Repository)
 * care implementeaza clasa JpaRepository.
 * By default toate metodele din JpaRepository sunt @Transactional, astfel nu trebuie sa adaugam @Transactional in clasa service
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //asta este o sintaxa care trebuie urmata exact. cu aceasta sintaxa reusim sa query in baza de date
    //find=ce actiune vrem sa facem by=in functie de ce parametri email=numele variabilei din entitatea noastra
    Optional<Employee> findByEmail(String email);

    //nu conteaza ce nume ii dam metodei
    //Employee este numele clasei nu numele tabelului
    //definim un custom quest folosind JPQL(Java Persistence Query Language) cu index params
    @Query("select e from Employee e where e.firstName =?1 and e.lastName =?2")
    Employee findByJPQL(String firstName, String lastName);

    //definim un custom quest folosind JPQL(Java Persistence Query Language) cu named params
    @Query("select e from Employee e where e.firstName =:firstName and e.lastName =:lastName")
    Employee findByJPQLNamedParams(@Param("firstName") String firstName, @Param("lastName") String lastName);

    //definim un custom query folosind Native SQL cu index params
    //folosim value pentru a defini un native query(native query este cel care il folosim direct in MySql database)
    //In JPQL foloseam numele claselor, in native sql folosim numele tabelelor
    @Query(value = "select * from employees e where e.first_name =?1 and e.last_name =?2", nativeQuery = true)
    Employee findByNativeSQL(String firstName, String lastName);

    //definim un custom query folosind Native SQL cu named params
    @Query(value = "select * from employees e where e.first_name =:firstName and e.last_name =:lastName", nativeQuery = true)
    Employee findByNativeSQLNamedParams(@Param("firstName") String firstName, @Param("lastName") String lastName);


}
