package net.dean.jraw.models

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import net.dean.jraw.databind.ExpandedSubredditsDeserializer
import net.dean.jraw.databind.UnixTimeDeserializer
import java.util.*

data class Multireddit(
    /** If the currently logged-in user can edit this multireddit */
    val canEdit: Boolean,

    /** The path this multireddit was copied from, or null if not copied */
    val copiedFrom: String?,

    @JsonDeserialize(using = UnixTimeDeserializer::class)
    @JsonProperty("created_utc")
    override val created: Date,

    /** Markdown-formatted description */
    @JsonProperty("description_md")
    val description: String,

    /** Name displayed to the user */
    val displayName: String,

    /** See [MultiredditPatch.iconName] */
    val iconName: String,

    /**
     * A hex-formatted hex string, like `#CEE3F8`. This color is primarily used when viewing the multireddit on the
     * mobile site.
     */
    val keyColor: String,

    /** An icon, if any */
    val iconUrl: String?,

    /** Name used in the API */
    val name: String,

    /** The full multireddit path in the format of `/user/{username}/m/{multiname}` */
    val path: String,

    /** A list of Subreddits that this multireddit draws from */
    @JsonDeserialize(using = ExpandedSubredditsDeserializer::class)
    val subreddits: List<Subreddit>,

    /** One of `public`, `private`, or `hidden` */
    val visibility: String,

    /** Either 'classic' or 'fresh' */
    val weightingScheme: String
) : RedditObject(KindConstants.MULTIREDDIT), Created
