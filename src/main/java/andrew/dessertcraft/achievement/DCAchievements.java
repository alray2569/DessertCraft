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

	/** Achievement earned by crafting Black Forest Cake */
	public static Achievement makeGermanCake;
	/** Achievement earned by crafting the Ice Cream Maker */
	public static Achievement makeIceCreamChurn;
	/** Achievement earned by using the Ice Cream Maker to make Ice Cream */
	public static Achievement churnIceCream;

	/**
	 * Initializes the achievements and the achievement page for the
	 * DessertCraft mod.
	 */
	public static void init() {
		makeGermanCake = new Achievement("achievement." + DCConstants.MODID
				+ "_makeGermanCake", "makeGermanCake", 0, 0,
				DCItems.germanCake, AchievementList.buildWorkBench)
				.registerStat();
		makeIceCreamChurn = new Achievement("achievement." + DCConstants.MODID
				+ "_makeIceCreamChurn", "makeIceCreamChurn", 2, 1,
				DCBlocks.iceCreamMaker, AchievementList.buildWorkBench)
				.registerStat();
		churnIceCream = new Achievement("achievement." + DCConstants.MODID
				+ "_iceCream", "churnIceCream", 3, 3,
				DCItems.iceCream_chocolate, makeIceCreamChurn).registerStat();

		AchievementPage dcAchievements = new AchievementPage(
				DCConstants.MODNAME, new Achievement[] { makeGermanCake,
						makeIceCreamChurn, churnIceCream });

		AchievementPage.registerAchievementPage(dcAchievements);
	}
}
