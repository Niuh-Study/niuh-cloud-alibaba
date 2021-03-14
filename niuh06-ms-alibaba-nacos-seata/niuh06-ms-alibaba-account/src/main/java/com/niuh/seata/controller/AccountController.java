package com.niuh.seata.controller;



import com.niuh.seata.service.IAccountService;
import com.niuh.seata.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hejianhui
 * @since 2019-11-25
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;


    @PostMapping("/reduceBalance")
    @ResponseBody
    public ResultVo reduceBalance(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money) throws Exception {

        boolean reduceMoneyFlag = accountService.reduceBalance(userId,money);

        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(reduceMoneyFlag);
        resultVo.setMsg("扣款成功");
        resultVo.setData("扣款成功");

        return resultVo;
    }
}

