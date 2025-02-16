package taiwan.no.one.ricemaster.impl.sake.data.provider

val fakeDataJson = """
    {
  "breweries": [
    {
      "breweryId": 1,
      "name": "Hokusetsu Sake Brewery",
      "location": "Niigata Prefecture",
      "description": "Known for its well-balanced and refined sake, using high-quality rice and pristine water from the region.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 2,
      "name": "Koshino Junmai",
      "location": "Niigata Prefecture",
      "description": "Specializes in Junmai sake, renowned for its fruity and smooth flavors, showcasing the terroir of Niigata.",
      "website": "http://example.com/b"
    },
    {
      "breweryId": 3,
      "name": "Nakanishi Sake Brewery",
      "location": "Niigata Prefecture",
      "description": "A family-run brewery that offers a range of traditional sake with rich flavor profiles.",
      "website": "http://example.com/c"
    },
    {
      "breweryId": 4,
      "name": "Hakutsuru Sake Brewery",
      "location": "Hyōgo Prefecture",
      "description": "One of Japan’s largest breweries, famous for its premium sake and consistency in quality.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 5,
      "name": "Kobe Shushin Gura",
      "location": "Hyōgo Prefecture",
      "description": "Located in Kobe, known for its artisanal sake-making processes and diverse range of products.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 6,
      "name": "Shinobu Sake Brewery",
      "location": "Hyōgo Prefecture",
      "description": "Offers high-quality Junmai sake with a focus on traditional brewing methods.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 7,
      "name": "Kizakura Sake Brewery",
      "location": "Osaka Prefecture",
      "description": "Famous for its light and fruity sake, appealing to a wide audience with refreshing flavors.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 8,
      "name": "Sakamasamune",
      "location": "Osaka Prefecture",
      "description": "Renowned for its smooth and modern sake offerings, balancing traditional techniques with innovation.",
      "website": "http://example.com/b"
    },
    {
      "breweryId": 9,
      "name": "Tamanohikari Brewery",
      "location": "Osaka Prefecture",
      "description": "A respected brewery known for its high-quality sake using carefully selected rice and pure water.",
      "website": "http://example.com/c"
    },
    {
      "breweryId": 10,
      "name": "Ishikawa Sake Brewery",
      "location": "Akita Prefecture",
      "description": "Offers rich, characterful sake that represents the unique flavors of Akita's artisanal brewing.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 11,
      "name": "Kiku Masamune Sake Brewery",
      "location": "Akita Prefecture",
      "description": "Famous for its balanced and harmonious sake, using traditional brewing techniques and local rice.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 12,
      "name": "Shinoda Sake Brewery",
      "location": "Akita Prefecture",
      "description": "A family-owned brewery with a long history, producing a variety of traditional sakes.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 13,
      "name": "Hana-no-mai Sake Brewery",
      "location": "Tokyo",
      "description": "Known for its clean and crisp flavors, reflecting the metropolitan area's vibrant culture.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 14,
      "name": "Saito Sake Brewery",
      "location": "Tokyo",
      "description": "Offers a range of sake with innovative flavors while respecting traditional brewing methods.",
      "website": "http://example.com/b"
    },
    {
      "breweryId": 15,
      "name": "Tachibana Sake Brewery",
      "location": "Tokyo",
      "description": "A small, artisanal brewery that emphasizes quality and craftsmanship in its sake production.",
      "website": "http://example.com/c"
    },
    {
      "breweryId": 16,
      "name": "Tsurunoe Sake Brewery",
      "location": "Fukushima Prefecture",
      "description": "Specializes in Junmai sake with a focus on umami-rich flavors and a smooth finish.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 17,
      "name": "Nukagawa Sake Brewery",
      "location": "Fukushima Prefecture",
      "description": "Known for its modern approach to sake, offering unique flavors and contemporary styles.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 18,
      "name": "Kōrōkan Brewery",
      "location": "Fukushima Prefecture",
      "description": "Respected for its traditional brewing styles and rich, well-rounded sake products.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 19,
      "name": "Gozenshu (Gozen Sake)",
      "location": "Hiroshima Prefecture",
      "description": "An award-winning brewery recognized for its meticulously crafted, aromatic sakes.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 20,
      "name": "Kamoizumi Brewery",
      "location": "Hiroshima Prefecture",
      "description": "Offers a sophisticated range of sake known for its rich flavors and fruity aromas.",
      "website": "http://example.com/b"
    },
    {
      "breweryId": 21,
      "name": "Kamotsuru Sake Brewery",
      "location": "Hiroshima Prefecture",
      "description": "Famous for its well-balanced, flavorful sakes that cater to various preferences.",
      "website": "http://example.com/c"
    },
    {
      "breweryId": 22,
      "name": "Kizakura",
      "location": "Yamagata Prefecture",
      "description": "Known for its light and refreshing sake, Kizakura focuses on local rice and traditional brewing methods.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 23,
      "name": "Dewazakura",
      "location": "Yamagata Prefecture",
      "description": "A prominent brewery with a reputation for fruity and fragrant sakes, often winning awards in competitions.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 24,
      "name": "Tendo Sake Brewery",
      "location": "Yamagata Prefecture",
      "description": "Celebrated for its smooth and complex sakes, reflecting the flavor profiles from the Yamagata region.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 25,
      "name": "Tachibana Sake Brewery",
      "location": "Miyagi Prefecture",
      "description": "Known for a variety of sake styles, highlighting local ingredients and seasonal flavors.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 26,
      "name": "Tsurunoe Brewery",
      "location": "Miyagi Prefecture",
      "description": "Offers a rich and aromatic sake, reflecting the smooth waters of the region.",
      "website": "http://example.com/b"
    },
    {
      "breweryId": 27,
      "name": "Ichinokura Sake Brewery",
      "location": "Miyagi Prefecture",
      "description": "One of the most famous breweries, known for its traditional sake with a harmonious flavor profile.",
      "website": "http://example.com/c"
    },
    {
      "breweryId": 28,
      "name": "Ishizuchi Brewery",
      "location": "Ehime Prefecture",
      "description": "Renowned for its rich, umami-forward sakes crafted from traditional techniques.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 29,
      "name": "Kumasaka Brewery",
      "location": "Ehime Prefecture",
      "description": "Offers a variety of flavorful sakes that reflect the local climate and rice varieties.",
      "website": "http://example.com/a"
    },
    {
      "breweryId": 30,
      "name": "Kitanokuroda Brewery",
      "location": "Ehime Prefecture",
      "description": "Known for its elegant and refined sake, often praised for its intricate flavor profiles.",
      "website": "http://example.com/a"
    }
  ],
  "speciallyDesignatedSakes": [
    {
      "speciallyDesignatedSakeId": 1,
      "name": "Junmai",
      "description": "Pure rice sake."
    },
    {
      "speciallyDesignatedSakeId": 2,
      "name": "Special Junmai",
      "description": "Premium sake with a fruity aroma."
    },
    {
      "speciallyDesignatedSakeId": 3,
      "name": "Junmai Ginjo",
      "description": "Super premium grade sake with rich flavors and a refined, smooth texture."
    },
    {
      "speciallyDesignatedSakeId": 4,
      "name": "Junmai Daiginjo",
      "description": "Top-grade Junmai sake, using highly polished rice for an exquisite flavor."
    },
    {
      "speciallyDesignatedSakeId": 5,
      "name": "Ginjo",
      "description": "Fruity and floral aroma, crafted with rice milled to 60% or less for a delicate taste."
    },
    {
      "speciallyDesignatedSakeId": 6,
      "name": "Daiginjo",
      "description": "Exceptionally refined and aromatic sake, made from rice milled to 50% or less, often complex with layers of flavor."
    },
    {
      "speciallyDesignatedSakeId": 7,
      "name": "Honjozo",
      "description": "Brewed with added distilled alcohol, provides a light, clean and refreshing taste."
    },
    {
      "speciallyDesignatedSakeId": 8,
      "name": "Special Honjozo",
      "description": "Honjozo sake with a special brewing method, resulting in a richer flavor profile and enhanced aroma."
    }
  ],
  "flavorProfiles": [
    {
      "flavorProfileId": 1,
      "name": "Fruity",
      "description": "Characterized by flavors reminiscent of various fruits such as apple, pear, or tropical fruits. This profile often brings a refreshing and vibrant quality to the sake, appealing to those who enjoy sweeter, fruit-forward notes."
    },
    {
      "flavorProfileId": 2,
      "name": "Floral",
      "description": "Offers delicate aromas and flavors reminiscent of flowers, such as cherry blossoms or jasmine. This profile is often found in lighter sakes, contributing to a refined and elegant drinking experience."
    },
    {
      "flavorProfileId": 3,
      "name": "Refreshing",
      "description": "Describes a crisp and clean taste, often associated with well-balanced acidity. This flavor profile leaves the palate feeling invigorated, similar to a cool breeze on a warm day, making it ideal for light, easy-drinking sakes."
    },
    {
      "flavorProfileId": 4,
      "name": "Rich / Full-bodied",
      "description": "Indicates a sake with a deep and complex flavor, often featuring a well-rounded mouthfeel. This profile can include notes of umami or a bolder fruit presence, creating a satisfying and substantial drinking experience."
    },
    {
      "flavorProfileId": 5,
      "name": "Aged / Matured",
      "description": "Refers to the depth and complexity that comes from aged sake, often featuring nuanced flavors developed over time. This character can include earthy, nutty, or even caramel notes, highlighting the evolving nature of the sake's profile through aging."
    }
  ],
  "aromaProfiles": [
    {
      "aromaProfileId": 1,
      "name": "Aromatic / Fragrant",
      "description": "Describes a sake with a strong and pleasant scent that captivates the senses. It can encompass a wide range of aromatic notes, from floral to fruity, often presenting a complex bouquet that entices the drinker before tasting."
    },
    {
      "aromaProfileId": 2,
      "name": "Rich / Full-bodied",
      "description": "Indicates a deep and enveloping aroma that suggests a complex and well-rounded character in the sake. This profile often conveys hints of fruits or natural sweetness, providing a full scent that enhances the overall tasting experience."
    },
    {
      "aromaProfileId": 3,
      "name": "Light and Smooth",
      "description": "Reflects a fresh, clean, and uncomplicated aroma that leaves a soft impression. This profile often suggests a sake that is easy to drink with gentle, pleasant notes, making it approachable and enjoyable without overwhelming the senses."
    },
    {
      "aromaProfileId": 4,
      "name": "Crisp / Refreshing",
      "description": "Signifies a clean and bright aroma that exudes clarity. This profile is often associated with sakes that have high acidity or a refreshing character, making it ideal for warm weather or casual drinking."
    },
    {
      "aromaProfileId": 5,
      "name": "Rich / Depth",
      "description": "Refers to a complex and robust aroma, suggesting a well-rounded and flavorful experience. You may find a variety of notes that give depth, including hints of umami or fuller-bodied characteristics, enriching the overall experience of the sake."
    },
    {
      "aromaProfileId": 6,
      "name": "Aged / Matured",
      "description": "Indicates the aromas developed from the aging process, often leading to earthy, nutty, or complex characteristics. This profile brings mature flavors that suggest richness and depth, showcasing the sake's evolution over time."
    },
    {
      "aromaProfileId": 7,
      "name": "Clean / Clear",
      "description": "Suggests a bright and refreshing aroma that is free from heaviness or muddiness. This profile typically emphasizes purity, often presenting crisp or fruity notes that contribute to an inviting and pleasant aromatic experience."
    }
  ],
  "awards": [
    {
      "awardId": 1,
      "name": "Gold Medal",
      "year": 2021
    },
    {
      "awardId": 2,
      "name": "Best Sake",
      "year": 2022
    },
    {
      "awardId": 3,
      "name": "People's Choice",
      "year": 2023
    }
  ],
  "sakes": [
    {
      "sakeId": 1,
      "name": "Sake A",
      "abv": 15,
      "polishingRatio": 60,
      "priceRange": "20-30 USD",
      "description": "A fruity and refreshing sake.",
      "brewDate": "2021-01-01T00:00:00Z",
      "expirationDate": "2023-12-31T00:00:00Z",
      "speciallyDesignatedId": 1,
      "breweryId": 1,
      "flavorIds": [
        1,
        3,
        4
      ],
      "aromaIds": [
        1,
        2
      ],
      "awardIds": [
        1,
        2
      ]
    },
    {
      "sakeId": 2,
      "name": "Sake B",
      "abv": 16,
      "polishingRatio": 55,
      "priceRange": "25-35 USD",
      "description": "A sophisticated and elegant sake.",
      "brewDate": "2022-02-01T00:00:00Z",
      "expirationDate": "2024-02-01T00:00:00Z",
      "speciallyDesignatedId": 1,
      "breweryId": 2,
      "flavorIds": [
        2,
        3
      ],
      "aromaIds": [
        3
      ],
      "awardIds": [
        3
      ]
    },
    {
      "sakeId": 3,
      "name": "Sake C",
      "abv": 14.5,
      "polishingRatio": 50,
      "priceRange": "30-40 USD",
      "description": "A rich and complex sake.",
      "brewDate": "2023-03-01T00:00:00Z",
      "expirationDate": "2025-03-01T00:00:00Z",
      "speciallyDesignatedId": 2,
      "breweryId": 3,
      "flavorIds": [
        4
      ],
      "aromaIds": [
        2,
        1
      ],
      "awardIds": [
        2,
        1
      ]
    },
    {
      "sakeId": 4,
      "name": "Sake D",
      "abv": 15.5,
      "polishingRatio": 65,
      "priceRange": "18-28 USD",
      "description": "A versatile sake with depth.",
      "brewDate": "2022-07-01T00:00:00Z",
      "expirationDate": "2024-07-01T00:00:00Z",
      "speciallyDesignatedId": 3,
      "breweryId": 2,
      "flavorIds": [
        1,
        3
      ],
      "aromaIds": [
        3
      ],
      "awardIds": [
        3
      ]
    }
  ],
  "images": [
    {
      "imageId": 1,
      "imageUrl": "http://example.com/image1.jpg",
      "description": "Image of Sake A.",
      "sakeId": 1
    },
    {
      "imageId": 2,
      "imageUrl": "http://example.com/image2.jpg",
      "description": "Image of Sake B.",
      "sakeId": 1
    },
    {
      "imageId": 3,
      "imageUrl": "http://example.com/image3.jpg",
      "description": "Image of Sake C.",
      "sakeId": 3
    },
    {
      "imageId": 4,
      "imageUrl": "http://example.com/image4.jpg",
      "description": "Image of Sake D.",
      "sakeId": 4
    }
  ]
}
""".trimIndent()
