package turniplabs.shieldmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.LookupFuelFurnace;
import net.minecraft.core.data.DataLoader;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.tag.ItemTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.RecipeEntrypoint;
import turniplabs.shieldmod.item.ShieldItem;
import turniplabs.halplibe.helper.*;
import net.minecraft.core.item.*;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.shieldmod.item.ShieldMaterials;

public class ShieldMod implements ModInitializer, RecipeEntrypoint {
    public static final String MOD_ID = "shield_mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Item woodenShield = ItemHelper.createItem(MOD_ID, new ShieldItem("wooden.shield", 17000, ShieldMaterials.TOOL_WOOD),"wooden_shield.png").withTags(ItemTags.preventCreativeMining);
	public static final Item stoneShield = ItemHelper.createItem(MOD_ID, new ShieldItem("stone.shield", 17001, ShieldMaterials.TOOL_STONE), "stone_shield.png").withTags(ItemTags.preventCreativeMining);
	public static final Item ironShield = ItemHelper.createItem(MOD_ID, new ShieldItem("iron.shield", 17002, ShieldMaterials.TOOL_IRON), "iron_shield.png").withTags(ItemTags.preventCreativeMining);
	public static final Item goldShield = ItemHelper.createItem(MOD_ID, new ShieldItem("gold.shield", 17003, ShieldMaterials.TOOL_GOLD), "gold_shield.png").withTags(ItemTags.preventCreativeMining);
	public static final Item diamondShield = ItemHelper.createItem(MOD_ID, new ShieldItem("diamond.shield", 17004, ShieldMaterials.TOOL_DIAMOND), "diamond_shield.png").withTags(ItemTags.preventCreativeMining);

	public static final Item steelShield = ItemHelper.createItem(MOD_ID, new ShieldItem("steel.shield", 17005, ShieldMaterials.TOOL_STEEL), "steel_shield.png").withTags(ItemTags.preventCreativeMining);




    @Override
    public void onInitialize() {
        LOGGER.info("Shield mod loaded");
		LookupFuelFurnace.instance.addFuelEntry(ShieldMod.woodenShield.id, 600);
    }
	@Override
	public void onRecipesReady() {
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" P ","PLP"," P ")
			.addInput('P', "minecraft:planks")
			.addInput('L',"minecraft:logs")
			.create("woodenShield", woodenShield.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" P ","PLP"," P ")
			.addInput('P', Block.cobbleStone)
			.addInput('L',"minecraft:planks")
			.create("stoneShield", stoneShield.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" P ","PLP"," P ")
			.addInput('P', Item.ingotIron)
			.addInput('L',"minecraft:planks")
			.create("ironShield", ironShield.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" P ","PLP"," P ")
			.addInput('P', Item.ingotGold)
			.addInput('L',"minecraft:planks")
			.create("goldShield", goldShield.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" P ","PLP"," P ")
			.addInput('P', Item.diamond)
			.addInput('L',"minecraft:planks")
			.create("diamondShield", diamondShield.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" P ","PLP"," P ")
			.addInput('P', Item.ingotSteel)
			.addInput('L',"minecraft:planks")
			.create("woodenShield", steelShield.getDefaultStack());


	}
}
