package mizurin.shieldmod;

import net.minecraft.core.item.ItemStack;

import java.awt.*;

public interface IColoredArmor {
	ColoredArmorTexture[] getArmorTextures(ItemStack stack);
}
