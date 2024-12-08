package web_api.framework.aop

import com.fasterxml.jackson.databind.ObjectMapper
import java.time.OffsetDateTime
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class CustomLogAspect(private val objectMapper: ObjectMapper) {
  companion object {
    private val LOGGER = LoggerFactory.getLogger(this::class.java)
  }

  @Around(value = "@annotation(web_api.framework.annotation.CustomLog)")
  fun around(pjp: ProceedingJoinPoint) {
    beforeAround(jointPoint = pjp)
    pjp.proceed()
    afterAround(jointPoint = pjp)
  }

  private fun beforeAround(jointPoint: JoinPoint) {
    val info =
        mapOf(
            "javaClass" to jointPoint.signature.declaringType,
            "methodName" to jointPoint.signature.name,
            "args" to jointPoint.args,
            "timestamp" to OffsetDateTime.now())
    val json = objectMapper.writeValueAsString(info)

    LOGGER.info(json)
  }

  private fun afterAround(jointPoint: JoinPoint) {
    val info =
        mapOf(
            "javaClass" to jointPoint.signature.declaringType,
            "methodName" to jointPoint.signature.name,
            "args" to jointPoint.args,
            "timestamp" to OffsetDateTime.now())
    val json = objectMapper.writeValueAsString(info)

    LOGGER.info(json)
  }
}
