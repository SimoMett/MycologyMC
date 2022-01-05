# **TODO list**
- [ ] Get the NBT tags working (maybe with capabilities?)
- [X] Make a data model to be stored in each mushroom (species, temperature, humidity, soil type, effects, ecc...) (Almost done)
- [X] Color the mushrooms based on the NBT/data stored
- [X] Ability to plant mushrooms
- [ ] Implement capabilities for the mushroom blocks
- [ ] Edit mushroom spreading mechanic and implement breeding
- [ ] Add natural generation in the world

###Other notes
- Currently for each fungus type (Crimson and Warped) I need different tile entities containing the same data.
Maybe I can instantiate a single item, Eg:
```COLORED_FUNGUS -> COLORED_CRIMSON_FUNGUS``` and give different textures (using BlockStates)
