package org.declare.modules.upload.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.declare.modules.upload.entity.UploadInfo;
import org.declare.modules.upload.service.IUploadDetailService;
import org.declare.modules.upload.service.IUploadInfoService;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.aspect.annotation.AutoLog;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.system.base.controller.JeecgController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
 * @Description: 上传信息
 * @Author: jeecg-boot
 * @Date:   2020-07-23
 * @Version: V1.0
 */
@Slf4j
@Api(tags="上传信息")
@RestController
@RequestMapping("/upload/uploadInfo")
public class UploadInfoController extends JeecgController<UploadInfo, IUploadInfoService> {
	@Autowired
	private IUploadInfoService uploadInfoService;
	 @Autowired
	 private IUploadDetailService uploadDetailService;
	/**
	 * 分页列表查询
	 *
	 * @param uploadInfo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "上传信息-分页列表查询")
	@ApiOperation(value="上传信息-分页列表查询", notes="上传信息-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(UploadInfo uploadInfo,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<UploadInfo> queryWrapper = QueryGenerator.initQueryWrapper(uploadInfo, req.getParameterMap());
		Page<UploadInfo> page = new Page<UploadInfo>(pageNo, pageSize);
		IPage<UploadInfo> pageList = uploadInfoService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 * 添加
	 *
	 * @param uploadInfo
	 * @return
	 */
	@AutoLog(value = "上传信息-添加")
	@ApiOperation(value="上传信息-添加", notes="上传信息-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody UploadInfo uploadInfo) {
		uploadInfoService.save(uploadInfo);
		return Result.ok("添加成功！");
	}
	
	/**
	 * 编辑
	 *
	 * @param uploadInfo
	 * @return
	 */
	@AutoLog(value = "上传信息-编辑")
	@ApiOperation(value="上传信息-编辑", notes="上传信息-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody UploadInfo uploadInfo) {
		uploadInfoService.updateById(uploadInfo);
		return Result.ok("编辑成功!");
	}
	
	/**
	 * 通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "上传信息-通过id删除")
	@ApiOperation(value="上传信息-通过id删除", notes="上传信息-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		uploadInfoService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 * 批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "上传信息-批量删除")
	@ApiOperation(value="上传信息-批量删除", notes="上传信息-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.uploadInfoService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "上传信息-通过id查询")
	@ApiOperation(value="上传信息-通过id查询", notes="上传信息-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		UploadInfo uploadInfo = uploadInfoService.getById(id);
		return Result.ok(uploadInfo);
	}

  /**
   * 导出excel
   *
   * @param request
   * @param uploadInfo
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, UploadInfo uploadInfo) {
      return super.exportXls(request, uploadInfo, UploadInfo.class, "上传信息");
  }

  /**
   * 通过excel导入数据
   *
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
  public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      return super.importExcel(request, response, UploadInfo.class);
  }

}
