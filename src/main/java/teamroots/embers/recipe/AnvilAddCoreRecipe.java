package teamroots.embers.recipe;

import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import teamroots.embers.RegistryManager;
import teamroots.embers.api.itemmod.ItemModUtil;
import teamroots.embers.api.itemmod.ModifierBase;

import java.util.List;

public class AnvilAddCoreRecipe extends DawnstoneAnvilRecipe {
    @Override
    public boolean matches(ItemStack input1, ItemStack input2) {
        ModifierBase modifier = ItemModUtil.getModifier(input2); //TODO: instead of hardcoding this, see if the modifier can be applied as a core
        return input2.getItem() == RegistryManager.ancient_motive_core && (!ItemModUtil.hasHeat(input1) || !ItemModUtil.hasModifier(input1, modifier)) && modifier.canApplyTo(input1);
    }

    @Override
    public List<ItemStack> getResult(TileEntity tile, ItemStack input1, ItemStack input2) {
        ItemStack result = input1.copy();
        ItemModUtil.addModifier(result, input2);
        return Lists.newArrayList(result);
    }
}
