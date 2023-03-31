package ac.github.attributeaddion.internal.attribute.lis;

import ac.github.attributeaddion.AttributeAddion;
import ac.github.attributeaddion.internal.attribute.Listi;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class PluginManagers {
    public static void EnablePlugins() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Listi(), AttributeAddion.getInstance());
    }
}
