package com.taotao.mapper;

import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemParamMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated Sat Sep 09 23:09:22 CST 2017
     */
    int countByExample(TbItemParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated Sat Sep 09 23:09:22 CST 2017
     */
    int deleteByExample(TbItemParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated Sat Sep 09 23:09:22 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated Sat Sep 09 23:09:22 CST 2017
     */
    int insert(TbItemParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated Sat Sep 09 23:09:22 CST 2017
     */
    int insertSelective(TbItemParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated Sat Sep 09 23:09:22 CST 2017
     */
    List<TbItemParam> selectByExampleWithBLOBs(TbItemParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated Sat Sep 09 23:09:22 CST 2017
     */
    List<TbItemParam> selectByExample(TbItemParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated Sat Sep 09 23:09:22 CST 2017
     */
    TbItemParam selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated Sat Sep 09 23:09:22 CST 2017
     */
    int updateByExampleSelective(@Param("record") TbItemParam record, @Param("example") TbItemParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated Sat Sep 09 23:09:22 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") TbItemParam record, @Param("example") TbItemParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated Sat Sep 09 23:09:22 CST 2017
     */
    int updateByExample(@Param("record") TbItemParam record, @Param("example") TbItemParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated Sat Sep 09 23:09:22 CST 2017
     */
    int updateByPrimaryKeySelective(TbItemParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated Sat Sep 09 23:09:22 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(TbItemParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_item_param
     *
     * @mbggenerated Sat Sep 09 23:09:22 CST 2017
     */
    int updateByPrimaryKey(TbItemParam record);
}