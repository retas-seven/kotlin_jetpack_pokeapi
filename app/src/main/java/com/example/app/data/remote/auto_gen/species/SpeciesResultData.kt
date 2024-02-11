package com.example.app.data.remote.auto_gen.species


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpeciesResultData(
    @Json(name = "base_happiness")
    val baseHappiness: Int?,
    @Json(name = "capture_rate")
    val captureRate: Int?,
    val color: Color?,
    @Json(name = "egg_groups")
    val eggGroups: List<EggGroup>?,
    @Json(name = "evolution_chain")
    val evolutionChain: EvolutionChain?,
    @Json(name = "evolves_from_species")
    val evolvesFromSpecies: EvolvesFromSpecies?,
    @Json(name = "flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>?,
    @Json(name = "form_descriptions")
    val formDescriptions: List<Any>?,
    @Json(name = "forms_switchable")
    val formsSwitchable: Boolean?,
    @Json(name = "gender_rate")
    val genderRate: Int?,
    val genera: List<Genera>?,
    val generation: Generation?,
    @Json(name = "growth_rate")
    val growthRate: GrowthRate?,
    val habitat: Habitat?,
    @Json(name = "has_gender_differences")
    val hasGenderDifferences: Boolean?,
    @Json(name = "hatch_counter")
    val hatchCounter: Int?,
    val id: Int?,
    @Json(name = "is_baby")
    val isBaby: Boolean?,
    @Json(name = "is_legendary")
    val isLegendary: Boolean?,
    @Json(name = "is_mythical")
    val isMythical: Boolean?,
    val name: String?,
    val names: List<Name>?,
    val order: Int?,
    @Json(name = "pal_park_encounters")
    val palParkEncounters: List<PalParkEncounter>?,
    @Json(name = "pokedex_numbers")
    val pokedexNumbers: List<PokedexNumber>?,
    val shape: Shape?,
    val varieties: List<Variety>?
)