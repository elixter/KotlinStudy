package com.elixter.kopring.aop

import mu.KLogging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.util.StopWatch

@Aspect
class LogExecutionTimeAspect {

    @Around("@annotation(LogExecutionTime)")
    @Throws(Throwable::class)
    fun logExecutionTime(joinPoint: ProceedingJoinPoint): Any? {
        if (!logger.isInfoEnabled) {
            return joinPoint.proceed()
        }

        val stopWatch = StopWatch()
        stopWatch.start()

        // annotation 이 붙어있는 타겟
        val proceed = joinPoint.proceed()

        stopWatch.stop()
        logger.info(stopWatch.prettyPrint());

        return proceed
    }


    companion object : KLogging()
}