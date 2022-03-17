package org.acme.resource

import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional
import io.smallrye.mutiny.Uni
import org.acme.dao.TaggedMessageDao
import java.util.UUID
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/reproducer")
class ReproducerResource(
    private val taggedMessageDao: TaggedMessageDao
) {

    @POST
    @ReactiveTransactional
    fun post(): Uni<Void> {
        return taggedMessageDao.delete(
            listOf(
                UUID.fromString("d2adad11-d5ee-4ce0-82f4-2449ec92bf07"),
                UUID.fromString("f9457bc4-b78a-4a8d-8b7f-ebe7f0e8b719"),
            ),
            UUID.fromString("d0149697-69a2-4ca5-8f04-c894ee18472c")
        )
    }
}