# Lithium Configuration File Summary
The configuration file makes use of the [Java properties format](https://docs.oracle.com/cd/E23095_01/Platform.93/ATGProgGuide/html/s0204propertiesfileformat01.html). If the configuration file does not exist during game start-up, a blank file with a comment will be created.

The configuration file defines *overrides* for the available options, and as such, a blank file is perfectly normal! It simply means that you'd like to use all the default values.

Each category below includes a list of options which can be changed by the user. Due to the nature of the mod, configuration options require a game restart to take effect.

### Editing the configuration file

All configuration options are simple key-value pairs. In other words, you first specify the option's name, followed by the desired value, like so:

```properties
mixin.ai.pathing=false
mixin.gen.biome_noise_cache=false
```

The remarks after the `#` are comments and exist for your own book-keeping. As such, you don't need to include them, but you might want to include a note as to why you're modifying a default value.

# Configuration options
### `mixin.ai`
(default: `true`)  
Mob AI optimizations  
  
### `mixin.ai.nearby_entity_tracking`
(default: `true`)  
Event-based system for tracking nearby entities.
  
Requirements:
- `mixin.util.entity_section_position=true`  
  
### `mixin.ai.nearby_entity_tracking.goals`
(default: `true`)  
A number of AI goals which query for nearby entities in the world every tick will use the event-based
system for tracking nearby entities. In other words, instead of entities constantly polling to see if
other entities are nearby, they will instead be notified only occasionally when such an entity enters
their range.
  
  
### `mixin.ai.pathing`
(default: `true`)  
A faster code path is used for determining what kind of path-finding node type is associated with a
given block. Additionally, a faster chunk cache will be used for accessing blocks while evaluating
paths.
  
  
### `mixin.ai.poi`
(default: `true`)  
Implements a faster POI search  
  
### `mixin.ai.poi.fast_portals`
(default: `true`)  
Portal search uses the faster POI search  
  
### `mixin.ai.poi.poi.tasks`
(default: `true`)  
Mob Tasks which search for POIs use the optimized POI search  
  
### `mixin.ai.raid`
(default: `true`)  
Avoids unnecessary raid bar updates and optimizes expensive leader banner operations  
  
### `mixin.ai.sensor.secondary_poi`
(default: `true`)  
Avoid unnecessary secondary POI searches of non-farmer villagers  
  
### `mixin.ai.task`
(default: `true`)  
Various AI task optimizations  
  
### `mixin.ai.task.launch`
(default: `true`)  
Keep track of running and runnable tasks to speed up task launching checks  
  
### `mixin.ai.task.memory_change_counting`
(default: `true`)  
Keep track of AI memory changes to skip checking AI task memory prerequisites  
  
### `mixin.ai.task.replace_streams`
(default: `true`)  
Replace Stream code of AI tasks with more traditional iteration.  
  
### `mixin.alloc`
(default: `true`)  
Patches that reduce memory allocations  
  
### `mixin.alloc.blockstate`
(default: `true`)  
Improve the BlockState withTable lookup by using a custom table implementation.  
  
### `mixin.alloc.chunk_random`
(default: `true`)  
Random block ticking uses fewer block position allocations, thereby reducing the object allocation rate.  
  
### `mixin.alloc.chunk_ticking`
(default: `true`)  
Reuse large chunk lists  
  
### `mixin.alloc.composter`
(default: `true`)  
Composters will reuse the available slot arrays that are requested by hoppers  
  
### `mixin.alloc.deep_passengers`
(default: `true`)  
Reduce stream code usage when getting the passengers of an entity  
  
### `mixin.alloc.entity_tracker`
(default: `true`)  
Entity trackers use a fastutil set for storing players instead of an IdentityHashSet  
  
### `mixin.alloc.enum_values`
(default: `true`)  
Avoid `Enum#values()` array copy in frequently called code  
  
### `mixin.alloc.explosion_behavior`
(default: `true`)  
Remove lambda allocation in frequently called block blast resistance calculation in explosion code  
  
### `mixin.alloc.nbt`
(default: `true`)  
NBT tags use a fastutil hashmap instead of a standard HashMap  
  
### `mixin.block`
(default: `true`)  
Optimizations related to blocks  
  
### `mixin.block.flatten_states`
(default: `true`)  
BlockStates store their FluidState directly and whether they are empty  
  
### `mixin.block.hopper`
(default: `true`)  
Reduces hopper lag using caching, notification systems and BlockEntity sleeping  
Requirements:
- `mixin.ai.nearby_entity_tracking=true`
- `mixin.util.block_entity_retrieval=true`
- `mixin.util.inventory_change_listening=true`  
  
### `mixin.block.moving_block_shapes`
(default: `true`)  
Moving blocks and retracting pistons avoid calculating their VoxelShapes by reusing previously created VoxelShapes.  
  
### `mixin.block.redstone_wire`
(default: `true`)  
Redstone wire power calculations avoid duplicate block accesses  
  
### `mixin.cached_hashcode`
(default: `true`)  
BlockNeighborGroups used in fluid code cache their hashcode  
  
### `mixin.chunk`
(default: `true`)  
Various world chunk optimizations  
  
### `mixin.chunk.block_counting`
(default: `true`)  
Chunk sections count certain blocks inside them and provide a method to quickly check whether a chunk contains any of these blocks  
  
### `mixin.chunk.entity_class_groups`
(default: `true`)  
Allow grouping entity classes for faster entity access, e.g. boats and shulkers  
  
### `mixin.chunk.no_locking`
(default: `true`)  
Remove debug checks in block access code  
  
### `mixin.chunk.no_validation`
(default: `true`)  
Skip bounds validation when accessing blocks  
  
### `mixin.chunk.palette`
(default: `true`)  
Replaces the vanilla hash palette with an optimized variant  
  
### `mixin.chunk.serialization`
(default: `true`)  
Optimizes chunk palette compaction when serializing chunks  
  
### `mixin.collections`
(default: `true`)  
Various collection optimizations  
  
### `mixin.collections.attributes`
(default: `true`)  
Uses fastutil hashmaps for entity attributes  
  
### `mixin.collections.block_entity_tickers`
(default: `true`)  
Uses fastutil hashmaps for BlockEntity tickers  
  
### `mixin.collections.brain`
(default: `true`)  
Uses fastutil hashmaps for AI memories and sensors  
  
### `mixin.collections.entity_by_type`
(default: `true`)  
Uses fastutil hashmaps for type specific entity lists  
  
### `mixin.collections.entity_filtering`
(default: `true`)  
The expensive check to see if a TypeFilterableList can be filtered by a specific class is only made when a new list for that type needs to be created  
  
### `mixin.collections.entity_ticking`
(default: `true`)  
Copy entity hashmap instead of duplicating the list using iteration  
  
### `mixin.collections.gamerules`
(default: `true`)  
Uses fastutil hashmaps for gamerules  
  
### `mixin.collections.goals`
(default: `true`)  
Uses fastutil hashsets for goals in the AI goal selector  
  
### `mixin.collections.mob_spawning`
(default: `true`)  
Uses custom hashset/list combination for faster mob spawn checks  
  
### `mixin.entity`
(default: `true`)  
Various entity optimizations  
  
### `mixin.entity.collisions`
(default: `true`)  
Various entity collision optimizations  
  
### `mixin.entity.collisions.fluid`
(default: `true`)  
Skips being pushed by fluids when the nearby chunk sections do not contain this fluid  
  
### `mixin.entity.collisions.intersection`
(default: `true`)  
Uses faster block access for block collisions and delayed entity access with grouped boat/shulker for entity collisions when available  
Requirements:
- `mixin.chunk.block_counting=true`  
  
### `mixin.entity.collisions.movement`
(default: `true`)  
Entity movement uses optimized block access and optimized and delayed entity access  
  
### `mixin.entity.collisions.suffocation`
(default: `true`)  
Avoids stream code in suffocation check  
  
### `mixin.entity.collisions.unpushable_cramming`
(default: `true`)  
In chunks with many mobs in ladders a separate list of pushable entities for cramming tests is used  
Requirements:
- `mixin.chunk.entity_class_groups=true`  
  
### `mixin.entity.data_tracker`
(default: `true`)  
Various entity data tracker optimizations  
  
### `mixin.entity.data_tracker.no_locks`
(default: `true`)  
Remove unnecessary locking when accessing the data tracker  
  
### `mixin.entity.data_tracker.use_arrays`
(default: `true`)  
Data trackers use a custom optimized entry map  
  
### `mixin.entity.fast_elytra_check`
(default: `true`)  
Skip repeatedly writing to the data tracker that an entity is not flying  
  
### `mixin.entity.fast_hand_swing`
(default: `true`)  
Skip hand swinging speed and animation calculations when the hand of an entity is not swinging  
  
### `mixin.entity.fast_powder_snow_check`
(default: `true`)  
Skip checking whether an entity is inside powder snow for movement speed slowdown when it is not freezing  
  
### `mixin.entity.fast_retrieval`
(default: `true`)  
Access entities faster when accessing a relatively small number of entity sections  
  
### `mixin.entity.hopper_minecart`
(default: `true`)  
Hopper minecarts search for item entities faster by combining multiple item entity searches. Also eliminates duplicated item entity pickup attempts  
  
### `mixin.entity.inactive_navigations`
(default: `true`)  
Block updates skip notifying mobs that won't react to the block update anyways  
  
### `mixin.entity.replace_entitytype_predicates`
(default: `true`)  
Accesses entities of the correct type directly instead of accessing all nearby entities and filtering them afterwards  
  
### `mixin.entity.skip_equipment_change_check`
(default: `true`)  
Skips repeated checks whether the equipment of an entity changed. Instead equipment updates are detected  
  
### `mixin.gen`
(default: `true`)  
Various world generation optimizations  
  
### `mixin.gen.cached_generator_settings`
(default: `true`)  
World generator settings cache the sea level  
  
### `mixin.gen.chunk_region`
(default: `true`)  
An optimized chunk cache is used for world population features which avoids array indirection and complex logic  
  
### `mixin.item`
(default: `true`)  
Item stacks use the cached empty flag  
  
### `mixin.math`
(default: `true`)  
Various math optimizations  
  
### `mixin.math.fast_blockpos`
(default: `true`)  
Avoids indirection and inlines several functions  
  
### `mixin.math.fast_util`
(default: `true`)  
Avoid indirection and inline several functions in Direction, Axis and Box code  
  
### `mixin.profiler`
(default: `true`)  
Avoid indirection when accessing the profiler  
  
### `mixin.shapes`
(default: `true`)  
Various VoxelShape optimizations  
  
### `mixin.shapes.blockstate_cache`
(default: `true`)  
Use a faster collection for the full cube test cache  
  
### `mixin.shapes.lazy_shape_context`
(default: `true`)  
Entity shape contexts initialize rarely used fields only on first use  
  
### `mixin.shapes.optimized_matching`
(default: `true`)  
VoxelShape collisions use a faster intersection test for cuboid shapes  
  
### `mixin.shapes.precompute_shape_arrays`
(default: `true`)  
VoxelShapes store position arrays for their shape instead of recalculating the positions  
  
### `mixin.shapes.shape_merging`
(default: `true`)  
Merging and intersecting VoxelShapes is optimized using faster position list merging  
  
### `mixin.shapes.specialized_shapes`
(default: `true`)  
Specialized VoxelShape implementations are used for cuboid and empty shapes. Collisions with those shapes are optimized using a cuboid specific implementation  
  
### `mixin.util`
(default: `true`)  
Various utilities for other mixins  
  
### `mixin.util.block_entity_retrieval`
(default: `true`)  
Allows access to existing BlockEntities without creating new ones  
  
### `mixin.util.entity_section_position`
(default: `true`)  
Entity sections store their position  
  
### `mixin.util.inventory_change_listening`
(default: `true`)  
Certain BlockEntity Inventories emit updates to their listeners when their stack list is changed or the inventory becomes invalid  
  
### `mixin.util.inventory_comparator_tracking`
(default: `true`)  
BlockEntity Inventories update their listeners when a comparator is placed near them  
Requirements:
- `mixin.util.block_entity_retrieval=true`  
  
### `mixin.util.world_border_listener`
(default: `true`)  
World border changes are sent to listeners such as BlockEntities  
  
### `mixin.world`
(default: `true`)  
Various world related optimizations  
  
### `mixin.world.block_entity_ticking`
(default: `true`)  
Various BlockEntity ticking optimizations  
  
### `mixin.world.block_entity_ticking.sleeping`
(default: `true`)  
Allows BlockEntities to sleep, meaning they are no longer ticked until woken up, e.g. by updates to their inventory or block state  
  
### `mixin.world.block_entity_ticking.sleeping.brewing_stand`
(default: `true`)  
BlockEntity sleeping for inactive brewing stands  
  
### `mixin.world.block_entity_ticking.sleeping.campfire`
(default: `true`)  
BlockEntity sleeping for inactive campfires  
  
### `mixin.world.block_entity_ticking.sleeping.furnace`
(default: `true`)  
BlockEntity sleeping for inactive furnaces  
  
### `mixin.world.block_entity_ticking.sleeping.hopper`
(default: `true`)  
BlockEntity sleeping for locked hoppers  
  
### `mixin.world.block_entity_ticking.sleeping.shulker_box`
(default: `true`)  
BlockEntity sleeping for closed shulker boxes  
  
### `mixin.world.block_entity_ticking.support_cache`
(default: `false`)  
BlockEntity ticking caches whether the BlockEntity can exist in the BlockState at the same location  
  
### `mixin.world.block_entity_ticking.world_border`
(default: `true`)  
Avoids repeatedly testing whether the BlockEntity is inside the world border by caching the test result and listening for world border changes  
Requirements:
- `mixin.util.world_border_listener=true`  
  
### `mixin.world.chunk_access`
(default: `true`)  
Several changes to the chunk manager to speed up chunk access  
  
### `mixin.world.chunk_tickets`
(default: `true`)  
Improves the chunk ticket sets by speeding up the removal of chunk tickets  
  
### `mixin.world.explosions`
(default: `true`)  
Various improvements to explosions, e.g. not accessing blocks along an explosion ray multiple times  
  
### `mixin.world.inline_block_access`
(default: `true`)  
Faster block and fluid access due to inlining and reduced method size  
  
### `mixin.world.inline_height`
(default: `true`)  
Reduces indirection by inlining world height access methods  
  
### `mixin.world.player_chunk_tick`
(default: `true`)  
Batches sending chunks to player together by replacing the corresponding code  
  
### `mixin.world.tick_scheduler`
(default: `true`)  
Use faster tick collections and pack scheduled ticks into integers for easier tick comparisons  
  
