package com.mettsmirnov.mycology.effects.PlayerEffects;

import com.mettsmirnov.mycology.MycologyMod;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import org.jline.utils.Log;

@Mod.EventBusSubscriber(modid = MycologyMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerEffectsEventsHandler
{
    @SubscribeEvent
    public static void onPlayerPickupXP(PlayerXpEvent.PickupXp evt)
    {
        Player player = evt.getEntity();
        if(player.hasEffect(ModEffects.XP_MULTIPLIER.get()))
        {
            float multiplier = 1+0.5f*(player.getEffect(ModEffects.XP_MULTIPLIER.get()).getAmplifier()+1);
            evt.getOrb().value*=(int)multiplier;
        }
    }

    @SubscribeEvent
    public static void onPlayerRightClickEmpty(PlayerInteractEvent.RightClickEmpty evt)
    {
        Player player = evt.getEntity();
        if(evt.getSide()==LogicalSide.SERVER && player.getMainHandItem().isEmpty() && player.hasEffect(ModEffects.TELEPORTING.get()))
        {
            Log.info("right click");
            //BlockHitResult hitResult = getTargetofgun(evt.getLevel(), player, ClipContext.Fluid.ANY, 20);
        }
    }

    public static BlockHitResult getTargetofgun(Level pLevel, Player pPlayer, ClipContext.Fluid pFluidMode, double reach)
    {
        //from https://forums.minecraftforge.net/topic/110972-forge1181-how-to-raycast/
        float f = pPlayer.getXRot();
        float f1 = pPlayer.getYRot();
        Vec3 vec3 = pPlayer.getEyePosition();
        float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        Vec3 vec31 = vec3.add((double)f6 * reach, (double)f5 * reach, (double)f7 * reach);
        return pLevel.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, pFluidMode, pPlayer));
    }
}
