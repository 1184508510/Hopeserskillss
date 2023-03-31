package ac.github.attributeaddion;

import ac.github.attributeaddion.internal.attribute.*;
import ac.github.attributeaddion.internal.attribute.lis.PluginManagers;
import org.bukkit.plugin.java.JavaPlugin;

public final class AttributeAddion extends JavaPlugin {
    public static AttributeAddion instance;

    public void onLoad() {
        instance = this;
    }


    public static AttributeAddion getInstance() {
        return instance;
    }


    public void onEnable() {
        instance = this;
        PluginManagers.EnablePlugins();
        (new DamageUp()).registerAttribute();
        (new NewDefence()).registerAttribute();
        (new HealthPlus()).registerAttribute();
        (new Armourpiercing()).registerAttribute();
        (new Inteligence()).registerAttribute();
        (new DefenseUp()).registerAttribute();
    }

    public void onDisable() {}
}