package xmlparserdaocdb;

public class Item {
	private int ogg_id = 0;
	private String name = "";
	private int slot = 0;
	//private String lh = "";
	private int realm = 0;
	private int lvl = 0;
	private Slot [] slots = new Slot[10];
	private float imbue = 0;
	private String use1 = "''";
	private String use2 = "''";
	private String note = "''";
	
	private int currentSlot = 0;
	private boolean primoType = true;
	
	public Item(int ogg_id) {
		this.ogg_id = ogg_id;
		//System.out.println("creato nuovo item");
	}
	
	public void setter(String elemento, String contenuto, boolean isNew) {
		elemento = elemento.trim().toLowerCase();
		contenuto = contenuto.trim().toLowerCase();
		switch(elemento) {
			case "realm": {
				setRealm(contenuto);
				break;
			}
			case "level": {
				setLvl(contenuto);
				break;
			}
			case "location": {
				setSlot(contenuto);
				break;
			}
			case "itemname": {
				setName(contenuto);
				break;
			}
			case "offhand": {
				setOffhand(contenuto);
				break;
			}
			case "effect": {
				createSlot(contenuto);
				break;
			}
			case "amount": {
				setSlotAmount(contenuto);
				break;
			}
			case "type": {
				if (isNew) {
					setSlotType(contenuto);
				}
				else {
					if (primoType) {
						primoType = false;
					}
					else {
						setSlotType(contenuto);
					}
				}
				break;
			}
		}
	}
	
	private void setSlotType(String type) {
		slots[currentSlot].setType(type);
		currentSlot++;
	}
	
	private void setSlotAmount(String amount) {
		if (amount.equals("")) {
			slots[currentSlot].amount = 0;
		}
		else {
			slots[currentSlot].amount = Integer.parseInt(amount);
		}
	}
	
	private void createSlot(String effect) {
		slots[currentSlot] = new Slot();
		slots[currentSlot].effect = effect;
	}
	
	private void setRealm(String realm) {
		switch(realm) {
			case "all": {
				this.realm = 0;
				break;
			}
			case "albion": {
				this.realm = 1;
				break;
			}
			case "hibernia": {
				this.realm = 2;
				break;
			}
			case "midgard": {
				this.realm = 3;
				break;
			}
			default: {
				this.realm = 0;
				break;
			}
		}
	}
	
	private void setLvl(String level) {
		this.lvl = Integer.parseInt(level);
	}
	
	private void setSlot(String slot) {
		switch(slot) {
			case "arms": {
				this.slot = 1;
				break;
			}
			case "belt": {
				this.slot = 2;
				break;
			}
			case "chest": {
				this.slot = 3;
				break;
			}
			case "cloak": {
				this.slot = 4;
				break;
			}
			case "feet": {
				this.slot = 5;
				break;
			}
			case "hands": {
				this.slot = 6;
				break;
			}
			case "head": {
				this.slot = 7;
				break;
			}
			case "jewel": {
				this.slot = 8;
				break;
			}
			case "left hand": {
				this.slot = 9;
				break;
			}
			case "left ring": case "ring": {
				this.slot = 10;
				break;
			}
			case "left wrist": case "right wrist": {
				this.slot = 11;
				break;
			}
			case "legs": {
				this.slot = 12;
				break;
			}
			case "neck": {
				this.slot = 13;
				break;
			}
			case "ranged": {
				this.slot = 14;
				break;
			}
			case "right hand": {
				this.slot = 15;
				break;
			}
			case "2 handed": {
				this.slot = 16;
				break;
			}
			default: {
				this.slot = 18;
				System.err.println("slot");
				break;
			}
		}
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	private void setOffhand(String string) {
		if (string.equals("no")) {
//			this.lh = string;
		}
		else {
//			this.lh = string;
		}
	}
	
	public void chiudiOggetto() {
		for (int i = 0; i < 10; i++) {
			this.slots[i].setEffectInt();
		}
		calcolaImbue();
	}

	private void calcolaImbue() {
		for (int i = 0; i < 10; i++) {
			if (this.slots[i].isResist)
				this.imbue += this.slots[i].amount * 2;
			if (this.slots[i].isStat)
				this.imbue += this.slots[i].amount * 2 / 3;
			if (this.slots[i].isSkill)
				this.imbue += this.slots[i].amount * 5;
			if (this.slots[i].isHits)
				this.imbue += this.slots[i].amount / 4;
		}
	}
	
	@Override
	public String toString() {
		char c = ',';
		return
                        "insert into oggetti values(" +
			this.ogg_id + "," + "'" +
			this.name.replace("'", " ") + "'" + c +
			this.slot + c +
			this.realm + c +
			this.lvl + c +
			this.slots[0].effectInt + c + this.slots[0].amount + c +
			this.slots[1].effectInt + c + this.slots[1].amount + c +
			this.slots[2].effectInt + c + this.slots[2].amount + c +
			this.slots[3].effectInt + c + this.slots[3].amount + c +
			this.slots[4].effectInt + c + this.slots[4].amount + c +
			this.slots[5].effectInt + c + this.slots[5].amount + c +
			this.slots[6].effectInt + c + this.slots[6].amount + c +
			this.slots[7].effectInt + c + this.slots[7].amount + c +
			this.slots[8].effectInt + c + this.slots[8].amount + c +
			this.slots[9].effectInt + c + this.slots[9].amount + c +
			this.imbue + c +
			this.use1 + c +
			this.use2 + c +
			this.note + ");";
	}
}
