package com.didispace.config;

import com.didispace.enums.Events;
import com.didispace.enums.States;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;

/**
 * @author ZhengYingDeng
 * @email 892467242@qq.com
 * @create 9:53 2018/6/20
 **/
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        //初始化当前状态拥有哪些状态
        states
                .withStates()
                .initial(States.UNPAID)  //初始状态
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        //初始化当前状态机有哪些状态迁移动作
        transitions
                .withExternal()
                .source(States.UNPAID).target(States.WAITING_FOR_RECEIVE) //从什么到什么
                .event(Events.PAY)  //迁移动作
                .and()
                .withExternal()
                .source(States.WAITING_FOR_RECEIVE).target(States.DONE)
                .event(Events.RECEIVE);
    }

//    @Override
//    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
////            throws Exception {
////        config
////                .withConfiguration()
////                .listener(listener()); //指定状态机的处理监听器
////    }

//    @Bean
//    public StateMachineListener<States, Events> listener() {
//        return new StateMachineListenerAdapter<States, Events>() {
//
//            @Override
//            public void transition(Transition<States, Events> transition) {
//                if(transition.getTarget().getId() == States.UNPAID) {
//                    logger.info("订单创建，待支付");
//                    return;
//                }
//
//                if(transition.getSource().getId() == States.UNPAID
//                        && transition.getTarget().getId() == States.WAITING_FOR_RECEIVE) {
//                    logger.info("用户完成支付，待收货");
//                    return;
//                }
//
//                if(transition.getSource().getId() == States.WAITING_FOR_RECEIVE
//                        && transition.getTarget().getId() == States.DONE) {
//                    logger.info("用户已收货，订单完成");
//                    return;
//                }
//            }
//
//        };
//    }
}
