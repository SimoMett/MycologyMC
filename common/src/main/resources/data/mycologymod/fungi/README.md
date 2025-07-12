# JSON model for new fungi species (Deprecated)
Let's analyse amanita_rubra.json:

- ```"species": "Amanita rubra"``` specifies the name to be displayed by the itemstack.
- ```"type": "colored_crimson_fungus"``` specifies the texture template to use.
- ```"colors": [16777164, 16724736, 15921906, 15921906]``` is the color palette for the texture overlays respectively for stelum, head, details and details2 in ARGB format
- ```"spreading": 25``` is the expected frequency of spreading, i.e. when a random tick occurs the probability of spreading is 1/25.
- ```"spreadboost": 1.0``` is a multiplier for the spreading probability. The new probability will be **(1/spreading)spreadboost**.
- ```"light": 15``` is the light level required to spread.
- ```"terrain": "grass"``` specifies the terrain requirement. If left blank then the mushroom can spread only on mycelium.
- ```"humidity": 0.8, "temperature": 0.25``` are respectively the rainfall and temperature of the biome required to spread.
- ```"area": 3``` is the radius in blocks of the effect application. In this example the ```"effect"``` is applied to each entity in a 7x7 area centered in the mushroom.
