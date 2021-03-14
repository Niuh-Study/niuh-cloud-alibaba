package com.niuh.seata.service;


import com.niuh.seata.domin.Account;
import com.niuh.seata.mapper.AccountMapper;

import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hejianhui
 * @since 2019-11-25
 */
@Slf4j
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public boolean reduceBalance(Integer userId, BigDecimal balance) throws Exception {

        log.info("当前 XID: {}", RootContext.getXID());
        checkBalance(userId, balance);

        log.info("开始扣减用户 {} 余额", userId);
        //模拟异常
        Integer record = accountMapper.reduceBalance(userId, balance);

        System.out.println(1/0);

        log.info("结束扣减用户 {} 余额结果:{}", userId, record > 0 ? "操作成功" : "扣减余额失败");
        return record > 0;
    }

    private void checkBalance(Integer userId, BigDecimal price) throws Exception {
        log.info("检查用户 {} 余额", userId);
        Account account = accountMapper.selectByUserId(userId);

        if (account!=null) {
            BigDecimal balance = account.getBalance();
            if (balance.compareTo(price) == -1) {
                log.warn("用户 {} 余额不足，当前余额:{}", userId, balance);
                throw new Exception("余额不足");
            }
        }
    }
}
