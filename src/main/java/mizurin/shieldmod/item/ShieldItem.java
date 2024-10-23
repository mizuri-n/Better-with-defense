package mizurin.shieldmod.item;

import mizurin.shieldmod.interfaces.IDazed;
import mizurin.shieldmod.interfaces.ParryInterface;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemToolSword;
import net.minecraft.core.world.World;

public class ShieldItem extends ItemToolSword {
	public ToolMaterial tool;
	public int weaponDamage;


	public ShieldItem(String name, int id, ToolMaterial toolMaterial){
		super(name, id, toolMaterial);
		maxStackSize = 1;
		setMaxDamage(toolMaterial.getDurability());
		this.tool = toolMaterial;
		this.weaponDamage = 4 + toolMaterial.getDamage();


	}

	//Applies a knockback effect for all shields, bonus knockback to Leather Shields, and sets hitEntities on fire when hit by a Steel Shield.
	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLiving target, EntityLiving player) {
		if(itemstack.getItem() == Shields.leatherShield){
			target.knockBack(player, 1, (player.x - target.x), (player.z - target.z ));
			target.push((target.x - player.x)/7, 0, (target.z - player.z)/7);
		} else {
			target.knockBack(player, 3, player.x - target.x, player.z - target.z);
		}
		if(itemstack.getItem() == Shields.goldShield){
			((IDazed)target).shieldmod$dazedHurt();
			target.push((target.x - player.x)/20, 0, (target.z - player.z)/20);
		}
		itemstack.damageItem(1, player);

		return true;
	}
	public int getDamageVsEntity(Entity entity) {
		return this.weaponDamage;
	}


	//Activates ticks that determine if the player is blocking.
	@Override
	public ItemStack onUseItem(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		//Set to true then add the ticks to the data.
		((ParryInterface)entityplayer).shieldmod$setIsBlock(true);
		((ParryInterface)entityplayer).shieldmod$Block(5);

		return itemstack;
	}

}

