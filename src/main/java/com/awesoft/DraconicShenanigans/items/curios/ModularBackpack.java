package com.awesoft.DraconicShenanigans.items.curios;

import static com.brandon3055.draconicevolution.init.ModuleCfg.removeInvalidModules;

import java.util.List;

import javax.annotation.Nullable;

import com.brandon3055.brandonscore.api.TechLevel;
import com.brandon3055.draconicevolution.api.modules.ModuleCategory;
import com.brandon3055.draconicevolution.api.modules.lib.ModularOPStorage;
import com.brandon3055.draconicevolution.api.modules.lib.ModuleHostImpl;
import com.brandon3055.draconicevolution.init.EquipCfg;
import com.brandon3055.draconicevolution.init.TechProperties;
import com.brandon3055.draconicevolution.items.equipment.IModularArmor;

import com.awesoft.DraconicShenanigans.items.IModularEnergyItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ModularBackpack extends Item implements IModularEnergyItem, IModularArmor {

    private TechLevel techLevel;

    public ModularBackpack(TechProperties props) {
        super(props);
        techLevel = props.getTechLevel();
    }

    @Override
    public TechLevel getTechLevel() {
        return techLevel;
    }

    @Override
    public ModuleHostImpl createHost(ItemStack stack) {
        ModuleHostImpl host = new ModuleHostImpl(techLevel, 2 + techLevel.index, 2 + techLevel.index, "backpack", removeInvalidModules);
        host.addCategories(ModuleCategory.ALL, ModuleCategory.ARMOR_HEAD, ModuleCategory.ARMOR_CHEST,ModuleCategory.ENERGY);
        return host;
    }

    @Nullable
    @Override
    public ModularOPStorage createOPStorage(ItemStack stack, ModuleHostImpl host) {
        long capacity = (long)(EquipCfg.getBaseEnergy(techLevel));
        return new ModularOPStorage(host, capacity, capacity / 64);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flags) {
        IModularEnergyItem.super.appendHoverText(stack, world, tooltip, flags);
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return damageBarVisible(stack);
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return damageBarWidth(stack);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return damageBarColour(stack);
    }
}