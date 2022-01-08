# JSON model for new fungi species
Let's analyse red_amanita.json:

- ```"species": "Red Amanita"``` specifies the name to be displayed by the itemstack.
- ```"type": "colored_crimson_fungus"``` specifies the texture template to use.
- ```"colors": [16777164, 16724736, 15921906, 15921906]``` is the color palette for the texture overlays
- ```"spreading": 25``` is the expected frequency of spreading, i.e. when a random tick occurs the probability of spreading is 1/25.
- ```"spreadboost": 1.0``` is a multiplier for the spreading probability. The new probability will be **(1/spreading)spreadboost**.
- ```"light": 15``` is the light level required to spread.
- ```"terrain": "grass"``` specifies the terrain requirement. If left blank then the mushroom can spread only on mycelium.
- ```"humidity": 0.8, "temperature": 0.25``` are respectively the rainfall and temperature of the biome required to spread.
- ```"area": 3``` is the radius in blocks of the effect application. In this example the effect is applied to each entity in a 7x7 area centered in the mushroom.
###### And now the fun part
- ```"uses"``` specifies what you can do with the mushroom item. In this example you can put it in a brewing stand or in a furnace. With the brewing stand you get a **level 1 poison potion**. With the furnace you get one **red mushroom**.
