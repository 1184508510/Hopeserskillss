package ac.github.attributeaddion.internal.attribute;

import ac.github.attributeaddion.AttributeAddion;
import github.saukiya.sxattribute.data.attribute.AttributeType;
import github.saukiya.sxattribute.data.attribute.SubAttribute;
import github.saukiya.sxattribute.data.eventdata.EventData;
import github.saukiya.sxattribute.data.eventdata.sub.DamageData;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewDefence extends SubAttribute {
    private Object[] doubles;

    private double Defencevas;


    public NewDefence() {
        super((JavaPlugin)AttributeAddion.instance, 1, new AttributeType[] { AttributeType.DEFENCE });
    }

    protected YamlConfiguration defaultConfig(YamlConfiguration config) {
        config.set("DiscernName", "Defense");
        config.set("Defencevas", Integer.valueOf(170));
        config.set("CombatPower", Integer.valueOf(1));
        config.set("skills_defense", "skills_Defencevas");
        return config;
    }

    public void  eventMethod(double[] doubles, EventData eventData) {
        if (eventData instanceof DamageData) {
            DamageData damageData = (DamageData) eventData;
            List<BigDecimal> bigDecimals = new ArrayList<>();
            for (int i = 0; i < doubles.length; i++)
                bigDecimals.add(new BigDecimal(doubles[i]));
            BigDecimal num = new BigDecimal(this.Defencevas);
            BigDecimal s = BigDecimal.valueOf(doubles[0]);
            double damage = damageData.getDamage();
            if (!damageData.getEffectiveAttributeList().contains("Real")) {
                BigDecimal dama = new BigDecimal(damage);
                BigDecimal pl1 = num.add(BigDecimal.valueOf(doubles[0]));
                BigDecimal pl2 = s.divide(pl1, 3, RoundingMode.HALF_UP);
                BigDecimal v = dama.multiply(pl2);
                damageData.takeDamage(v.doubleValue());
            }
        }
    }

    public Object getPlaceholder(double[] values, Player player, String string) {
        char c = Character.MAX_VALUE;
        switch (string.hashCode()) {
            case 1680829717:
                if (string.equals("skills_Defencevas"))
                    c = '\001';
                break;
            case -1306766525:
                if (string.equals("skills_defense"))
                    c = Character.MIN_VALUE;
                break;
        }
        switch (c) {
            case '\000':
                return Double.valueOf(values[0]);
            case '\001':
                return Double.valueOf(this.Defencevas);
        }
        return null;
    }

    public List<String> getPlaceholders() {
        return Arrays.asList(new String[] { "skills_defense", "skills_Defencevas" });
    }

    public void onEnable() {
        this.Defencevas = config().getDouble("Defencevas", 170.0D);
    }

    public void onReLoad() {
        this.Defencevas = config().getDouble("Defencevas", 170.0D);
    }

    public void loadAttribute(double[] doubles, String s) {
        if (s.contains(getString("DiscernName", new Object[0])))
            doubles[0] = doubles[0] + getNumber(s);
    }

    public double calculationCombatPower(double[] values) {
        return config().getInt("CombatPower") * values[0];
    }
}