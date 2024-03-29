package by.devpav.serfor.domain

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "realm_configs")
class RealmConfig : BasicEntity {

    @Column(name = "realm_virtual_directory")
    var realmVirtualDirectory: String? = null

    @Column(name = "realm_max_image_length", nullable = false)
    var realmMaxImageLength: Int? = null

    @OneToOne(orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "realm_config_id", referencedColumnName = "id")
    var realm: Realm? = null

    constructor() {}

    constructor(realmVirtualDirectory: String, realmMaxImageLength: Int?) {
        this.realmVirtualDirectory = realmVirtualDirectory
        this.realmMaxImageLength = realmMaxImageLength
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RealmConfig) return false
        if (!super.equals(other)) return false
        val that = other as RealmConfig?
        return realmVirtualDirectory == that!!.realmVirtualDirectory &&
                realmMaxImageLength == that.realmMaxImageLength &&
                realm == that.realm
    }

    override fun hashCode(): Int {
        return Objects.hash(super.hashCode(), realmVirtualDirectory, realmMaxImageLength, realm)
    }

}
