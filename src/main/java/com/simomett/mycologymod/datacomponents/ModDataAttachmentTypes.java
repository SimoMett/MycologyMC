package com.simomett.mycologymod.datacomponents;

import com.simomett.mycologymod.MycologyMod;
import com.simomett.mycologymod.genetics.FungusGenoma;
import com.simomett.mycologymod.genetics.FungusTraits;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModDataAttachmentTypes
{
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MycologyMod.MODID);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<FungusGenoma>> FUNGUS_GENOMA_ATTACHMENT = ATTACHMENT_TYPES.register("fungus_genoma", () ->
            AttachmentType.builder( () -> new FungusGenoma(FungusTraits.UNINIT, FungusTraits.UNINIT)).serialize(ModDataComponentTypes.FUNGUS_GENOMA_CODEC).build());
}
