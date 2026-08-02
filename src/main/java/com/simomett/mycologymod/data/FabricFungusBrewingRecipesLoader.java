package com.simomett.mycologymod.data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simomett.mycologymod.Constants;
import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipe;
import com.simomett.mycologymod.recipes.brewing.FungusBrewingRecipeLoader;
import com.simomett.mycologymod.items.potions.FungusIngredient;
import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.fabricmc.fabric.api.resource.v1.reloader.SimpleReloadListener;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;

import java.io.InputStreamReader;
import java.util.Map;
import java.util.logging.Logger;

public class FabricFungusBrewingRecipesLoader extends SimpleReloadListener<JsonElement>
{
    public static final Identifier FABRIC_ID = Identifier.fromNamespaceAndPath(Constants.MOD_ID, "fungi_brewing");
    private static final Gson GSON = new Gson();

    @Override
    protected JsonElement prepare(SharedState state)
    {
        return loadBrewingRecipe(state.resourceManager());
    }

    @Override
    protected void apply(JsonElement prepared, SharedState state) {}

    private JsonElement loadBrewingRecipe(ResourceManager manager)
    {
        final int json_length = ".json".length();
        for(Map.Entry<Identifier, Resource> e : manager.listResources(FABRIC_ID.getPath(), r -> r.getPath().endsWith(".json")).entrySet())
        {
            Identifier id = e.getKey();
            String[] parts = id.getPath().split("/");
            String name = parts[parts.length - 1];
            name = name.substring(0, name.length() - json_length);

            try (var reader = new InputStreamReader(e.getValue().open()))
            {
                JsonObject g = GSON.fromJson(reader, JsonObject.class);
                FungusBrewingRecipeLoader.INSTANCE.loadBrewingRecipe(g);
                return g;
            }
            catch (Exception ignored)
            {
                Logger.getGlobal().severe("Couldn't load brewing recipe "+name);
            }
        }

        this.registerPotionsRecipes();
        return null;
    }

    private void registerPotionsRecipes()
    {
        FabricPotionBrewingBuilder.BUILD.register(builder -> {
            for(FungusBrewingRecipe r : FungusBrewingRecipeLoader.INSTANCE.getQueue())
            {
                builder.registerPotionRecipe(r.getInputPotion(), FungusIngredient.of(r.speciesName), BuiltInRegistries.POTION.wrapAsHolder(r.resultPotion.value()));
            }
        });
    }
}
