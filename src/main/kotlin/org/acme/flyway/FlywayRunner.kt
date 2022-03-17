package org.acme.flyway

import io.quarkus.runtime.StartupEvent
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.flywaydb.core.Flyway
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes

// https://stackoverflow.com/questions/66268122/reactive-hibernate-on-quarkus-with-flyway

@ApplicationScoped
class FlywayRunner {

    @ConfigProperty(name = "quarkus.datasource.password")
    lateinit var datasourcePassword: String

    @ConfigProperty(name = "quarkus.datasource.reactive.url")
    lateinit var datasourceUrl: String

    @ConfigProperty(name = "quarkus.datasource.username")
    lateinit var datasourceUsername: String

    fun runFlywayMigration(@Observes event: StartupEvent) {
        val flyway = Flyway
            .configure()
            .dataSource("jdbc:$datasourceUrl", datasourceUsername, datasourcePassword)
            .validateOnMigrate(true)
            .load()
        flyway.migrate()
    }
}
