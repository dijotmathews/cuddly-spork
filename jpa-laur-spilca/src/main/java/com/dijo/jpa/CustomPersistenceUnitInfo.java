package com.dijo.jpa;

import jakarta.persistence.PersistenceUnitTransactionType; // API enum (preferred going forward)
import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;

import javax.sql.DataSource;
import java.net.URL;
import java.util.*;

public class CustomPersistenceUnitInfo implements PersistenceUnitInfo {

    private final String puName = "my-persistence-unit";
    private final ClassLoader classLoader;
    private final URL rootUrl;                    // classes root (e.g., target/classes)
    private final List<String> managed = new ArrayList<>();
    private final List<URL> jarUrls = new ArrayList<>();
    private final Properties props = new Properties();

    // hold API enum internally; convert to SPI in getter for JPA 3.2 compat
    private PersistenceUnitTransactionType apiTxType = PersistenceUnitTransactionType.RESOURCE_LOCAL;

    public CustomPersistenceUnitInfo(URL persistenceUnitRootUrl) {
        this(persistenceUnitRootUrl, Thread.currentThread().getContextClassLoader());
    }

    public CustomPersistenceUnitInfo(URL persistenceUnitRootUrl, ClassLoader cl) {
        this.rootUrl = persistenceUnitRootUrl;
        this.classLoader = (cl != null) ? cl : CustomPersistenceUnitInfo.class.getClassLoader();

        // === Equivalent to <class>com.dijo.entities.Product</class> ===
        managed.add(com.dijo.entities.Product.class.getName());
        managed.add(com.dijo.entities.Vehicle.class.getName());
        managed.add(com.dijo.entities.VehicleDetails.class.getName());
        managed.add(com.dijo.entities.Biller.class.getName());
        managed.add(com.dijo.entities.User.class.getName());
        managed.add(com.dijo.entities.Group.class.getName());

        // === Properties from your persistence.xml ===
        // JDBC
        props.put("jakarta.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/postgres");
        props.put("jakarta.persistence.jdbc.user", "postgres");
        props.put("jakarta.persistence.jdbc.password", "password");
        props.put("jakarta.persistence.jdbc.driver", "org.postgresql.Driver");

        // Provider
        props.put("jakarta.persistence.provider", "org.hibernate.jpa.HibernatePersistenceProvider");

        // HikariCP (ensure HikariCP jar is on classpath)
//        props.put("hibernate.hikari.maximumPoolSize", "10");
//        props.put("hibernate.hikari.minimumIdle", "2");
//        props.put("hibernate.hikari.idleTimeout", "600000");
//        props.put("hibernate.hikari.connectionTimeout", "30000");
//        props.put("hibernate.hikari.poolName", "MyHikariPool");

        // Hibernate behavior
        props.put("hibernate.hbm2ddl.auto", "create");
        props.put("hibernate.show_sql", "true");
//        props.put("hibernate.format_sql", "true");
    }

    /* ---------- optional helpers ---------- */
    public CustomPersistenceUnitInfo addManagedClass(Class<?> entity) {
        managed.add(entity.getName());
        return this;
    }
    public CustomPersistenceUnitInfo addJar(URL jarUrl) {
        jarUrls.add(jarUrl);
        return this;
    }
    public Properties getProps() { return props; }
    public void setTransactionType(PersistenceUnitTransactionType apiTx) { this.apiTxType = apiTx; }

    /* ---------- PersistenceUnitInfo contract ---------- */

    @Override public String getPersistenceUnitName() { return puName; }
    @Override public String getPersistenceProviderClassName() { return "org.hibernate.jpa.HibernatePersistenceProvider"; }

    @SuppressWarnings("removal") // SPI enum is deprecated-for-removal in JPA 3.2
    @Override
    public jakarta.persistence.spi.PersistenceUnitTransactionType getTransactionType() {
        // Convert API enum -> SPI enum for current signature
        return jakarta.persistence.spi.PersistenceUnitTransactionType.valueOf(apiTxType.name());
    }

    @Override public DataSource getJtaDataSource() { return null; }
    @Override public DataSource getNonJtaDataSource() { return null; }

    @Override public List<String> getMappingFileNames() { return Collections.emptyList(); }
    @Override public List<URL> getJarFileUrls() { return Collections.unmodifiableList(jarUrls); }
    @Override public URL getPersistenceUnitRootUrl() { return rootUrl; }

    @Override public List<String> getManagedClassNames() { return Collections.unmodifiableList(managed); }

    // We’re listing classes explicitly, so exclude others
    @Override public boolean excludeUnlistedClasses() { return true; }

    @Override public SharedCacheMode getSharedCacheMode() { return SharedCacheMode.UNSPECIFIED; }
    @Override public ValidationMode getValidationMode() { return ValidationMode.AUTO; }
    @Override public Properties getProperties() { return props; }
    @Override public String getPersistenceXMLSchemaVersion() { return "3.0"; }

    @Override public ClassLoader getClassLoader() { return classLoader; }
    @Override public void addTransformer(ClassTransformer transformer) { }
    @Override public ClassLoader getNewTempClassLoader() { return classLoader; }

    /* ---------- New in JPA 3.2 (for CDI integration) ---------- */
    @Override public String getScopeAnnotationName() { return null; }      // not using CDI scopes

    @Override
    public List<String> getQualifierAnnotationNames() {
        return List.of();
    }

}
