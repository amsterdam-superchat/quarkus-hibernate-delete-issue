package org.acme.record

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "tagged_message")
class TaggedMessageRecord(

    @Id
    @Column(name = "id")
    val id: UUID,

    @ManyToOne
    @JoinColumn(name = "message_id")
    val message: MessageRecord,
)
