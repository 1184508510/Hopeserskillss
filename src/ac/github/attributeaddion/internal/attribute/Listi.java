package ac.github.attributeaddion.internal.attribute;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;



public class Listi implements Listener {

    private double damage;

    public void DamageData(EntityDamageByEntityEvent e) {
        this.damage = Math.round(e.getDamage());
    }

    public double getDamage() {
        return this.damage;
    }


}




