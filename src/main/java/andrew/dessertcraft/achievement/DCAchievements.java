package andrew.dessertcraft.achievement;

import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
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
	
	/*
	public static Achievement makeGermanCake;
	public static Achievement makeIceCreamChurn;
	public static Achievement churnIceCream;
	*/

	/** Achievement earned by eating first dessert */
	public static Achievement dessertLover;
	/** Achievement earned by eating every dessert in the game */
	public static Achievement gourmand;

	/**
	 * Initializes the achievements and the achievement page for the
	 * DessertCraft mod.
	 */
	public static void init() {
		if (!initialized) { // only run once!
			/*
			makeGermanCake = new Achievement("achievement." + DCConstants.MODID
					+ "_makeGermanCake", "makeGermanCake", 0, 0,
					DCItems.germanCake, AchievementList.buildWorkBench)
					.registerStat();
			makeIceCreamChurn = new Achievement("achievement."
					+ DCConstants.MODID + "_makeIceCreamChurn",
					"makeIceCreamChurn", 2, 1, DCBlocks.iceCreamMaker,
					AchievementList.buildWorkBench).registerStat();
			churnIceCream = new Achievement("achievement." + DCConstants.MODID
					+ "_iceCream", "churnIceCream", 3, 3,
					DCItems.iceCream_chocolate, makeIceCreamChurn)
					.registerStat();
			*/

			gourmand = new Achievement("achievement.gourmand.name", "gourmand", 0,
					2, DCItems.germanCake, dessertLover).setSpecial();
			dessertLover = new Achievement("achievement.dessertLover.name",
					"dessertLover", 0, 0, DCItems.applePie,
					AchievementList.buildWorkBench);

			AchievementPage dcAchievements = new AchievementPage(
					DCConstants.MODNAME, new Achievement[] { dessertLover, gourmand });

			AchievementPage.registerAchievementPage(dcAchievements);

			initialized = true;
		}
	}
}
