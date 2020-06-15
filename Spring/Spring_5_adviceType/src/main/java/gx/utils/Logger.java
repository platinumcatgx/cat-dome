package gx.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知Logger中的beforePrintLog方法开始执行了");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger中的afterReturningPrintLog方法开始执行了");
    }

    /**
     * 异常通知
     */
    public void afterThowingPrintLog(){
        System.out.println("异常通知Logger中的afterThowingPrintLog方法开始执行了");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("最终通知Logger中的afterPrintLog方法开始执行了");
    }

    /**
     * 环绕通知
     * 问题:
     *      配置了环绕通知后,切入点方法没有执行,而通知方法执行了
     * 分析:
     *      通过对比,动态代理中环绕通知的代码,发现动态代理的环绕通知有明确的业务层切入点调用,而我们的代码中没有
     * 解决:
     *      Spring框架提供了ProceedingJoinPoint , 该接口有一个方法 proceed(),此方法相当于明确调用切入点方法
     *      该接口可以作为环绕通知的方法参数,在程序执行时,spring会为我们提供该接口的实现类供我们使用
     * spring中的环绕通知:
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null ;
        try {
            Object[] args = pjp.getArgs();//方法执行所需的参数

            System.out.println("aroundPrintLog方法执行了前置通知");//前置通知

            rtValue = pjp.proceed();//明确调用业务层方法(切入点方法)

            System.out.println("aroundPrintLog方法执行了后置通知");//后置通知

            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("aroundPrintLog方法执行了异常通知");//异常通知
            throwable.printStackTrace();
        } finally {
            System.out.println("aroundPrintLog方法执行了最终通知");//最终通知
        }
        return null;
    }



}
