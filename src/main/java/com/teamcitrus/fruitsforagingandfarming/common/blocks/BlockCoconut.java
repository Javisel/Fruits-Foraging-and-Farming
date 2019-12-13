package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class BlockCoconut extends BlockFalling implements IGrowable {

    public static final PropertyInteger age = net.minecraft.block.properties.PropertyInteger.create("age", 0, 6);


    private static final AxisAlignedBB[] COCONUT_AABB = {


            //STAGE 0 "Newborn"
            new AxisAlignedBB(0, 0, 0, 0.25, 0.25, 0.25).offset(0.375, .75, 0.375),
            //Stage 1: Mid-Way
            new AxisAlignedBB(0, 0, 0, 0.375, 0.375, 0.375).offset(0.3125, 0.625, 0.3125),
            //Stage 2 Adult, on Tree, Ready to Fall
            new AxisAlignedBB(0, 0, 0, .5, .5, .5).offset(.25, .5, .25),
            //Stage 3 Adult, Placed. Will not fall.
            new AxisAlignedBB(0, 0, 0, .5, .5, .5).offset(.25, .5, .25),

            //Stage 4, On Ground
            new AxisAlignedBB(0, 0, 0, .5, .5, .5).offset(0.25, 0, 0.25),
            //Stage 5, Cracked, facing East-West
            new AxisAlignedBB(0, 0, 0, .5, .5, .5).offset(0.25, 0, 0.25),
            //Stage 6, Cracked, Facing North-South
            new AxisAlignedBB(0, 0, 0, .5, .5, .5).offset(0.25, 0, 0.25),


    };


    public BlockCoconut() {
        super(Material.PLANTS);
        this.setRegistryName("coconut");
        setUnlocalizedName("coconut");
        setHardness(0.5F);
        setResistance(0);
        this.setDefaultState(this.blockState.getBaseState().withProperty(getAgeProperty(), 0));
        setTickRandomly(true);
        setLightOpacity(0);
        setCreativeTab(FruitsForagingAndFarming.fffCreativeTab);
    }
    protected static float getGrowthChance(World worldIn, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockpos = pos.up();

        for (int x = -4; x <= 4; ++x) {
            for (int y = -4; y <=0; y++) {
                for (int z = -4; z <= 4; ++z) {
                    float f1 = 0.0F;
                    IBlockState iblockstate = worldIn.getBlockState(blockpos.add(x, y, z));

                    if (iblockstate.getBlock() == BlockRegistration.PALM_LOG) {
                        f1 = 1.0F;

                        if (iblockstate.getBlock() instanceof BlockLeaves) {
                            f1 = 3.0F;
                        }
                    }

                    if (x != 0 || z != 0) {
                        f1 /= 4.0F;
                    }

                    f += f1;
                }
            }
        }



        return f;
    }
    protected PropertyInteger getAgeProperty() {
        return age;
    }
    protected int getAge(IBlockState state) {
        return state.getValue(this.getAgeProperty());
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {

        int age = getAge(state);
        if(age<2) {return;}

       else if (age < 5) {

           drops.add(new ItemStack(BlockRegistration.COCONUT,1));


        }

       if (age>=5) {
           drops.add(new ItemStack(ItemRegistration.CRACKED_COCONUT,1));

       }



    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {

        return  null;
    }

    public int quantityDropped(Random random) {
        return 1;
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */
    public int quantityDroppedWithBonus(int fortune, Random random) {
        return 1;
    }

    @Override
    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }


    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, age);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return COCONUT_AABB[state.getValue(getAgeProperty())];
    }


    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        if (facing == EnumFacing.DOWN) {
            return this.getDefaultState().withProperty(age, 3);
        } else {
            return this.getDefaultState().withProperty(age, 4);
        }

    }

    @Override
    public boolean isTranslucent(IBlockState state) {
        return true;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isNormalCube(IBlockState state) {
        return false;
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.withAge(meta);
    }

    public IBlockState withAge(int type) {
        if ( type < 0 )  {type = 0;}
        else if (type>6) {type = 6;}
        return this.getDefaultState().withProperty(getAgeProperty(), type);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;

    }


    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }


    public int getMetaFromState(IBlockState state) {
        return this.getAge(state);
    }


    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {

        return !isClient && getAge(state) <2;

    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return getAge(state) <2;

    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            int i = rand.nextInt(2);
            i += getMetaFromState(state);
            int j = 2;

            if (i > j) {
                i = j;
            }

            worldIn.setBlockState(pos, this.withAge(i), 2);
        }
    }
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {


        if (!worldIn.isAreaLoaded(pos, 1) || worldIn.isRemote) {
            return;
        }
        int i = this.getAge(state);
        if (canGrow(worldIn,pos,state,false)) {
            float f = getGrowthChance( worldIn, pos);

            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int) (25.0F / f) + 1) == 0)) {
                worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                i=getAge(worldIn.getBlockState(pos));
            }


        }

         if (i>=4 && worldIn.isAirBlock(pos.down())) {


            EntityFallingBlock entityfallingblock = new EntityFallingBlock(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, BlockRegistration.COCONUT.getStateFromMeta(i));
            entityfallingblock.setHurtEntities(true);
            worldIn.spawnEntity(entityfallingblock);



        }



    }
    protected void onStartFalling(EntityFallingBlock fallingEntity)
    {
        fallingEntity.setHurtEntities(true);

    }
    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        if (rand.nextInt(16) == 0)
        {
            BlockPos blockpos = pos.down();

            if (canFallThrough(worldIn.getBlockState(blockpos)) &&  getAge(stateIn) ==2)
            {
                double d0 = (float)pos.getX() + rand.nextFloat();
                double d1 = (double)pos.getY() - 0.05D;
                double d2 = (float)pos.getZ() + rand.nextFloat();
                worldIn.spawnParticle(EnumParticleTypes.BLOCK_DUST, d0, d1, d2, 0.0D, 0.0D, 0.0D, Block.getStateId(stateIn));

            }
        }
    }

    @Override
    public void onEndFalling(World worldIn, BlockPos pos, IBlockState p_176502_3_, IBlockState p_176502_4_)
    {
        if (!worldIn.isRemote && worldIn.getBlockState(pos.down()).getBlock().getMaterial(worldIn.getBlockState(pos.down())) == Material.ROCK) {




            worldIn.setBlockToAir(pos);

            ItemStack items = new ItemStack(ItemRegistration.COCONUT_CHUNK,4);
            EntityItem chunks = new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(),items);

            worldIn.spawnEntity(chunks);

        }
    }
}
