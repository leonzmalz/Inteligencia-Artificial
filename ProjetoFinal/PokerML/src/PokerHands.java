import java.util.HashMap;
import java.util.Map;

public enum PokerHands {
	
	NADA_NA_MAO(0, "Nada na mão"),
	UM_PAR(1, "Um par"),
	DOIS_PARES(2, "Dois pares"),
	TRINCA(3, "Trinca"),
	STRAIGHT(4, "Straight"),
	FLUSH(5,"Flush"),
	FULL_HOUSE(6,"Full house"),
	QUADRA(7,"Quadra"),
	STRAIGHT_FLUSH(8,"Straight flush"),
	ROYAL_FLUSH(9,"Royal flush");
	
	private int value;
	private String texto;

    private static Map<Integer, PokerHands> map = new HashMap<>();

    static {
        for (PokerHands pokerEnum : PokerHands.values()) {
            map.put(pokerEnum.value, pokerEnum);
        }
    }

    public static PokerHands valueOf(int value) {
        return map.get(value);
    }
	
	private PokerHands(int value, String texto) {
		this.value = value;
		this.texto = texto;
	}
	
	public String getTexto() {
		return texto;
	}
	
	
	

}
