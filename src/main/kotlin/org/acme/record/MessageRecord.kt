package org.acme.record

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.PrimaryKeyJoinColumn
import javax.persistence.Table

@Entity
@Table(name = "message")
@PrimaryKeyJoinColumn(name = "id")
class MessageRecord(

    id: UUID,

    @Column(name = "content")
    val content: String,

    workspaceId: UUID,
) : ThreadRecord(id, workspaceId)
