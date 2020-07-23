package org.declare.modules.goods.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.declare.modules.goods.entity.Goods;
import org.declare.modules.goods.service.IGoodsService;
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
 * @Description: 商品展示
 * @Author: jeecg-boot
 * @Date:   2020-07-23
 * @Version: V1.0
 */
@Slf4j
@Api(tags="商品展示")
@RestController
@RequestMapping("/goods/goods")
public class GoodsController extends JeecgController<Goods, IGoodsService> {
	@Autowired
	private IGoodsService goodsService;
	
	/**
	 * 分页列表查询
	 *
	 * @param goods
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "商品展示-分页列表查询")
	@ApiOperation(value="商品展示-分页列表查询", notes="商品展示-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(Goods goods,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<Goods> queryWrapper = QueryGenerator.initQueryWrapper(goods, req.getParameterMap());
		Page<Goods> page = new Page<Goods>(pageNo, pageSize);
		IPage<Goods> pageList = goodsService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 * 添加
	 *
	 * @param goods
	 * @return
	 */
	@AutoLog(value = "商品展示-添加")
	@ApiOperation(value="商品展示-添加", notes="商品展示-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody Goods goods) {
		goodsService.save(goods);
		return Result.ok("添加成功！");
	}
	
	/**
	 * 编辑
	 *
	 * @param goods
	 * @return
	 */
	@AutoLog(value = "商品展示-编辑")
	@ApiOperation(value="商品展示-编辑", notes="商品展示-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody Goods goods) {
		goodsService.updateById(goods);
		return Result.ok("编辑成功!");
	}
	
	/**
	 * 通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "商品展示-通过id删除")
	@ApiOperation(value="商品展示-通过id删除", notes="商品展示-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		goodsService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 * 批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "商品展示-批量删除")
	@ApiOperation(value="商品展示-批量删除", notes="商品展示-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.goodsService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "商品展示-通过id查询")
	@ApiOperation(value="商品展示-通过id查询", notes="商品展示-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		Goods goods = goodsService.getById(id);
		return Result.ok(goods);
	}

  /**
   * 导出excel
   *
   * @param request
   * @param goods
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, Goods goods) {
      return super.exportXls(request, goods, Goods.class, "商品展示");
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
      return super.importExcel(request, response, Goods.class);
  }

}
