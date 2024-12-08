package web_api.api.sample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(private val service: SampleService) {
  @GetMapping("/api/sample")
  fun get() {
    service.execute()
  }
}
