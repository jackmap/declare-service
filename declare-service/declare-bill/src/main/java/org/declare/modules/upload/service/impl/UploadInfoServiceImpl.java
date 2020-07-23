package org.declare.modules.upload.service.impl;

import org.declare.modules.upload.entity.UploadInfo;
import org.declare.modules.upload.mapper.UploadInfoMapper;
import org.declare.modules.upload.service.IUploadInfoService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 上传信息
 * @Author: jeecg-boot
 * @Date:   2020-07-23
 * @Version: V1.0
 */
@Service
public class UploadInfoServiceImpl extends ServiceImpl<UploadInfoMapper, UploadInfo> implements IUploadInfoService {

}
