package anvilclient.anvilclient.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.Minecraft;

@Mixin(Minecraft.class)
public interface IMixinMinecraft {
	
	@Accessor(value="debugFPS")
	int getFPS();
}
