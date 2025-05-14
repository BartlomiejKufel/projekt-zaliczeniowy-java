module com.crowdle {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires org.postgresql.jdbc;
    requires java.sql;



    opens com.crowdle to javafx.fxml;
    exports com.crowdle;

    exports com.crowdle.model to org.hibernate.orm.core;

    opens com.crowdle.model to org.hibernate.orm.core;

    uses org.hibernate.Session;
}