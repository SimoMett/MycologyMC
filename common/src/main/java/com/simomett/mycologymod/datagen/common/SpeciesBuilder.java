package com.simomett.mycologymod.datagen.common;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.blocks.BlocksDefinitions;
import com.simomett.mycologymod.effects.FungusEffect;
import com.simomett.mycologymod.effects.FungusEffects;
import com.simomett.mycologymod.tags.ModBlockTags;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.Block;

import java.nio.file.Path;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.simomett.mycologymod.genetics.FungusGenoma.*;

public class SpeciesBuilder
{
    public static final String CRIMSON_TYPE = BlocksDefinitions.COLORED_CRIMSON_STRING;
    public static final String WARPED_TYPE = BlocksDefinitions.COLORED_WARPED_STRING;

    //some spreading default values
    public static final int DEFAULT_SPREADING = 24;
    public static final int VERY_SLOW_SPREADING = 2*DEFAULT_SPREADING;

    public static final float DEFAULT_SPREADBOOST = 1.5f;

    public static final int DEFAULT_AREA_RADIUS = 3;

    public SpeciesBuilder(PackOutput.PathProvider pathProvider, CachedOutput hashCache, List<CompletableFuture<?>> completableFutureList)
    {
        this.pathProvider = pathProvider;
        this.hashCache = hashCache;
        this.completableFutureList = completableFutureList;
    }

    //Traits
    private String speciesName;
    private String type;
    private Integer[] colors;
    private Integer spreading;
    private Float spreadBoost;
    private Integer light;
    private String terrain;
    private BiomesSpecs biomesSpecs;
    private Integer areaRadius;
    private FungusEffect areaEffect;
    private String eatingEffect;
    private FungusSpawn spawnInfo;

    //building attributes
    private final PackOutput.PathProvider pathProvider;
    private final CachedOutput hashCache;
    private final List<CompletableFuture<?>> completableFutureList;

    //Methods chaining
    public SpeciesBuilder createSpecies(String speciesName)
    {
        this.speciesName = speciesName;
        this.areaEffect = FungusEffects.NO_EFFECT;
        this.areaRadius = DEFAULT_AREA_RADIUS;
        return this;
    }

    @Deprecated(forRemoval = true)
    public SpeciesBuilder createDefaultSpecies(String speciesName)
    {
        this.createSpecies(speciesName);
        this.crimsonType(0, 0, 0, 0);
        this.spreading = DEFAULT_SPREADING;
        this.spreadBoost = DEFAULT_SPREADBOOST;
        this.light = 15;
        this.terrain(ModBlockTags.GRASS);
        this.biomesSpecs = BiomesSpecs.FOREST;
        this.areaEffect = FungusEffects.NO_EFFECT;
        this.areaRadius = DEFAULT_AREA_RADIUS;
        this.spawnInfo = FungusSpawn.NO_SPAWN;
        return this;
    }

    public SpeciesBuilder warpedType(int stelum, int head, int details1, int details2)
    {
        this.type = WARPED_TYPE;
        this.colors = new Integer[]{stelum, head, details1, details2};
        return this;
    }

    public SpeciesBuilder crimsonType(int stelum, int head, int details1, int details2)
    {
        this.type = CRIMSON_TYPE;
        this.colors = new Integer[]{stelum, head, details1, details2};
        return this;
    }

    public SpeciesBuilder spreading(int spreading)
    {
        this.spreading = spreading;
        return this;
    }

    public SpeciesBuilder spreadBoost(float spreadBoost)
    {
        this.spreadBoost = spreadBoost;
        return this;
    }

    public SpeciesBuilder light(int light)
    {
        this.light = light;
        return this;
    }

    public SpeciesBuilder terrain(Block terrainBlock)
    {
        this.terrain = BuiltInRegistries.BLOCK.getKey(terrainBlock).toString();
        return this;
    }

    public SpeciesBuilder terrain(TagKey<Block> terrainTag)
    {
        this.terrain = "#"+terrainTag.location();
        return this;
    }

    public SpeciesBuilder biomesSpecs(BiomesSpecs biomesSpecs)
    {
        this.biomesSpecs = biomesSpecs;
        return this;
    }

    public SpeciesBuilder areaRadius(int areaRadius)
    {
        this.areaRadius = areaRadius;
        return this;
    }

    public SpeciesBuilder areaEffect(FungusEffect areaEffect)
    {
        this.areaEffect = areaEffect;
        if(areaEffect.equals(FungusEffects.NO_EFFECT))
            this.areaRadius = DEFAULT_AREA_RADIUS;
        return this;
    }

    public SpeciesBuilder spawnType(FungusSpawn spawnType)
    {
        this.spawnInfo = spawnType;
        return this;
    }

    private static void manageException(String message)
    {
        //throw new NullPointerException(message);
        //Log.error(message);
    }

    private static final int MAX_NAME_LEN = 34;
    public void build()
    {
        if(speciesName.length() > MAX_NAME_LEN)
            speciesName = speciesName.substring(0, MAX_NAME_LEN);
        if(!(speciesName.matches("([a-zA-Z]* ?)*") || speciesName.matches("[A-Z]*_FUNGUS")))
            throw new InvalidParameterException("SpeciesBuilder: invalid species name '"+speciesName+"'");
        //FIXME is there a better way of doing this?
        if(colors==null)
            throw new NullPointerException("SpeciesBuilder: 'colors' attribute of '"+speciesName+"' is null");
        if(spreading==null)
            manageException("SpeciesBuilder: 'spreading' attribute of '"+speciesName+"' is null");
        if(spreadBoost==null)
            manageException("SpeciesBuilder: 'spreadBoost' attribute of '"+speciesName+"' is null");
        if(light==null)
            manageException("SpeciesBuilder: 'light' attribute of '"+speciesName+"' is null");
        if(terrain==null)
            manageException("SpeciesBuilder: 'terrain' attribute of '"+speciesName+"' is null");
        if(biomesSpecs==null)
            manageException("SpeciesBuilder: 'biomesSpecs' attribute of '"+speciesName+"' is null");
        if(areaRadius==null)
            manageException("SpeciesBuilder: 'areaRadius' attribute of '"+speciesName+"' is null");
        if(areaEffect==null)
            manageException("SpeciesBuilder: 'areaEffect' attribute of '"+speciesName+"' is null");

        JsonObject fungusJson = new JsonObject();
        fungusJson.addProperty("species",speciesName);
        fungusJson.addProperty("type",type);
        JsonArray jsonColors = new JsonArray();
        for(int i = 0; i<4; i++)
            jsonColors.add(colors[i]);
        fungusJson.add("colors", jsonColors);
        fungusJson.addProperty(SPREADING, spreading);
        fungusJson.addProperty(SPREAD_BOOST, spreadBoost);
        fungusJson.addProperty(LIGHT, light);
        fungusJson.addProperty(TERRAIN, terrain);
        fungusJson.addProperty(HUMIDITY, biomesSpecs.humidity);
        fungusJson.addProperty(TEMP, biomesSpecs.temperature);
        fungusJson.addProperty(AREA, areaRadius);
        fungusJson.addProperty(EFFECT,areaEffect.getEffectName());
        if(eatingEffect != null)
            fungusJson.addProperty(EATING_EFFECT, eatingEffect);
        JsonObject spawnJson = new JsonObject();
        if(spawnInfo !=null)
        {
            spawnJson.addProperty("biomes", spawnInfo.getBiomes());
            spawnJson.addProperty("chance", spawnInfo.chance);
        }
        fungusJson.add("spawn", spawnJson);
        String jsonFileName = speciesName.toLowerCase().replace(' ', '_')+".json";
        Path jsonLocation = this.pathProvider.json(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, jsonFileName));

        this.completableFutureList.add(DataProvider.saveStable(this.hashCache,fungusJson,jsonLocation));

        //reset all variable
        speciesName = null;
        type = CRIMSON_TYPE;
        colors = null;
        spreading = null;
        spreadBoost = null;
        light = null;
        terrain = null;
        biomesSpecs = null;
        areaRadius = null;
        areaEffect = null;
        eatingEffect = null;
        spawnInfo = null;
    }

    public SpeciesBuilder eatingEffect(Holder<MobEffect> mobEffect)
    {
        eatingEffect = mobEffect.getRegisteredName();
        return this;
    }
}
