package taiwan.no.one.ricemaster.impl.sake.data.provider

import kotlinx.datetime.Instant
import taiwan.no.one.ricemaster.impl.sake.data.model.AromaProfileModel
import taiwan.no.one.ricemaster.impl.sake.data.model.BreweryModel
import taiwan.no.one.ricemaster.impl.sake.data.model.FlavorProfileModel
import taiwan.no.one.ricemaster.impl.sake.data.model.SakeModel
import taiwan.no.one.ricemaster.impl.sake.data.model.SpeciallyDesignatedSakeModel
import taiwan.no.one.ricemaster.impl.sake.data.model.compose.SakeAromaModel
import taiwan.no.one.ricemaster.impl.sake.data.model.compose.SakeAwardModel
import taiwan.no.one.ricemaster.impl.sake.data.model.compose.SakeFlavorModel
import taiwan.no.one.ricemaster.impl.sake.data.model.compose.SakeImageModel

// Fake Brewery Data
internal val breweries = listOf(
    BreweryModel(
        id = 1,
        name = "Brewery A",
        location = "Hokkaido, Japan",
        description = "Known for its excellent Junmai sake.",
        website = "http://breweryA.com",
    ),
    BreweryModel(
        id = 2,
        name = "Brewery B",
        location = "Niigata, Japan",
        description = "Famous for its premium Daiginjo sake.",
        website = "http://breweryB.com",
    ),
    BreweryModel(
        id = 3,
        name = "Brewery C",
        location = "Osaka, Japan",
        description = "Specializes in flavored Nigori sake.",
        website = "http://breweryC.com",
    ),
)

// Fake Specially Designated Sake Data
internal val designatedSakes = listOf(
    SpeciallyDesignatedSakeModel(
        id = 1,
        name = "Junmai",
        description = "Pure rice sake, brewed without adding distilled alcohol.",
    ),
    SpeciallyDesignatedSakeModel(
        id = 2,
        name = "Ginjo",
        description = "A premium sake made with rice polished to at least 60%.",
    ),
    SpeciallyDesignatedSakeModel(
        id = 3,
        name = "Daiginjo",
        description = "Top-quality sake, polished to at least 50%.",
    ),
)

// Fake Sake Data
internal val sakes = listOf(
    SakeModel(
        id = 1,
        name = "Sake A",
        breweryId = breweries[0].id,
        speciallyDesignatedId = designatedSakes[0].id,
        abv = 15.0f,
        polishingRatio = 3.4f,
        brewDate = Instant.parse("2022-12-01T00:00:00Z"),
        expirationDate = Instant.parse("2023-12-01T00:00:00Z"),
        priceRange = "$30-$40",
        imageUrl = "http://example.com/images/sakeA.png",
        description = "A smooth Junmai sake with fruity notes.",
    ),
    SakeModel(
        id = 2,
        name = "Sake B",
        breweryId = breweries[1].id,
        speciallyDesignatedId = designatedSakes[1].id,
        abv = 16.0f,
        polishingRatio = 4.6f,
        brewDate = Instant.parse("2022-11-15T00:00:00Z"),
        expirationDate = Instant.parse("2023-11-15T00:00:00Z"),
        priceRange = "$50-$60",
        imageUrl = "http://example.com/images/sakeB.png",
        description = "A refreshing Ginjo sake, perfect for spring.",
    ),
    SakeModel(
        id = 3,
        name = "Sake C",
        breweryId = breweries[2].id,
        speciallyDesignatedId = designatedSakes[2].id,
        abv = 14.5f,
        polishingRatio = 2.0f,
        brewDate = Instant.parse("2023-01-10T00:00:00Z"),
        expirationDate = Instant.parse("2024-01-10T00:00:00Z"),
        priceRange = "$25-$35",
        imageUrl = "http://example.com/images/sakeC.png",
        description = "A rich Daiginjo sake that pairs well with sushi.",
    ),
)

// Fake Flavor Profile Data
internal val flavorProfiles = listOf(
    FlavorProfileModel(
        id = 1,
        name = "Fruity",
        description = "Notes of fruits such as melon and peach.",
    ),
    FlavorProfileModel(
        id = 2,
        name = "Floral",
        description = "Delicate flower aromas, often found in premium sakes.",
    ),
    FlavorProfileModel(
        id = 3,
        name = "Earthy",
        description = "A deeper, richer taste often associated with Junmai sakes.",
    ),
)

// Fake Sake Flavor Data
internal val sakeFlavor1 = SakeFlavorModel(
    id = 1,
    sakeId = sakes[0].id,
    flavorId = flavorProfiles[0].id,
)

internal val sakeFlavor2 = SakeFlavorModel(
    id = 2,
    sakeId = sakes[1].id,
    flavorId = flavorProfiles[1].id,
)

internal val sakeFlavor3 = SakeFlavorModel(
    id = 3,
    sakeId = sakes[2].id,
    flavorId = flavorProfiles[2].id,
)

// Fake Aroma Profile Data
internal val aromaProfiles = listOf(
    AromaProfileModel(
        id = 1,
        name = "Spicy",
        description = "Notes of spices like cinnamon or ginger.",
    ),
    AromaProfileModel(
        id = 2,
        name = "Herbal",
        description = "Aromatic herbs that bring freshness to the sake.",
    ),
    AromaProfileModel(
        id = 3,
        name = "Sweet",
        description = "Hints of sweetness that balance the flavor.",
    ),
)

// Fake Sake Aroma Data
internal val sakeAromas = listOf(
    SakeAromaModel(
        id = 1,
        sakeId = sakes[0].id,
        aromaId = aromaProfiles[0].id,
    ),
    SakeAromaModel(
        id = 2,
        sakeId = sakes[1].id,
        aromaId = aromaProfiles[1].id,
    ),
    SakeAromaModel(
        id = 3,
        sakeId = sakes[2].id,
        aromaId = aromaProfiles[2].id,
    ),
)

// Fake Sake Image Data
internal val sakeImages = listOf(
    SakeImageModel(
        id = 1,
        sakeId = sakes[0].id,
        imageUrl = "http://example.com/images/sakeA1.png",
    ),
    SakeImageModel(
        id = 2,
        sakeId = sakes[1].id,
        imageUrl = "http://example.com/images/sakeB1.png",
    ),
    SakeImageModel(
        id = 3,
        sakeId = sakes[2].id,
        imageUrl = "http://example.com/images/sakeC1.png",
    ),
)

// Fake Sake Award Data
internal val sakeAwards = listOf(
    SakeAwardModel(
        id = 1,
        sakeId = sakes[0].id,
        awardName = "Gold Medal - Sake Challenge 2022",
        year = 2022,
    ),
    SakeAwardModel(
        id = 2,
        sakeId = sakes[1].id,
        awardName = "Best Ginjo Sake - Tokyo Sake Festiinternal val 2023",
        year = 2023,
    ),
    SakeAwardModel(
        id = 3,
        sakeId = sakes[2].id,
        awardName = "Silver Medal - International Sake Competition 2022",
        year = 2022,
    ),
)
