package io.github.adamraichu.framedrecoverycompassfix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.CompassAnglePredicateProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

@Mixin(CompassAnglePredicateProvider.class)
public abstract class CompassAnglePredicateProviderMixin {
  @ModifyArgs(method = "Lnet/minecraft/client/item/CompassAnglePredicateProvider;getAngle(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/world/ClientWorld;ILnet/minecraft/entity/Entity;)F", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/item/CompassAnglePredicateProvider$CompassTarget;getPos(Lnet/minecraft/client/world/ClientWorld;Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/math/GlobalPos;"))
  private void inject(Args args) {
    ItemStack item = args.get(1);
    if (!item.getItem().equals(Items.RECOVERY_COMPASS)) {
      return;
    }
    MinecraftClient client = MinecraftClient.getInstance();
    args.set(2, client.player);
  }
}
