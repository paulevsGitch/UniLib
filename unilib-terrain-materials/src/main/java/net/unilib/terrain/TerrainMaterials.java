package net.unilib.terrain;

import net.risingworld.api.utils.Utils.MathUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * This class stores terrain materials constants and some utility methods
 */
public class TerrainMaterials {
	private static final Map<String, ULTerrainMaterial> MAT_BY_NAME = new HashMap<>();
	private static final Map<Integer, ULTerrainMaterial> MAT_BY_ID = new HashMap<>();
	
	public static final ULTerrainMaterial AIR = make(0, "air", 0);
	public static final ULTerrainMaterial STONE = make(1, "stone", 0x7a7375);
	public static final ULTerrainMaterial GRAVEL_1 = make(2, "gravel_1", 0x94898a);
	public static final ULTerrainMaterial GRAVEL_2 = make(3, "gravel_2", 0xada29e);
	public static final ULTerrainMaterial GRAVEL_3 = make(4, "gravel_3", 0xa4887d);
	
	public static final ULTerrainMaterial DIRT = make(5, "dirt", 0x95664e);
	public static final ULTerrainMaterial MUD = make(6, "mud", 0x503322);
	public static final ULTerrainMaterial FARMLAND_DRY = make(7, "farmland_dry", 0x5b3a2a);
	public static final ULTerrainMaterial FARMLAND_WET = make(8, "farmland_wet", 0x4e3021);
	public static final ULTerrainMaterial FOREST_GROUND_1 = make(9, "forest_ground_1", 0x865b40);
	public static final ULTerrainMaterial FOREST_GROUND_2 = make(10, "forest_ground_2", 0x7e562d);
	public static final ULTerrainMaterial FOREST_GROUND_3 = make(11, "forest_ground_3", 0x6b3528);
	public static final ULTerrainMaterial FOREST_GRASS = make(12, "forest_grass", 0x51460a);
	public static final ULTerrainMaterial VOLCANIC = make(13, "volcanic", 0x313241);
	public static final ULTerrainMaterial OBSIDIAN = make(14, "obsidian", 0x25283b);
	public static final ULTerrainMaterial OBSIDIAN_HOT = make(15, "obsidian_hot", 0x30283a);
	public static final ULTerrainMaterial DRY_GROUND = make(16, "dry_ground", 0xa7805f);
	public static final ULTerrainMaterial SAND_DESERT = make(17, "sand_desert", 0xeea46a);
	public static final ULTerrainMaterial SAND_BEACH = make(18, "sand_beach", 0xc79a62);
	public static final ULTerrainMaterial SAND_SEA = make(19, "sand_sea", 0x664636);
	public static final ULTerrainMaterial DESERT_STONE = make(20, "desert_stone", 0x967056);
	public static final ULTerrainMaterial SANDSTONE_1 = make(21, "sandstone_1", 0xb46f5e);
	public static final ULTerrainMaterial SANDSTONE_2 = make(22, "sandstone_2", 0xe29471);
	public static final ULTerrainMaterial RED_CLAY = make(23, "red_clay", 0xa64827);
	public static final ULTerrainMaterial RUBBLE = make(24, "rubble", 0x795d55);
	public static final ULTerrainMaterial SNOW = make(25, "snow", 0xadc8d8);
	public static final ULTerrainMaterial ICE = make(26, "ice", 0x0c5a6c);
	public static final ULTerrainMaterial UNDERWATER = make(27, "underwater", 0x525231);
	public static final ULTerrainMaterial SEA_GRASS = make(28, "sea_grass", 0x4e5b2d);
	public static final ULTerrainMaterial HELLSTONE = make(29, "hellstone", 0xc31230);
	public static final ULTerrainMaterial HELLSTONE_HOT = make(30, "hellstone_hot", 0xc4172f);
	public static final ULTerrainMaterial COBBLE = make(31, "cobble", 0x7d5a4b);
	
	public static final ULTerrainMaterial COAL_ORE = make(50, "coal_ore", 0x706869);
	public static final ULTerrainMaterial SULFUR_ORE = make(51, "sulfur_ore", 0x7b706a);
	public static final ULTerrainMaterial IRON_ORE = make(52, "iron_ore", 0x684a47);
	public static final ULTerrainMaterial ALUMINIUM_ORE = make(53, "aluminium_ore", 0x585657);
	public static final ULTerrainMaterial TUNGSTEN_ORE = make(54, "tungsten_ore", 0x4e4444);
	public static final ULTerrainMaterial GOLD_ORE = make(55, "gold_ore", 0x64513d);
	
	public static final ULTerrainMaterial GRASS_0 = make(100, "grass_0", 0x425322);
	public static final ULTerrainMaterial GRASS_1 = make(101, "grass_1", 0x425322);
	public static final ULTerrainMaterial GRASS_2 = make(102, "grass_2", 0x425322);
	public static final ULTerrainMaterial GRASS_3 = make(103, "grass_3", 0x425322);
	public static final ULTerrainMaterial GRASS_4 = make(104, "grass_4", 0x425322);
	
	public static final ULTerrainMaterial GRASS_ARID_0 = make(105, "grass_arid_0", 0xa2803e);
	public static final ULTerrainMaterial GRASS_ARID_1 = make(106, "grass_arid_1", 0xa2803e);
	public static final ULTerrainMaterial GRASS_ARID_2 = make(107, "grass_arid_2", 0xa2803e);
	public static final ULTerrainMaterial GRASS_ARID_3 = make(108, "grass_arid_3", 0xa2803e);
	public static final ULTerrainMaterial GRASS_ARID_4 = make(109, "grass_arid_4", 0xa2803e);
	
	public static final ULTerrainMaterial GRASS_DRY_0 = make(110, "grass_dry_0", 0x825d4c);
	public static final ULTerrainMaterial GRASS_DRY_1 = make(111, "grass_dry_1", 0x825d4c);
	public static final ULTerrainMaterial GRASS_DRY_2 = make(112, "grass_dry_2", 0x825d4c);
	public static final ULTerrainMaterial GRASS_DRY_3 = make(113, "grass_dry_3", 0x825d4c);
	public static final ULTerrainMaterial GRASS_DRY_4 = make(114, "grass_dry_4", 0x825d4c);
	
	public static final ULTerrainMaterial GRASS_DEAD_0 = make(115, "grass_dead_0", 0x51460a);
	public static final ULTerrainMaterial GRASS_DEAD_1 = make(116, "grass_dead_1", 0x51460a);
	public static final ULTerrainMaterial GRASS_DEAD_2 = make(117, "grass_dead_2", 0x51460a);
	public static final ULTerrainMaterial GRASS_DEAD_3 = make(118, "grass_dead_3", 0x51460a);
	public static final ULTerrainMaterial GRASS_DEAD_4 = make(119, "grass_dead_4", 0x51460a);
	
	public static final ULTerrainMaterial GRASS_FROZEN_0 = make(120, "grass_frozen_0", 0x928c72);
	public static final ULTerrainMaterial GRASS_FROZEN_1 = make(121, "grass_frozen_1", 0x928c72);
	public static final ULTerrainMaterial GRASS_FROZEN_2 = make(122, "grass_frozen_2", 0x928c72);
	public static final ULTerrainMaterial GRASS_FROZEN_3 = make(123, "grass_frozen_3", 0x928c72);
	public static final ULTerrainMaterial GRASS_FROZEN_4 = make(124, "grass_frozen_4", 0x928c72);
	
	public static final ULTerrainMaterial GRASS_FOREST_0 = make(125, "grass_forest_0", 0x51460a);
	public static final ULTerrainMaterial GRASS_FOREST_1 = make(126, "grass_forest_1", 0x51460a);
	public static final ULTerrainMaterial GRASS_FOREST_2 = make(127, "grass_forest_2", 0x51460a);
	public static final ULTerrainMaterial GRASS_FOREST_3 = make(128, "grass_forest_3", 0x51460a);
	public static final ULTerrainMaterial GRASS_FOREST_4 = make(129, "grass_forest_4", 0x51460a);
	
	public static final ULTerrainMaterial GRASS_JUNGLE_0 = make(130, "grass_jungle_0", 0x55491b);
	public static final ULTerrainMaterial GRASS_JUNGLE_1 = make(131, "grass_jungle_1", 0x55491b);
	public static final ULTerrainMaterial GRASS_JUNGLE_2 = make(132, "grass_jungle_2", 0x55491b);
	public static final ULTerrainMaterial GRASS_JUNGLE_3 = make(133, "grass_jungle_3", 0x55491b);
	public static final ULTerrainMaterial GRASS_JUNGLE_4 = make(134, "grass_jungle_4", 0x55491b);
	
	public static final ULTerrainMaterial GRASS_SEA_0 = make(135, "grass_sea_0", 0x4e5b2d);
	public static final ULTerrainMaterial GRASS_SEA_1 = make(136, "grass_sea_1", 0x4e5b2d);
	public static final ULTerrainMaterial GRASS_SEA_2 = make(137, "grass_sea_2", 0x4e5b2d);
	public static final ULTerrainMaterial GRASS_SEA_3 = make(138, "grass_sea_3", 0x4e5b2d);
	public static final ULTerrainMaterial GRASS_SEA_4 = make(139, "grass_sea_4", 0x4e5b2d);
	
	public static final ULTerrainMaterial GRASS_SEAWEED_0 = make(140, "grass_seaweed_0", 0x505f2e);
	public static final ULTerrainMaterial GRASS_SEAWEED_1 = make(141, "grass_seaweed_1", 0x505f2e);
	public static final ULTerrainMaterial GRASS_SEAWEED_2 = make(142, "grass_seaweed_2", 0x505f2e);
	public static final ULTerrainMaterial GRASS_SEAWEED_3 = make(143, "grass_seaweed_3", 0x505f2e);
	public static final ULTerrainMaterial GRASS_SEAWEED_4 = make(144, "grass_seaweed_4", 0x505f2e);
	
	public static final ULTerrainMaterial WATER_FLOWING = make(202, "water_flowing", 0x2a8ac1);
	public static final ULTerrainMaterial WATER_INFINITY = make(203, "water_infinity", 0x2a8ac1);
	
	private static final ULTerrainMaterial[] GRASS_NORMAL = new ULTerrainMaterial[] {
		GRASS_0, GRASS_1, GRASS_2, GRASS_3, GRASS_4
	};
	
	private static final ULTerrainMaterial[] GRASS_ARID = new ULTerrainMaterial[] {
		GRASS_ARID_0, GRASS_ARID_1, GRASS_ARID_2, GRASS_ARID_3, GRASS_ARID_4
	};
	
	private static final ULTerrainMaterial[] GRASS_DRY = new ULTerrainMaterial[] {
		GRASS_DRY_0, GRASS_DRY_1, GRASS_DRY_2, GRASS_DRY_3, GRASS_DRY_4
	};
	
	private static final ULTerrainMaterial[] GRASS_DEAD = new ULTerrainMaterial[] {
		GRASS_DEAD_0, GRASS_DEAD_1, GRASS_DEAD_2, GRASS_DEAD_3, GRASS_DEAD_4
	};
	
	private static final ULTerrainMaterial[] GRASS_FROZEN = new ULTerrainMaterial[] {
		GRASS_FROZEN_0, GRASS_FROZEN_1, GRASS_FROZEN_2, GRASS_FROZEN_3, GRASS_FROZEN_4
	};
	
	private static final ULTerrainMaterial[] GRASS_FOREST = new ULTerrainMaterial[] {
		GRASS_FOREST_0, GRASS_FOREST_1, GRASS_FOREST_2, GRASS_FOREST_3, GRASS_FOREST_4
	};
	
	private static final ULTerrainMaterial[] GRASS_JUNGLE = new ULTerrainMaterial[] {
		GRASS_JUNGLE_0, GRASS_JUNGLE_1, GRASS_JUNGLE_2, GRASS_JUNGLE_3, GRASS_JUNGLE_4
	};
	
	private static final ULTerrainMaterial[] GRASS_SEA = new ULTerrainMaterial[] {
		GRASS_SEA_0, GRASS_SEA_1, GRASS_SEA_2, GRASS_SEA_3, GRASS_SEA_4
	};
	
	private static final ULTerrainMaterial[] GRASS_SEAWEED = new ULTerrainMaterial[] {
		GRASS_SEAWEED_0, GRASS_SEAWEED_1, GRASS_SEAWEED_2, GRASS_SEAWEED_3, GRASS_SEAWEED_4
	};
	
	/**
	 * Get Normal Grass with specified length
	 * @param length {@code int} grass length [0 - 4]
	 * @return {@link ULTerrainMaterial}
	 */
	public static ULTerrainMaterial getNormalGrass(int length) {
		return GRASS_NORMAL[MathUtils.clamp(0, 4, length)];
	}
	
	/**
	 * Get Arid Grass with specified length
	 * @param length {@code int} grass length [0 - 4]
	 * @return {@link ULTerrainMaterial}
	 */
	public static ULTerrainMaterial getAridGrass(int length) {
		return GRASS_ARID[MathUtils.clamp(0, 4, length)];
	}
	
	/**
	 * Get Dry Grass with specified length
	 * @param length {@code int} grass length [0 - 4]
	 * @return {@link ULTerrainMaterial}
	 */
	public static ULTerrainMaterial getDryGrass(int length) {
		return GRASS_DRY[MathUtils.clamp(0, 4, length)];
	}
	
	/**
	 * Get Dead Grass with specified length
	 * @param length {@code int} grass length [0 - 4]
	 * @return {@link ULTerrainMaterial}
	 */
	public static ULTerrainMaterial getDeadGrass(int length) {
		return GRASS_DEAD[MathUtils.clamp(0, 4, length)];
	}
	
	/**
	 * Get Frozen Grass with specified length
	 * @param length {@code int} grass length [0 - 4]
	 * @return {@link ULTerrainMaterial}
	 */
	public static ULTerrainMaterial getFrozenGrass(int length) {
		return GRASS_FROZEN[MathUtils.clamp(0, 4, length)];
	}
	
	/**
	 * Get Forest Grass with specified length
	 * @param length {@code int} grass length [0 - 4]
	 * @return {@link ULTerrainMaterial}
	 */
	public static ULTerrainMaterial getForestGrass(int length) {
		return GRASS_FOREST[MathUtils.clamp(0, 4, length)];
	}
	
	/**
	 * Get Jungle Grass with specified length
	 * @param length {@code int} grass length [0 - 4]
	 * @return {@link ULTerrainMaterial}
	 */
	public static ULTerrainMaterial getJungleGrass(int length) {
		return GRASS_JUNGLE[MathUtils.clamp(0, 4, length)];
	}
	
	/**
	 * Get Sea Grass with specified length
	 * @param length {@code int} grass length [0 - 4]
	 * @return {@link ULTerrainMaterial}
	 */
	public static ULTerrainMaterial getSeaGrass(int length) {
		return GRASS_SEA[MathUtils.clamp(0, 4, length)];
	}
	
	/**
	 * Get Seaweed Grass with specified length
	 * @param length {@code int} grass length [0 - 4]
	 * @return {@link ULTerrainMaterial}
	 */
	public static ULTerrainMaterial getSeaweedGrass(int length) {
		return GRASS_SEAWEED[MathUtils.clamp(0, 4, length)];
	}
	
	/**
	 * Get material by its name
	 * @param name {@link String} material name
	 * @return {@link ULTerrainMaterial}
	 */
	public static ULTerrainMaterial getByName(String name) {
		return MAT_BY_NAME.getOrDefault(name, AIR);
	}
	
	/**
	 * Get material by its ID
	 * @param id {@code int} material ID
	 * @return {@link ULTerrainMaterial}
	 */
	public static ULTerrainMaterial getByID(int id) {
		return MAT_BY_ID.getOrDefault(id, AIR);
	}
	
	private static ULTerrainMaterial make(int id, String name, int rgb) {
		ULTerrainMaterial material = new ULTerrainMaterial((byte) id, name, rgb << 8 | 255);
		MAT_BY_NAME.put(name, material);
		MAT_BY_ID.put(id, material);
		return material;
	}
}
