package andrew.dessertcraft.achievement;

import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.JsonSerializableSet;
import net.minecraftforge.common.AchievementPage;
import andrew.dessertcraft.blocks.DCBlocks;
import andrew.dessertcraft.items.DCItems;
import andrew.dessertcraft.lib.DCConstants;

/**
 * Handles all DessertCraft achievements.
 *
 */
public class DCAchievements {

	/** True if this has been initialized */
	private static boolean initialized = false;

	/** Achievement earned by crafting a mixing bowl. */
	public static Achievement mixMaster;
	/** Achievement earned by crafting a pastry counter. */
	public static Achievement patisserie;
	/** Achievement earned by crafting an ice cream churn. */
	public static Achievement makeChurn;
	/** Achievement earned by crafting a barrel. */
	public static Achievement homebrew;
	/** Achievement earned by eating first dessert */
	public static Achievement dessertLover;
	/** Achievement earned by eating every dessert in the game */
	public static Achievement gourmand;
	/** Achievement earned by drinking alcohol and getting drunk */
	public static Achievement drunk;
	

	/**
	 * Initializes the achievements and the achievement page for the
	 * DessertCraft mod.
	 */
	public static void init() {
		if (!initialized) { // only run once!
			
			mixMaster = new Achievement("achievement.mixMaster", "mixMaster", -2, 0, DCItems.mixingBowl, AchievementList.buildWorkBench).registerStat();
			patisserie = new Achievement("achivement.patisserie", "patisserie", 2, 0, DCBlocks.pastryCounter, AchievementList.buildWorkBench).registerStat();
			makeChurn = new Achievement("achievement.makeChurn", "makeChurn", -1, -2, DCBlocks.iceCreamMaker, AchievementList.buildWorkBench).registerStat();
			homebrew = new Achievement("achievement.homebrew", "homebrew", 1, -2, DCBlocks.barrel, AchievementList.buildWorkBench).registerStat();
			dessertLover = new Achievement("achievement.dessertLover", "dessertLover", 0, 2, DCItems.applePie, AchievementList.buildWorkBench).registerStat();
			gourmand = new Achievement("achievement.gourmand", "gourmand", 0, 4, DCItems.germanCake, dessertLover).setSpecial().func_150953_b(JsonSerializableSet.class).registerStat();
			drunk = new Achievement("achievement.drunk", "drunk", 2, -4, DCItems.bottleRum, homebrew).registerStat();
			
			AchievementPage dcAchievements = new AchievementPage(DCConstants.MODNAME, new Achievement[] { dessertLover, gourmand, mixMaster, patisserie, makeChurn, homebrew, drunk });

			AchievementPage.registerAchievementPage(dcAchievements);

			initialized = true;
		}
	}
}
