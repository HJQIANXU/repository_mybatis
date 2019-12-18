package com.xuqian.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {

    //zs
    private Object target;

    public TransactionInvocationHandler(Object target){

        this.target = target;
    }

    //代理类的业务方法
    //ls的方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        SqlSession session = null;
        Object obj = null;

        try {

            session = SqlSessionUtil.getSession();

            //处理业务逻辑
            //zs的方法
            obj = method.invoke(target,args);

            //处理业务逻辑完毕后，提交事务
            session.commit();

        }catch (Exception e){

            session.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.myClose(session);
        }

        return obj;
    }

    public Object getProxy(){

        //取得ls代理类对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
