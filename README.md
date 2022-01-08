[![Java CI with Gradle](https://github.com/DonSimonetti/MycologyMC/actions/workflows/gradle.yml/badge.svg)](https://github.com/DonSimonetti/MycologyMC/actions/workflows/gradle.yml)

# TODO list
- [ ] Get the NBT tags working (maybe with capabilities?)
- [X] Make a data model to be stored in each mushroom (species, temperature, humidity, soil type, effects, ecc...)
- [ ] Make some species using datapacks (creativity required)
- [ ] Ah yes, datapack support
- [X] Color the mushrooms based on the NBT/data stored
- [X] Ability to plant mushrooms
- [ ] Implement capabilities for the mushroom blocks
- [ ] Edit mushroom spreading mechanic and implement breeding
- [ ] Add natural generation in the world
- [ ] Implement fungus spores' area effect

### Other notes
- ~~Currently for each fungus type (Crimson and Warped) I need different tile entities containing the same data.
Maybe I can instantiate a single item, Eg:
```COLORED_CRIMSON_FUNGUS -> COLORED_FUNGUS```, and give different textures (using BlockStates).~~
Fixed in this [commit](https://github.com/DonSimonetti/MycologyMC/commit/c1f09c75a4cf0db633ca6b8aed460779044bc5ed).

# Mycology
[final readme here]
