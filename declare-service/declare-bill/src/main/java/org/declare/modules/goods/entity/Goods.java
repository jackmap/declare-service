package org.declare.modules.goods.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Description: 商品展示
 * @Author: jeecg-boot
 * @Date:   2020-07-23
 * @Version: V1.0
 */
@Data
@TableName("sys_goods")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="sys_goods对象", description="商品展示")
public class Goods implements Serializable{
    
	/**id*/
	@TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "id")
	private java.lang.Integer id;
	/**商品中文名称*/
	@Excel(name = "商品中文名称", width = 15)
    @ApiModelProperty(value = "商品中文名称")
	private java.lang.String name;
	/**商品英文名称*/
	@Excel(name = "商品英文名称", width = 15)
    @ApiModelProperty(value = "商品英文名称")
	private java.lang.String nameEn;
	/**商品类型*/
	@Excel(name = "商品类型", width = 15)
    @ApiModelProperty(value = "商品类型")
	private java.lang.Integer type;
	/**商品标记sign*/
	@Excel(name = "商品标记sign", width = 15)
    @ApiModelProperty(value = "商品标记sign")
	private java.lang.String sign;

}
