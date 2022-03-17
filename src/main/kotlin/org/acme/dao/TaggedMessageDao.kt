package org.acme.dao

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase
import io.smallrye.mutiny.Uni
import org.acme.record.TaggedMessageRecord
import java.util.UUID
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TaggedMessageDao : PanacheRepositoryBase<TaggedMessageRecord, UUID> {

    fun delete(ids: List<UUID>, workspaceId: UUID): Uni<Void> {
        return delete(
            "id in ?1 and message.workspaceId = ?2",
            ids,
            workspaceId
        ).replaceWithVoid()
    }
}