import java.util.*;

public class Challenge41 {
	public static void main(String[] args) {
		Sword sword1 = new Sword(Material.IRON, Gemstone.NONE, 85, 19);
		Sword sword2 = sword1.withMaterial(Material.STEEL);
		Sword sword3 = sword1.withMaterial(Material.WOOD);
		
		System.out.println(sword1.toString());
		System.out.println(sword2.toString());
		System.out.println(sword3.toString());
	}
}

enum Material {
	WOOD("wood"),
	BRONZE("bronze"),
	IRON("iron"),
	STEEL("steel"),
	BINARIUM("binarium");
	
	private String value;
	private Material (final String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}

enum Gemstone {
	EMERALD("emerald"),
	AMBER("amber"),
	SAPPHIRE("sapphire"),
	DIAMOND("diamond"),
	BITSTONE("bitstone"),
	NONE("no");
	
	private String value;
	private Gemstone (final String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}

public record Sword (Material material, Gemstone gemstone, int length, int crossguard) {
	@Override
	public String toString() {
		String gemstoneText = switch(gemstone) {
			case EMERALD, AMBER, SAPPHIRE, DIAMOND, BITSTONE -> ", and an embedded " + gemstone.toString() + ".";
			case NONE ->										".";
			default ->											".";
		};
		
		return "A " + material.toString() + " sword of " + length + " centimetres long, a crossguard width of " + crossguard + " cm" + gemstoneText;
	}
	
	public Sword withMaterial(Material material) {
		return new Sword(material, gemstone, length, crossguard);
	}
}