package taiwan.no.one.ricemaster.impl.sake.data.provider

val fakeDataJson = """
    {
      "breweries": [
        {
          "breweryId": 1,
          "name": "Brewery A",
          "location": "Location A",
          "description": "A fine brewery.",
          "website": "http://example.com/a"
        },
        {
          "breweryId": 2,
          "name": "Brewery B",
          "location": "Location B",
          "description": "An excellent brewery.",
          "website": "http://example.com/b"
        },
        {
          "breweryId": 3,
          "name": "Brewery C",
          "location": "Location C",
          "description": "A unique brewery.",
          "website": "http://example.com/c"
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
          "name": "Ginjo",
          "description": "Premium sake with a fruity aroma."
        },
        {
          "speciallyDesignatedSakeId": 3,
          "name": "Daiginjo",
          "description": "Super premium grade sake."
        }
      ],
      "flavorProfiles": [
        {
          "flavorProfileId": 1,
          "name": "Fruity",
          "description": "Fruity notes of apple and pear."
        },
        {
          "flavorProfileId": 2,
          "name": "Floral",
          "description": "Floral notes like cherry blossoms."
        },
        {
          "flavorProfileId": 3,
          "name": "Nutty",
          "description": "Rich nutty flavors."
        },
        {
          "flavorProfileId": 4,
          "name": "Spicy",
          "description": "Hints of spice and warmth."
        }
      ],
      "aromaProfiles": [
        {
          "aromaProfileId": 1,
          "name": "Earthy",
          "description": "Earthy notes reminiscent of the soil."
        },
        {
          "aromaProfileId": 2,
          "name": "Spicy",
          "description": "Spicy notes that add depth."
        },
        {
          "aromaProfileId": 3,
          "name": "Floral",
          "description": "A subtle floral aroma."
        },
        {
          "aromaProfileId": 4,
          "name": "Fruity",
          "description": "A vibrant fruity bouquet."
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
          "brewDate": "2021-01-01T00:00:00Z",
          "expirationDate": "2023-12-31T00:00:00Z",
          "priceRange": "20-30 USD",
          "description": "A fruity and refreshing sake.",
          "speciallyDesignatedId": 1,
          "breweryId": 1,
          "flavorIds": [1,3,4],
          "aromaIds": [1,2],
          "awardIds": [1,2]
        },
        {
          "sakeId": 2,
          "name": "Sake B",
          "abv": 16,
          "polishingRatio": 55,
          "brewDate": "2022-02-01T00:00:00Z",
          "expirationDate": "2024-02-01T00:00:00Z",
          "priceRange": "25-35 USD",
          "description": "A sophisticated and elegant sake.",
          "speciallyDesignatedId": 1,
          "breweryId": 2,
          "flavorIds": [2,3],
          "aromaIds": [3],
          "awardIds": [3]
        },
        {
          "sakeId": 3,
          "name": "Sake C",
          "abv": 14.5,
          "polishingRatio": 50,
          "brewDate": "2023-03-01T00:00:00Z",
          "expirationDate": "2025-03-01T00:00:00Z",
          "priceRange": "30-40 USD",
          "description": "A rich and complex sake.",
          "speciallyDesignatedId": 2,
          "breweryId": 3,
          "flavorIds": [4],
          "aromaIds": [2,1],
          "awardIds": [2,1]
        },
        {
          "sakeId": 4,
          "name": "Sake D",
          "abv": 15.5,
          "polishingRatio": 65,
          "brewDate": "2022-07-01T00:00:00Z",
          "expirationDate": "2024-07-01T00:00:00Z",
          "priceRange": "18-28 USD",
          "description": "A versatile sake with depth.",
          "speciallyDesignatedId": 3,
          "breweryId": 2,
          "flavorIds": [1,3],
          "aromaIds": [3],
          "awardIds": [3]
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
