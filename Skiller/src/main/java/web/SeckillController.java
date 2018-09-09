package web;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.entity.Seckill;

import dto.Exposer;
import dto.SeckillExecution;
import dto.SeckillResult;
import enums.SeckillState;
import exception.RepeatKillException;
import exception.SeckillCloseException;
import service.SeckillService;

@Controller
@RequestMapping(value = "/seckill")
public class SeckillController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeckillService seckillService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Seckill> list = seckillService.getSeckillList();
		model.addAttribute("list", list);
		return "list";
	}

	@RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
		if (seckillId == null) {
			return "redirect:/seckill/list";
		}
		Seckill seckill = seckillService.getById(seckillId);
		if (seckill == null) {
			return "forword:/seckill/list";
		}
		model.addAttribute("seckill", seckill);
		return "detail";
	}

	@RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<Exposer> exposer(Long seckillId) {
		SeckillResult<Exposer> result;

		try {

			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
			result = new SeckillResult<Exposer>(true, exposer);
		} catch (Exception e) {
			result = new SeckillResult<Exposer>(false, e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/{seckillId}/{md5}/execute", method = RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<SeckillExecution> execute(
			@PathVariable("seckillId") Long seckillId,
			@PathVariable("md5") String md5,
			@CookieValue(value = "killPhone", required = false) Long phone) {

		if (phone == null) {
			return new SeckillResult<SeckillExecution>(false, "未注册");
		}
		try {

			// SeckillResult<SeckillExecution> result;
			SeckillExecution execution = seckillService.executeSeckill(
					seckillId, phone, md5);
			return new SeckillResult<SeckillExecution>(true, execution);
		} catch (RepeatKillException e) {
			SeckillExecution execution = new SeckillExecution(seckillId,
					SeckillState.REPEAT_KILL);
			return new SeckillResult<SeckillExecution>(false, execution);
		} catch (SeckillCloseException e) {
			SeckillExecution execution = new SeckillExecution(seckillId,
					SeckillState.END);
			return new SeckillResult<SeckillExecution>(false, execution);
		} catch (Exception e) {
			SeckillExecution execution = new SeckillExecution(seckillId,
					SeckillState.INNER_ERROR);
			logger.equals(e.getMessage());
			return new SeckillResult<SeckillExecution>(false, execution);
		}

	}

	@RequestMapping(value = "/time/now", method = RequestMethod.GET)
	@ResponseBody
	public SeckillResult<Long> time() {
		Date date = new Date();
		return new SeckillResult<Long>(true, date.getTime());
	}

}
