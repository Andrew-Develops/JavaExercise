package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Pentru a face interfata EmployeeRepository spring data jpa repository trebuie sa extindem interfata JpaRepository.
 * JpaRepository contine 2 parametri: primul este tipul entității(Employee), iar al doilea este tipul variabilei id din entitate(Long).
 * De ce nu avem nevoie de @Repository: Spring Data Jpa model furnizeaza clasa SimpleJpaRepository(care contine deja adnotarea @Repository)
 *      care implementeaza clasa JpaRepository.
 * By default toate metodele din JpaRepository sunt @Transactional, astfel nu trebuie sa adaugam @Transactional in clasa service
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
