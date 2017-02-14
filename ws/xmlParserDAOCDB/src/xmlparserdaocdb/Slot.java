package xmlparserdaocdb;

public class Slot {
	private int type = 0;
	public String effect = null;
	public int amount = 0;
	public int effectInt = 0;
	
	public boolean isStat = false;
	public boolean isResist = false;
	public boolean isSkill = false;
	public boolean isHits = false;

	public Slot() {
		//System.out.println("______________creato nuovo slot");
	}
	
	public int getType() {
		return this.type;
	}

	public void setEffectInt() {
		switch (this.type) {
			case 1:
				switch (this.effect) {
					case "strength": this.effectInt = 1; this.isStat = true; break;
					case "constitution": this.effectInt = 2; this.isStat = true; break;
					case "dexterity": this.effectInt = 3; this.isStat = true; break;
					case "quickness": this.effectInt = 4; this.isStat = true; break;
					case "intelligence": this.effectInt = 5; this.isStat = true; break;
					case "piety": this.effectInt = 6; this.isStat = true; break;
					case "charisma": this.effectInt = 7; this.isStat = true; break;
					case "empathy": this.effectInt = 8; this.isStat = true; break;
					case "hits": this.effectInt = 9;this.isHits = true; break;
					case "power": this.effectInt = 10; break;
					case "power regeneration": this.effectInt = 11; break;
					case "acuity": this.effectInt = 12; this.isStat = true; break;
					default: this.effectInt = -1; System.out.println("effect:" + this.effect); break;
				}
				break;
			case 2:
				this.isResist = true;
				switch (this.effect) {
					case "body resist": this.effectInt = 13; break;
					case "cold resist": this.effectInt = 14; break;
					case "heat resist": this.effectInt = 15; break;
					case "energy resist": this.effectInt = 16; break;
					case "matter resist": this.effectInt = 17; break;
					case "spirit resist": this.effectInt = 18; break;
					case "crush resist": this.effectInt = 19; break;
					case "thrust resist": this.effectInt = 20; break;
					case "slash resist": this.effectInt = 21; break;
					default: this.effectInt = -1; System.out.println("effect:" + this.effect); break;
				}
				break;
			case 3:
				this.isSkill = true;
				switch(this.effect) {
					case "all dual wield skill bonus": this.effectInt = 22; break;
					case "all magic skill bonus": this.effectInt = 23; break;
					case "all melee skill bonus": this.effectInt = 24; break;
					case "arboreal path": this.effectInt = 25; break;
					case "archery skill bonus": this.effectInt = 26; break;
					case "augmentation": this.effectInt = 27; break;
					case "axe": this.effectInt = 28; break;
					case "battlesongs": this.effectInt = 29; break;
					case "blades": this.effectInt = 30; break;
					case "blunt": this.effectInt = 31; break;
					case "body magic": this.effectInt = 32; break;
					case "bone army": this.effectInt = 33; break;
					case "celtic dual": this.effectInt = 34; break;
					case "celtic spear": this.effectInt = 35; break;
					case "cold magic": this.effectInt = 36; break;
					case "composite bow": this.effectInt = 37; break;
					case "creeping path": this.effectInt = 38; break;
					case "critical strike": this.effectInt = 39; break;
					case "crossbow": this.effectInt = 40; break;
					case "crush": this.effectInt = 41; break;
					case "cursing": this.effectInt = 42; break;
					case "darkness": this.effectInt = 43; break;
					case "death servant": this.effectInt = 44; break;
					case "deathsight": this.effectInt = 45; break;
					case "dementia": this.effectInt = 46; break;
					case "dual wield": this.effectInt = 47; break;
					case "earth magic": this.effectInt = 48; break;
					case "enchantments": this.effectInt = 49; break;
					case "enhancement": this.effectInt = 50; break;
					case "envenom": this.effectInt = 51; break;
					case "ethereal shriek": this.effectInt = 52; break;
					case "fire magic": this.effectInt = 53; break;
					case "fist wraps": this.effectInt = 54; break;
					case "flexible": this.effectInt = 55; break;
					case "hammer": this.effectInt = 56; break;
					case "hand to hand": this.effectInt = 57; break;
					case "hexing": this.effectInt = 58; break;
					case "instruments": this.effectInt = 59; break;
					case "large weaponry": this.effectInt = 60; break;
					case "left axe": this.effectInt = 61; break;
					case "light": this.effectInt = 62; break;
					case "longbow": this.effectInt = 63; break;
					case "mana": this.effectInt = 64; break;
					case "matter magic": this.effectInt = 65; break;
					case "mauler staff": this.effectInt = 66; break;
					case "mending": this.effectInt = 67; break;
					case "mentalism": this.effectInt = 68; break;
					case "mind magic": this.effectInt = 69; break;
					case "music": this.effectInt = 70; break;
					case "nature": this.effectInt = 71; break;
					case "nurture": this.effectInt = 72; break;
					case "painworking": this.effectInt = 73; break;
					case "parry": this.effectInt = 74; break;
					case "phantasmal wail": this.effectInt = 75; break;
					case "piercing": this.effectInt = 76; break;
					case "polearm": this.effectInt = 77; break;
					case "power strikes": this.effectInt = 78; break;
					case "recurve bow": this.effectInt = 79; break;
					case "regrowth": this.effectInt = 80; break;
					case "rejuvenation": this.effectInt = 81; break;
					case "runecarving": this.effectInt = 82; break;
					case "scythe": this.effectInt = 83; break;
					case "shadow mastery": this.effectInt = 84; break;
					case "shield": this.effectInt = 85; break;
					case "slash": this.effectInt = 86; break;
					case "smite": this.effectInt = 87; break;
					case "soulrending": this.effectInt = 88; break;
					case "spear": this.effectInt = 89; break;
					case "spectral guard": this.effectInt = 90; break;
					case "spirit magic": this.effectInt = 91; break;
					case "staff": this.effectInt = 92; break;
					case "stealth": this.effectInt = 93; break;
					case "stormcalling": this.effectInt = 94; break;
					case "subterranean": this.effectInt = 95; break;
					case "summoning": this.effectInt = 96; break;
					case "suppression": this.effectInt = 97; break;
					case "sword": this.effectInt = 98; break;
					case "thrown weapons": this.effectInt = 99; break;
					case "thrust": this.effectInt = 100; break;
					case "two handed": this.effectInt = 101; break;
					case "valor": this.effectInt = 102; break;
					case "vampiiric embrace": this.effectInt = 103; break;
					case "verdant path": this.effectInt = 104; break;
					case "void": this.effectInt = 105; break;
					case "wind magic": this.effectInt = 106; break;
					default: this.effectInt = -1; System.out.println("effect:" + this.effect); break;
				}
				break;
			case 4: 
				switch(this.effect) {
					case "acuity": this.effectInt = 107; break;
					case "charisma": this.effectInt = 108; break;
					case "constitution": this.effectInt = 109; break;
					case "dexterity": this.effectInt = 110; break;
					case "empathy": this.effectInt = 111; break;
					case "hits": this.effectInt = 112; break;
					case "intelligence": this.effectInt = 113; break;
					case "piety": this.effectInt = 114; break;
					case "power": this.effectInt = 115; break;
					case "quickness": this.effectInt = 116; break;
					case "strength": this.effectInt = 117; break;
					default: this.effectInt = -1; System.out.println("effect:" + this.effect); break;
				}
				break;
			case 5:
				switch(this.effect) {
					case "melee damage bonus": this.effectInt = 118; break;
					case "af bonus": this.effectInt = 119; break;
					case "buff bonus": this.effectInt = 120; break;
//modificato
				//	case "archery skills bonus": this.effectInt = 121; break;
					case "archery skills bonus": this.effectInt = 26; break;
					case "spell duration bonus": this.effectInt = 122; break;
					case "power percentage bonus": this.effectInt = 123; break;
					case "casting speed bonus": this.effectInt = 124; break;
					case "healing bonus": this.effectInt = 125; break;
					case "spell range bonus": this.effectInt = 126; break;
					case "style damage bonus": this.effectInt = 127; break;
					case "spell damage bonus": this.effectInt = 128; break;
					case "fatigue": this.effectInt = 129; break;
					case "melee speed bonus": this.effectInt = 130; break;
					case "death experience loss reduction": this.effectInt = 131; break;
					case "archery speed bonus": this.effectInt = 132; break;
					case "bonus to frequency of crafting skill gain": this.effectInt = 133; break;
					case "bonus to quality of crafted items": this.effectInt = 134; break;
					case "archery damage bonus": this.effectInt = 135; break;
					case "arrow recovery": this.effectInt = 136; break;
					case "archery range bonus": this.effectInt = 137; break;
					case "resist pierce": this.effectInt = 138; break;
					case "debuff bonus": this.effectInt = 139; break;
					default: this.effectInt = -1; System.out.println("effect:" + this.effect); break;
				}
				break;
			case 6:
				switch(this.effect) {
					case "light focus": this.effectInt = 140; break;
					case "all focus bonus": this.effectInt = 141; break;
					case "arboreal focus": this.effectInt = 142; break;
					case "enchantments focus": this.effectInt = 143; break;
					case "mentalism focus": this.effectInt = 144; break;
					case "bone army focus": this.effectInt = 145; break;
					case "void focus": this.effectInt = 146; break;
					case "body focus": this.effectInt = 147; break;
					case "painworking focus": this.effectInt = 148; break;
					case "cold focus": this.effectInt = 149; break;
					case "death servant focus": this.effectInt = 150; break;
					case "mana focus": this.effectInt = 151; break;
					case "spirit focus": this.effectInt = 152; break;
					case "spectral guard": this.effectInt = 153; break;
					case "creeping path focus": this.effectInt = 154; break;
					case "darkness focus": this.effectInt = 155; break;
					case "cursing": this.effectInt = 156; break;
					case "verdant path focus": this.effectInt = 157; break;
					case "wind focus": this.effectInt = 158; break;
					case "deathsight focus": this.effectInt = 159; break;
					case "earth focus": this.effectInt = 160; break;
					case "fire focus": this.effectInt = 161; break;
					case "matter focus": this.effectInt = 162; break;
					case "mind focus": this.effectInt = 163; break;
					case "runecarving focus": this.effectInt = 164; break;
					case "summoning focus": this.effectInt = 165; break;
					case "suppression focus": this.effectInt = 166; break;
					case "phantasmal wail": this.effectInt = 167; break;
					case "hexing focus": this.effectInt = 168; break;
					case "ethereal shriek": this.effectInt = 169; break;
					default: this.effectInt = -1; System.out.println("effect:" + this.effect); break;
				}
				break;
			case 7:
				switch(this.effect) {
					case "to-hit bonus": this.effectInt = 170; break;
					case "bladeturn reinforcement": this.effectInt = 171; break;
					case "negative effect duration reduction": this.effectInt = 172; break;
					case "piece ablative": this.effectInt = 173; break;
					case "defensive bonus": this.effectInt = 174; break;
					case "reactionary style damage bonus": this.effectInt = 175; break;
					case "evade": this.effectInt = 176; break;
					case "parry": this.effectInt = 177; break;
					case "concentration": this.effectInt = 178; break;
					case "block": this.effectInt = 179; break;
					case "spell power cost reduction": this.effectInt = 180; break;
					case "style cost reduction": this.effectInt = 181; break;
					default: this.effectInt = -1; System.out.println("effect:" + this.effect); break;
				}
				break;
		}
	}

	public void setType(String type) {
		switch(type) {
			case "stat": case "power": case "hits":
				this.type = 1; break;
			case "resist":
				this.type = 2;
				break;
			case "skill":
				this.type = 3;
				break;
			case "cap increase":
				this.type = 4;
				break;
			case "other bonus":
				this.type = 5;
				break;
			case "focus":
				this.type = 6;
				break;
			case "non-frontiers": case "pve":
				this.type = 7;
				break;
			default:
				this.type = -1;
				break;
		}
	}
}
