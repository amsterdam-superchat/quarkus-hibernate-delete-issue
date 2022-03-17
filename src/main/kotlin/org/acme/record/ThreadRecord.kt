package org.acme.record

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.Table

@Entity
@Table(name = "thread")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class ThreadRecord(

    @Id
    @Column(name = "id")
    val id: UUID,

    @Column(name = "workspace_id")
    val workspaceId: UUID,
)
