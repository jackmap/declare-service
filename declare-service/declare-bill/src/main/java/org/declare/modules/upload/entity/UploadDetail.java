package org.declare.modules.upload.entity;

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
 * @Description: 上传信息
 * @Author: jeecg-boot
 * @Date:   2020-07-23
 * @Version: V1.0
 */
@Data
@TableName("upload_detail")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="upload_detail对象", description="上传信息")
public class UploadDetail implements Serializable{
    
	/**uploadDetailId*/
	@Excel(name = "uploadDetailId", width = 15)
    @ApiModelProperty(value = "uploadDetailId")
	private java.lang.Integer uploadDetailId;
	/**uploadId*/
	@Excel(name = "uploadId", width = 15)
    @ApiModelProperty(value = "uploadId")
	private java.lang.Integer uploadId;
}
