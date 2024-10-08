package com.mettsmirnov.mycology.datagen;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mettsmirnov.mycology.MycologyMod;
import com.mettsmirnov.mycology.blocks.ModBlocks;
import com.mettsmirnov.mycology.effects.FungusEffect;
import com.mettsmirnov.mycology.datagen.common.BiomesSpecs;
import com.mettsmirnov.mycology.datagen.common.FungusSpawn;
import com.mettsmirnov.mycology.effects.FungusEffects;
import com.mettsmirnov.mycology.tags.ModBlockTags;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.server.packs.PackType;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jline.utils.Log;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SpeciesBuilder
{
    public static final String CRIMSON_TYPE = ModBlocks.COLORED_CRIMSON_STRING;
    public static final String WARPED_TYPE = ModBlocks.COLORED_WARPED_STRING;

    public SpeciesBuilder(DataGenerator generator, CachedOutput hashCache, List<CompletableFuture<?>> completableFutureList)
    {
        this.generator = generator;
        this.hashCache = hashCache;
        this.completableFutureList = completableFutureList;
    }

    //Traits
    private String speciesName;
    private @NonNull String type;
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
    private final DataGenerator generator;
    private final CachedOutput hashCache;
    private final List<CompletableFuture<?>> completableFutureList;

    //Methods chaining
    public SpeciesBuilder createSpecies(@NonNull String speciesName)
    {

        this.speciesName = speciesName;
        return this;
    }

    private static final int DEFAULT_AREA_RADIUS = 3;
    public SpeciesBuilder createDefaultSpecies(String speciesName)
    {
        this.speciesName = speciesName;
        this.spreading = 25;
        this.spreadBoost = 1.0f;
        this.light = 15;
        this.terrain(ModBlockTags.GRASS);
        this.biomesSpecs = BiomesSpecs.FOREST;
        this.areaEffect = FungusEffects.NO_EFFECT;
        this.areaRadius = DEFAULT_AREA_RADIUS;
        this.spawnInfo = FungusSpawn.NO_SPAWN;
        return this;
    }

    @Deprecated
    public SpeciesBuilder createProtoSpecies(String speciesName)
    {
        return createDefaultSpecies(speciesName)
                .crimsonType()
                .colors4(0, 0, 0, 0);
    }

    public SpeciesBuilder warpedType()
    {
        this.type = WARPED_TYPE;
        return this;
    }

    public SpeciesBuilder crimsonType()
    {
        this.type = CRIMSON_TYPE;
        return this;
    }

    public SpeciesBuilder colors4(int stelum, int head, int details1, int details2)
    {
        this.colors = new Integer[]{stelum, head, details1, details2};
        return this;
    }

    public SpeciesBuilder colors1(int color)
    {
        this.colors = new Integer[]{color, color, color, color};
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
        this.terrain = ForgeRegistries.BLOCKS.getKey(terrainBlock).toString();
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
        Log.error(message);
    }

    public void build()
    {
        //FIXME is there a better way of doing this?
        if(type==null)
            throw new NullPointerException("SpeciesBuilder: 'type' attribute of '"+speciesName+"' is null");
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

        //IMPORTANT TODO: sanitize speciesName string
        JsonObject fungusJson = new JsonObject();
        fungusJson.addProperty("species",speciesName);
        fungusJson.addProperty("type",type);
        JsonArray jsonColors = new JsonArray();
        for(int i = 0; i<4; i++)
            jsonColors.add(colors[i]);
        fungusJson.add("colors", jsonColors);
        fungusJson.addProperty("spreading",spreading);
        fungusJson.addProperty("spreadboost",spreadBoost);
        fungusJson.addProperty("light",light);
        fungusJson.addProperty("terrain",terrain);
        fungusJson.addProperty("humidity",biomesSpecs.humidity);
        fungusJson.addProperty("temperature",biomesSpecs.temperature);
        fungusJson.addProperty("area",areaRadius);
        fungusJson.addProperty("effect",areaEffect.getEffectName());
        if(eatingEffect != null)
            fungusJson.addProperty("eat_effect", eatingEffect);
        JsonObject spawnJson = new JsonObject();
        if(spawnInfo !=null)
        {
            spawnJson.addProperty("biomes", spawnInfo.getBiomes());
            spawnJson.addProperty("chance", spawnInfo.chance);
        }
        fungusJson.add("spawn", spawnJson);
        Path path = this.generator.getPackOutput().getOutputFolder();
        String jsonFileName = speciesName.toLowerCase().replace(' ', '_')+".json";
        Path jsonLocation = path.resolve(String.join("/", PackType.SERVER_DATA.getDirectory(), MycologyMod.MODID, "fungi", jsonFileName));

        this.completableFutureList.add(DataProvider.saveStable(this.hashCache,fungusJson,jsonLocation));

        //reset all variable
        speciesName = null;
        type = null;
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

    public SpeciesBuilder eatingEffect(RegistryObject<MobEffect> mobEffect)
    {
        eatingEffect = mobEffect.getKey().location().toString();
        return this;
    }
}
