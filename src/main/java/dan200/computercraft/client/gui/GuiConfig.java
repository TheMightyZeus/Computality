package dan200.computercraft.client.gui;

import dan200.computercraft.ComputerCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.IConfigElement;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GuiConfig extends net.minecraftforge.fml.client.config.GuiConfig {
    public GuiConfig(GuiScreen parentScreen) {
        super(parentScreen, getConfigElements(), "computercraft", "computercraft", false, true, "Computality");
    }

    private static List<IConfigElement> getConfigElements() {
        ArrayList<IConfigElement> elements = new ArrayList<IConfigElement>();
        for (Property property : ComputerCraft.Config.config.getCategory(Configuration.CATEGORY_GENERAL).getOrderedValues()) {
            elements.add(new ConfigElement(property));
        }
        return elements;
    }

    public static class Factory implements IModGuiFactory {
        @Override
        public void initialize(Minecraft minecraftInstance) {

        }
        @Override
        public Class<? extends GuiScreen> mainConfigGuiClass() {
            return GuiConfig.class;
        }

        @Override
        public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
            return null;
        }

        @Nullable
        @Override
        public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
            return null;
        }
    }
}