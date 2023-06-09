<h1 align="center">UniLib</h1>

<p align="center">
	<img src="unilib-logo.png" height="200px"/>
</p>

<p align="center">
	<a href="https://jitpack.io/#paulevsGitch/UniLib">
		<img src="https://jitpack.io/v/paulevsGitch/UniLib.svg"/>
	</a>
</p>

UniLib is the Universal Library for Rising World plugins.
It is a modular library that is supposed to be used as
embedded library (packed inside plugin jar).

**[Project Wiki](https://github.com/paulevsGitch/UniLib/wiki)**

### Available Modules:

1. **unilib-database-utils**
    - Database management module
    - Create databases, tables and requests with builders
    - Locate databases in world, plugin or custom directories
    - Store different data types (including Vector3f and Vector3i)
    - Update, remove and add new data into tables with builders
    - Don't require SQL syntax knowledge
2. **unilib-config-utils**
    - Config managment module
    - Create simple configs in .conf format (in plugin folder)
    - Store primitives and custom classes
    - Comment any entry with as many comments as needed
3. **unilib-terrain-materials**
    - Terrain Material data storage module
    - Contains all terrain materials as constants with IDs, names and average colors
    - Have additional methods to get terrain by ID/name or get grass by length

### Planned Modules:
1. **math module** - some useful mathematical operations and fast trigonomentric functions
2. **blueprint module** - integrated version of [BlueLib](https://github.com/paulevsGitch/BlueLib) to work with RW blueprints
3. **noise module** - module with different noise functions (perlin, simplex, voronoi)
4. **sdf module** - module with SDF functions (mostly ported from BCLib with adaptations)
5. **worldgen module** (when API will be updated) - to manipulate worldgen (probably will be not necessary)