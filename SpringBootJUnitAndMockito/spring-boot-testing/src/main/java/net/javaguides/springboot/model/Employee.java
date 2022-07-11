package net.javaguides.springboot.model;

import lombok.*;

import javax.persistence.*;

@Setter //folosim @Setter pentru a crea metode setter pentru variabilele noastre
@Getter //folosim @Getter pentru a crea metode getter pentru variabilele noastre
@AllArgsConstructor
//folosim @AllArgsConstructor pentru a genera un constructor cu argumente pentru clasa noastra Employee
@NoArgsConstructor //folosim @NoArgsConstructor pentru a genera un constructor default pentru clasa noastra Employee
@Builder //folosim @Builder pentru a crea un obiect de tip Employee. Util pentru crearea unui Builder pattern

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //furnizeaza functionalitatea auto-increment
    private long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false) //daca nu specificam numele tabelului, acesta este by default numele variabilei
    private String email;
}
