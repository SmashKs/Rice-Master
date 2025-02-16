package taiwan.no.one.ricemaster.impl.sake.data.provider

import kotlinx.datetime.Instant
import taiwan.no.one.ricemaster.impl.sake.data.model.AromaProfileModel
import taiwan.no.one.ricemaster.impl.sake.data.model.AwardModel
import taiwan.no.one.ricemaster.impl.sake.data.model.BreweryModel
import taiwan.no.one.ricemaster.impl.sake.data.model.FlavorProfileModel
import taiwan.no.one.ricemaster.impl.sake.data.model.ImageModel
import taiwan.no.one.ricemaster.impl.sake.data.model.SakeModel
import taiwan.no.one.ricemaster.impl.sake.data.model.SpeciallyDesignatedSakeModel

internal object ProvideFakeData {
    // Create fake data for the models
    val breweries = listOf(
        BreweryModel(
            id = 1,
            name = "Brewery A",
            location = "Location A",
            description = "A fine brewery.",
            website = "http://example.com/a",
        ),
        BreweryModel(
            id = 2,
            name = "Brewery B",
            location = "Location B",
            description = "An excellent brewery.",
            website = "http://example.com/b",
        ),
        BreweryModel(
            id = 3,
            name = "Brewery C",
            location = "Location C",
            description = "A unique brewery.",
            website = "http://example.com/c",
        ),
    )

    val speciallyDesignatedSakes = listOf(
        SpeciallyDesignatedSakeModel(id = 1, name = "Junmai", description = "Pure rice sake."),
        SpeciallyDesignatedSakeModel(id = 2, name = "Ginjo", description = "Premium sake with a fruity aroma."),
        SpeciallyDesignatedSakeModel(id = 3, name = "Daiginjo", description = "Super premium grade sake."),
    )

    val images = listOf(
        ImageModel(id = 1, imageUrl = "http://example.com/image1.jpg", description = "Image of Sake A."),
        ImageModel(id = 2, imageUrl = "http://example.com/image2.jpg", description = "Image of Sake B."),
        ImageModel(id = 3, imageUrl = "http://example.com/image3.jpg", description = "Image of Sake C."),
        ImageModel(id = 4, imageUrl = "http://example.com/image4.jpg", description = "Image of Sake D."),
    )

    val flavorProfiles = listOf(
        FlavorProfileModel(id = 1, name = "Fruity", description = "Fruity notes of apple and pear."),
        FlavorProfileModel(id = 2, name = "Floral", description = "Floral notes like cherry blossoms."),
        FlavorProfileModel(id = 3, name = "Nutty", description = "Rich nutty flavors."),
        FlavorProfileModel(id = 4, name = "Spicy", description = "Hints of spice and warmth."),
    )

    val aromaProfiles = listOf(
        AromaProfileModel(id = 1, name = "Earthy", description = "Earthy notes reminiscent of the soil."),
        AromaProfileModel(id = 2, name = "Spicy", description = "Spicy notes that add depth."),
        AromaProfileModel(id = 3, name = "Floral", description = "A subtle floral aroma."),
        AromaProfileModel(id = 4, name = "Fruity", description = "A vibrant fruity bouquet."),
    )

    val awards = listOf(
        AwardModel(id = 1, awardName = "Gold Medal", year = 2021),
        AwardModel(id = 2, awardName = "Best Sake", year = 2022),
        AwardModel(id = 3, awardName = "People's Choice", year = 2023),
    )

    // Create list of SakeModels with their relationships
    val sakes = listOf(
        SakeModel(
            id = 1,
            name = "Sake A",
            abv = 15.0f,
            polishingRatio = 60.0f,
            brewDate = Instant.parse("2021-01-01T00:00:00Z"),
            expirationDate = Instant.parse("2023-12-31T00:00:00Z"),
            priceRange = "20-30 USD",
            imageUrl = images[0].imageUrl,
            description = "A fruity and refreshing sake.",
//            imageIds = listOf(images[0].id), // You can only have one image per this implementation
            speciallyDesignatedId = speciallyDesignatedSakes[0].id,
            breweryId = breweries[0].id,
//            flavorIds = listOf(flavorProfiles[0].id),
//            aromaProfileIds = listOf(aromaProfiles[0].id),
//            awardIds = listOf(awards[0].id),
        ),
        SakeModel(
            id = 2,
            name = "Sake B",
            abv = 16.0f,
            polishingRatio = 55.0f,
            brewDate = Instant.parse("2022-02-01T00:00:00Z"),
            expirationDate = Instant.parse("2024-02-01T00:00:00Z"),
            priceRange = "25-35 USD",
            imageUrl = images[1].imageUrl,
            description = "A sophisticated and elegant sake.",
//            imageIds = listOf(images[1].id),
            speciallyDesignatedId = speciallyDesignatedSakes[1].id,
            breweryId = breweries[1].id,
//            flavorIds = listOf(flavorProfiles[1].id),
//            aromaProfileIds = listOf(aromaProfiles[1].id),
//            awardIds = listOf(awards[1].id, awards[2].id),
        ),
        SakeModel(
            id = 3,
            name = "Sake C",
            abv = 14.5f,
            polishingRatio = 50.0f,
            brewDate = Instant.parse("2023-03-01T00:00:00Z"),
            expirationDate = Instant.parse("2025-03-01T00:00:00Z"),
            priceRange = "30-40 USD",
            imageUrl = images[2].imageUrl,
            description = "A rich and complex sake.",
//            imageIds = listOf(images[2].id),
            speciallyDesignatedId = speciallyDesignatedSakes[2].id,
            breweryId = breweries[2].id,
//            flavorIds = listOf(flavorProfiles[2].id, flavorProfiles[3].id),
//            aromaProfileIds = listOf(aromaProfiles[2].id),
//            awardIds = listOf(awards[1].id),
        ),
        SakeModel(
            id = 4,
            name = "Sake D",
            abv = 15.5f,
            polishingRatio = 65.0f,
            brewDate = Instant.parse("2022-07-01T00:00:00Z"),
            expirationDate = Instant.parse("2024-07-01T00:00:00Z"),
            priceRange = "18-28 USD",
            imageUrl = images[3].imageUrl,
            description = "A versatile sake with depth.",
//            imageIds = listOf(images[3].id),
            speciallyDesignatedId = speciallyDesignatedSakes[0].id,
            breweryId = breweries[0].id,
//            flavorIds = listOf(flavorProfiles[0].id, flavorProfiles[3].id),
//            aromaProfileIds = listOf(aromaProfiles[0].id, aromaProfiles[1].id),
//            awardIds = listOf(awards[2].id),
        ),
    )
}
