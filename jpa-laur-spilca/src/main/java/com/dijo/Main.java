package com.dijo;

import com.dijo.entities.*;
import com.dijo.jpa.CustomPersistenceUnitInfo;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.jpa.HibernatePersistenceProvider;


import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        URL root = com.dijo.entities.Product.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation();

        CustomPersistenceUnitInfo pui = new CustomPersistenceUnitInfo(root);

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(pui, pui.getProperties());


//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

        EntityManager em = emf.createEntityManager();
        try {

            em.getTransaction().begin();

            Vehicle v  = new Vehicle();
            v.setCode("HD51");
            v.setName("HD1");
            v.setType("H");
            v.setStatus("active");


            VehicleDetails vd = new VehicleDetails();
            vd.setAddress("Address line 1");
            vd.setContactEmail("head@hd51.io");
            vd.setContactNo("763247324");

            v.setVehicleDetails(vd);
            em.persist(vd);
            System.out.println(v);

            var b1 = new Biller();
            b1.setName("biller1");
            b1.setNpcibillerid("HDSFDF23423");
            b1.setVehicle(v);
            em.persist(b1);

            var b2 = new Biller();
            b2.setName("biller2");
            b2.setNpcibillerid("TYWEWE234");
            b2.setVehicle(v);

            em.persist(b2);
            v.setBillers(Set.of(b1, b2));

            em.persist(v);

            var u1 = new User();
            u1.setUserName("dijo");

            var u2 = new User();
            u2.setUserName("sam");

            var g1 = new Group();
            g1.setGroupName("sudo");

            g1.setUsers(List.of(u1, u2));


            em.persist(u1);
            em.persist(u2);
            em.persist(g1);


            Faker faker = new Faker(new Locale("en-IND"));
            var p = new Product();
            p.setName(faker.name().name());

            em.persist(p);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
