package com.mycompany.cepa3hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure("classpath:hibernate.cfg.xml")
                    .build();
            Metadata metadata = new MetadataSources(standardRegistry)
                    .getMetadataBuilder()
                    .build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            // Log the exception for detailed information
            System.err.println("Error al inicializar la SessionFactory: " + e);
            throw new ExceptionInInitializerError("Error al inicializar la SessionFactory");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Cerrar el registro de servicios estándar al apagar la aplicación
        StandardServiceRegistryBuilder.destroy(sessionFactory.getSessionFactoryOptions().getServiceRegistry());
    }
}
