package taiwan.no.one.ricemaster.sake.impl.data.provider

import kotlinx.datetime.Instant
import taiwan.no.one.ricemaster.sake.impl.data.model.AromaProfileModel
import taiwan.no.one.ricemaster.sake.impl.data.model.AwardModel
import taiwan.no.one.ricemaster.sake.impl.data.model.BreweryModel
import taiwan.no.one.ricemaster.sake.impl.data.model.FlavorProfileModel
import taiwan.no.one.ricemaster.sake.impl.data.model.ImageModel
import taiwan.no.one.ricemaster.sake.impl.data.model.SakeModel
import taiwan.no.one.ricemaster.sake.impl.data.model.SpeciallyDesignatedSakeModel

internal object ProvideFakeData {
    // Create fake data for the models
    val breweries = listOf(
        BreweryModel(
            breweryId = 1,
            name = "Brewery A",
            location = "Location A",
            description = "A fine brewery.",
            website = "http://example.com/a",
        ),
        BreweryModel(
            breweryId = 2,
            name = "Brewery B",
            location = "Location B",
            description = "An excellent brewery.",
            website = "http://example.com/b",
        ),
        BreweryModel(
            breweryId = 3,
            name = "Brewery C",
            location = "Location C",
            description = "A unique brewery.",
            website = "http://example.com/c",
        ),
    )

    val speciallyDesignatedSakes = listOf(
        SpeciallyDesignatedSakeModel(speciallyDesignatedSakeId = 1, name = "Junmai", description = "Pure rice sake."),
        SpeciallyDesignatedSakeModel(
            speciallyDesignatedSakeId = 2,
            name = "Ginjo",
            description = "Premium sake with a fruity aroma.",
        ),
        SpeciallyDesignatedSakeModel(
            speciallyDesignatedSakeId = 3,
            name = "Daiginjo",
            description = "Super premium grade sake.",
        ),
    )

    val flavorProfiles = listOf(
        FlavorProfileModel(flavorProfileId = 1, name = "Fruity", description = "Fruity notes of apple and pear."),
        FlavorProfileModel(flavorProfileId = 2, name = "Floral", description = "Floral notes like cherry blossoms."),
        FlavorProfileModel(flavorProfileId = 3, name = "Nutty", description = "Rich nutty flavors."),
        FlavorProfileModel(flavorProfileId = 4, name = "Spicy", description = "Hints of spice and warmth."),
    )

    val aromaProfiles = listOf(
        AromaProfileModel(aromaProfileId = 1, name = "Earthy", description = "Earthy notes reminiscent of the soil."),
        AromaProfileModel(aromaProfileId = 2, name = "Spicy", description = "Spicy notes that add depth."),
        AromaProfileModel(aromaProfileId = 3, name = "Floral", description = "A subtle floral aroma."),
        AromaProfileModel(aromaProfileId = 4, name = "Fruity", description = "A vibrant fruity bouquet."),
    )

    val awards = listOf(
        AwardModel(awardId = 1, name = "Gold Medal", year = 2021),
        AwardModel(awardId = 2, name = "Best Sake", year = 2022),
        AwardModel(awardId = 3, name = "People's Choice", year = 2023),
    )

    // Create list of SakeModels with their relationships
    val sakes = listOf(
        SakeModel(
            sakeId = 1,
            name = "Sake A",
            abv = 15.0f,
            polishingRatio = 60.0f,
            brewDate = Instant.parse("2021-01-01T00:00:00Z"),
            expirationDate = Instant.parse("2023-12-31T00:00:00Z"),
            priceRange = "20-30 USD",
            description = "A fruity and refreshing sake.",
            speciallyDesignatedId = speciallyDesignatedSakes[0].speciallyDesignatedSakeId,
            breweryId = breweries[0].breweryId,
            flavorIds = listOf(
                flavorProfiles[0].flavorProfileId,
                flavorProfiles[2].flavorProfileId,
                flavorProfiles[3].flavorProfileId,
            ),
            aromaIds = listOf(
                aromaProfiles[0].aromaProfileId,
                aromaProfiles[1].aromaProfileId,
            ),
            awardIds = listOf(
                awards[0].awardId,
                awards[1].awardId,
            ),
        ),
        SakeModel(
            sakeId = 2,
            name = "Sake B",
            abv = 16.0f,
            polishingRatio = 55.0f,
            brewDate = Instant.parse("2022-02-01T00:00:00Z"),
            expirationDate = Instant.parse("2024-02-01T00:00:00Z"),
            priceRange = "25-35 USD",
            description = "A sophisticated and elegant sake.",
            speciallyDesignatedId = speciallyDesignatedSakes[1].speciallyDesignatedSakeId,
            breweryId = breweries[1].breweryId,
            flavorIds = listOf(
                flavorProfiles[1].flavorProfileId,
                flavorProfiles[2].flavorProfileId,
            ),
            aromaIds = listOf(aromaProfiles[2].aromaProfileId),
            awardIds = listOf(awards[2].awardId),
        ),
        SakeModel(
            sakeId = 3,
            name = "Sake C",
            abv = 14.5f,
            polishingRatio = 50.0f,
            brewDate = Instant.parse("2023-03-01T00:00:00Z"),
            expirationDate = Instant.parse("2025-03-01T00:00:00Z"),
            priceRange = "30-40 USD",
            description = "A rich and complex sake.",
            speciallyDesignatedId = speciallyDesignatedSakes[2].speciallyDesignatedSakeId,
            breweryId = breweries[2].breweryId,
            flavorIds = listOf(flavorProfiles[3].flavorProfileId),
            aromaIds = listOf(
                aromaProfiles[1].aromaProfileId,
                aromaProfiles[0].aromaProfileId,
            ),
            awardIds = listOf(
                awards[1].awardId,
                awards[0].awardId,
            ),
        ),
        SakeModel(
            sakeId = 4,
            name = "Sake D",
            abv = 15.5f,
            polishingRatio = 65.0f,
            brewDate = Instant.parse("2022-07-01T00:00:00Z"),
            expirationDate = Instant.parse("2024-07-01T00:00:00Z"),
            priceRange = "18-28 USD",
            description = "A versatile sake with depth.",
            speciallyDesignatedId = speciallyDesignatedSakes[2].speciallyDesignatedSakeId,
            breweryId = breweries[1].breweryId,
            flavorIds = listOf(
                flavorProfiles[0].flavorProfileId,
                flavorProfiles[2].flavorProfileId,
            ),
            aromaIds = listOf(aromaProfiles[2].aromaProfileId),
            awardIds = listOf(awards[2].awardId),
        ),
    )

    val images = listOf(
        ImageModel(
            imageId = 1,
            imageUrl = "http://example.com/image1.jpg",
            description = "Image of Sake A.",
            sakeId = sakes[0].sakeId,
        ),
        ImageModel(
            imageId = 2,
            imageUrl = "http://example.com/image2.jpg",
            description = "Image of Sake B.",
            sakeId = sakes[0].sakeId,
        ),
        ImageModel(
            imageId = 3,
            imageUrl = "http://example.com/image3.jpg",
            description = "Image of Sake C.",
            sakeId = sakes[2].sakeId,
        ),
        ImageModel(
            imageId = 4,
            imageUrl = "http://example.com/image4.jpg",
            description = "Image of Sake D.",
            sakeId = sakes[3].sakeId,
        ),
    )
}
