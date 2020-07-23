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
@TableName("upload_info")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="upload_info对象", description="上传信息")
public class UploadInfo implements Serializable{
    
	/**uploadId*/
	@Excel(name = "uploadId", width = 15)
    @ApiModelProperty(value = "uploadId")
	private java.lang.Integer uploadId;
	/**fileName*/
	@Excel(name = "fileName", width = 15)
    @ApiModelProperty(value = "fileName")
	private java.lang.String fileName;
}
