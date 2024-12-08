package web_api.api.sample

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import web_api.framework.annotation.CustomLog

@Service
class SampleService {
  companion object {
    private val LOGGER = LoggerFactory.getLogger(this::class.java)
  }

  @CustomLog
  fun execute() {
    LOGGER.info("${this::class.simpleName}.execute：開始")
    Thread.sleep(1000)
    LOGGER.info("${this::class.simpleName}.execute：終了")
  }
}
