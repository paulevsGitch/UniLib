package net.unilib.terrain;

import net.risingworld.api.utils.Utils.MathUtils;

public class TerrainMaterials {
	public static final ULTerrainMaterial AIR = new ULTerrainMaterial(0, "air", 0);
	public static final ULTerrainMaterial STONE = new ULTerrainMaterial(1, "stone", 0);
	public static final ULTerrainMaterial GRAVEL_1 = new ULTerrainMaterial(2, "gravel_1", 0);
	public static final ULTerrainMaterial GRAVEL_2 = new ULTerrainMaterial(3, "gravel_2", 0);
	public static final ULTerrainMaterial GRAVEL_3 = new ULTerrainMaterial(4, "gravel_3", 0);
	
	public static final ULTerrainMaterial DIRT = new ULTerrainMaterial(5, "dirt", 0);
	public static final ULTerrainMaterial MUD = new ULTerrainMaterial(6, "mud", 0);
	public static final ULTerrainMaterial FARMLAND_DRY = new ULTerrainMaterial(7, "farmland_dry", 0);
	public static final ULTerrainMaterial FARMLAND_WET = new ULTerrainMaterial(8, "farmland_wet", 0);
	public static final ULTerrainMaterial FOREST_GROUND_1 = new ULTerrainMaterial(9, "forest_ground_1", 0);
	public static final ULTerrainMaterial FOREST_GROUND_2 = new ULTerrainMaterial(10, "forest_ground_2", 0);
	public static final ULTerrainMaterial FOREST_GROUND_3 = new ULTerrainMaterial(11, "forest_ground_3", 0);
	public static final ULTerrainMaterial FOREST_GRASS = new ULTerrainMaterial(12, "forest_grass", 0);
	public static final ULTerrainMaterial VOLCANIC = new ULTerrainMaterial(13, "volcanic", 0);
	public static final ULTerrainMaterial OBSIDIAN = new ULTerrainMaterial(14, "obsidian", 0);
	public static final ULTerrainMaterial OBSIDIAN_HOT = new ULTerrainMaterial(15, "obsidian_hot", 0);
	public static final ULTerrainMaterial DRY_GROUND = new ULTerrainMaterial(16, "dry_ground", 0);
	public static final ULTerrainMaterial SAND_DESERT = new ULTerrainMaterial(17, "sand_desert", 0);
	public static final ULTerrainMaterial SAND_BEACH = new ULTerrainMaterial(18, "sand_beach", 0);
	public static final ULTerrainMaterial SAND_SEA = new ULTerrainMaterial(19, "sand_sea", 0);
	public static final ULTerrainMaterial DESERT_STONE = new ULTerrainMaterial(20, "desert_stone", 0);
	public static final ULTerrainMaterial SANDSTONE_1 = new ULTerrainMaterial(21, "sandstone_1", 0);
	public static final ULTerrainMaterial SANDSTONE_2 = new ULTerrainMaterial(22, "sandstone_2", 0);
	public static final ULTerrainMaterial RED_CLAY = new ULTerrainMaterial(23, "red_clay", 0);
	public static final ULTerrainMaterial RUBBLE = new ULTerrainMaterial(24, "rubble", 0);
	public static final ULTerrainMaterial SNOW = new ULTerrainMaterial(25, "snow", 0);
	public static final ULTerrainMaterial ICE = new ULTerrainMaterial(26, "ice", 0);
	public static final ULTerrainMaterial UNDERWATER = new ULTerrainMaterial(27, "underwater", 0);
	public static final ULTerrainMaterial SEA_GRASS = new ULTerrainMaterial(28, "sea_grass", 0);
	public static final ULTerrainMaterial HELLSTONE = new ULTerrainMaterial(29, "hellstone", 0);
	public static final ULTerrainMaterial HELLSTONE_HOT = new ULTerrainMaterial(30, "hellstone_hot", 0);
	public static final ULTerrainMaterial COBBLE = new ULTerrainMaterial(31, "cobble", 0);
	
	public static final ULTerrainMaterial COAL_ORE = new ULTerrainMaterial(50, "coal_ore", 0);
	public static final ULTerrainMaterial SULFUR_ORE = new ULTerrainMaterial(51, "sulfur_ore", 0);
	public static final ULTerrainMaterial IRON_ORE = new ULTerrainMaterial(52, "iron_ore", 0);
	public static final ULTerrainMaterial ALUMINIUM_ORE = new ULTerrainMaterial(53, "aluminium_ore", 0);
	public static final ULTerrainMaterial TUNGSTEN_ORE = new ULTerrainMaterial(54, "tungsten_ore", 0);
	public static final ULTerrainMaterial GOLD_ORE = new ULTerrainMaterial(55, "gold_ore", 0);
	
	public static final ULTerrainMaterial GRASS_0 = new ULTerrainMaterial(100, "grass_0", 0);
	public static final ULTerrainMaterial GRASS_1 = new ULTerrainMaterial(101, "grass_1", 0);
	public static final ULTerrainMaterial GRASS_2 = new ULTerrainMaterial(102, "grass_2", 0);
	public static final ULTerrainMaterial GRASS_3 = new ULTerrainMaterial(103, "grass_3", 0);
	public static final ULTerrainMaterial GRASS_4 = new ULTerrainMaterial(104, "grass_4", 0);
	
	public static final ULTerrainMaterial GRASS_ARID_0 = new ULTerrainMaterial(105, "grass_arid_0", 0);
	public static final ULTerrainMaterial GRASS_ARID_1 = new ULTerrainMaterial(106, "grass_arid_1", 0);
	public static final ULTerrainMaterial GRASS_ARID_2 = new ULTerrainMaterial(107, "grass_arid_2", 0);
	public static final ULTerrainMaterial GRASS_ARID_3 = new ULTerrainMaterial(108, "grass_arid_3", 0);
	public static final ULTerrainMaterial GRASS_ARID_4 = new ULTerrainMaterial(109, "grass_arid_4", 0);
	
	public static final ULTerrainMaterial GRASS_DRY_0 = new ULTerrainMaterial(110, "grass_dry_0", 0);
	public static final ULTerrainMaterial GRASS_DRY_1 = new ULTerrainMaterial(111, "grass_dry_1", 0);
	public static final ULTerrainMaterial GRASS_DRY_2 = new ULTerrainMaterial(112, "grass_dry_2", 0);
	public static final ULTerrainMaterial GRASS_DRY_3 = new ULTerrainMaterial(113, "grass_dry_3", 0);
	public static final ULTerrainMaterial GRASS_DRY_4 = new ULTerrainMaterial(114, "grass_dry_4", 0);
	
	public static final ULTerrainMaterial GRASS_DEAD_0 = new ULTerrainMaterial(115, "grass_dead_0", 0);
	public static final ULTerrainMaterial GRASS_DEAD_1 = new ULTerrainMaterial(116, "grass_dead_1", 0);
	public static final ULTerrainMaterial GRASS_DEAD_2 = new ULTerrainMaterial(117, "grass_dead_2", 0);
	public static final ULTerrainMaterial GRASS_DEAD_3 = new ULTerrainMaterial(118, "grass_dead_3", 0);
	public static final ULTerrainMaterial GRASS_DEAD_4 = new ULTerrainMaterial(119, "grass_dead_4", 0);
	
	public static final ULTerrainMaterial GRASS_FROZEN_0 = new ULTerrainMaterial(120, "grass_frozen_0", 0);
	public static final ULTerrainMaterial GRASS_FROZEN_1 = new ULTerrainMaterial(121, "grass_frozen_1", 0);
	public static final ULTerrainMaterial GRASS_FROZEN_2 = new ULTerrainMaterial(122, "grass_frozen_2", 0);
	public static final ULTerrainMaterial GRASS_FROZEN_3 = new ULTerrainMaterial(123, "grass_frozen_3", 0);
	public static final ULTerrainMaterial GRASS_FROZEN_4 = new ULTerrainMaterial(124, "grass_frozen_4", 0);
	
	public static final ULTerrainMaterial GRASS_FOREST_0 = new ULTerrainMaterial(125, "grass_forest_0", 0);
	public static final ULTerrainMaterial GRASS_FOREST_1 = new ULTerrainMaterial(126, "grass_forest_1", 0);
	public static final ULTerrainMaterial GRASS_FOREST_2 = new ULTerrainMaterial(127, "grass_forest_2", 0);
	public static final ULTerrainMaterial GRASS_FOREST_3 = new ULTerrainMaterial(128, "grass_forest_3", 0);
	public static final ULTerrainMaterial GRASS_FOREST_4 = new ULTerrainMaterial(129, "grass_forest_4", 0);
	
	public static final ULTerrainMaterial GRASS_JUNGLE_0 = new ULTerrainMaterial(130, "grass_jungle_0", 0);
	public static final ULTerrainMaterial GRASS_JUNGLE_1 = new ULTerrainMaterial(131, "grass_jungle_1", 0);
	public static final ULTerrainMaterial GRASS_JUNGLE_2 = new ULTerrainMaterial(132, "grass_jungle_2", 0);
	public static final ULTerrainMaterial GRASS_JUNGLE_3 = new ULTerrainMaterial(133, "grass_jungle_3", 0);
	public static final ULTerrainMaterial GRASS_JUNGLE_4 = new ULTerrainMaterial(134, "grass_jungle_4", 0);
	
	public static final ULTerrainMaterial GRASS_SEA_0 = new ULTerrainMaterial(135, "grass_sea_0", 0);
	public static final ULTerrainMaterial GRASS_SEA_1 = new ULTerrainMaterial(136, "grass_sea_1", 0);
	public static final ULTerrainMaterial GRASS_SEA_2 = new ULTerrainMaterial(137, "grass_sea_2", 0);
	public static final ULTerrainMaterial GRASS_SEA_3 = new ULTerrainMaterial(138, "grass_sea_3", 0);
	public static final ULTerrainMaterial GRASS_SEA_4 = new ULTerrainMaterial(139, "grass_sea_4", 0);
	
	public static final ULTerrainMaterial GRASS_SEAWEED_0 = new ULTerrainMaterial(140, "grass_seaweed_0", 0);
	public static final ULTerrainMaterial GRASS_SEAWEED_1 = new ULTerrainMaterial(141, "grass_seaweed_1", 0);
	public static final ULTerrainMaterial GRASS_SEAWEED_2 = new ULTerrainMaterial(142, "grass_seaweed_2", 0);
	public static final ULTerrainMaterial GRASS_SEAWEED_3 = new ULTerrainMaterial(143, "grass_seaweed_3", 0);
	public static final ULTerrainMaterial GRASS_SEAWEED_4 = new ULTerrainMaterial(144, "grass_seaweed_4", 0);
	
	public static final ULTerrainMaterial WATER_FLOWING = new ULTerrainMaterial(202, "water_flowing", 0);
	public static final ULTerrainMaterial WATER_INFINITY = new ULTerrainMaterial(203, "water_infinity", 0);
	
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
	
	public static ULTerrainMaterial getNormalGrass(int length) {
		return GRASS_NORMAL[MathUtils.clamp(0, 4, length)];
	}
	
	public static ULTerrainMaterial getAridGrass(int length) {
		return GRASS_ARID[MathUtils.clamp(0, 4, length)];
	}
	
	public static ULTerrainMaterial getDryGrass(int length) {
		return GRASS_DRY[MathUtils.clamp(0, 4, length)];
	}
	
	public static ULTerrainMaterial getDeadGrass(int length) {
		return GRASS_DEAD[MathUtils.clamp(0, 4, length)];
	}
	
	public static ULTerrainMaterial getFrozenGrass(int length) {
		return GRASS_FROZEN[MathUtils.clamp(0, 4, length)];
	}
	
	public static ULTerrainMaterial getForestGrass(int length) {
		return GRASS_FOREST[MathUtils.clamp(0, 4, length)];
	}
	
	public static ULTerrainMaterial getJungleGrass(int length) {
		return GRASS_JUNGLE[MathUtils.clamp(0, 4, length)];
	}
	
	public static ULTerrainMaterial getSeaGrass(int length) {
		return GRASS_SEA[MathUtils.clamp(0, 4, length)];
	}
	
	public static ULTerrainMaterial getSeaweedGrass(int length) {
		return GRASS_SEAWEED[MathUtils.clamp(0, 4, length)];
	}
}
